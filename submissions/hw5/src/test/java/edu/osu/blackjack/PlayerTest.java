package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class PlayerTest {
		
	@Test
	public void makeBetTest(){
	Player p  = new Player();
	int number = 0;
	number = p.makeBet();
	assertEquals(10, number);
	
	};
	
	@Test
	public void doubleDownBetTest(){
		Player p  = new Player();
		int number = 10;	
		number = p.makeBet();
		number = p.doubleDownBet();
		assertEquals(20, number);
		
	}
	
	@Test
	public void moveMoneyToInsuranceTest(){
		Player p  = new Player();
		//test successful condition
		p.moveMoneyToInsurance(10);
		int number = 10;
		assertEquals(number, p.makeInsuranceBet());
	
	}
	
	@Test
	public void toStringTest(){
		Player p  = new Player();
		Card c = new Card(Card.Face.ACE,Card.Suit.HEART);
		p.acceptCard(c);
		assertEquals("Player: [ACEHEART]w 1000b nulli null", p.toString());
	}
	
	@Test(expected = RuntimeException.class)
    public void moveMoneyToInsuranceTest2() {
		Player p  = new Player();
		//test successful condition
		p.moveMoneyToInsurance(10000000);
		//int number = 10000000;
		//assertEquals(number, p.makeInsuranceBet());
    }
	
		
	@Test(expected = RuntimeException.class)
    public void moveMoneyToBet() {
		Player p  = new Player();
		//test unsuccessful condition
		p.moveMoneyToBet(10000000);
		//int number = 10000000;
		//assertEquals(number, p.makeInsuranceBet());
    }
	
	@Test
    public void moveMoneyToBet2() {
		Player p  = new Player();
		//test successful condition
		p.moveMoneyToBet(10);
		int number = p.getCurrentBet();
		assertEquals(number, 10);
    }
/*	
	@Test
	public void nextHandTest(){
		Player p = new Player();
		p.nextHand();
		assertNotEquals("Player: []w nullb nulli null", p.toString());

	}
*/	
	@Test
	public void getHandTest(){
		Player p1 = new Player();
		Player p2 = new Player();
		Card c = new Card(Card.Face.ACE,Card.Suit.HEART);
		p1.acceptCard(c);
		p2.acceptCard(c);
		
		assertEquals(p2.getHand(), p1.getHand());
		
	}
	
};