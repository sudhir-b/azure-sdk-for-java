// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.notificationhubs.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Namespace / NotificationHub Regenerate Keys request.
 */
@Fluent
public final class PolicyKeyResource implements JsonSerializable<PolicyKeyResource> {
    /*
     * Type of Shared Access Policy Key (primary or secondary).
     */
    private PolicyKeyType policyKey;

    /**
     * Creates an instance of PolicyKeyResource class.
     */
    public PolicyKeyResource() {
    }

    /**
     * Get the policyKey property: Type of Shared Access Policy Key (primary or secondary).
     * 
     * @return the policyKey value.
     */
    public PolicyKeyType policyKey() {
        return this.policyKey;
    }

    /**
     * Set the policyKey property: Type of Shared Access Policy Key (primary or secondary).
     * 
     * @param policyKey the policyKey value to set.
     * @return the PolicyKeyResource object itself.
     */
    public PolicyKeyResource withPolicyKey(PolicyKeyType policyKey) {
        this.policyKey = policyKey;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (policyKey() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property policyKey in model PolicyKeyResource"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(PolicyKeyResource.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("policyKey", this.policyKey == null ? null : this.policyKey.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PolicyKeyResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PolicyKeyResource if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PolicyKeyResource.
     */
    public static PolicyKeyResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PolicyKeyResource deserializedPolicyKeyResource = new PolicyKeyResource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("policyKey".equals(fieldName)) {
                    deserializedPolicyKeyResource.policyKey = PolicyKeyType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPolicyKeyResource;
        });
    }
}
