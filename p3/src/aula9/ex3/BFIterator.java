package aula9.ex3;

public interface BFIterator {
	boolean hasPrevious(); 
	Pessoa previous(); 
	boolean hasNext() ;
	Object next() ;
	
}