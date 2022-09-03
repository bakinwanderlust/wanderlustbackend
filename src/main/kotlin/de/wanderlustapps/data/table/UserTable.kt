package de.wanderlustapps.data.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object UserTable : IntIdTable(name = "users") {
    val email = varchar(name = "email", 50)
    val created_at = datetime("created_at").default(LocalDateTime.now())
}