#  Sinch RCS demo for Java

Use this demo to communicate with the RCS API. It contains some examples to help you get started.

The code generated using the RCS API specification at 
https://us.rcs.api.sinch.com/sinch_rcs_api_v1.yml. The specification is downloaded when the 
project is built, and then the client classes are generated from it.

These client classes are then used to call the Sinch RCS API.

# Account

Go to the Sinch dashboard (https://dashboard.sinch.com) and register for an account if 
you don't have one. Once registered you can request access to try out our RCS services.

# Examples

## com.sinch.rcs.api.example.MessageApiExample 

In this example, we send RCS messages. The example shows both how to send a simple text payload as 
 well as a more complex rich card.

## com.sinch.rcs.api.example.EventApiExample
 
In this example, we send the _composing_ event, to illustrate that we are composing a reply, to
give an impression of an active counterpart.

## com.sinch.rcs.api.example.CapabilitiesAPIExample

Finally, we show how to do a capability lookup.  

# How to run the examples

1. Get your credentials for your Sender ID (chatbot) here: https://dashboard.sinch.com/rcs/senders. 
You'll need the `auth name` and the `auth token`. 
2. Clone this repository and add your credentials to the examples under `src/main/java/`.
Use `auth name` for `botId`.
3. Build with `./gradlew build`.
4. Run the MessageApiExample with `./gradlew run`, or specify which example to run:  
`./gradlew -Pexample=Event run`   
`./gradlew -Pexample=Capabilities run`  
`./gradlew -Pexample=Message run`
