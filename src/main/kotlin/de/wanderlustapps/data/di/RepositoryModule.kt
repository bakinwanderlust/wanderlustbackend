package de.wanderlustapps.data.di

import de.wanderlustapps.data.repo.AuthRepository
import org.koin.dsl.module

val repoModule = module {
    single { AuthRepository() }
}