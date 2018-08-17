package br.com.caelum.camel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import br.com.caelum.livraria.modelo.Livro;

public class TestePolling {

	public static void main(String[] args) throws Exception 
	{
		
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setDatabaseName("fj36_camel");
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setUser("root");
		ds.setPassword("caelum");
		
		JndiContext jndiContext = new JndiContext();
		jndiContext.rebind("mysqlDataSource", ds);
		
		CamelContext camelContext = new DefaultCamelContext( jndiContext);
		camelContext.addRoutes( new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("http://localhost:8088/fj36-livraria/loja/livros/mais-vendidos")
				.delay(1000)
				.unmarshal()
				.json()
				.process(new Processor() {
					
					@Override
					public void process(Exchange arg0) throws Exception 
					{
						List<?> listaDeLivros = (List<?>) arg0.getIn().getBody();
						ArrayList<Livro> livros = (ArrayList<Livro>) listaDeLivros.get(0);
						Message message = arg0.getIn();
						message.setBody(livros);
					}
				})
				.log("${body}")
				.to("direct:livros");
				
				from("direct:livros")
				.split(body())
				.process(new Processor() {
					
					@Override
					public void process(Exchange exchange) throws Exception 
					{
						Message msg = exchange.getIn();
						
						Livro livro = (Livro) msg.getBody();
						String nomeAutor = livro.getNomeAutor();
						msg.setHeader("nomeAutor", nomeAutor);
					}
				})
				.setBody(simple("insert into Livros (nomeAutor) values (:?nomeAutor)"))
				.to("jdbc:mysqlDataSource?useHeadersAsParameters=true");
				
			}
		});
		
		

		camelContext.start();
		new Scanner( System.in).nextLine();
		camelContext.stop();
	}
	
	/*
	 * 				from("http://localhost:8088/fj36-livraria/loja/livros/mais-vendidos")
				.del
	 */

}
