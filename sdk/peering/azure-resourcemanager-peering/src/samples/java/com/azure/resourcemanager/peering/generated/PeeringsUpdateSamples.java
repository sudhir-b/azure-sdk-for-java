// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.peering.generated;

import com.azure.resourcemanager.peering.models.Peering;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for Peerings Update.
 */
public final class PeeringsUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/peering/resource-manager/Microsoft.Peering/stable/2021-01-01/examples/UpdatePeeringTags.json
     */
    /**
     * Sample code: Update peering tags.
     * 
     * @param manager Entry point to PeeringManager.
     */
    public static void updatePeeringTags(com.azure.resourcemanager.peering.PeeringManager manager) {
        Peering resource = manager.peerings()
            .getByResourceGroupWithResponse("rgName", "peeringName", com.azure.core.util.Context.NONE)
            .getValue();
        resource.update().withTags(mapOf("tag0", "value0", "tag1", "value1")).apply();
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
