package edu.osu.blackjack;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardTest  {
		

		
		@Test
		public void toStringTest(){
			Card c = new Card(Card.Face.ACE,Card.Suit.HEART);
			c.toString();
			assertEquals("ACEHEART", c.toString());
		}
		
		@Test
		public void isVisibleTest(){
			Card c = new Card(Card.Face.ACE,Card.Suit.HEART);
			c.setVisible(false);
			assertEquals(false, c.isVisible());
			
		}
		
		
}