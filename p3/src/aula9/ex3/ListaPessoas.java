package aula9.ex3;

import java.util.Iterator;
import java.util.LinkedList;






public class ListaPessoas {
	LinkedList<Pessoa> pessoas;
	public ListaPessoas()
	{
		pessoas = new LinkedList<Pessoa>();
		
	}
	boolean addPessoa(Pessoa p) 
	{
	
		pessoas.add(p);
		
		return true;
	}
	boolean removePessoa(Pessoa p) 
	{
	
		if(pessoas.size()>0)return false;
		pessoas.remove(p);
		return true;
	
	}
	int totalPessoas() {
		return pessoas.size();
	}	
	public Iterator<Pessoa> iterator()
	{
		return pessoas.iterator();
	}
	BFIterator bfilisterator()
	{
		return (this).new BFIListaIterator(); 
	}
	
	private class BFIListaIterator implements BFIterator
	{
		int pointer;
		
		BFIListaIterator() {
			pointer=0;
		}
		
		public boolean hasPrevious() 
		{
			return pointer > 0;
		}
		public Pessoa previous()
		{
			if(hasPrevious()) {
				int l = pointer-1;
				return pessoas.get(l);
			}
			return null;
		}
	
		public boolean hasNext() {
		
			return pointer < totalPessoas();
		}
	
		public Pessoa next() {
			assert(hasNext()): "No more People";
			pointer++;
			return pessoas.get(pointer-1);
			
		}
	}
}


