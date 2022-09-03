package de.wanderlustapps.data.entity

import de.wanderlustapps.core.serializers.LocalDateTimeSerializer
import de.wanderlustapps.data.table.UserTable
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

@kotlinx.serialization.Serializable
data class UserEntity(
    val id: Int,
    val email: String,
    @kotlinx.serialization.Serializable(with = LocalDateTimeSerializer::class)
    val created_at: LocalDateTime,
) {
    companion object {
        fun fromRow(row: ResultRow): UserEntity {
            return UserEntity(
                id = row[UserTable.id].value,
                email = row[UserTable.email],
                created_at = row[UserTable.created_at]
            )
        }
    }
}
