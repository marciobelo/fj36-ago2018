package br.com.caelum.estoque.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class EstoqueService extends UnicastRemoteObject implements EstoqueRmi 
{
	private static final long serialVersionUID = 1L;

	private Map<String,ItemEstoque> itens = new HashMap<>();
	
	public EstoqueService() throws RemoteException {
		super();
		itens.put( "SOA", new ItemEstoque("SOA", 3));
		itens.put( "ARQ", new ItemEstoque("ARQ", 1));
	}

	@Override
	public ItemEstoque getItemEstoque(String codigo) throws RemoteException 
	{
		System.out.printf("consulta feito ao codigo %s\n", codigo);
		return itens.get( codigo);
	}
}
