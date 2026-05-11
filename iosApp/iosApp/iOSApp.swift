import SwiftUI

import ComposeApp

@main
struct iOSApp: App {

    init() {
        ComposeApp.KoinHelperKt.doInitKoinIos()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}