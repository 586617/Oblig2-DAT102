package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;


public abstract class MengdeADTTest {

	// Referanse til mengde
	private MengdeADT<Integer> mengde;
	private MengdeADT<Integer> mengde2;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract MengdeADT<Integer> reset();
		
	/*
	 * Henter en ny mengde for hver test.
	 */
	@BeforeEach
	public void setup() {
		mengde = reset();
		mengde2 = reset();
	}
	
	@Test
	public final void UnionFellesTest() {  
		MengdeADT<Integer> begge;
		begge = reset();
		
		mengde.leggTil(e1);
		mengde.leggTil(e2);
		mengde.leggTil(e3);
		mengde.leggTil(e4);
		mengde2.leggTil(e1);
		mengde2.leggTil(e2);
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		
		begge.leggTil(e1);
		begge.leggTil(e2);
		begge.leggTil(e3);
		begge.leggTil(e4);
		
		assertTrue(begge.equals(mengde.union(mengde2)));
		
	}
	
	@Test
	public final void UnionDisjunktTest() {
		MengdeADT<Integer> begge;
		begge = reset();
		
		mengde.leggTil(e0);
		mengde.leggTil(e3);
		mengde.leggTil(e2);
		mengde2.leggTil(e1);
		mengde2.leggTil(e4);
		
		begge.leggTil(e0);
		begge.leggTil(e1);
		begge.leggTil(e2);
		begge.leggTil(e3);
		begge.leggTil(e4);
		
		assertTrue(begge.equals(mengde.union(mengde2)));
		
	}
	
	@Test
	public final void SnittFellesTest() {
		MengdeADT<Integer> begge;
		begge = reset();
		
		mengde.leggTil(e0);
		mengde.leggTil(e1);
		mengde.leggTil(e3);
		mengde2.leggTil(e0);
		mengde2.leggTil(e1);
		mengde2.leggTil(e3);
		
		begge.leggTil(e0);
		begge.leggTil(e1);
		begge.leggTil(e3);
		
		assertTrue(begge.equals(mengde.snitt(mengde2)));
		
	}
	
	@Test 
	public final void SnittDisjunktTest() {
		MengdeADT<Integer> begge;
		begge = reset();
		
		mengde.leggTil(e0);
		mengde.leggTil(e1);
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		
		assertTrue(begge.equals(mengde.snitt(mengde2)));
		
	}
	
	@Test
	public final void DifferensFellesTest() {
		MengdeADT<Integer> begge;
		begge = reset();
		
		mengde.leggTil(e0);
		mengde.leggTil(e2);
		mengde.leggTil(e4);
		mengde.leggTil(e3);
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		
		begge.leggTil(e0);
		begge.leggTil(e2);
		
		assertTrue(begge.equals(mengde.differens(mengde2)));
		
	}
	
	@Test
	public final void DifferensDisjunktTest() {
		MengdeADT<Integer> begge;
		begge = reset();
		
		mengde.leggTil(e0);
		mengde.leggTil(e1);
		mengde.leggTil(e2);
		mengde2.leggTil(e0);
		mengde2.leggTil(e1);
		mengde2.leggTil(e2);
		
		assertTrue(begge.equals(mengde.differens(mengde2)));
		
	}
	
	
}