// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datalakestore.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datalakestore.fluent.models.CreateOrUpdateVirtualNetworkRuleProperties;
import java.io.IOException;

/**
 * The parameters used to create a new virtual network rule while creating a new Data Lake Store account.
 */
@Fluent
public final class CreateVirtualNetworkRuleWithAccountParameters
    implements JsonSerializable<CreateVirtualNetworkRuleWithAccountParameters> {
    /*
     * The unique name of the virtual network rule to create.
     */
    private String name;

    /*
     * The virtual network rule properties to use when creating a new virtual network rule.
     */
    private CreateOrUpdateVirtualNetworkRuleProperties innerProperties
        = new CreateOrUpdateVirtualNetworkRuleProperties();

    /**
     * Creates an instance of CreateVirtualNetworkRuleWithAccountParameters class.
     */
    public CreateVirtualNetworkRuleWithAccountParameters() {
    }

    /**
     * Get the name property: The unique name of the virtual network rule to create.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The unique name of the virtual network rule to create.
     * 
     * @param name the name value to set.
     * @return the CreateVirtualNetworkRuleWithAccountParameters object itself.
     */
    public CreateVirtualNetworkRuleWithAccountParameters withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the innerProperties property: The virtual network rule properties to use when creating a new virtual network
     * rule.
     * 
     * @return the innerProperties value.
     */
    private CreateOrUpdateVirtualNetworkRuleProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the subnetId property: The resource identifier for the subnet.
     * 
     * @return the subnetId value.
     */
    public String subnetId() {
        return this.innerProperties() == null ? null : this.innerProperties().subnetId();
    }

    /**
     * Set the subnetId property: The resource identifier for the subnet.
     * 
     * @param subnetId the subnetId value to set.
     * @return the CreateVirtualNetworkRuleWithAccountParameters object itself.
     */
    public CreateVirtualNetworkRuleWithAccountParameters withSubnetId(String subnetId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CreateOrUpdateVirtualNetworkRuleProperties();
        }
        this.innerProperties().withSubnetId(subnetId);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property name in model CreateVirtualNetworkRuleWithAccountParameters"));
        }
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property innerProperties in model CreateVirtualNetworkRuleWithAccountParameters"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(CreateVirtualNetworkRuleWithAccountParameters.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CreateVirtualNetworkRuleWithAccountParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CreateVirtualNetworkRuleWithAccountParameters if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CreateVirtualNetworkRuleWithAccountParameters.
     */
    public static CreateVirtualNetworkRuleWithAccountParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CreateVirtualNetworkRuleWithAccountParameters deserializedCreateVirtualNetworkRuleWithAccountParameters
                = new CreateVirtualNetworkRuleWithAccountParameters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedCreateVirtualNetworkRuleWithAccountParameters.name = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedCreateVirtualNetworkRuleWithAccountParameters.innerProperties
                        = CreateOrUpdateVirtualNetworkRuleProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCreateVirtualNetworkRuleWithAccountParameters;
        });
    }
}
