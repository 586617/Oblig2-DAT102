package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.LinearNode;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class KjedetKoe<T> implements KoeADT<T>{
	private int antall; 
	private LinearNode<T> foran, bak;
	
	public KjedetKoe() {
		antall = 0;
		foran = bak = null;
	}
	
	@Override
	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		
		if(erTom()) {
			foran = nyNode;
		} else {
			bak.setNeste(nyNode);
		}
		bak = nyNode;
		antall++;
	}

	@Override
	public T utKoe() {
		if(erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = foran.getElement();
		foran = foran.getNeste();
		antall--;
		
		if(erTom()) {
			bak = null;
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if(erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = foran.getElement();
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

}
