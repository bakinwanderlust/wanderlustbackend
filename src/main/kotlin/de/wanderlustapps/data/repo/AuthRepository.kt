package de.wanderlustapps.data.repo

import de.wanderlustapps.data.database.getMysqlDb
import de.wanderlustapps.data.table.UserTable
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

class AuthRepository {
    fun insertUser(emailValue: String): Result<Int> {
        return try {
            transaction(getMysqlDb()) {
                val id = UserTable.insertAndGetId {
                    it[email] = emailValue
                }

                return@transaction Result.success(id.value)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}