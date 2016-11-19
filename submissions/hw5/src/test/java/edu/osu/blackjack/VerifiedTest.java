package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;

public class VerifiedTest{
    
	//this tests if the dealer recieves cards to the dealer's hand
	/*
	@Test
	public void testDealerhand(){
		DealerAction dt = mock(DealerAction.class);
		PlayerAction pa = mock(PlayerAction.class);
		
		SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
		j.playRound();
		
		verify(dt.dealerHand, times(2)).size(); //
	}
*/
	@Test
	public void isInsuranceAvailableTest(){
		Dealer d = new Dealer();
		Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
		Card c2 = new Card(Card.Face.TEN,Card.Suit.HEART);
		c1.setVisible(true);
		
		d.acceptCard(c1);
		d.acceptCard(c2);
		
		assertNotEquals(false, d.isInsuranceAvailable());
	}
	
	@Test
	public void nextHandTest(){
		Player p = new Player();
		p.nextHand();
		assertNotEquals("Player: []w nullb nulli null", p.toString());

	}
	
	@Test
	public void teststartingdealershand(){
		DealerAction dt = mock(DealerAction.class);
		PlayerAction pa = mock(PlayerAction.class);
		
		
		when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
		SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
		j.playRound();
		verify(dt, times(2)).dealCard(dt);
		
	}


	@Test //the player's starting hand should be 2 cards
	public void testhandStartingHandSize(){
		DealerAction dt = mock(DealerAction.class);
		PlayerAction pa = mock(PlayerAction.class);
		
		when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
		SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
		j.playRound();
		verify(dt, times(2)).dealCard(pa);
	}
	
	
	@Test
    public void testHit(){
	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);

	when(pa.getAction()).thenReturn(PlayerAction.ActionType.HIT)
		.thenReturn(PlayerAction.ActionType.HIT)
		.thenReturn(PlayerAction.ActionType.HIT)
		.thenReturn(PlayerAction.ActionType.STAND);	                          
	SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
	j.playRound();
	verify(dt, times(5)).dealCard(pa);
    }

		
	@Test
    public void testDouble(){
	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);

	when(pa.getAction()).thenReturn(PlayerAction.ActionType.DOUBLE)
		.thenReturn(PlayerAction.ActionType.DOUBLE)
		.thenReturn(PlayerAction.ActionType.STAND);	                          
	SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
	j.playRound();
	verify(pa, times(1)).doubleDownBet(); //
    }
	
	@Test
    public void testStand(){
	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);

	when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND)
		.thenReturn(PlayerAction.ActionType.STAND);	                          
	SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
	j.playRound();
	verify(dt, times(2)).dealCard(pa);
    }
	
}
