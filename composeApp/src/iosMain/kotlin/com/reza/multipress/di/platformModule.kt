package com.reza.multipress.di

import com.reza.multipress.system.DeviceLocale
import com.reza.multipress.system.IosDeviceLocale
import org.koin.dsl.module

actual val platformModule = module {
    single<DeviceLocale> { IosDeviceLocale() }
}