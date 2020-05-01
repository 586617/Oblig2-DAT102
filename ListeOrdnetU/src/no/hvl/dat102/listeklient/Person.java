package no.hvl.dat102.listeklient;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	// Konstruktører

	public Person() {
		this("", "", 0);

	}

	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselsaar;

	}

	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	int getFoedselsaar() {
		return foedselsaar;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String toString() {
		return this.getFoedselsaar() + " " + this.getEtternavn() + ", " + this.getFornavn() + "\n";
	}

	public int compareTo(Person denAndrePersonen) {
		int resultat = 0;
		//... Fyll ut
		
		final int Mindre = -1;

		final int Lik = 0;

		final int Større = 1;



		if (this == denAndrePersonen) {
			return resultat;
		}

		if (this.getFoedselsaar() < denAndrePersonen.getFoedselsaar()) {
			return Mindre;
		}

		if (this.getFoedselsaar() > denAndrePersonen.getFoedselsaar()) {
			return Større;
		}


		int etternavn = this.getEtternavn().compareTo(denAndrePersonen.getEtternavn());

		if (etternavn != Lik) {
			return etternavn;
		}


		int fornavn = this.getFornavn().compareTo(denAndrePersonen.getEtternavn());

		if (fornavn != Lik) {
			return fornavn;
		}

		
		return Lik;
		
	}//

}// class