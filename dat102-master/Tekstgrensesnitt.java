package no.hvl.dat102;

import java.util.Scanner;

public class Tekstgrensesnitt {
	private static Datakontakt data;
	
		public Tekstgrensesnitt(Datakontakt data) {
			Tekstgrensesnitt.data = data;
		}
		
		public void start() { 
			
			System.out.println("Tekstgrensesnitt");
			System.out.println("0: Avslutt");
			System.out.println("1: Les Medlem");
			System.out.println("2. Skriv liste med hobby");
			System.out.println("3. Skriv par liste");
			
			Scanner input = new Scanner(System.in);
			String change = "";
			boolean gaar = true;
			while(gaar) {
				change = input.nextLine();
				
				if(change.equals("0")) {
					gaar = false;
					
				}
				else if(change.equals("1")) {
						System.out.println();
						Medlem med = lesMedlem();
						data.leggTilMedlem(med);
						System.out.println("Tekstgrensesnitt");
						System.out.println("0: Avslutt");
						System.out.println("1: Les Medlem");
						System.out.println("2. Skriv liste med hobby");
						System.out.println("3. Skriv par liste");
						
				} else if(change.equals("2")) {
					System.out.println("Velg en person:");
					change = input.nextLine();
					try {
						skrivHobbyListe(data.getMedlem(change));
						
					}catch(NullPointerException e) {
						System.out.println("Nullpoint");
						
					}
					System.out.println("Tekstgrensesnitt");
					System.out.println("0: Avslutt");
					System.out.println("1: Les Medlem");
					System.out.println("2. Skriv liste med hobby");
					System.out.println("3. Skriv par liste");
				
				}else if(change.equals("3")) {
					System.out.println("Her er alle parene:");
					skrivParListe(data);
					System.out.println("Tekstgrensesnitt");
					System.out.println("0: Avslutt");
					System.out.println("1: Les Medlem");
					System.out.println("2. Skriv liste med hobby");
					System.out.println("3. Skriv par liste");
				}else {
					System.out.println("Ugyldig kommando");
					System.out.println("Tekstgrensesnitt");
					System.out.println("0: Avslutt");
					System.out.println("1: Les Medlem");
					System.out.println("2. Skriv liste med hobby");
					System.out.println("3. Skriv par liste");
					
				}
				
			}
			
			input.close();
			System.out.println("Ha en fin dag!");
		}
	
		public static Medlem lesMedlem() {
	
			Tabellmengde<Hobby> hh = new Tabellmengde<Hobby>();
			Hobby h;
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			String m = "";
			boolean running = true;
			
			System.out.println("Legger inn et nytt medlem:");
			System.out.println("Skriv navn");
			m = input.nextLine();
			System.out.println();
			Medlem med = new Medlem(m);
			System.out.println("Skriv inn hobbyene en og en");
				System.out.println("skriv ferdig når du er ferdig:");
			
			while(running) {
				
				m = input.nextLine();
				
				if(!m.equals("ferdig")) {
					h = new Hobby(m);
					hh.leggTil(h);
				}else
					running = false; 
		
			}
			med.setHobbyer(hh);
			System.out.println("Fullført");
			
			return med;
		}
		
		public static void skrivHobbyListe(Medlem medlem) {
			System.out.println("Alle hobbyene ");
			System.out.println(medlem.getHobbyer().toString());
		}
		
		public static void skrivParListe(Datakontakt arkiv) {
			Datakontakt kopi = arkiv;
			String liste = "";
			String partnerNavn = "";
			Medlem m1;
			Medlem m2;
			Medlem[] mmer = kopi.getMedlemsTabell();
			int størrelse = kopi.getAntall();
			
			for(int i = 0; i < størrelse; i++){
				
				m1 = mmer[i];
				
				if(m1.getStatusIndeks() > i || m1.getStatusIndeks() == -1) {
				
				liste += m1.getNavn() + " og ";
				kopi.finnPartnerFor(m1.getNavn());
				if(m1.getStatusIndeks() != -1) {
					m2 = mmer[m1.getStatusIndeks()];
					partnerNavn = m2.getNavn();
				}else 
					partnerNavn = " (ingen partner)";
				liste += partnerNavn + " ";
				liste += m1.getHobbyer();
				liste += "\n";
				
				}
			}
			System.out.println(liste);
		}
		}
