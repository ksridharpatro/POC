//
//  ContentView2.swift
//  iosApp
//
//  Created by Sridhar on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ContentView2: View {
    @ObservedObject private(set) var viewModel2: ViewModel2
    
    var body: some View {
             NavigationView {
                 listView()
                 .navigationBarTitle("SpaceX Launches")
                 .navigationBarItems(trailing:
                     Button("Reload") {
                         self.viewModel2.loadLaunches(forceReload: true)
                 })
             }
         }

         private func listView() -> AnyView {
             switch viewModel2.launches {
             case .loading:
                 return AnyView(Text("Loading...").multilineTextAlignment(.center))
             case .result(let launches):
                 return AnyView(List(launches) { launch in
                     RocketLaunchRow(rocketLaunch: launch)
                 })
             case .error(let description):
                 return AnyView(Text(description).multilineTextAlignment(.center))
             }
         }

}

extension ContentView2 {
    enum LoadableLaunches {
        case loading
        case result([RocketLaunch])
        case error(String)
    }

   @MainActor
   class ViewModel2: ObservableObject {
       let sdk: SpaceXSDK
       @Published var launches = LoadableLaunches.loading

       init(sdk: SpaceXSDK) {
           self.sdk = sdk
           self.loadLaunches(forceReload: false)
       }

       func loadLaunches(forceReload: Bool) {
           Task {
                   do {
                       self.launches = .loading
                       let launches = try await sdk.getLaunches(forceReload: forceReload)
                       self.launches = .result(launches)
                   } catch {
                       self.launches = .error(error.localizedDescription)
                   }
               }
       }
   }
}

extension RocketLaunch: Identifiable { }
