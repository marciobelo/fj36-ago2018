package br.com.caelum.estoque.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import br.com.caelum.estoque.rmi.*;
import java.util.List;

public class TestaLeituraDeObjetos {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		try( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("itens.bin")))
		{
			List<ItemEstoque> itens = (List<ItemEstoque>) ois.readObject();
			for( ItemEstoque ie : itens)
			{
				System.out.println( String.format("%s - %d\n", ie.getCodigo(), ie.getQuantidade()));
			}
		}
	}

}
