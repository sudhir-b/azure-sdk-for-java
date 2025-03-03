// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The number of days used to look back.
 */
public final class LookBackPeriod extends ExpandableStringEnum<LookBackPeriod> {
    /**
     * Static value Last7Days for LookBackPeriod.
     */
    public static final LookBackPeriod LAST7DAYS = fromString("Last7Days");

    /**
     * Static value Last30Days for LookBackPeriod.
     */
    public static final LookBackPeriod LAST30DAYS = fromString("Last30Days");

    /**
     * Static value Last60Days for LookBackPeriod.
     */
    public static final LookBackPeriod LAST60DAYS = fromString("Last60Days");

    /**
     * Creates a new instance of LookBackPeriod value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public LookBackPeriod() {
    }

    /**
     * Creates or finds a LookBackPeriod from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding LookBackPeriod.
     */
    public static LookBackPeriod fromString(String name) {
        return fromString(name, LookBackPeriod.class);
    }

    /**
     * Gets known LookBackPeriod values.
     * 
     * @return known LookBackPeriod values.
     */
    public static Collection<LookBackPeriod> values() {
        return values(LookBackPeriod.class);
    }
}
