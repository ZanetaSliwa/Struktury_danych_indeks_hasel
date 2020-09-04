package indekshasel;

/**
 *
 * @author Żaneta
 */
public class BSTNode {
    
    private Comparable key;
    private BSTNode left;
    private BSTNode right;
    private BSTNode father;
    

    public Comparable getKey() {
        return key;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public BSTNode getFather() {
        return father;
    }

    public void setFather(BSTNode father) {
        this.father = father;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
    
    
}
