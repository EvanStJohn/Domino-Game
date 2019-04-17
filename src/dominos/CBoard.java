package dominos;


public class CBoard {
    int front;
    int end;
    
    public CBoard() {
        front = 0;
        end = 0;
    }
    
    public void playFirstTile(CDomino tile) {
        front = tile.left;
        end = tile.right;
    }
    
    public void playTile(CDomino tile, int location) {
        //0 is end, 1 is front
        //Check if play is playable in CGame
        if (location == 0) {
            if (tile.left == end) {
                end = tile.right;
            }
            else {
                end = tile.left;
            }
        }
        if (location == 1) {
            if (tile.left == front) {
                front = tile.right;
            }
            else {
                front = tile.left;
            }
        }
    }   
}
