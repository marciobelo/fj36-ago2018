import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TratadorDeMensagem implements MessageListener {

	String id = "N/D";
	
	public TratadorDeMensagem() {
	}

	public TratadorDeMensagem( String id)
	{
		this.id =id;
	}
	
	@Override
	public void onMessage(Message msg) 
	{
		TextMessage txtMsg = (TextMessage) msg;
		try
		{
			System.out.println( "Tratador recebendo mensagem: " + txtMsg.getText());
		}
		catch( JMSException jmse)
		{
			throw new RuntimeException( jmse);
		}
	}
}