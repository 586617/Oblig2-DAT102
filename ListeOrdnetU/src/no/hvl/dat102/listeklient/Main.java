package no.hvl.dat102.listeklient;

import java.util.Scanner;
import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class Main {
	public static void main(String[] args) {
		printIntro();
		Scanner sc = new Scanner(System.in);
		int method = 0;
 
		try{
			method = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e){
			e.printStackTrace();
		}

		switch(method){
			case 0: System.out.println("Ugyldig input");
			break;

			case 1: kjorSirkulaerKoe(sc);
			break;

			case 2: kjorKjedetKoe(sc);
			break;

			case 3: kjorTabellOrdnettListe(sc);
			break;

			case 4: kjorKjedetOrdnetListe(sc);
			break;

			default: System.out.println("Error reading input..");
			sc.close();
			break;
		}
	}

	public static void printIntro(){
		
		System.out.println("Oppgave 5");
		System.out.println("**************************");
		System.out.println("Hvilken kø/liste vil du bruke?");
		System.out.println("1. Sirkulær kø");
		System.out.println("2. Kjedet kø");
		System.out.println("3. TabellOrdnet liste");
		System.out.println("4. KjedetOrdnet liste");
		System.out.println("**************************");
		System.out.println("Skriv inn nummer:");
	}


	public static void kjorKjedetKoe(Scanner sc){
		KjedetKoe<Person> personKoe = new KjedetKoe<>();

		System.out.println("Antall personer som skal legges til: ");
		int antall = 0;

		try{
			antall = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}

		int i = 0;
		while(i < antall) {
			System.out.println("**************************\nPerson " + (i+1));
			Person person = new Person();

			System.out.println("Fornavn: ");
			person.setFornavn(sc.nextLine());

			System.out.println("Etternavn: ");
			person.setEtternavn(sc.nextLine());

			System.out.println("Fødselsår: ");
			try{
				person.setFoedselsaar(Integer.parseInt(sc.nextLine()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			if(person!= null) {
				personKoe.innKoe(person);
			}
			
			i++;
			System.out.println("**************************\n");
		}

		while(personKoe.antall() > 0) {
			System.out.println(personKoe.utKoe().toString());
		}
	}

	public static void kjorSirkulaerKoe(Scanner sc) {
		SirkulaerKoe<Person> personKoe = new SirkulaerKoe<>();

		System.out.println("Antall personer som skal legges til: ");
		int antall = 0;

		try{
			antall = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}

		int i = 0;
		while(i < antall) {
			System.out.println("**************************\nPerson " + (i+1));
			Person person = new Person();

			System.out.println("Fornavn: ");
			person.setFornavn(sc.nextLine());

			System.out.println("Etternavn: ");
			person.setEtternavn(sc.nextLine());

			System.out.println("Fødselsår: ");
			try{
				person.setFoedselsaar(Integer.parseInt(sc.nextLine()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			if(person!= null) {
				personKoe.innKoe(person);
			}
			
			i++;
			System.out.println("**************************\n");
		}

		while(personKoe.antall() > 0){
			System.out.println(personKoe.utKoe().toString());
		}
	}

	public static void kjorTabellOrdnettListe(Scanner sc){
		TabellOrdnetListe<Person> personListe = new TabellOrdnetListe<>();

		System.out.println("Antall personer som skal legges til: ");
		int antall = 0;

		try{
			antall = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}

		int i = 0;
		while(i < antall) {
			System.out.println("**************************\nPerson " + (i+1));
			Person person = new Person();

			System.out.println("Fornavn: ");
			person.setFornavn(sc.nextLine());

			System.out.println("Etternavn: ");
			person.setEtternavn(sc.nextLine());

			System.out.println("Fødselsår: ");
			try{
				person.setFoedselsaar(Integer.parseInt(sc.nextLine()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			if(person!= null) {
				personListe.leggTil(person);
			}
			
			i++;
			System.out.println("**************************\n");
		}

		while(personListe.antall() > 0) {
			System.out.println(personListe.fjernSiste().toString());
		}
	}

	public static void kjorKjedetOrdnetListe(Scanner sc) {
		KjedetOrdnetListe<Person> personListe = new KjedetOrdnetListe<>();
		System.out.println("Antall personer som skal legges til: ");
		int antall = 0;

		try{
			antall = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}

		int i = 0;
		while( i < antall) {
			System.out.println("**************************\nPerson " + (i+1));
			Person person = new Person();

			System.out.println("Fornavn: ");
			person.setFornavn(sc.nextLine());

			System.out.println("Etternavn: ");
			person.setEtternavn(sc.nextLine());

			System.out.println("Fødselsår: ");
			try{
				person.setFoedselsaar(Integer.parseInt(sc.nextLine()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			if(person!= null)
				personListe.leggTil(person);
			i++;
			System.out.println("**************************\n");
		}

		while(personListe.antall() > 0){
			System.out.println(personListe.fjernSiste().toString());

		}
	}
}
