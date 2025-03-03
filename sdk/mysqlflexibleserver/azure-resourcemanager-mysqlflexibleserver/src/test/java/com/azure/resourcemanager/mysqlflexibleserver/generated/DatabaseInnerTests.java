// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysqlflexibleserver.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mysqlflexibleserver.fluent.models.DatabaseInner;
import org.junit.jupiter.api.Assertions;

public final class DatabaseInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DatabaseInner model = BinaryData.fromString(
            "{\"properties\":{\"charset\":\"c\",\"collation\":\"c\"},\"id\":\"ierhhbcsglummaj\",\"name\":\"j\",\"type\":\"odxobnbdxkqpxok\"}")
            .toObject(DatabaseInner.class);
        Assertions.assertEquals("c", model.charset());
        Assertions.assertEquals("c", model.collation());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DatabaseInner model = new DatabaseInner().withCharset("c").withCollation("c");
        model = BinaryData.fromObject(model).toObject(DatabaseInner.class);
        Assertions.assertEquals("c", model.charset());
        Assertions.assertEquals("c", model.collation());
    }
}
