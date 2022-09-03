package de.wanderlustapps.domain.usecases

class LoginWithEmailAndPasswordUseCase {
    @kotlinx.serialization.Serializable
    data class Output(
        val username: String,
        val password: String
    )

    fun invoke(email: String, password: String): Output {
        return Output(email, password)
    }
}