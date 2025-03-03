// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.notificationhubs.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Description of a NotificationHub XiaomiCredentialProperties.
 */
@Fluent
public final class XiaomiCredentialProperties implements JsonSerializable<XiaomiCredentialProperties> {
    /*
     * Gets or sets app secret.
     */
    private String appSecret;

    /*
     * Gets or sets xiaomi service endpoint.
     */
    private String endpoint;

    /**
     * Creates an instance of XiaomiCredentialProperties class.
     */
    public XiaomiCredentialProperties() {
    }

    /**
     * Get the appSecret property: Gets or sets app secret.
     * 
     * @return the appSecret value.
     */
    public String appSecret() {
        return this.appSecret;
    }

    /**
     * Set the appSecret property: Gets or sets app secret.
     * 
     * @param appSecret the appSecret value to set.
     * @return the XiaomiCredentialProperties object itself.
     */
    public XiaomiCredentialProperties withAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    /**
     * Get the endpoint property: Gets or sets xiaomi service endpoint.
     * 
     * @return the endpoint value.
     */
    public String endpoint() {
        return this.endpoint;
    }

    /**
     * Set the endpoint property: Gets or sets xiaomi service endpoint.
     * 
     * @param endpoint the endpoint value to set.
     * @return the XiaomiCredentialProperties object itself.
     */
    public XiaomiCredentialProperties withEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("appSecret", this.appSecret);
        jsonWriter.writeStringField("endpoint", this.endpoint);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of XiaomiCredentialProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of XiaomiCredentialProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the XiaomiCredentialProperties.
     */
    public static XiaomiCredentialProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            XiaomiCredentialProperties deserializedXiaomiCredentialProperties = new XiaomiCredentialProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("appSecret".equals(fieldName)) {
                    deserializedXiaomiCredentialProperties.appSecret = reader.getString();
                } else if ("endpoint".equals(fieldName)) {
                    deserializedXiaomiCredentialProperties.endpoint = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedXiaomiCredentialProperties;
        });
    }
}
