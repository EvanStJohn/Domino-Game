package dominos;


import java.util.*;


public class CPlayer {
    
    private int id;
    private ArrayList<CDomino> hand;
    
    //player constructor
    public CPlayer (int idNum)
    {
        id = idNum;
        hand = new ArrayList();
    }
    
    //returns hand
    public ArrayList getHand()
    {
        return hand;
    }
    
    //returns player ID
    public int getId()
    {
        return id;
    }
    
    //adds piece to player's hand
    public void addPiece(CDomino domino)
    {
        hand.add(domino);
    }
    
    //removes piece from player's hand
    public void removePiece(CDomino domino)
    {
        hand.remove(domino);
    }
    
    //checks if hand is empty
    public boolean isEmpty()
    {
        return hand.isEmpty();
    }
    
    //determines if the player has a possible play
    public boolean hasPlay(int front, int end)
    {
    	if (hand != null) {
    		for (int i = 0; i < hand.size(); i++) {
    			if (front == hand.get(i).getLeft() || front == hand.get(i).getRight()) {
    				return true;
    			}
    			if (end == hand.get(i).getLeft() || end == hand.get(i).getRight()) {
    				return true;
    			}
    		}
    	}
        // will finish after domino class is complete
        return false;
    }
    
    //prints possible plays for the player
    public void showPlays(int front, int end) {
    	if (hand != null) {
    		for (int i = 0; i < hand.size(); i++) {
    			if (front == hand.get(i).getLeft() || front == hand.get(i).getRight()) {
    				hand.get(i).printH();
    				System.out.print("Piece " + i + " Can be played at the front \n");
    			}
    			if (end == hand.get(i).getLeft() || end == hand.get(i).getRight()) {
    				hand.get(i).printH();
    				System.out.print("Piece " + i + " Can be played at the end \n");
    			}
    		}
    		System.out.println();
    	}
    }
    
    //prints hand for the player
    public void showHand() {
    	if (hand != null) {
    		System.out.println("Here is your hand");
    		for (int i = 0; i < hand.size(); i++ ) {
    			hand.get(i).printH();
    		}
    		System.out.println();
    	}
    }
    
}
