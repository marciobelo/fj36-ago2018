package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService( targetNamespace = "http://caelum.com.br/estoquews/v1")
@Stateless
public class EstoqueWS 
{
	private Map<String, ItemEstoque> repositorio = new HashMap<>();

	public EstoqueWS() 
	{
		repositorio.put( "SOA", new ItemEstoque( "SOA", 5));
		repositorio.put( "TDD", new ItemEstoque( "TDD", 1));
		repositorio.put( "RES", new ItemEstoque( "RES", 2));
		repositorio.put( "LOG", new ItemEstoque( "LOG", 4));
		repositorio.put( "WEB", new ItemEstoque( "WEB", 1));
		repositorio.put( "ARQ", new ItemEstoque( "ARQ", 2));
	}
	
	@WebMethod
	public ItemEstoque getQuantidade( String codigo)
	{
		return repositorio.get( codigo);
	}
	
	@WebMethod
	public List<ItemEstoque> getQuantidades( @WebParam( name="codigos") List<String> codigos,
			@WebParam( header = true, name = "tokenUsuario") String token)
	{
		if( token == null || !"TOKEN123".equals(token))
		{
			throw new AutorizacaoException("Nao autorizado");
		}
		
		List<ItemEstoque> itens = new ArrayList<>();
		
		System.out.printf("a consultar os codigos %s\n", codigos);
		if( codigos == null || codigos.isEmpty())
		{
			return itens;
		}
		return codigos.stream()
				.map( codigo -> repositorio.get(codigo))
				.collect( Collectors.toList() );
	}

}
