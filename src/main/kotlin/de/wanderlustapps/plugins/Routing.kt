package de.wanderlustapps.plugins

import de.wanderlustapps.core.ResponseWrapper
import de.wanderlustapps.domain.usecases.LoginWithEmailAndPasswordUseCase
import de.wanderlustapps.domain.usecases.RegisterUseCase
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val loginWithEmailAndPasswordUseCase by inject<LoginWithEmailAndPasswordUseCase>()
    val registerUseCase by inject<RegisterUseCase>()

    routing {
        route("/auth") {
            get("/loginWithEmailAndPassword") {
                val username = call.parameters["username"].toString()
                val password = call.parameters["password"].toString()
                val result = loginWithEmailAndPasswordUseCase.invoke(username, password)
                val response = ResponseWrapper.successResponse(result)
                val jsonString = Json.encodeToString(response)
                call.respondText(jsonString)
            }

            get("/loginWithFacebook") {
                call.respondText("loginWithFacebook")
            }

            get("/register") {
                val email = call.parameters["email"].toString()
                val result = registerUseCase.invoke(email)

                if (result.isSuccess) {
                    ResponseWrapper.successResponse(result.getOrThrow())
                } else {
                    ResponseWrapper.errorResponse(result.exceptionOrNull()?.message ?: "")
                }
            }
        }
    }
}
