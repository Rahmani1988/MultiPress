package com.reza.multipress.system

import java.util.Locale

class AndroidDeviceLocale: DeviceLocale {
    override fun getCountryCode(): String {
        return Locale.getDefault().country.lowercase()
    }
}