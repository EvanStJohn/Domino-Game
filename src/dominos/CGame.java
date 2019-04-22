package dominos;

import java.util.ArrayList;
import java.util.Scanner;

public class CGame {

    CBoard board;
    CDeck deck;
    CPlayer p1;
    CPlayer p2;
    
    //Constructor to set up game
    public CGame(int startHandSize) {
        //Create deck
        deck = new CDeck();
        deck.shuffle();
        
        //Create players
        p1 = new CPlayer(1);
        p2 = new CPlayer(2);
        
        //Give hands
        for (int i = 0; i < startHandSize; i++) {
            deck.deal(p1);
            deck.deal(p2);
        }
        
        //Create Board
        board = new CBoard();
        
        int starter = firstPlay();
        if (starter == 1) {
            Play(p1, p2);
        }
        else {
            Play(p2, p1);
        }

    }
    
    //determines starting player
    public int firstPlay() {
        int largestWeight = 0;
        int startingPlayer = 0;
        ArrayList<CDomino> hand1 = p1.getHand();
        ArrayList<CDomino> hand2 = p2.getHand();
        
        for (int i = 0; i < hand1.size(); i++) {
            int pieceWeight = hand1.get(i).getTotal();
            if (pieceWeight > largestWeight) {
                startingPlayer = 1;
                largestWeight = pieceWeight;
            }
        }
        
        for (int i = 0; i < hand2.size(); i++) {
            int pieceWeight = hand2.get(i).getTotal();
            if (pieceWeight == largestWeight && startingPlayer == 1) {
                startingPlayer = 0;
            }
            else if (pieceWeight > largestWeight) {
                startingPlayer = 2;
                largestWeight = pieceWeight;
            }
        }
        
        if (startingPlayer == 0) {
            //May want to implement a system to pick a first player if a tie
            return 1;
        }
        return startingPlayer;
    }
    
    //dictates main flow of game
    public void Play(CPlayer startingPlayer, CPlayer otherPlayer) {
        
        int turn = 1;
        int passes = 0;
        int winner = 0;
        boolean cont = true;
        ArrayList<CDomino> hand = startingPlayer.getHand();
        System.out.println("Player " + startingPlayer.getId() + ", place the first piece.");
        startingPlayer.showHand();
        boolean needInput = true;
        int tile = -1;
        
        while(needInput) {
        	Scanner scan = new Scanner(System.in);
        	if (scan.hasNextInt()) {
        		tile = scan.nextInt();
        		if (hand.size() > tile) {
            		board.playFirstTile(hand.get(tile));
            		startingPlayer.removePiece(hand.get(tile));
            		needInput = false;
        		}
        		else {
        			System.out.println("Please select a tile index within your hand.");
        		}
        	}
        	else {
        		System.out.println("Please use an integer to specify an index of tile from your hand.");
        	}
        	
        }
        
        while(cont) {
        	System.out.println("Front: " + board.getFront() + ". End: " + board.getEnd());
        	if (turn%2 == 0) {
        		System.out.println("It is player "+ startingPlayer.getId() +"s turn.");
        		int pass = takeTurn(startingPlayer);
        		if (pass == 0) {
        			passes = 0;
        		}
        		else {
        			System.out.println("You must pass your turn");
        			passes++;
        		}
        		if (startingPlayer.getHand().size() == 0) {
        			cont = false;
        			winner = 1;
        		}
        		turn++;
        	}
        	else {
        		System.out.println("It is player "+ otherPlayer.getId() +"s turn.");
        		int pass = takeTurn(otherPlayer);
        		if (pass == 0) {
        			passes = 0;
        		}
        		else {
        			System.out.println("You must pass your turn");
        			passes++;
        		}
        		if (otherPlayer.getHand().size() == 0) {
        			cont = false;
        			winner = 2;
        		}
        		turn++;
        	}
        	
        	if(passes == 2) {
        		System.out.println("Both players had to pass. Game over.");
        		cont = false;
        		winner = bothPassed(startingPlayer, otherPlayer);
        	}
       
        	
        	
     
        }
        
        if (winner == 1) {
        	int score = score(otherPlayer);
        	System.out.println("Player " + startingPlayer.getId() + " wins with " + score + " points");
        }
        else if (winner == 2){
        	int score = score(startingPlayer);
        	System.out.println("Player " + otherPlayer.getId() + " wins with " + score + " points");
        }
        else {
        	System.out.println("Both players tied the tie breaker.");
        }
        
        
    }
    
