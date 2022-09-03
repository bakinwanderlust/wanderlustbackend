package de.wanderlustapps.domain.di

import de.wanderlustapps.domain.usecases.LoginWithEmailAndPasswordUseCase
import de.wanderlustapps.domain.usecases.RegisterUseCase
import org.koin.dsl.module

val useCaseModules = module {
    single { LoginWithEmailAndPasswordUseCase() }
    single { RegisterUseCase(get()) }
}