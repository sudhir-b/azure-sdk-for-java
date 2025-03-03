// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.models.TransparentDataEncryptionListResult;

public final class TransparentDataEncryptionListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TransparentDataEncryptionListResult model = BinaryData.fromString(
            "{\"value\":[{\"location\":\"areqna\",\"properties\":{\"status\":\"Enabled\"},\"id\":\"gjhkycubeddg\",\"name\":\"sofwqmzqalkrmnji\",\"type\":\"pxacqqudfn\"},{\"location\":\"xbaaabjyv\",\"properties\":{\"status\":\"Disabled\"},\"id\":\"imrzrtuzqog\",\"name\":\"exn\",\"type\":\"vfdnwnwmewzsyyce\"},{\"location\":\"soibjudpfrx\",\"properties\":{\"status\":\"Enabled\"},\"id\":\"zvaytdwkqbr\",\"name\":\"ubpaxhe\",\"type\":\"iilivpdtiirqtd\"},{\"location\":\"axoruzfgsquy\",\"properties\":{\"status\":\"Enabled\"},\"id\":\"xleptramx\",\"name\":\"ezw\",\"type\":\"wnwxuqlcvyd\"}],\"nextLink\":\"atdooaojkniod\"}")
            .toObject(TransparentDataEncryptionListResult.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TransparentDataEncryptionListResult model = new TransparentDataEncryptionListResult();
        model = BinaryData.fromObject(model).toObject(TransparentDataEncryptionListResult.class);
    }
}
