import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviadorParaFila 
{
	public static void main(String[] args) throws NamingException
	{
		InitialContext ic = new InitialContext();
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Queue queue = (Queue) ic.lookup("jms/FILA.GERADOR");
		try( JMSContext ctx = cf.createContext( "jms", "jms2"))
		{
			JMSProducer producer = ctx.createProducer();
			Scanner scanner = new Scanner( System.in);
			System.out.println("Digite a mensagem:");
			while( scanner.hasNextLine())
			{
				
				String linha = scanner.nextLine();
				producer.send( queue, linha);
			}
			scanner.close();
		}
	}
}
