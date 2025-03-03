// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.resourcemanager.costmanagement.fluent.models.DimensionInner;
import com.azure.resourcemanager.costmanagement.models.ExternalCloudProviderType;

/**
 * An instance of this class provides access to all the operations defined in DimensionsClient.
 */
public interface DimensionsClient {
    /**
     * Lists the dimensions by the defined scope.
     * 
     * @param scope The scope associated with dimension operations. This includes '/subscriptions/{subscriptionId}/' for
     * subscription scope, '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for resourceGroup scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}' for Billing Account scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/departments/{departmentId}' for Department
     * scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/enrollmentAccounts/{enrollmentAccountId}'
     * for EnrollmentAccount scope, '/providers/Microsoft.Management/managementGroups/{managementGroupId}' for
     * Management Group scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}' for
     * billingProfile scope,
     * 'providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}/invoiceSections/{invoiceSectionId}'
     * for invoiceSection scope, and
     * 'providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for partners.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of listing dimensions as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DimensionInner> list(String scope);

    /**
     * Lists the dimensions by the defined scope.
     * 
     * @param scope The scope associated with dimension operations. This includes '/subscriptions/{subscriptionId}/' for
     * subscription scope, '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for resourceGroup scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}' for Billing Account scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/departments/{departmentId}' for Department
     * scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/enrollmentAccounts/{enrollmentAccountId}'
     * for EnrollmentAccount scope, '/providers/Microsoft.Management/managementGroups/{managementGroupId}' for
     * Management Group scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}' for
     * billingProfile scope,
     * 'providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}/invoiceSections/{invoiceSectionId}'
     * for invoiceSection scope, and
     * 'providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for partners.
     * @param filter May be used to filter dimensions by properties/category, properties/usageStart,
     * properties/usageEnd. Supported operators are 'eq','lt', 'gt', 'le', 'ge'.
     * @param expand May be used to expand the properties/data within a dimension category. By default, data is not
     * included when listing dimensions.
     * @param skiptoken Skiptoken is only used if a previous operation returned a partial result. If a previous response
     * contains a nextLink element, the value of the nextLink element will include a skiptoken parameter that specifies
     * a starting point to use for subsequent calls.
     * @param top May be used to limit the number of results to the most recent N dimension data.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of listing dimensions as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DimensionInner> list(String scope, String filter, String expand, String skiptoken, Integer top,
        Context context);

    /**
     * Lists the dimensions by the external cloud provider type.
     * 
     * @param externalCloudProviderType The external cloud provider type associated with dimension/query operations.
     * This includes 'externalSubscriptions' for linked account and 'externalBillingAccounts' for consolidated account.
     * @param externalCloudProviderId This can be '{externalSubscriptionId}' for linked account or
     * '{externalBillingAccountId}' for consolidated account used with dimension/query operations.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of listing dimensions as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DimensionInner> byExternalCloudProviderType(ExternalCloudProviderType externalCloudProviderType,
        String externalCloudProviderId);

    /**
     * Lists the dimensions by the external cloud provider type.
     * 
     * @param externalCloudProviderType The external cloud provider type associated with dimension/query operations.
     * This includes 'externalSubscriptions' for linked account and 'externalBillingAccounts' for consolidated account.
     * @param externalCloudProviderId This can be '{externalSubscriptionId}' for linked account or
     * '{externalBillingAccountId}' for consolidated account used with dimension/query operations.
     * @param filter May be used to filter dimensions by properties/category, properties/usageStart,
     * properties/usageEnd. Supported operators are 'eq','lt', 'gt', 'le', 'ge'.
     * @param expand May be used to expand the properties/data within a dimension category. By default, data is not
     * included when listing dimensions.
     * @param skiptoken Skiptoken is only used if a previous operation returned a partial result. If a previous response
     * contains a nextLink element, the value of the nextLink element will include a skiptoken parameter that specifies
     * a starting point to use for subsequent calls.
     * @param top May be used to limit the number of results to the most recent N dimension data.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of listing dimensions as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DimensionInner> byExternalCloudProviderType(ExternalCloudProviderType externalCloudProviderType,
        String externalCloudProviderId, String filter, String expand, String skiptoken, Integer top, Context context);
}
