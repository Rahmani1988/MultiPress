package com.reza.multipress.di

import com.reza.multipress.system.AndroidDeviceLocale
import com.reza.multipress.system.DeviceLocale
import org.koin.dsl.module

actual val platformModule = module {
    single<DeviceLocale> { AndroidDeviceLocale() }
}