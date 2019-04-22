package dominos;


public class CBoard {
    private int front;
    private int end;
    
    //board constructor. consists of front and end values of tile chain
    public CBoard() {
        front = 0;
        end = 0;
    }
    
    //allows for the first play of a tile
    public void playFirstTile(CDomino tile) {
        front = tile.getLeft();
        end = tile.getRight();
    }
    
    //plays tile at given location
    public void playTile(CDomino tile, int location) {
        //0 is end, 1 is front
        //Check if play is playable in CGame
        if (location == 0) {
            if (tile.getLeft() == end) {
                end = tile.getRight();
            }
            else {
                end = tile.getLeft();
            }
        }
        if (location == 1) {
            if (tile.getLeft() == front) {
                front = tile.getRight();
            }
            else {
                front = tile.getLeft();
            }
        }
    }
    
    //returns front
    public int getFront() {
    	return front;
    }
    
    //returns end
    public int getEnd() {
    	return end;
    }
}
