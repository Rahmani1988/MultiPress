package com.reza.multipress.system

import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.countryCode

class IosDeviceLocale: DeviceLocale {
    override fun getCountryCode(): String {
        return NSLocale.currentLocale.countryCode?.lowercase() ?: "us"
    }
}