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
package com.example;

import com.example.domain.FirestoreMessage;
import com.example.service.MessageService;
import com.google.cloud.functions.*;
import io.micronaut.gcp.function.GoogleFunctionInitializer;

import javax.inject.*;


public class Example
    extends GoogleFunctionInitializer
  implements BackgroundFunction<FirestoreMessage> {

    @Inject
    MessageService messageService;

    @Override
    public void accept(FirestoreMessage message, Context context) {
        messageService.updateRecord(context, message.getValue());
    }
}
