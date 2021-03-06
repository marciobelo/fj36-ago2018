package br.com.caelum.livraria.jms;

import java.io.Serializable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.jaxb.SerializadorXml;
import br.com.caelum.livraria.modelo.Pedido;

@Component
@Lazy(true)
public class EnviadorMensagemJms implements Serializable {
	
	@Autowired
	private ConnectionFactory cf;
	
	@Autowired
	private Topic topico;
	
	@Autowired
	private SerializadorXml serializador;
	

	private static final long serialVersionUID = 1L;

	public void enviar(Pedido pedido) 
	{
		System.out.printf("Enviado mensagem JMS: %s%n", pedido);
		try( JMSContext ctx = cf.createContext( "jms", "jms2"))
		{
			JMSProducer producer = ctx.createProducer();
			producer.setProperty("formato", pedido.getFormato());
			
			String xml = serializador.toXml(pedido);
			System.out.println(xml);
			producer.send( topico, xml);
		}
	}
}
