package dominos;


import java.util.*;


public class CPlayer {
    
    private int id;
    private List<CDomino> hand;
    
    
    public CPlayer (int idNum, List<CDomino> dominos)
    {
        id = idNum;
        hand = dominos;
    }
    
    public List<CDomino> getHand()
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
    
    public void hasPlay()
    {
        // will finish after domino class is complete
    }
    
}
