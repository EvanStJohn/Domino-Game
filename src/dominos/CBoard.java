package dominos;


public class CBoard {
    private int front;
    private int end;
    
    public CBoard() {
        front = 0;
        end = 0;
    }
    
    public void playFirstTile(CDomino tile) {
        front = tile.getLeft();
        end = tile.getRight();
    }
    
    public void playTile(CDomino tile, int location) {
        //0 is end, 1 is front
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
    
    public int getFront() {
    	return front;
    }
    
    public int getEnd() {
    	return end;
    }
}
