package dominos;


import java.util.*;


public class CPlayer {
    
    private int id;
    private ArrayList<CDomino> hand;
    
    
    public CPlayer (int idNum)
    {
        id = idNum;
        hand = new ArrayList();
    }
    
    public ArrayList getHand()
    {
        return hand;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void addPiece(CDomino domino)
    {
        hand.add(domino);
    }
    
    public void removePiece(CDomino domino)
    {
        hand.remove(domino);
    }
    
    public boolean isEmpty()
    {
        return hand.isEmpty();
    }
    
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
