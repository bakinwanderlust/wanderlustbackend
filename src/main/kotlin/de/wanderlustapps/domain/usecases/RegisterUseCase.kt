package de.wanderlustapps.domain.usecases

import de.wanderlustapps.data.repo.AuthRepository

class RegisterUseCase constructor(
    private val authRepository: AuthRepository
) {
    fun invoke(mail: String): Result<Int> {
        return authRepository.insertUser(mail)
    }
}