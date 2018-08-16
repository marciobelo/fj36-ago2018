import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistraFinanceiroNoTopico 
{
	public static void main(String[] args) throws NamingException 
	{
		InitialContext ic = new InitialContext();
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topico = (Topic) ic.lookup("jms/TOPICO.LIVRARIA");
		try( JMSContext ctx = cf.createContext( "jms", "jms2"))
		{
			ctx.setClientID("Financeiro");
			JMSConsumer consumer = ctx.createDurableConsumer(topico, "AssinaturaNotas");
			consumer.setMessageListener(new TratadorDeMensagem("Financeiro"));
			ctx.start();
			System.out.println("Aperte ENTER para finalizar.");
			Scanner teclado = new Scanner( System.in);
			teclado.nextLine();
			teclado.close();
			ctx.stop();
		}
	}

}
