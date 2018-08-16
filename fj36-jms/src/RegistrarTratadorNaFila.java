import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistrarTratadorNaFila 
{
	public static void main(String[] args) throws NamingException 
	{
		InitialContext ic = new InitialContext();
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Queue queue = (Queue) ic.lookup("jms/FILA.GERADOR");
		try( JMSContext ctx = cf.createContext( "jms", "jms2"))
		{
			JMSConsumer consumer = ctx.createConsumer(queue);
			consumer.setMessageListener( new TratadorDeMensagem());
			ctx.start();
			System.out.println("Aperte ENTER para finalizar.");
			new Scanner(System.in).nextLine();
			ctx.stop();
		}
	}
}
