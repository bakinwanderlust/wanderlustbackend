package de.wanderlustapps.data.database

import org.jetbrains.exposed.sql.Database

private val dbUrl = "jdbc:mysql://localhost:3306/wanderlust"
private val driver = "com.mysql.cj.jdbc.Driver"
private val user = "root"
private val password = ".11Salim11"

fun getMysqlDb(): Database {
    return Database.connect(
        driver = driver,
        user = user,
        password = password,
        url = dbUrl
    )
}