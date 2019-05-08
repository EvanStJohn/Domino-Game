package dominos;

import java.util.ArrayList;

public class CAi {
    
    CBoard board;
    CDeck deck;
    CPlayer p1;
    CPlayer p2;
    int winner = 0;
    int pass = 0;
    
    public CAi(int startHandSize)
    {
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
        
        // make first play
        firstPlay();
        
        // 
        while (winner == 0 && pass < 2)
        {
            pass = 0;
            
            System.out.println("Player 1:");
            p1.showHand();
            System.out.println("player 1 decides to play");
            play(p1);
            checkWinner();
            
            if (winner == 0)
            {
                System.out.println("Player 2:");
                p2.showHand();
                System.out.println("player 2 decides to play");
                play(p2);
                checkWinner();
            }
            
        }
        
        result();
    }
    
    public void firstPlay()
    {
        ArrayList<CDomino> hand = p1.getHand();
        CDomino firstTile = hand.get(0);
        
        System.out.println("Player 1:");
        p1.showHand();
        System.out.println("player 1 decides to play");
        firstTile.printH();
        System.out.println(" ");
        board.playFirstTile(firstTile);
        board.printBoard();
        System.out.println(" ");
        p1.removePiece(firstTile);
        
        System.out.println("Player 2:");
        p2.showHand();
        System.out.println("player 2 decides to play");
        play(p2);
    }
    
    public void play(CPlayer player)
    {
        ArrayList<CDomino> hand = player.getHand();
        boolean played = false;
        
        for (int i = 0; i < hand.size(); i++) 
        {
            CDomino tile = hand.get(i);
            
            if (tile.getLeft() == board.getFront() || tile.getRight() == board.getFront())
            {
                tile.printH();
                System.out.println(" ");
                board.playTile(tile, 1);
                board.printBoard();
                System.out.println(" ");
                player.removePiece(tile);
                played = true;
                break;
            }
            
            if (tile.getLeft() == board.getEnd() || tile.getRight() == board.getEnd())
            {
                tile.printH();
                System.out.println(" ");
                board.playTile(tile, 0);
                board.printBoard();
                System.out.println(" ");
                player.removePiece(tile);
                played = true;
                break;
            }
        }
        
        if (!played)
        {
            System.out.println("no tiles and draws a new tile");
            board.printBoard();
            System.out.println(" ");
            if (!deck.getDeck().isEmpty())
            {
                deck.deal(player);
            }
            else
            {
                pass++; 
            }
        }
    }
    
    public void checkWinner()
    {
        if (p1.getHand().isEmpty())
        {
            winner = 1;
        }
        
        if (p2.getHand().isEmpty())
        {
            winner = 2;
        }
    }
    
    public int score(CPlayer loser) {
    	ArrayList<CDomino> hand = loser.getHand();
    	int sum = 0;
    	for (int i = 0; i < hand.size(); i++) {
    		sum += hand.get(i).getTotal();
    	}
    	return sum;
    }
    
    public void result()
    {
       if (winner == 1)
       {
           System.out.println("Player 1 wins the game with " + score(p2) + " points");
       }
       else if (winner == 2)
       {
           System.out.println("Player 2 wins the game with " + score(p1) + " points");
       }
       else
       {
           System.out.println("The game has ended in a tie");
       }
    }
}
