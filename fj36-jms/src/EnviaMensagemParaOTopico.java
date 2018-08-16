import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviaMensagemParaOTopico 
{
	public static void main(String[] args) throws NamingException
	{
		InitialContext ic = new InitialContext();
		
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topico = (Topic) ic.lookup("jms/TOPICO.LIVRARIA");
		
		try( JMSContext ctx = cf.createContext( "jms", "jms2"))
		{
			JMSProducer producer = ctx.createProducer();
			
			producer.setProperty("formato", "ebook");
			
	
			Scanner teclado = new Scanner(System.in);
			System.out.println("Digite a mensagem: ");
			while( teclado.hasNextLine())
			{
				String linha = teclado.nextLine();
				producer.send(topico, linha);
				System.out.println("Digite a mensagem: ");
			}
			teclado.close();
		}
	}

}
