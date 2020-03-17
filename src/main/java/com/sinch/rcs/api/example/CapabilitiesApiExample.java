package com.sinch.rcs.api.example;

import com.sinch.rcs.ApiClient;
import com.sinch.rcs.api.CapabilitiesApi;
import com.sinch.rcs.model.CapabilitiesResponse;

public class CapabilitiesApiExample {

  public static void main(String[] args) {
    ApiClient apiClient = new ApiClient();

    // Configure API key authorization
    apiClient.setApiKeyPrefix("Bearer");
    apiClient.setApiKey("< Your API token >");

    CapabilitiesApi apiInstance = new CapabilitiesApi(apiClient);

    String botId = "< ID of your bot >";
    String phoneNumber = "< Phone number for the lookup >";

    try {
      CapabilitiesResponse result = apiInstance.capabilityQuery(botId, phoneNumber);
      System.out.println(result);
    } catch (Exception e) {
      System.err.println("Exception when calling CapabilitiesApi#capabilityQuery");
      e.printStackTrace();
    }
  }
}
