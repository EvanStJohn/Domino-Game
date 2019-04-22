package dominos;


public class CDomino {
    
    private int left, right;
    
    //constructor of domino. contains value for left and right
    public CDomino(int l, int r)
    {
        left = l;
        right = r;
    }
    
    //returns left
    public int getLeft()
    {
        return left;
    }
    
    //returns right
    public int getRight()
    {
        return right;
    }
    
    //returns total value of domino
    public int getTotal()
    {
        return left + right;
    }
    
    //flips values of domino
    public void flip()
    {
        int num = right;
        right = left;
        left = num;
    }
    
    //horizontally prints domino
    public void printH()
    {
        System.out.print("[" + left + " | " + right + "]");
    }
    
  //vertically prints domino
    public void printV()
    {
        System.out.println("---");
        System.out.println(" " + left);
        System.out.println(" -");
        System.out.println(" " + right);
        System.out.println("---");
    }
}
