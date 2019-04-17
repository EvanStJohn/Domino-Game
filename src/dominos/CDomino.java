package dominos;


public class CDomino {
    
    private int left, right;
    
    public CDomino(int l, int r)
    {
        left = l;
        right = r;
    }
    
    public int getLeft()
    {
        return left;
    }
    
    public int getRight()
    {
        return right;
    }
    
    public int getTotal()
    {
        return left + right;
    }
    
    public void flip()
    {
        int num = right;
        right = left;
        left = num;
    }
    
    public void printH()
    {
        System.out.print("[" + left + " | " + right + "]");
    }
    
    public void printV()
    {
        System.out.println("---");
	System.out.println(" " + left);
	System.out.println(" -");
	System.out.println(" " + right);
	System.out.println("---");
    }
}
