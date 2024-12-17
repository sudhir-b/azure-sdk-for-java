// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.core.http;

import io.clientcore.core.http.client.HttpClient;
import io.clientcore.core.http.models.HttpRetryOptions;
import io.clientcore.core.http.pipeline.HttpPipeline;
import java.time.Duration;
import io.clientcore.core.http.pipeline.HttpPipelineBuilder;
import io.clientcore.core.http.pipeline.HttpRetryPolicy;

/**
 * Codesnippets for {@link HttpPipelineBuilder}.
 */
public class HttpPipelineBuilderJavaDocCodeSnippets {
    public void noConfigurationBuild() {
        // BEGIN: io.clientcore.core.http.HttpPipelineBuilder.noConfiguration
        HttpPipeline pipeline = new HttpPipelineBuilder().build();
        // END: io.clientcore.core.http.HttpPipelineBuilder.noConfiguration
    }

    public void defaultHttpClientWithRetryPolicyBuild() {
        // BEGIN: io.clientcore.core.http.HttpPipelineBuilder.defaultHttpClientWithRetryPolicy
        HttpPipeline pipeline = new HttpPipelineBuilder()
            .httpClient(HttpClient.getNewInstance())
            .policies(new HttpRetryPolicy(new HttpRetryOptions(3, Duration.ofSeconds(1))))
            .build();
        // END: io.clientcore.core.http.HttpPipelineBuilder.defaultHttpClientWithRetryPolicy
    }
}
