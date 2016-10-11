package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardCollectionTest  {
    
	
    public void testWithBadSize(int n) {
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = i;
        }
        CardCollection c = new CardCollection();
        c.add(Card.newDeck());
        c.permute(a);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooSmall() {
        testWithBadSize(1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTooBig() {
        testWithBadSize(100);
    }

	//there should be zero cards in this deck.
	@Test(expected = IndexOutOfBoundsException.class) 
	public void test_decksize(){
		CardCollection c = new CardCollection();
		Card c1 = c.getCards().get(0);
		
	}

	@Test public void testdiscardCard_from_top(){
		CardCollection c = new CardCollection();
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		Card c2 = new Card(Card.Face.KING,Card.Suit.DIAMOND);
		Card c3 = new Card(Card.Face.FIVE,Card.Suit.CLUB);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		Card c4 = c.getCards().get(0);
		assertEquals(c1.suit,c4.suit);
		assertEquals(c4.face.getValue(),11);
		//test deck
		Card c_discard = c.discardCard(0);
		assertEquals(c_discard.suit, c1.suit);

		//tests the remaining cards to make sure the cards are still in the same order
		Card new_top = c.getCards().get(0);
		Card new_bottom = c.getCards().get(1);
		
		assertEquals(new_top.face.getValue(), 10);
		assertEquals(new_bottom.face.getValue(), 5);
		}

	@Test public void testdiscardCard_from_middle(){
		CardCollection c = new CardCollection();
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		Card c2 = new Card(Card.Face.KING,Card.Suit.DIAMOND);
		Card c3 = new Card(Card.Face.FIVE,Card.Suit.CLUB);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		Card c4 = c.getCards().get(1);
		assertEquals(c2.suit,c4.suit);
		assertEquals(c4.face.getValue(),10);
		//test deck
		Card c_discard = c.discardCard(0);
		assertEquals(c_discard.suit, c1.suit);

		//tests the remaining cards to make sure the cards are still in the same order
		Card new_top = c.getCards().get(0);
		Card new_bottom = c.getCards().get(1);
		
		assertEquals(new_top.face.getValue(), 11); //error detected here
		assertEquals(new_bottom.face.getValue(), 5);
		}
		
	@Test public void testdiscardCard_from_back(){
		CardCollection c = new CardCollection();
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		Card c2 = new Card(Card.Face.KING,Card.Suit.DIAMOND);
		Card c3 = new Card(Card.Face.FIVE,Card.Suit.CLUB);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		Card c4 = c.getCards().get(2);
		assertEquals(c3.suit,c4.suit);
		assertEquals(c4.face.getValue(),5);
		//test deck
		Card c_discard = c.discardCard(0);
		assertEquals(c_discard.suit, c1.suit);

		//tests the remaining cards to make sure the cards are still in the same order
		Card new_top = c.getCards().get(0);
		Card new_bottom = c.getCards().get(1);
		
		assertEquals(new_top.face.getValue(), 11); //error detected here
		assertEquals(new_bottom.face.getValue(), 10);
		}
		
//this is to check that the deck decreases in size after a card is discarded
	@Test(expected=IndexOutOfBoundsException.class)
		public void testdecksizechanges() {
		CardCollection c = new CardCollection();
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		Card c2 = new Card(Card.Face.KING,Card.Suit.DIAMOND);
		Card c3 = new Card(Card.Face.FIVE,Card.Suit.CLUB);
		Card c_discard = c.discardCard(0);
		
		Card should_fail = c.getCards().get(2);
		}
		
	@Test(expected = IndexOutOfBoundsException.class)
	public void testdiscardCarddiscards(){
		CardCollection c = new CardCollection();
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		c.add(c1);
		Card c2 = new Card(Card.Face.KING,Card.Suit.DIAMOND);
		c.add(c2);
		Card c4 = c.discardCard(0);
		Card c5 = c.getCards().get(1);
	}


/*
	@Test public void testpermute(){
		//random array for permute
		int[] test_array1 = {0,1,2,3,4};
		
		//Creat the deck of cards for testing
		CardCollection c = new CardCollection();
		Card c0 = new Card(Card.Face.ACE,Card.Suit.HEART);
		c.add(c0);
		Card c1 = new Card(Card.Face.KING,Card.Suit.SPADE);
		c.add(c1);
		Card c2 = new Card(Card.Face.QUEEN,Card.Suit.CLUB);
		c.add(c2);
		Card c3 = new Card(Card.Face.JACK,Card.Suit.DIAMOND);
		c.add(c3);
		Card c4 = new Card(Card.Face.TEN,Card.Suit.HEART);
		c.add(c4);
		
		//call on the permute function
		//the card order should remain the same.
		c.permute(test_array1);
		assertEquals(c0.suit, c.getCards().get(0).suit);
		assertEquals(c1.suit, c.getCards().get(1).suit);
		assertEquals(c2.suit, c.getCards().get(2).suit);
		assertEquals(c3.suit, c.getCards().get(3).suit);
		assertEquals(c4.suit, c.getCards().get(4).suit);
		
		//this array will change the order
		int[] test_array2 = {3,4,1,0,2};
		c.permute(test_array2);
		assertEquals(c0.suit, c.getCards().get(3).suit);
		assertEquals(c1.suit, c.getCards().get(2).suit);
		assertEquals(c2.suit, c.getCards().get(4).suit);
		assertEquals(c3.suit, c.getCards().get(0).suit);
		assertEquals(c4.suit, c.getCards().get(1).suit);
		
	}
*/

}
