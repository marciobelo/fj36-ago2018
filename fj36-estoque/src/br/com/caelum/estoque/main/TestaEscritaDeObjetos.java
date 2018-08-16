package br.com.caelum.estoque.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.estoque.rmi.ItemEstoque;

public class TestaEscritaDeObjetos 
{

	public static void main(String[] args) throws IOException
	{
		
		try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("itens.bin")))
		{
			ItemEstoque ie1 = new ItemEstoque( "ARQ", 2);
			ItemEstoque ie2 = new ItemEstoque( "SOA", 3);
			List<ItemEstoque> itens = new ArrayList<>();
			itens.add( ie1);
			itens.add( ie2);
			oos.writeObject( itens);
		}
	}
}
