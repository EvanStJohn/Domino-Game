package dominos;

public class CGame {

    CBoard board;
    CDeck deck;
    CPlayer p1;
    CPlayer p2;
    
    public CGame(int startHandSize) {
        //Create deck
        deck = new CDeck();
        deck.shuffle();
        
        //Create players
        p1 = new CPlayer(1);
        p2 = new CPlayer(2);
        
        //Give hands
        for (int i = 0; i < startHandSize; i++) {
            deck.deal(p1, 1);
            deck.deal(p2, 1);
        }
        
        //Create Board
        board = new CBoard();

    }
    
    public int firstPlay() {
        int largestWeight = 0;
        int startingPlayer = 0;
        for (int i = 0; i < p1.getHand().size(); i++) {
            int pieceWeight = p1.getHand().get(i).getTotal();
            if (pieceWeight > largestWeight) {
                startingPlayer = 1;
                largestWeight = pieceWeight;
            }
        }
        
        for (int i = 0; i < p2.getHand().size(); i++) {
            int pieceWeight = p2.getHand().get(i).getTotal();
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
    
    //Have not completed this method
    public void Play(CPlayer startingPlayer) {
        
        int turn = 0;
        boolean cont = true;
        if (startingPlayer.hasPlay()) {
            //Get input for stating play
        }
        else {
            
        }
        while(cont) {

        }
    }
    
    public static void main(String[] args) {

        CGame game = new CGame(7);
        int starter = game.firstPlay();
        if (starter == 1) {
            game.Play(game.p1);
        }
        else {
            game.Play(game.p2);
        }
    }
}

