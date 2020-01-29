#  Sinch RCS SDK for Java

An OpenAPI specification for the Sinch RCS API is published at https://api.clxcommunications.com/rcs_api_swagger.yml.
When building this project, we first download the specification and then generate client classes from it.

These client classes are then used to call the Sinch RCS API.

# Examples

## MessageApiExample 

In this example, we send rcs messages. The example shows both how to send a simple text payload as 
 well as a more complex rich card.

## EventApiExample
 
In this example, we send the _composing_ event, to illustrate that we are composing a reply, to
give an impression of an active counterpart. 
 
## CapabilitiesAPIExample

Finally, we demonstrate how to do a capability lookup.  

