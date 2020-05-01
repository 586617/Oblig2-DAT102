package no.hvl.dat102;

import java.util.Random;

import no.hvl.dat102.adt.MengdeADT;

public class Tabellmengde<T> implements MengdeADT<T>{
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public Tabellmengde() {
		this(STDK);
	}
	
	@SuppressWarnings("unchecked")
	public Tabellmengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);

	}
	
	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
		
	}
	@SuppressWarnings("unchecked")
	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}
	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}
	@Override
	public T fjern(T element) {
		T svar = null;

		for (int i = 0; i < this.antall; i++) {
			if (tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall - 1];
				antall--;
			}
		}
		
		return svar;
	}
	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}
	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		
		if (this.antall() == m2.antall()) {
			for (int i = 0; i < this.antall(); i++) {
				if (!m2.inneholder(this.tab[i])) {
					likeMengder = false;
				}
			}
		}
		
		
		return likeMengder;
	}
	@Override
	public int antall() {
		return antall;
	}
	
}
