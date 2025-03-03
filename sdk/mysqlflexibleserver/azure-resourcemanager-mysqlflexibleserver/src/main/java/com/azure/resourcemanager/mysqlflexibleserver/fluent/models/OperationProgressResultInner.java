// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysqlflexibleserver.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.exception.ManagementError;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.mysqlflexibleserver.models.OperationProgressResponseType;
import com.azure.resourcemanager.mysqlflexibleserver.models.OperationStatusResult;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Represents Operation Results API Response.
 */
@Fluent
public final class OperationProgressResultInner extends OperationStatusResult {
    /*
     * The response properties specific to the operation
     */
    private OperationProgressResponseType properties;

    /*
     * Fully qualified ID of the resource against which the original async operation was started.
     */
    private String resourceId;

    /**
     * Creates an instance of OperationProgressResultInner class.
     */
    public OperationProgressResultInner() {
    }

    /**
     * Get the properties property: The response properties specific to the operation.
     * 
     * @return the properties value.
     */
    public OperationProgressResponseType properties() {
        return this.properties;
    }

    /**
     * Set the properties property: The response properties specific to the operation.
     * 
     * @param properties the properties value to set.
     * @return the OperationProgressResultInner object itself.
     */
    public OperationProgressResultInner withProperties(OperationProgressResponseType properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the resourceId property: Fully qualified ID of the resource against which the original async operation was
     * started.
     * 
     * @return the resourceId value.
     */
    @Override
    public String resourceId() {
        return this.resourceId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationProgressResultInner withId(String id) {
        super.withId(id);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationProgressResultInner withName(String name) {
        super.withName(name);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationProgressResultInner withStatus(String status) {
        super.withStatus(status);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationProgressResultInner withPercentComplete(Float percentComplete) {
        super.withPercentComplete(percentComplete);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationProgressResultInner withStartTime(OffsetDateTime startTime) {
        super.withStartTime(startTime);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationProgressResultInner withEndTime(OffsetDateTime endTime) {
        super.withEndTime(endTime);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationProgressResultInner withOperations(List<OperationStatusResult> operations) {
        super.withOperations(operations);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationProgressResultInner withError(ManagementError error) {
        super.withError(error);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
        if (status() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property status in model OperationProgressResultInner"));
        }
        if (operations() != null) {
            operations().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(OperationProgressResultInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("status", status());
        jsonWriter.writeStringField("id", id());
        jsonWriter.writeStringField("name", name());
        jsonWriter.writeNumberField("percentComplete", percentComplete());
        jsonWriter.writeStringField("startTime",
            startTime() == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(startTime()));
        jsonWriter.writeStringField("endTime",
            endTime() == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(endTime()));
        jsonWriter.writeArrayField("operations", operations(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("error", error());
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of OperationProgressResultInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of OperationProgressResultInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the OperationProgressResultInner.
     */
    public static OperationProgressResultInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OperationProgressResultInner deserializedOperationProgressResultInner = new OperationProgressResultInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("status".equals(fieldName)) {
                    deserializedOperationProgressResultInner.withStatus(reader.getString());
                } else if ("id".equals(fieldName)) {
                    deserializedOperationProgressResultInner.withId(reader.getString());
                } else if ("resourceId".equals(fieldName)) {
                    deserializedOperationProgressResultInner.resourceId = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedOperationProgressResultInner.withName(reader.getString());
                } else if ("percentComplete".equals(fieldName)) {
                    deserializedOperationProgressResultInner
                        .withPercentComplete(reader.getNullable(JsonReader::getFloat));
                } else if ("startTime".equals(fieldName)) {
                    deserializedOperationProgressResultInner.withStartTime(reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString())));
                } else if ("endTime".equals(fieldName)) {
                    deserializedOperationProgressResultInner.withEndTime(reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString())));
                } else if ("operations".equals(fieldName)) {
                    List<OperationStatusResult> operations
                        = reader.readArray(reader1 -> OperationStatusResult.fromJson(reader1));
                    deserializedOperationProgressResultInner.withOperations(operations);
                } else if ("error".equals(fieldName)) {
                    deserializedOperationProgressResultInner.withError(ManagementError.fromJson(reader));
                } else if ("properties".equals(fieldName)) {
                    deserializedOperationProgressResultInner.properties
                        = OperationProgressResponseType.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedOperationProgressResultInner;
        });
    }
}
