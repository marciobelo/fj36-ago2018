package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.caelum.estoque.rmi.EstoqueRmi;

public class ClienteRmi 
{

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		EstoqueRmi estoque = (EstoqueRmi) Naming.lookup("rmi://localhost:1099/estoque");
		
		System.out.println( estoque.getItemEstoque("SOA").getQuantidade());
	}
}