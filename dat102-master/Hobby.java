package no.hvl.dat102;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby) {
		this.hobbyNavn = hobby;
	}

	public void setHobbyNavn(String hobbynavn) {
		this.hobbyNavn = hobbynavn;
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

	public String toString() {
		String tekst = "<" + hobbyNavn + ">";
		return tekst;
	}
}
