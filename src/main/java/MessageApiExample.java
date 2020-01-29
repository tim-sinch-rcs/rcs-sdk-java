import com.sinch.rcs.ApiClient;
import com.sinch.rcs.api.MessageApi;
import com.sinch.rcs.model.CarouselRichCardMessage;
import com.sinch.rcs.model.CarouselRichCardMessage.WidthEnum;
import com.sinch.rcs.model.FileInfo;
import com.sinch.rcs.model.Message;
import com.sinch.rcs.model.MessageQueuedResponse;
import com.sinch.rcs.model.Postback;
import com.sinch.rcs.model.RichCardContent;
import com.sinch.rcs.model.RichCardMedia;
import com.sinch.rcs.model.RichCardMedia.HeightEnum;
import com.sinch.rcs.model.SuggestedReply;
import com.sinch.rcs.model.TextMessage;
import com.sinch.rcs.model.TextMessage.TypeEnum;
import java.util.LinkedList;
import java.util.List;

public class MessageApiExample {

  public static void main(String[] args) {
    ApiClient apiClient = new ApiClient();

    // Configure API key authorization
    apiClient.setApiKeyPrefix("Bearer");
    apiClient.setApiKey("< Your API token >");

    MessageApi apiInstance = new MessageApi(apiClient);

    String msisdn = "< Phone number of the recipient >";
    String botId = "< ID of your bot >";

    Message body = textMessageWithSuggestions();
    // Uncomment to send a rich card message
    // body = carouselRichCardMessage();
    body.setTo(msisdn);

    try {
      MessageQueuedResponse result = apiInstance.sendAMessage(body, botId);
      System.out.println(result);
    } catch (Exception e) {
      System.err.println("Exception when calling MessageApi#sendAMessage");
      e.printStackTrace();
    }
  }

  private static Message textMessageWithSuggestions() {
    Message body = new Message();

    TextMessage textMessage = new TextMessage();
    textMessage.setType(TypeEnum.TEXT);
    textMessage.setText("Hello, wonderful world of RCS!");

    List<Object> suggestions = new LinkedList<>();

    SuggestedReply reply1 = new SuggestedReply();
    reply1.setDisplayText("Hello, friend");
    Postback postback1 = new Postback();
    postback1.setData("feed1169-8500-4b66-a65c-5986b8ae59f7_HELLO");
    reply1.setPostback(postback1);
    reply1.setType(SuggestedReply.TypeEnum.REPLY);

    SuggestedReply reply2 = new SuggestedReply();
    reply2.setDisplayText("Goodbye, stranger");
    Postback postback2 = new Postback();
    postback2.setData("feed1169-8500-4b66-a65c-5986b8ae59f7_GOODBYE");
    reply2.setPostback(postback2);
    reply2.setType(SuggestedReply.TypeEnum.REPLY);

    suggestions.add(reply1);
    suggestions.add(reply2);

    body.setMessage(textMessage);
    body.setSuggestions(suggestions);

    return body;
  }

  private static Message carouselRichCardMessage() {
    Message body = new Message();

    CarouselRichCardMessage message = new CarouselRichCardMessage();
    message.setType(CarouselRichCardMessage.TypeEnum.CARD);
    message.setWidth(WidthEnum.SMALL);

    RichCardContent card1 = new RichCardContent();
    card1.setTitle("Card 1");

    FileInfo fileInfo = new FileInfo();
    fileInfo.setFileUri("http://example.com/my_image.png");
    fileInfo.setMimeType("image/png");

    RichCardMedia richCardMedia = new RichCardMedia();
    richCardMedia.setHeight(HeightEnum.MEDIUM);
    richCardMedia.setFile(fileInfo);

    card1.setMedia(richCardMedia);

    RichCardContent card2 = new RichCardContent();
    card2.setTitle("Card 2");
    card2.setDescription("Here's a rich card without media");

    message.addContentsItem(card1);
    message.addContentsItem(card2);
    body.setMessage(message);

    return body;
  }
}
