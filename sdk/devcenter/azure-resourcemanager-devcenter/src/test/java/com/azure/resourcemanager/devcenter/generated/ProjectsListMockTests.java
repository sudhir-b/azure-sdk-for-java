// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.devcenter.DevCenterManager;
import com.azure.resourcemanager.devcenter.models.CatalogItemType;
import com.azure.resourcemanager.devcenter.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.devcenter.models.Project;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ProjectsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Failed\",\"devCenterUri\":\"fmmfblcqcu\",\"devCenterId\":\"gqibrtalmetttw\",\"description\":\"slqxi\",\"maxDevBoxesPerUser\":5802151,\"displayName\":\"ooizqseyp\",\"catalogSettings\":{\"catalogItemSyncTypes\":[\"EnvironmentDefinition\",\"EnvironmentDefinition\",\"EnvironmentDefinition\",\"EnvironmentDefinition\"]}},\"identity\":{\"principalId\":\"22369ef6-de56-490a-bc42-129c83905bd4\",\"tenantId\":\"f77ab13d-bad7-455d-a3e6-5720c9f15924\",\"type\":\"SystemAssigned, UserAssigned\",\"userAssignedIdentities\":{\"g\":{\"principalId\":\"657c4e08-88e9-47d0-8c77-9e52fb7dc7e0\",\"clientId\":\"48ac03cc-ddfe-4238-8d3b-0873aa610fb5\"},\"oxslh\":{\"principalId\":\"6972d89d-46ba-4a6b-b08d-f42b8ee58e69\",\"clientId\":\"491d961a-82e2-4079-9488-38ecce38859a\"}}},\"location\":\"hlabrq\",\"tags\":{\"aehvvibrxjjstoq\":\"zjcjbtr\",\"bklftidgfcwqmpim\":\"eitpkxztmo\",\"yhohujswtwkozzwc\":\"qxzhem\"},\"id\":\"lkb\",\"name\":\"wpfaj\",\"type\":\"jwltlwtjjgu\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DevCenterManager manager = DevCenterManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Project> response = manager.projects().list(148819128, com.azure.core.util.Context.NONE);

        Assertions.assertEquals("hlabrq", response.iterator().next().location());
        Assertions.assertEquals("zjcjbtr", response.iterator().next().tags().get("aehvvibrxjjstoq"));
        Assertions.assertEquals(ManagedServiceIdentityType.SYSTEM_ASSIGNED_USER_ASSIGNED,
            response.iterator().next().identity().type());
        Assertions.assertEquals("gqibrtalmetttw", response.iterator().next().devCenterId());
        Assertions.assertEquals("slqxi", response.iterator().next().description());
        Assertions.assertEquals(5802151, response.iterator().next().maxDevBoxesPerUser());
        Assertions.assertEquals("ooizqseyp", response.iterator().next().displayName());
        Assertions.assertEquals(CatalogItemType.ENVIRONMENT_DEFINITION,
            response.iterator().next().catalogSettings().catalogItemSyncTypes().get(0));
    }
}
