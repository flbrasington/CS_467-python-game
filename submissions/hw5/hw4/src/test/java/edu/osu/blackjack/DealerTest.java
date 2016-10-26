package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;

public class DealerTest {
    
	@Test
	public void getHandTest(){
		Dealer d1 = new Dealer();
		Dealer d2 = new Dealer();

		d1.shuffleDeck();
		assertNotEquals(d1.getHand(), d2.getHand());
		
	}

	@Test
	public void dumpDeckTest(){
		
		Dealer d = new Dealer();
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		
		d.acceptCard(c1);
		
		d.dumpDeck(d.getHand());
		
		
		}
	
	@Test
	public void shuffleDeckTest(){
		Dealer d1 = new Dealer();
		Dealer d2 = new Dealer();
		
	}
	
	@Test
	public void dealCardTest(){
		Dealer d = new Dealer();
		Player p = new Player();
		d.dealCard(p);
		assertNull(p.getAction());
	}
	
	@Test
	public void compareHandAndSettleTest(){
		Dealer d = new Dealer();
		Player p1 = new Player();
		
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		Card c2 = new Card(Card.Face.TEN,Card.Suit.HEART);
		Card c3 = new Card(Card.Face.KING,Card.Suit.HEART);
		Card c4 = new Card(Card.Face.QUEEN,Card.Suit.HEART);
		
		p1.acceptCard(c1);
		p1.acceptCard(c2);
		d.acceptCard(c1);
		d.acceptCard(c2);
		
		d.compareHandAndSettle(p1);
		assertNotEquals("Player: []w nullb nulli null", p1.toString());
		
		Player p2 = new Player();
		p2.acceptCard(c1);
		p2.acceptCard(c2);
		p2.acceptCard(c3);
		p2.acceptCard(c4);
		
		d.acceptCard(c3);
		d.acceptCard(c4);
		
		d.compareHandAndSettle(p2);
		assertNotEquals("Player: []w nullb nulli null", p2.toString());
		

		
		Dealer d2 = new Dealer();
		d2.setDeck(p2.getHand());
		d2.compareHandAndSettle(p1);
		assertNotEquals("Player: []w nullb nulli null", p1.toString());
		
		d2.compareHandAndSettle(p1);
		
		Player p3 = new Player();
		p3.acceptCard(c1);
		p3.acceptCard(c1);
		
		int i;
			for( i = 0; i < 50; i++)
				d2.dealCard(p3);
		
		d2.compareHandAndSettle(p3);
		
		
	}
	
	@Test
	public void isInsuranceAvailableTest(){
		Dealer d = new Dealer();
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		Card c2 = new Card(Card.Face.TEN,Card.Suit.HEART);
		c1.setVisible(true);
		
		d.acceptCard(c1);
		d.acceptCard(c2);
		
		assertNotEquals(true, d.isInsuranceAvailable());
		
		Card c3 = new Card(Card.Face.THREE,Card.Suit.HEART);
		Card c4 = new Card(Card.Face.TEN,Card.Suit.HEART);
		
		assertNotEquals(false, d.isInsuranceAvailable());
		
		
	}
	
};