    //determines how a player takes a turn
    public int takeTurn(CPlayer currentPlayer) {
    	
    	if (currentPlayer.hasPlay(board.getFront(), board.getEnd())) {
    		currentPlayer.showHand();
    		currentPlayer.showPlays(board.getFront(), board.getEnd());
    		boolean takeTurn = true;
    		while(takeTurn) {
    			if (!makePlay(currentPlayer) ) {
    				takeTurn = false;
    			}
    		}
    		return 0;
    	}
    	else if (deck.size() > 0 && !currentPlayer.hasPlay(board.getFront(), board.getEnd())) {
    		deck.deal(currentPlayer);
    		if (currentPlayer.hasPlay(board.getFront(), board.getEnd())) {
    			currentPlayer.showHand();
        		currentPlayer.showPlays(board.getFront(), board.getEnd());
        		boolean takeTurn = true;
        		while(takeTurn) {
        			if (!makePlay(currentPlayer) ) {
        				takeTurn = false;
        			}
        		}
    			//Make play
    			return 0;
    		}
    		else {
    			return 1;
    		}
    	}
    	return 1;
    }
    
    //calculates score for the winning player
    public int score(CPlayer loser) {
    	ArrayList<CDomino> hand = loser.getHand();
    	int sum = 0;
    	for (int i = 0; i < hand.size(); i++) {
    		sum += hand.get(i).getTotal();
    	}
    	return sum;
    }
    
    //if both players passed, determines winner
    public int bothPassed(CPlayer startingPlayer, CPlayer otherPlayer) {
    	int lowest = 100;
    	int winner = 0;
        ArrayList<CDomino> hand1 = startingPlayer.getHand();
        ArrayList<CDomino> hand2 = otherPlayer.getHand();
    	
    	for (int i = 0; i < hand1.size(); i++) {
    		int tot = hand1.get(i).getTotal();
    		
    		if (tot < lowest) {
    			lowest = tot;
    			winner = 1;
    		}
    	}
    	
    	for (int i = 0; i < hand2.size(); i++) {
    		int tot = hand1.get(i).getTotal();
    		
    		if (tot < lowest) {
    			lowest = tot;
    			winner = 2;
    		}
    		else if (tot == lowest) {
    			winner = 0;
    		}
    	}
    		
    	return winner;
    }
    
    //if a player can make a play, the player makes the decisions
    public boolean makePlay(CPlayer currentPlayer) {
		
    	boolean takeTurnAgain = false;
		
		boolean needInput = true;
		int tile = -1;
		while(needInput) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Which tile would you like to place?");
			if (scan.hasNextInt()) {
				tile = scan.nextInt();
				needInput = false;
			}
			else {
				System.out.println("Not a valid tile number. Please input a number.");
			}
		}
		
		int location = -1;
		needInput = true;
		while(needInput) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Would you like to place the tile at the front (1) or the end (0)?");
			if(scan.hasNextInt()) {
				location = scan.nextInt();
				needInput = false;
			}
			else {
				System.out.println("Please input a valid location: front (1) or end (0) ");
			}
			
		}
		if (isValidPlay(currentPlayer, tile, location)) {
			board.playTile((CDomino) currentPlayer.getHand().get(tile), location);
			currentPlayer.removePiece((CDomino) currentPlayer.getHand().get(tile));
			takeTurnAgain = false;
		}
		else {
			System.out.println("Invalid play. Please re-select tile and location");
			takeTurnAgain = true;
		}

		//Make play
		
		return takeTurnAgain;
    }
    
    //determines if an inputed play is valid
    public boolean isValidPlay(CPlayer player, int tileIndex, int location) {
    	
    	ArrayList<CDomino> hand = player.getHand();
    	
    	boolean handBounds = hand.size() > tileIndex;
    	boolean placement = false;
    	if (handBounds) {
    		if (location == 1) {
    			placement = board.getFront() == hand.get(tileIndex).getLeft() || board.getFront() == hand.get(tileIndex).getRight();
    		}
    		else if (location == 0) {
    			placement = board.getEnd() == hand.get(tileIndex).getLeft() || board.getEnd() == hand.get(tileIndex).getRight();
    		}
    	}
    	return placement;
    	
    }
    
    //runs the game
    public static void main(String[] args) {

        CGame game = new CGame(10);

    }
}

