// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.fluent.models.SqlPoolColumnProperties;
import com.azure.resourcemanager.synapse.models.ColumnDataType;
import org.junit.jupiter.api.Assertions;

public final class SqlPoolColumnPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SqlPoolColumnProperties model = BinaryData.fromString("{\"columnType\":\"datetimeoffset\",\"isComputed\":true}")
            .toObject(SqlPoolColumnProperties.class);
        Assertions.assertEquals(ColumnDataType.DATETIMEOFFSET, model.columnType());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SqlPoolColumnProperties model = new SqlPoolColumnProperties().withColumnType(ColumnDataType.DATETIMEOFFSET);
        model = BinaryData.fromObject(model).toObject(SqlPoolColumnProperties.class);
        Assertions.assertEquals(ColumnDataType.DATETIMEOFFSET, model.columnType());
    }
}
