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
package com.example.domain;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Singleton;


@Singleton
public class MessageRepository {
  private static final Logger log = LoggerFactory.getLogger(MessageRepository.class);

  private final Firestore firestore;

  public MessageRepository(Firestore firestore) {
    this.firestore = firestore;
  }

  public ApiFuture<WriteResult> update(String source, String newValue)
  {
    Map<String, String> newFields = Map.of("original", newValue);

    return firestore.document(source).set(newFields, SetOptions.merge());
  }
}
