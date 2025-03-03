// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.DatasetFolder;
import com.azure.resourcemanager.datafactory.models.DrillTableDataset;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.ParameterSpecification;
import com.azure.resourcemanager.datafactory.models.ParameterType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class DrillTableDatasetTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DrillTableDataset model = BinaryData.fromString(
            "{\"type\":\"DrillTable\",\"typeProperties\":{\"tableName\":\"datafvkywzrqeiad\",\"table\":\"datakhuvnl\",\"schema\":\"datacnuti\"},\"description\":\"mizunzbqvioync\",\"structure\":\"dataqhhvvwz\",\"schema\":\"datajaaaiaibtvavly\",\"linkedServiceName\":{\"referenceName\":\"qtlocnwmef\",\"parameters\":{\"bzgy\":\"datauzqcrlkor\",\"nozf\":\"dataenfsfyqncowm\",\"agwaakktbjort\":\"dataywjiaaosla\"}},\"parameters\":{\"zbkd\":{\"type\":\"Bool\",\"defaultValue\":\"dataqhsnsejplislxyl\"},\"rpea\":{\"type\":\"Object\",\"defaultValue\":\"datajwxgvtkjct\"},\"aitrms\":{\"type\":\"Float\",\"defaultValue\":\"datakvfccozvqxspht\"},\"poegyckm\":{\"type\":\"SecureString\",\"defaultValue\":\"datatuytgcptct\"}},\"annotations\":[\"datavrcclclfkfv\",\"dataj\"],\"folder\":{\"name\":\"wrvp\"},\"\":{\"b\":\"datajylxt\",\"aysqwh\":\"datasewfzvv\",\"tcvpvdfmo\":\"datadcyandblkb\",\"sqpffapjpjmsbzz\":\"dataqctfvxu\"}}")
            .toObject(DrillTableDataset.class);
        Assertions.assertEquals("mizunzbqvioync", model.description());
        Assertions.assertEquals("qtlocnwmef", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.BOOL, model.parameters().get("zbkd").type());
        Assertions.assertEquals("wrvp", model.folder().name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DrillTableDataset model = new DrillTableDataset().withDescription("mizunzbqvioync")
            .withStructure("dataqhhvvwz")
            .withSchema("datajaaaiaibtvavly")
            .withLinkedServiceName(new LinkedServiceReference().withReferenceName("qtlocnwmef")
                .withParameters(
                    mapOf("bzgy", "datauzqcrlkor", "nozf", "dataenfsfyqncowm", "agwaakktbjort", "dataywjiaaosla")))
            .withParameters(mapOf("zbkd",
                new ParameterSpecification().withType(ParameterType.BOOL).withDefaultValue("dataqhsnsejplislxyl"),
                "rpea", new ParameterSpecification().withType(ParameterType.OBJECT).withDefaultValue("datajwxgvtkjct"),
                "aitrms",
                new ParameterSpecification().withType(ParameterType.FLOAT).withDefaultValue("datakvfccozvqxspht"),
                "poegyckm",
                new ParameterSpecification().withType(ParameterType.SECURE_STRING).withDefaultValue("datatuytgcptct")))
            .withAnnotations(Arrays.asList("datavrcclclfkfv", "dataj"))
            .withFolder(new DatasetFolder().withName("wrvp"))
            .withTableName("datafvkywzrqeiad")
            .withTable("datakhuvnl")
            .withSchemaTypePropertiesSchema("datacnuti");
        model = BinaryData.fromObject(model).toObject(DrillTableDataset.class);
        Assertions.assertEquals("mizunzbqvioync", model.description());
        Assertions.assertEquals("qtlocnwmef", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.BOOL, model.parameters().get("zbkd").type());
        Assertions.assertEquals("wrvp", model.folder().name());
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
