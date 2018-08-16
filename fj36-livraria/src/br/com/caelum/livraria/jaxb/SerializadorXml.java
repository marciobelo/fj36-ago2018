package br.com.caelum.livraria.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

import br.com.caelum.livraria.modelo.Pedido;

@Component
public class SerializadorXml {

	public String toXml(Pedido pedido)
	{
		
		Marshaller marshaller;
		try 
		{
			marshaller = JAXBContext.newInstance(Pedido.class).createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.marshal(pedido, writer);
			return writer.toString();
		} 
		catch (JAXBException e) 
		{
			throw new RuntimeException(e);
		}
	}

}
