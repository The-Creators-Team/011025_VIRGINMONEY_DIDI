package compose.project.virginmoney.domain

import compose.project.virginmoney.data.network.NetworkClient
import compose.project.virginmoney.domain.repository.PeopleRepository
import compose.project.virginmoney.domain.repository.RoomsRepository
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun startKoin() {
    startKoin {
        modules(sharedModule)
    }
}

val sharedModule: Module = module {
    single { NetworkClient() }
    single { PeopleRepository(get()) }
    single { RoomsRepository(get()) }
}
