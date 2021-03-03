//
// Copyright 2021 the original author or authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
package com.example.service;

import com.example.domain.MessageRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.functions.Context;
import com.google.gson.JsonObject;
import java.util.Locale;


public class MessageService {
  private static final String DOCUMENTS = "/documents/";
  private static final String QUOTE = "\"";
  private static final String EMPTY = "";
  MessageRepository messageRepository;

  public ApiFuture<WriteResult> updateRecord(Context context, JsonObject value)
    throws IllegalArgumentException
  {
    String currentValue = null;
    if (value != null) {
      value = value.getAsJsonObject("fields");
    }
    if (value != null) {
      value = value.getAsJsonObject("original");
    }
    if (value != null && value.has("stringValue")) {
      currentValue = value.get("stringValue").getAsString();
    }
    if (currentValue == null) {
      throw new IllegalArgumentException("Malformed JSON: " + value);
    }
    String newValue = currentValue.toUpperCase(Locale.getDefault());

    return messageRepository.update(getSource(context), newValue);
  }

  private String getSource(Context context) {
    return context.resource().split(DOCUMENTS)[1].replace(QUOTE, EMPTY);
  }
}
