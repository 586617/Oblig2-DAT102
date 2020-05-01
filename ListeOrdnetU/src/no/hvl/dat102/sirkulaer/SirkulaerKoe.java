package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T>{
	private static final int STDK = 100;
	private int foran, bak, antall;
	private T[] koe;
	
	public SirkulaerKoe() {
		this(STDK);
	}
	
	
	public SirkulaerKoe(int startKapasitet) {
		koe = ((T[]) (new Object[startKapasitet]));
		foran = bak = antall = 0;
	}
	
	@Override
	public void innKoe(T element) {
		if(antall() == koe.length) {
			utvid();
		}
		
		koe[bak] = element;
		bak = (bak+1) % koe.length;
		antall++;
	}
	
	@Override
	public T utKoe() {
		if(erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = koe[foran];
		koe[foran] = null;
		foran = (foran + 1) % koe.length;
		antall--;
		
		return resultat;
	}
	
	@Override
	public T foerste() {
		if(erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = koe[foran];
		return resultat;
	}
	@Override
	public boolean erTom() {
		return (bak-foran == 0);
	}
	@Override
	public int antall() {
		return (bak-foran);
	}
	
	private void utvid() {
		T[] hjelpetabell = ((T[]) (new Object[koe.length * 2]));
		
		for(int soek = 0; soek < antall; soek++) {
			hjelpetabell[soek] = koe[foran];
			foran = (foran+1) % koe.length;
		}
		
		foran = 0;
		bak = antall;
		koe = hjelpetabell;
	}
	
}
