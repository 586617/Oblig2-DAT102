package no.hvl.dat102;

import no.hvl.dat102.adt.MengdeADT;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = null;
		statusIndeks = -1;
	} 
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setStatusIndeks(int status) {
		this.statusIndeks = status;
	}
	
	public int getStatusIndeks() {
		return statusIndeks;
	}
	
	public void setHobbyer(MengdeADT<Hobby> hobby) {
		hobbyer = hobby;
	}
	
	public MengdeADT<Hobby> getHobbyer(){
		return hobbyer;
	}
	
	public boolean equals(Medlem medlem2) {
		boolean erLik = true;
		
		if(getNavn() != medlem2.getNavn()) {
			erLik = false;
		}
		
		if(!getHobbyer().equals(medlem2.getHobbyer())) {
			erLik = false;
		}
		
		return erLik;
	}
	
	public boolean passerTil(Medlem medlem2) {
		boolean passerikke = false;
		
		if (!this.getHobbyer().equals(medlem2.getHobbyer())) {
			passerikke = true;
		}
		
		return passerikke;
	}
	 
	public void skrivUt() {
		
		System.out.println("Navn: " + navn);
		System.out.println("Statusindeks: "+ statusIndeks);
		System.out.println("Medlemshobbyer: " + hobbyer.toString());
		
	}
}
