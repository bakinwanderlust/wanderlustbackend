package de.wanderlustapps

import de.wanderlustapps.data.database.getMysqlDb
import de.wanderlustapps.data.table.UserTable
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import de.wanderlustapps.plugins.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureKoin()
        x()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}

fun x() {
    transaction(getMysqlDb()) {
        SchemaUtils.create(UserTable)
    }
}
