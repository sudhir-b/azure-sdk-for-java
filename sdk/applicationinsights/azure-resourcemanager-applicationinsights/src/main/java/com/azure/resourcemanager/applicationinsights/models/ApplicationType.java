// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.applicationinsights.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Type of application being monitored.
 */
public final class ApplicationType extends ExpandableStringEnum<ApplicationType> {
    /**
     * Static value web for ApplicationType.
     */
    public static final ApplicationType WEB = fromString("web");

    /**
     * Static value other for ApplicationType.
     */
    public static final ApplicationType OTHER = fromString("other");

    /**
     * Creates a new instance of ApplicationType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ApplicationType() {
    }

    /**
     * Creates or finds a ApplicationType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ApplicationType.
     */
    public static ApplicationType fromString(String name) {
        return fromString(name, ApplicationType.class);
    }

    /**
     * Gets known ApplicationType values.
     * 
     * @return known ApplicationType values.
     */
    public static Collection<ApplicationType> values() {
        return values(ApplicationType.class);
    }
}
