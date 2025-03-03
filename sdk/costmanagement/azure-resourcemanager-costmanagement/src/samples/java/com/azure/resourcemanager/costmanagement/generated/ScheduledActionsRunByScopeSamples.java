// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.generated;

/**
 * Samples for ScheduledActions RunByScope.
 */
public final class ScheduledActionsRunByScopeSamples {
    /*
     * x-ms-original-file:
     * specification/cost-management/resource-manager/Microsoft.CostManagement/stable/2022-10-01/examples/
     * scheduledActions/scheduledAction-sendNow-shared.json
     */
    /**
     * Sample code: ScheduledActionRunByScope.
     * 
     * @param manager Entry point to CostManagementManager.
     */
    public static void
        scheduledActionRunByScope(com.azure.resourcemanager.costmanagement.CostManagementManager manager) {
        manager.scheduledActions()
            .runByScopeWithResponse("subscriptions/00000000-0000-0000-0000-000000000000", "monthlyCostByResource",
                com.azure.core.util.Context.NONE);
    }
}
