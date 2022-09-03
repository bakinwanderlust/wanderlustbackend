package de.wanderlustapps.plugins

import de.wanderlustapps.data.di.repoModule
import de.wanderlustapps.domain.di.useCaseModules
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(repoModule, useCaseModules)
    }
}