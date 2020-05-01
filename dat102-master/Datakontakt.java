package no.hvl.dat102;

public class Datakontakt {
	private final static int STDK = 100;
	private Medlem[] tab;
	private int antall;
	
	public Datakontakt() {
		tab = new Medlem[STDK];
		antall = 0;
	}
	 
	public Medlem[] getMedlemsTabell() {
		return tab;
	}
	
	public void leggTilMedlem(Medlem person) {
		for(int i = 0; i < antall; i++) {
			if(tab[i].equals(person))  {
				tab[antall] = person;
				antall++;
			}
		}
	}
	
	public int getAntall() {
		return antall;
	}
	
	public Medlem getMedlem(String medlemsnavn) {
		int i = finnMedlemsIndeks(medlemsnavn);
		Medlem medlem = null;
		if(i!=-1) {
			medlem = tab[i];
		}
		
		return medlem;
	}
	
	public int finnMedlemsIndeks(String medlemsnavn) {
		int indeks = -1;
		boolean funnet = false;
		
		for (int i = 0; i < tab.length && !funnet; i++) {
			if (tab[i].getNavn().equals(medlemsnavn)) {
				indeks = i;
				funnet = true;
			}
		}
		
		return indeks;
	}
	
	public int finnPartnerFor(String medlemsnavn) {
		boolean funnet = false;
		int m1 = finnMedlemsIndeks(medlemsnavn);
		int m2 = -1;
		int indeks = -1;
		for (int i = 0; i < antall && !funnet; i++) {
			m2 = i;
			if((tab[m2].passerTil(tab[m1]) && tab[m2].getStatusIndeks() == -1) && m1 != m2) {
				tab[m2].setStatusIndeks(m1);
				tab[m1].setStatusIndeks(m2);
				indeks = m2;
				funnet = true;
			} 
		}
		return indeks;
	}
	
	public void tilbakestillStatusIndeks(String medlemsnavn) {
		int m1 = finnMedlemsIndeks(medlemsnavn);
		int m2 = tab[m1].getStatusIndeks();
		if(m2 != -1) {
			tab[m1].setStatusIndeks(-1);
			tab[m2].setStatusIndeks(-1);
		}
	}
	
}
