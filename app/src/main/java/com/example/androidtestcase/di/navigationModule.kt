package com.example.androidtestcase.di

import com.example.androidtestcase.navigation.GlobalRouter
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

val navigationModule = module {

    single<Cicerone<GlobalRouter>> { Cicerone.create(GlobalRouter()) }
    single<GlobalRouter> { get<Cicerone<GlobalRouter>>().router }
    single<NavigatorHolder> { get<Cicerone<GlobalRouter>>().navigatorHolder }
}