// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.security.keyvault.administration;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.policy.ExponentialBackoffOptions;
import com.azure.core.http.policy.FixedDelayOptions;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.RetryOptions;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.core.util.ClientOptions;
import com.azure.core.util.Header;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyVaultBackupClientBuilderTest {
    private String vaultUrl;
    private String blobStorageUrl;
    private String sasToken;
    private KeyVaultAdministrationServiceVersion serviceVersion;

    @BeforeEach
    public void setUp() {
        vaultUrl = "https://key-vault-url.vault.azure.net/";
        blobStorageUrl = "https://testaccount.blob.core.windows.net/backup";
        sasToken = "someSasToken";
        serviceVersion = KeyVaultAdministrationServiceVersion.getLatest();
    }

    @Test
    public void buildSyncClientTest() {
        KeyVaultBackupClient keyVaultBackupClient = new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
            .serviceVersion(serviceVersion)
            .credential(new TestUtils.TestCredential())
            .httpClient(request -> Mono.just(new MockHttpResponse(request, 200)))
            .buildClient();

        assertNotNull(keyVaultBackupClient);
        assertEquals(KeyVaultBackupClient.class.getSimpleName(), keyVaultBackupClient.getClass().getSimpleName());
    }

    @Test
    public void buildSyncClientUsingDefaultApiVersionTest() {
        KeyVaultBackupClient keyVaultBackupClient = new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
            .credential(new TestUtils.TestCredential())
            .httpClient(request -> Mono.just(new MockHttpResponse(request, 200)))
            .buildClient();

        assertNotNull(keyVaultBackupClient);
        assertEquals(KeyVaultBackupClient.class.getSimpleName(), keyVaultBackupClient.getClass().getSimpleName());
    }

    @Test
    public void buildAsyncClientTest() {
        KeyVaultBackupAsyncClient keyVaultBackupAsyncClient = new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
            .serviceVersion(serviceVersion)
            .credential(new TestUtils.TestCredential())
            .httpClient(request -> Mono.just(new MockHttpResponse(request, 200)))
            .buildAsyncClient();

        assertNotNull(keyVaultBackupAsyncClient);
        assertEquals(KeyVaultBackupAsyncClient.class.getSimpleName(),
            keyVaultBackupAsyncClient.getClass().getSimpleName());
    }

    @Test
    public void buildAsyncClientUsingDefaultApiVersionTest() {
        KeyVaultBackupAsyncClient keyVaultBackupAsyncClient = new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
            .credential(new TestUtils.TestCredential())
            .httpClient(request -> Mono.just(new MockHttpResponse(request, 200)))
            .buildAsyncClient();

        assertNotNull(keyVaultBackupAsyncClient);
        assertEquals(KeyVaultBackupAsyncClient.class.getSimpleName(),
            keyVaultBackupAsyncClient.getClass().getSimpleName());
    }

    @Test
    public void emptyVaultUrlThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new KeyVaultBackupClientBuilder().vaultUrl(""));
    }

    @Test
    public void nullCredentialThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new KeyVaultBackupClientBuilder().credential(null));
    }

    @Test
    public void clientOptionsIsPreferredOverLogOptions() {
        KeyVaultBackupClient keyVaultBackupClient = new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
            .credential(new TestUtils.TestCredential())
            .httpLogOptions(new HttpLogOptions().setApplicationId("anOldApplication"))
            .clientOptions(new ClientOptions().setApplicationId("aNewApplication"))
            .retryOptions(new RetryOptions(new FixedDelayOptions(0, Duration.ZERO)))
            .httpClient(httpRequest -> {
                assertTrue(httpRequest.getHeaders().getValue(HttpHeaderName.USER_AGENT).contains("aNewApplication"));
                return Mono.error(new HttpResponseException(new MockHttpResponse(httpRequest, 400)));
            })
            .buildClient();

        assertThrows(RuntimeException.class, () -> keyVaultBackupClient.beginBackup(blobStorageUrl, sasToken));
    }

    @Test
    public void applicationIdFallsBackToLogOptions() {
        KeyVaultBackupClient keyVaultBackupClient = new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
            .credential(new TestUtils.TestCredential())
            .httpLogOptions(new HttpLogOptions().setApplicationId("anOldApplication"))
            .retryOptions(new RetryOptions(new FixedDelayOptions(0, Duration.ZERO)))
            .httpClient(httpRequest -> {
                assertTrue(httpRequest.getHeaders().getValue(HttpHeaderName.USER_AGENT).contains("anOldApplication"));
                return Mono.error(new HttpResponseException(new MockHttpResponse(httpRequest, 400)));
            })
            .buildClient();

        assertThrows(RuntimeException.class, () -> keyVaultBackupClient.beginBackup(blobStorageUrl, sasToken));
    }

    @Test
    public void clientOptionHeadersAreAddedLast() {
        KeyVaultBackupClient keyVaultBackupClient = new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
            .credential(new TestUtils.TestCredential())
            .clientOptions(
                new ClientOptions().setHeaders(Collections.singletonList(new Header("User-Agent", "custom"))))
            .retryOptions(new RetryOptions(new FixedDelayOptions(0, Duration.ZERO)))
            .httpClient(httpRequest -> {
                assertEquals("custom", httpRequest.getHeaders().getValue(HttpHeaderName.USER_AGENT));
                return Mono.error(new HttpResponseException(new MockHttpResponse(httpRequest, 400)));
            })
            .buildClient();

        assertThrows(RuntimeException.class, () -> keyVaultBackupClient.beginBackup(blobStorageUrl, sasToken));
    }

    @Test
    public void bothRetryOptionsAndRetryPolicySet() {
        assertThrows(IllegalStateException.class,
            () -> new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
                .serviceVersion(serviceVersion)
                .credential(new TestUtils.TestCredential())
                .retryOptions(new RetryOptions(new ExponentialBackoffOptions()))
                .retryPolicy(new RetryPolicy())
                .httpClient(request -> Mono.just(new MockHttpResponse(request, 200)))
                .buildClient());
    }

    // This tests the policy is in the right place because if it were added per retry, it would be after the credentials
    // and auth would fail because we changed a signed header.
    @Test
    public void addPerCallPolicy() {
        KeyVaultBackupAsyncClient keyVaultBackupAsyncClient = new KeyVaultBackupClientBuilder().vaultUrl(vaultUrl)
            .credential(new TestUtils.TestCredential())
            .addPolicy(new TestUtils.PerCallPolicy())
            .addPolicy(new TestUtils.PerRetryPolicy())
            .httpClient(request -> Mono.just(new MockHttpResponse(request, 200)))
            .buildAsyncClient();

        HttpPipeline pipeline = keyVaultBackupAsyncClient.getHttpPipeline();

        int retryPolicyPosition = -1, perCallPolicyPosition = -1, perRetryPolicyPosition = -1;

        for (int i = 0; i < pipeline.getPolicyCount(); i++) {
            if (pipeline.getPolicy(i).getClass() == RetryPolicy.class) {
                retryPolicyPosition = i;
            }

            if (pipeline.getPolicy(i).getClass() == TestUtils.PerCallPolicy.class) {
                perCallPolicyPosition = i;
            }

            if (pipeline.getPolicy(i).getClass() == TestUtils.PerRetryPolicy.class) {
                perRetryPolicyPosition = i;
            }
        }

        assertTrue(perCallPolicyPosition != -1);
        assertTrue(perCallPolicyPosition < retryPolicyPosition);
        assertTrue(retryPolicyPosition < perRetryPolicyPosition);
    }
}
