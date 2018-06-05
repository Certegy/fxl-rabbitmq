import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitTest {
    private final static String QUEUE_NAME    = "dispatch.email.Incoming";
    private final static String RABBITMQ_HOST = "23.101.219.122";
    private final static String USERNAME      = "guest";
    private final static String PASSWORD      = "";
    
    public static void main(String[] args) {
        try {
            Channel channel = new RabbitTest().getChannel();

            MessageSender send = new MessageSender(channel, QUEUE_NAME);

            send.SendMessage("test");
            
            channel.close();
            channel.getConnection().close();

        }  catch (IOException e) {
            System.err.println("Unable to talk to bus" + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Attempt to talk to bus timed out" + e.getMessage());
        }
    }

    private Channel getChannel() throws IOException, TimeoutException
    {        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RABBITMQ_HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);

        Connection connection = factory.newConnection();
    
        // setup the connection            
        Channel channel = connection.createChannel();
        return channel;
    }
}
