package no.hvl.dat102.adt;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public interface KoeADT<T> {
		
	void innKoe (T element);
	
	T utKoe();
	
	T foerste();
	
	boolean erTom();
	
	int antall();
	
}//interface