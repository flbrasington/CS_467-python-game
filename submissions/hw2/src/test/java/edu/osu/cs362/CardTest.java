package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CardTest  {
	
	
	@Test
	public void testNewDeck(){
		CardCollection c = new CardCollection();
        c.add(Card.newDeck());
		
		//tests that all 52 cards have proper values
		assertEquals(2, c.getCards().get(0).face.getValue());
		assertEquals(3, c.getCards().get(1).face.getValue());
		assertEquals(4, c.getCards().get(2).face.getValue());
		assertEquals(5, c.getCards().get(3).face.getValue());
		assertEquals(6, c.getCards().get(4).face.getValue());
		assertEquals(7, c.getCards().get(5).face.getValue());
		assertEquals(8, c.getCards().get(6).face.getValue());
		assertEquals(9, c.getCards().get(7).face.getValue());
		assertEquals(10, c.getCards().get(8).face.getValue());
		assertEquals(10, c.getCards().get(9).face.getValue());
		assertEquals(10, c.getCards().get(10).face.getValue());
		assertEquals(10, c.getCards().get(11).face.getValue());
		assertEquals(11, c.getCards().get(12).face.getValue());
		assertEquals(2, c.getCards().get(13).face.getValue());
		assertEquals(3, c.getCards().get(14).face.getValue());
		assertEquals(4, c.getCards().get(15).face.getValue());
		assertEquals(5, c.getCards().get(16).face.getValue());
		assertEquals(6, c.getCards().get(17).face.getValue());
		assertEquals(7, c.getCards().get(18).face.getValue());
		assertEquals(8, c.getCards().get(19).face.getValue());
		assertEquals(9, c.getCards().get(20).face.getValue());
		assertEquals(10, c.getCards().get(21).face.getValue());
		assertEquals(10, c.getCards().get(22).face.getValue());
		assertEquals(10, c.getCards().get(23).face.getValue());
		assertEquals(10, c.getCards().get(24).face.getValue());
		assertEquals(11, c.getCards().get(25).face.getValue());
		assertEquals(2, c.getCards().get(26).face.getValue());
		assertEquals(3, c.getCards().get(27).face.getValue());
		assertEquals(4, c.getCards().get(28).face.getValue());
		assertEquals(5, c.getCards().get(29).face.getValue());
		assertEquals(6, c.getCards().get(30).face.getValue());
		assertEquals(7, c.getCards().get(31).face.getValue());
		assertEquals(8, c.getCards().get(32).face.getValue());
		assertEquals(9, c.getCards().get(33).face.getValue());
		assertEquals(10, c.getCards().get(34).face.getValue());
		assertEquals(10, c.getCards().get(35).face.getValue());
		assertEquals(10, c.getCards().get(36).face.getValue());
		assertEquals(10, c.getCards().get(37).face.getValue());
		assertEquals(11, c.getCards().get(38).face.getValue());
		assertEquals(2, c.getCards().get(39).face.getValue());
		assertEquals(3, c.getCards().get(40).face.getValue());
		assertEquals(4, c.getCards().get(41).face.getValue());
		assertEquals(5, c.getCards().get(42).face.getValue());
		assertEquals(6, c.getCards().get(43).face.getValue());
		assertEquals(7, c.getCards().get(44).face.getValue());
		assertEquals(8, c.getCards().get(45).face.getValue());
		assertEquals(9, c.getCards().get(46).face.getValue());
		assertEquals(10, c.getCards().get(47).face.getValue());
		assertEquals(10, c.getCards().get(48).face.getValue());
		assertEquals(10, c.getCards().get(49).face.getValue());
		assertEquals(10, c.getCards().get(50).face.getValue());
		assertEquals(11, c.getCards().get(51).face.getValue());
		//Test Suits
		assertEquals("CLUB", c.getCards().get(0).suit.name());
		assertEquals("DIAMOND", c.getCards().get(13).suit.name());
		assertEquals("HEART", c.getCards().get(26).suit.name());
		assertEquals("SPADE", c.getCards().get(39).suit.name());
		//test face values
		assertEquals("TWO", c.getCards().get(0).face.name());
		assertEquals("THREE", c.getCards().get(14).face.name());
		assertEquals("KING", c.getCards().get(24).face.name());
		assertEquals("ACE", c.getCards().get(51).face.name());
		
		//tests that the length is correct
		//int deck_length = c.size();
		//assertEquals(52, deck_length);
	}
		
		//this is to test if the cards are visible
		public void testisVisible(){
			CardCollection c = new CardCollection();
				Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
				c.add(c1);
			
			assertEquals(true, c1.isVisible());
			c1.setVisible(true);
			assertEquals(true, c1.isVisible());
			c1.setVisible(false);
			assertEquals(false, c1.isVisible());
		}
		
		//this is to test String toString
		public void testtoString(){
			CardCollection c = new CardCollection();
			c.add(Card.newDeck());
			assertEquals("TWOCLUB", c.getCards().toString());
		}

}