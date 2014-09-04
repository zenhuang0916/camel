/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.google.drive;

import java.io.IOException;
import java.util.Map;

import org.apache.camel.Processor;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.util.component.AbstractApiConsumer;
import org.apache.camel.util.component.ApiMethod;
import org.apache.camel.component.google.drive.internal.GoogleDriveApiName;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;

/**
 * The GoogleDrive consumer.
 */
public class GoogleDriveConsumer extends AbstractApiConsumer<GoogleDriveApiName, GoogleDriveConfiguration> {

    public GoogleDriveConsumer(GoogleDriveEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    } 
    
    @Override
    protected Object doInvokeMethod(Map<String, Object> properties) throws RuntimeCamelException {
        AbstractGoogleClientRequest request = (AbstractGoogleClientRequest) super.doInvokeMethod(properties);
        // TODO set any generic params, like OAuth token, etc.
        try {
            return request.execute();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }    
}
