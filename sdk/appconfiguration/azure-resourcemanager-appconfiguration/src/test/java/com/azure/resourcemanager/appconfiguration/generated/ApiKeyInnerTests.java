// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appconfiguration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appconfiguration.fluent.models.ApiKeyInner;

public final class ApiKeyInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ApiKeyInner model = BinaryData.fromString(
            "{\"id\":\"jqul\",\"name\":\"sntnbybkzgcw\",\"value\":\"clxxwrljdo\",\"connectionString\":\"kcqvkocrc\",\"lastModified\":\"2021-02-11T18:18:15Z\",\"readOnly\":false}")
            .toObject(ApiKeyInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ApiKeyInner model = new ApiKeyInner();
        model = BinaryData.fromObject(model).toObject(ApiKeyInner.class);
    }
}
