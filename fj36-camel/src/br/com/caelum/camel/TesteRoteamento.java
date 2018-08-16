package br.com.caelum.camel;

import java.util.Scanner;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TesteRoteamento 
{
	public static void main(String[] args) throws Exception
	{
		CamelContext camelContext = new DefaultCamelContext();
		
		camelContext.addRoutes( new RouteBuilder() {
			
			@Override
			public void configure() throws Exception 
			{
				errorHandler(
						deadLetterChannel("file:saida")
						.useOriginalMessage()
						);
				
				from("file:entrada?delay=5s&tempFileName=tempFile&fileExist=TryRename")
				.log(LoggingLevel.INFO, "Processando mensagem ${id} = ${body}")
				.to("validator:file:xsd/pedido.xsd")
				.to("file:saida");
				
			}
		});
		
		camelContext.start();
		
		new Scanner(System.in).nextLine();
		
		camelContext.stop();
	}
}
