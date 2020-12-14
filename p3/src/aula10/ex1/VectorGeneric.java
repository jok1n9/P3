package aula10.ex1;

import java.util.Iterator;



public class VectorGeneric<T> 
{
	private static int numPessoas;
	
	private T[] pessoas;
	
	@SuppressWarnings("unchecked")
	public VectorGeneric()
	{
		
		pessoas =(T[]) new Object[0];
		numPessoas=0;
		
	}
	public boolean addElem(T p) 
	{
		@SuppressWarnings("unchecked")
		T[] copy=(T[]) new Object[numPessoas+1];
		for(int i=0; i<numPessoas; i++) 
		{
			copy[i]= pessoas[i];
		}
		copy[numPessoas]=p;
		pessoas= copy;
		numPessoas++;
		return true;
	}
	
	Iterator<T> iterator() 
	{
		return (this).new VectorIterator();
	}

	public boolean removePessoa(T p) 
	{
		
		if(pessoas.length<=0) return false;
		
		@SuppressWarnings("unchecked")
		T[] copy= (T[]) new Object[numPessoas-1];
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
	private class VectorIterator implements Iterator<T>
	{
		int pointer;
		
		VectorIterator() {
			pointer=0;
		}
		public boolean hasNext() 
		{
			return pointer < numPessoas;
		}
		public T next() 
		{
			pointer++;
			return pessoas[pointer-1];
		}
	}
}
