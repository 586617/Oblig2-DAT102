package no.hvl.dat102.adt;

public interface MengdeADT<T> {
	void leggTil(T element);
	void leggTilAlle(MengdeADT<T> m2);
	T fjernTilfeldig();
	T fjern(T element);
	boolean inneholder(T element);
	boolean equals(MengdeADT<T> m2);
	int antall();
}
