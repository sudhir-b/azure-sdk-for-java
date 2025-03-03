// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.fluent.models.GroupCreateParametersProperties;
import com.azure.resourcemanager.apimanagement.models.GroupType;
import org.junit.jupiter.api.Assertions;

public final class GroupCreateParametersPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GroupCreateParametersProperties model = BinaryData.fromString(
            "{\"displayName\":\"zqfsgnwdxzed\",\"description\":\"l\",\"type\":\"custom\",\"externalId\":\"rxipmlnfyzav\"}")
            .toObject(GroupCreateParametersProperties.class);
        Assertions.assertEquals("zqfsgnwdxzed", model.displayName());
        Assertions.assertEquals("l", model.description());
        Assertions.assertEquals(GroupType.CUSTOM, model.type());
        Assertions.assertEquals("rxipmlnfyzav", model.externalId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GroupCreateParametersProperties model = new GroupCreateParametersProperties().withDisplayName("zqfsgnwdxzed")
            .withDescription("l")
            .withType(GroupType.CUSTOM)
            .withExternalId("rxipmlnfyzav");
        model = BinaryData.fromObject(model).toObject(GroupCreateParametersProperties.class);
        Assertions.assertEquals("zqfsgnwdxzed", model.displayName());
        Assertions.assertEquals("l", model.description());
        Assertions.assertEquals(GroupType.CUSTOM, model.type());
        Assertions.assertEquals("rxipmlnfyzav", model.externalId());
    }
}
