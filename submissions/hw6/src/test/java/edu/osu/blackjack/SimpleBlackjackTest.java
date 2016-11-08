package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class SimpleBlackjackTest {
    @Test
    public void testBasicFunctionality(){
	// Does it run without errors for a simple case?
	Dealer dealer = new Dealer();
	Player[] players  = new Player[1];
	players[0] = new Player(){
		@Override
		public int makeBet(){
		    this.currentBet = 1 + ((int)Math.random()*5);
		    return currentBet;
		}
	    };
	SimpleBlackjack j = new SimpleBlackjack(dealer,players);
	j.playRound();

    }
	
	

    	@Test
	public void testRandomBlackJack(){

	//define variables that won't change
	Dealer dealer = new Dealer();


	//variables that will be used in the round
	int num_of_players = 1;//defines the number of players	

	//this will preform 1000 rand tests
	
	for(int i=0; i<1000; i++){
		//randomlly selects number of players
		num_of_players = ((int) (Math.random() *(4 - 1))-1);

		Player[] players = new Player[num_of_players];
	
		//sets up random conditions for each player
		for(int j=0; j<num_of_players; j++){
			players[j] = new Player(){
				@Override
				public int makeBet(){
					this.currentBet = 1 + ((int)Math.random()*5);
					return currentBet;
				};
			
				public void currentWallet(){
					this.currentWallet = ((int) (Math.random() * (1000 - 0))-0);
				};
				
			};

		}
	
		SimpleBlackjack j = new SimpleBlackjack(dealer,players);
		j.playRound();

	}
	}
};
