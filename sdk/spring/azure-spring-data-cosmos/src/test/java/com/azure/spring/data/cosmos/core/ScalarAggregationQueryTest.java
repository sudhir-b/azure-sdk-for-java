// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.data.cosmos.core;

import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.spring.data.cosmos.core.query.CosmosQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ScalarAggregationQueryTest {

    @Mock
    private CosmosTemplate cosmosTemplate;

    @Test
    public void sumAggregationReturnsScalarValue() {
        // Arrange
        Long expectedSum = 1000L;
        SqlQuerySpec querySpec = new SqlQuerySpec(
            "SELECT VALUE SUM(c.totalCharacters) FROM c WHERE c.datetime >= @currentMinute",
            Arrays.asList(new SqlParameter("@currentMinute", OffsetDateTime.now()))
        );

        // Act
        when(cosmosTemplate.runQuery(eq(querySpec), eq(Long.class), any()))
            .thenReturn(expectedSum);

        // Now call the method through the repository
        Long actualSum = cosmosTemplate.runQuery(querySpec, Long.class, null);

        // Assert
        assertEquals(expectedSum, actualSum, "The SUM() query should return a single Long value");
    }

    @Test
    public void countAggregationReturnsScalarValue() {
        // Arrange
        Long expectedCount = 42L;
        SqlQuerySpec querySpec = new SqlQuerySpec(
            "SELECT VALUE COUNT(1) FROM c",
            List.of()
        );

        // Act
        when(cosmosTemplate.runQuery(eq(querySpec), eq(Long.class), any()))
            .thenReturn(expectedCount);

        // Now call the method through the repository
        Long actualCount = cosmosTemplate.runQuery(querySpec, Long.class, null);

        // Assert
        assertEquals(expectedCount, actualCount, "The COUNT() query should return a single Long value");
    }

    @Test
    public void sumAggregationHandlesNullResult() {
        // Arrange
        SqlQuerySpec querySpec = new SqlQuerySpec(
            "SELECT VALUE SUM(c.totalCharacters) FROM c WHERE c.datetime >= @currentMinute",
            Arrays.asList(new SqlParameter("@currentMinute", OffsetDateTime.now()))
        );

        // Act - Return null from cosmos when no documents match (common for aggregation queries)
        when(cosmosTemplate.runQuery(eq(querySpec), eq(Long.class), any()))
            .thenReturn(null);

        // Now call the method through the repository
        Long actualSum = cosmosTemplate.runQuery(querySpec, Long.class, null);

        // Assert
        assertEquals(null, actualSum, "The SUM() query should return null when no documents match");
    }

    @Test
    public void avgAggregationReturnsDoubleValue() {
        // Arrange
        Double expectedAvg = 75.5;
        SqlQuerySpec querySpec = new SqlQuerySpec(
            "SELECT VALUE AVG(c.someNumber) FROM c",
            List.of()
        );

        // Act
        when(cosmosTemplate.runQuery(eq(querySpec), eq(Double.class), any()))
            .thenReturn(expectedAvg);

        // Now call the method through the repository
        Double actualAvg = cosmosTemplate.runQuery(querySpec, Double.class, null);

        // Assert
        assertEquals(expectedAvg, actualAvg, "The AVG() query should return a single Double value");
    }
}