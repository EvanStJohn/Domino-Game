package dominos;

import java.util.Collections;
import java.util.*;


public class CDeck {
    
    private List<CDomino> deck;
    
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
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    public int size()
    {
        return deck.size();
    }
    
    public void deal(CPlayer player, int num)
    {
        player.addPiece(deck.remove(0));
    }
}
