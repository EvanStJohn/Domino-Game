package dominos;

import java.util.Collections;
import java.util.*;


public class CDeck {
    
    private List<CDomino> deck;
    
    //constructor of the deck. Creates one domino of each type
    public CDeck()
    {
        deck = new ArrayList<CDomino>();
        
        for(int i = 0; i <= 6; i++)
        {
            for(int k = 0; k <= 6; k++)
            {
                CDomino Dom = new CDomino(i,k);
                deck.add(Dom);
            }
        }
    }
    
    //shuffles deck
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    //returns size of deck
    public int size()
    {
        return deck.size();
    }
    
    //deals a tile to a player and removes it from the deck
    public void deal(CPlayer player)
    {
        player.addPiece(deck.remove(0));
    }
}
