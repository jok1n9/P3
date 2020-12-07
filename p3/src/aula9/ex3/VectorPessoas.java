package aula9.ex3;

import java.util.Iterator;



public class VectorPessoas 
{
	private static int numPessoas;
	private Pessoa[] pessoas;
	public VectorPessoas()
	{
		pessoas = new Pessoa[0];
		numPessoas=0;
		
	}
	public boolean addPessoa(Pessoa p) 
	{
		
		Pessoa[] copy= new Pessoa[numPessoas+1];
		for(int i=0; i<numPessoas; i++) 
		{
			copy[i]= pessoas[i];
		}
		copy[numPessoas]=p;
		pessoas= copy;
		numPessoas++;
		return true;
	}
	
	Iterator<Pessoa> iterator() 
	{
		return (this).new VectorIterator();
	}
	BFIterator bfiterator()
	{
		return (this).new BFIVectorIterator(); 
	}
	public boolean removePessoa(Pessoa p) 
	{
		
		if(pessoas.length<=0) return false;
		
		Pessoa[] copy= new Pessoa[numPessoas-1];
		int a=0;
		for(int i=0; i<numPessoas; i++) 
		{
			if(p== pessoas[i]) a++;
			if(a==0 && i!=numPessoas-1) copy[i]=pessoas[i]; 
			else if(a==1) copy[i-1]=pessoas[i];
			else return false;
		}
		pessoas= copy;
		numPessoas--;
		return true;
		
	}
	
	public int totalPessoas() {
		return numPessoas;
	}
	private class VectorIterator implements Iterator<Pessoa>
	{
		int pointer;
		
		VectorIterator() {
			pointer=0;
		}
		public boolean hasNext() 
		{
			return pointer < numPessoas;
		}
		public Pessoa next() 
		{
			pointer++;
			return pessoas[pointer-1];
		}
	}
	private class BFIVectorIterator implements BFIterator{
		int pointer;
		
		BFIVectorIterator() {
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
				return pessoas[l];
			}
			return null;
		}
	
		public boolean hasNext() {
		
			return pointer < numPessoas;
		}
	
		public Pessoa next() {
			assert(hasNext()): "No more People";
			pointer++;
			return pessoas[pointer-1];
			
		}
	}
}
