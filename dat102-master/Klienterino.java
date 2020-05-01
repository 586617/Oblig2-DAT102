package no.hvl.dat102.klient;

import no.hvl.dat102.Datakontakt;
import no.hvl.dat102.Tekstgrensesnitt;

public class Klienterino {
public static void main(String[] args) {
	Datakontakt letsgo=new Datakontakt();
	Tekstgrensesnitt skrtskrt=new Tekstgrensesnitt(letsgo);
	skrtskrt.start();
}

}
