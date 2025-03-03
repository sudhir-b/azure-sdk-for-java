// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mixedreality.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.mixedreality.MixedRealityManager;
import com.azure.resourcemanager.mixedreality.models.ResourceIdentityType;
import com.azure.resourcemanager.mixedreality.models.SkuTier;
import com.azure.resourcemanager.mixedreality.models.SpatialAnchorsAccount;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SpatialAnchorsAccountsGetByResourceGroupWithResponseMockTests {
    @Test
    public void testGetByResourceGroupWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"storageAccountName\":\"pvgqzcjrvxdjzlm\",\"accountId\":\"xkvugfhzov\",\"accountDomain\":\"jvzunluthnnp\"},\"identity\":{\"principalId\":\"i\",\"tenantId\":\"ilpjzuaejxdult\",\"type\":\"SystemAssigned\"},\"plan\":{\"principalId\":\"tdzumveekgpw\",\"tenantId\":\"uh\",\"type\":\"SystemAssigned\"},\"sku\":{\"name\":\"sjyofdx\",\"tier\":\"Free\",\"size\":\"dttouwaboekqvkel\",\"family\":\"mvb\",\"capacity\":1393240700},\"kind\":{\"name\":\"sflhhca\",\"tier\":\"Free\",\"size\":\"ixisxyawjoy\",\"family\":\"cslyjpk\",\"capacity\":888543440},\"location\":\"yexz\",\"tags\":{\"lhbnxkna\":\"ixhnrztf\",\"pnapnyiropuh\":\"aulppggd\",\"git\":\"igvpgylg\"},\"id\":\"medjvcslynqwwncw\",\"name\":\"zhxgktrmgucn\",\"type\":\"pkteo\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        MixedRealityManager manager = MixedRealityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        SpatialAnchorsAccount response = manager.spatialAnchorsAccounts()
            .getByResourceGroupWithResponse("e", "qsgzvahapj", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("yexz", response.location());
        Assertions.assertEquals("ixhnrztf", response.tags().get("lhbnxkna"));
        Assertions.assertEquals(ResourceIdentityType.SYSTEM_ASSIGNED, response.identity().type());
        Assertions.assertEquals(ResourceIdentityType.SYSTEM_ASSIGNED, response.plan().type());
        Assertions.assertEquals("sjyofdx", response.sku().name());
        Assertions.assertEquals(SkuTier.FREE, response.sku().tier());
        Assertions.assertEquals("dttouwaboekqvkel", response.sku().size());
        Assertions.assertEquals("mvb", response.sku().family());
        Assertions.assertEquals(1393240700, response.sku().capacity());
        Assertions.assertEquals("sflhhca", response.kind().name());
        Assertions.assertEquals(SkuTier.FREE, response.kind().tier());
        Assertions.assertEquals("ixisxyawjoy", response.kind().size());
        Assertions.assertEquals("cslyjpk", response.kind().family());
        Assertions.assertEquals(888543440, response.kind().capacity());
        Assertions.assertEquals("pvgqzcjrvxdjzlm", response.storageAccountName());
    }
}
