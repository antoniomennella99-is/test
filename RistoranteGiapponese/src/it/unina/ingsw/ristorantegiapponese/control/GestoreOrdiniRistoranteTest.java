package it.unina.ingsw.ristorantegiapponese.control;
import it.unina.ingsw.ristorantegiapponese.entity.*;

import static org.junit.Assert.*;

import org.junit.Test; 

public class GestoreOrdiniRistoranteTest {

	@Test
	public void test01FormulaConBevandeUnCoperto() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		
		int prezzoTotale;
		
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 1);
		
		Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(24, prezzoTotale);
	}
	
	@Test
	public void test02FormulaConBevandepiùCoperti() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();

		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 2);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(46, prezzoTotale);
		
	}
	
	@Test
	public void test03FormulaConBevandeUnCopertopiùComande() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 1);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(26, prezzoTotale);
		
		
	}
	@Test
	public void test04FormulaConBevandeUnCopertopiùComande() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 2);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(48, prezzoTotale);
	}
	
	@Test
	public void test05FormulaSenzaBevandeUnCopertopiùComande() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 3);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {0};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(66, prezzoTotale);	
	}
	@Test
	public void test06FormulaConBevandeZereoCoperto() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 0);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(0, prezzoTotale);
	}
	
	/*@Test
	public void test07FormulaSenzaComanda() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 1);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		//gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(0, prezzoTotale);		
	}*/
	
	@Test
	public void test08FormulaConBevandeUnCoperto() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(9, prezzoTotale);		
	}
	
	@Test
	public void test09FormulaConBevandeUnCoperto() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 2);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(11, prezzoTotale);		
	}
	@Test
	public void test10FormulaConBevandeUnCoperto() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(16, prezzoTotale);
	}
	@Test
	public void test11FormulaConBevandeUnCopertopiùComande() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 2);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(18, prezzoTotale);
	}
	@Test
	public void test12FormulaConBevandeUnCoperto() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(1);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(10, prezzoTotale);		
	}
	@Test
	public void test13FormulaConBevandeUnCopertopiùComande() {
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		int prezzoTotale;
        Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
        
        Piatto [] piatti = new Piatto[1];
		piatti[0] = gestore_ord.piattiInMenu.get(0);
		int [] qtaPiatti = {1};
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = gestore_ord.bevandeInMenu.get(0);
		int [] qtaBevande = {0};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);

		gestore_ord.chiudiConto(conto);
		
		prezzoTotale = gestore_ord.visualizzaConto(conto);

		assertEquals(7, prezzoTotale);		
	}
	}


