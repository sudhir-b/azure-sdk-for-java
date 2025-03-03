// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.fluent.models.ReplicationLinkInner;

public final class ReplicationLinkInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ReplicationLinkInner model = BinaryData.fromString(
            "{\"location\":\"wifto\",\"properties\":{\"isTerminationAllowed\":false,\"replicationMode\":\"uvksgplsaknynfsy\",\"partnerServer\":\"jphuopxodlqi\",\"partnerDatabase\":\"torzih\",\"partnerLocation\":\"osjswsr\",\"role\":\"NonReadableSecondary\",\"partnerRole\":\"Primary\",\"startTime\":\"2021-03-30T08:07:03Z\",\"percentComplete\":671314930,\"replicationState\":\"CATCH_UP\"},\"id\":\"ckqqzqioxiysui\",\"name\":\"zynkedya\",\"type\":\"rwyhqmibzyhwitsm\"}")
            .toObject(ReplicationLinkInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ReplicationLinkInner model = new ReplicationLinkInner();
        model = BinaryData.fromObject(model).toObject(ReplicationLinkInner.class);
    }
}
