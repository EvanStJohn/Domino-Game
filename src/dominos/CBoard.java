package dominos;

import java.util.*;


public class CBoard {
    private int front;
    private int end;
    private ArrayList<CDomino> train = new ArrayList<CDomino>();
    
    //board constructor. consists of front and end values of tile chain
    public CBoard() {
        front = 0;
        end = 0;
    }
    
    //allows for the first play of a tile
    public void playFirstTile(CDomino tile) {
        front = tile.getLeft();
        end = tile.getRight();
        train.add(tile);
    }
    
    //plays tile at given location
    public void playTile(CDomino tile, int location) {
        //0 is end, 1 is front
        //Check if play is playable in CGame
        if (location == 0) {
            if (tile.getLeft() == end) {
                end = tile.getRight();
                train.add(tile);
            }
            else {
                end = tile.getLeft();
                train.add(tile);
            }
        }
        if (location == 1) {
            if (tile.getLeft() == front) {
                front = tile.getRight();
                train.add(0, tile);
            }
            else {
                front = tile.getLeft();
                train.add(0, tile);
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
    
    public void printBoard()
    {
        System.out.println("front: " + front);
        System.out.println("end: " + end);
        System.out.println("board:");
        for (int i = 0; i < train.size(); i++ ) 
        {
            train.get(i).printH();
    	}
        System.out.println(" ");
    }
}
