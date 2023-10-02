import SwiftUI
import shared

@main
struct iOSApp: App {
    let sdk = SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory())
    
	var body: some Scene {
		WindowGroup {
            //ContentView(viewModel: ContentView.ViewModel())
            ContentView2(viewModel2: .init(sdk: sdk))
		}
	}
}