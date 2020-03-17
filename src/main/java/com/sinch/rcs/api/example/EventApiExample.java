package com.sinch.rcs.api.example;

import com.sinch.rcs.ApiClient;
import com.sinch.rcs.api.EventApi;
import com.sinch.rcs.model.AgentComposingEvent;
import com.sinch.rcs.model.AgentComposingEvent.TypeEnum;
import com.sinch.rcs.model.AgentEvent;

public class EventApiExample {

  public static void main(String[] args) {
    ApiClient apiClient = new ApiClient();

    // Configure API key authorization
    apiClient.setApiKeyPrefix("Bearer");
    apiClient.setApiKey("< Your API token >");

    EventApi apiInstance = new EventApi(apiClient);

    String phoneNumber = "< Phone number of the recipient >";
    String botId = "< ID of your bot >";

    AgentComposingEvent agentComposingEvent = new AgentComposingEvent();
    agentComposingEvent.setType(TypeEnum.COMPOSING);

    AgentEvent body = new AgentEvent();
    body.setEvent(agentComposingEvent);
    body.setTo(phoneNumber);

    try {
      apiInstance.sendAnEvent(body, botId);
    } catch (Exception e) {
      System.err.println("Exception when calling EventApi#sendAnEvent");
      e.printStackTrace();
    }
  }
}
