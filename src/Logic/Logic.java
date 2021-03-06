package Logic;
import Card.Card;

import Card.Deck;
import Player.PlayerAI;
import Player.PlayerHuman;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class contains methods that handle general game logic
 *
 */

public class Logic {
	private int playerTurn = 1;
	private boolean clockwise = true;
	
	/** Getter for playerTurn of type integer
	 * @return playerTurn of type integer
	 */
	public int getPlayerTurn() {
		int turn = playerTurn;
		return turn;
	}

	/** Setter for playerTurn of type integer
	 * @param playerTurn
	 */
	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	/** Method that returns the boolean for clockwise
	 * @return clockwise of type boolean
	 */
	public boolean isClockwise() {
		return clockwise;
	}

	/** Setter for clockwise of type boolean
	 * @param clockwise
	 */
	public void setClockwise(boolean clockwise) {
		this.clockwise = clockwise;
	}
	
	/** Called by PlayerAI.cardAI() and PlayerHuman.cardAction()
	 * Method that checks the if the card played is valid or not
	 * @param topCard
	 * @param cardPlayed
	 * @return valid of type boolean
	 */
	public boolean isValid(Card topCard, Card cardPlayed){
		boolean valid = false;
		String topCardColor = topCard.getColor();
		String topCardNumber = topCard.getNumber();
		String cardPlayedColor = cardPlayed.getColor();
		String cardPlayedNumber = cardPlayed.getNumber();
		System.out.println("Colors:  " + cardPlayedColor + "  " + topCardColor);
		System.out.println("Numbers:  " + cardPlayedNumber + "  " + topCardNumber);
		if (cardPlayedColor.equals(topCardColor) || cardPlayedNumber.equals(topCardNumber) || cardPlayedNumber.equals("Wild") || cardPlayedNumber.equals("Wild Draw 4")) {
			valid = true;
		}
		System.out.println(valid);
		return valid;
	}
	
	/** Called by cardAction() in both player classes
	 * Method updates playerTurn after every turn end. 
	 */
	public void gameState(){
		if (playerTurn == 5) {
			setPlayerTurn(1);
		} 
		else if (playerTurn == 6) {
			setPlayerTurn(2);
		}
		if (playerTurn ==0 ) {
			setPlayerTurn(4);
		} else if (playerTurn == -1) {
			setPlayerTurn(3);
		}
	}
	
	/** Method that takes in all the player hand sizes and prints out how many cards they have
	 * @param player1
	 * @param player2
	 * @param player3
	 * @param player4
	 */
	public void numOfCards(PlayerHuman player1, PlayerAI player2, PlayerAI player3, PlayerAI player4) {
		System.out.println("Player 1 has " + player1.getHand().size() + " Cards");
		System.out.println("Player 2 has " + player2.getHand().size() + " Cards");
		System.out.println("Player 3 has " + player3.getHand().size() + " Cards");
		System.out.println("Player 4 has " + player4.getHand().size() + " Cards");
	}
	
	/** Method that makes the player type "Uno" or "uno" to win
	 * Unused in GUI version
	 * @param playerhand of type ArrayList<Card>
	 */
	public void lastCard(ArrayList<Card> playerhand) {
		Scanner keyboard = new Scanner(System.in);
		String gameComplete = "  ";
		if (playerhand.size() == 1) {
				gameComplete = keyboard.nextLine();
			if (gameComplete.equals("Uno") || gameComplete.equals("uno")) {
			}
			else {
				Deck deck = new Deck();
				deck.draw(1,playerhand);
			}
		}
	}
}
	
	
	
	
	
	
	
	
	
