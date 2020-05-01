package no.hvl.dat102;

import java.io.*;
import no.hvl.dat102.TabellStabel;
public class Balansering {
	TabellStabel<Parentesinfo> stabel = new TabellStabel<Parentesinfo>();

	private boolean passer(char aapent, char lukket) {
		switch (aapent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {
        
		int lengde = innDataStreng.length();
		boolean balansert=true;
		Parentesinfo parainfo = new Parentesinfo();
		for (int i=0; i<lengde && balansert; i++) {
			char bokstav = innDataStreng.charAt(i);
			if ((bokstav =='(') || (bokstav=='[') || (bokstav=='{') ) {
				parainfo.setLinjenr(linjenr);
				parainfo.setPosisjon(i);
				parainfo.setVenstreparentes(bokstav);
				stabel.push(parainfo);
			} else if ((bokstav==')') || (bokstav==']') || (bokstav=='}') ) {
				if (stabel.erTom()) {
					balansert=false;
					System.out.println("Tegn "+ bokstav+ " på "+ linjenr+ " tegn nr " + i+ " har ikke åpnetegn");
				} else {
					Parentesinfo top = stabel.pop();
					char forrige = top.getVenstreparentes();
					balansert=passer(forrige, bokstav);
					if (!balansert) {
						System.out.println("Tegn "+bokstav+" på "+linjenr+" tegn nr "+ i+ " har feil og er ikke balansert");
						balansert=true;
					}
				}
			}
		}
while (!stabel.erTom()) {
	parainfo=stabel.pop();
	char parentes = innDataStreng.charAt(parainfo.getPosisjon());
	System.out.println("Aapesymbol "+ parentes +" på "+  parainfo.getLinjenr()+" tegn nr "+ parainfo.getPosisjon()+ " har ikke lukkesymbol.");
}
	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ike filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				foretaBalansering(linje, linjenr++);

			} // while
			
			//... Fyll ut
			//... Test på om om det er flere elementer igjen på stablen
			// ... tømme stabelen
			// dvs. dersom vi mangler ett eller flere lukkesymboler
			// Feilmelding 3
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
