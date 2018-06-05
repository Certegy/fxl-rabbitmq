
import com.rabbitmq.client.Channel;
import java.io.IOException;

final class MessageSender {

    String queueName = null;
    Channel channel = null;

    public  MessageSender(Channel channel, String queueName)
    {   
        this.channel = channel;
        this.queueName = queueName;
    }
  
    public void SendMessage(String Message) {
        try {
			channel.basicPublish("", queueName, null, Message.getBytes());
            System.out.println("Sent: '" + Message + "'");

        } catch (IOException e) {
            System.err.println("Unable to talk to bus: " + e.getMessage());
        }   
    }
}