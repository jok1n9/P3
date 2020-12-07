package aula9.ex3;

import java.util.Iterator;

public class teste {

	public static void main(String[] args) {
		VectorPessoas vp = new VectorPessoas();
		for (int i=0; i<10; i++)
		vp.addPessoa(new Pessoa("Bebé no Vector "+i,
		 1000+i, Data.today()));
		Iterator<Pessoa> vec = vp.iterator();
		while ( vec.hasNext() )
		System.out.println( vec.next() );
		ListaPessoas lp = new ListaPessoas();
		for (int i=0; i<10; i++)
		lp.addPessoa(new Pessoa("Bebé na Lista "+i,
		 2000+i, Data.today()));
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
		System.out.println( lista.next() );
		
		
		BFIterator bfi = vp.bfiterator();
		while( bfi.hasNext() ) {
			System.out.println("-> Previous: "+bfi.previous());
			System.out.println("BFIterator hasPrevious? "+ bfi.hasPrevious());
			System.out.println( bfi.next() );
			
			System.out.println();
		}
		
		BFIterator bfil = lp.bfilisterator();
		System.out.println("BFIterator hasPrevious? "+ bfil.hasPrevious());
		while( bfil.hasNext() ) {
			System.out.println("-> Previous: "+bfil.previous());
			System.out.println( bfil.next() );
			System.out.println("BFIterator hasPrevious? "+ bfil.hasPrevious());
			System.out.println();
		}
		
	}	
}
