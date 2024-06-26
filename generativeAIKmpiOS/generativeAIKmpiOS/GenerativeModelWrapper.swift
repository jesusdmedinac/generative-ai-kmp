//
//  GenerativeModelWrapper.swift
//  generativeAIKmpiOS
//
//  Created by Jesus Daniel Medina Cruz on 25/06/24.
//

import Foundation
import GoogleGenerativeAI

@objcMembers
class GenerativeModelWrapper : NSObject {
  let generativeModel: GenerativeModel
  
  init(
    name: String,
    apiKey: String
  ) {
    self.generativeModel = GenerativeModel(name: name, apiKey: apiKey)
  }
}
