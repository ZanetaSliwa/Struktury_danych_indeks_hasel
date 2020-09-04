package indekshasel;

/**
 *
 * @author Żaneta
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class BSTree {

    private BSTNode root;

    public boolean isEmpty() {
        return root == null;
    }

    private void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getKey());
            inOrder(node.getRight());
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void indexAppearance(BSTNode node, String[] hasla) {
        StringTokenizer st;
        if (node != null) {
            indexAppearance(node.getLeft(), hasla);
            System.out.print(node.getKey());
            System.out.print(" =>");
            for (int i = 0; i < hasla.length; i++) {
                
                String linie = hasla[i];
                st = new StringTokenizer(linie);
                int ile = st.countTokens();
                
                while (st.hasMoreTokens()) {
                    String indeks = st.nextToken();
                    if (node.getKey().equals(indeks)) {
                        System.out.print(" "+ (i + 1) + " ");
                    }
                }
            }
            System.out.println("");
            indexAppearance(node.getRight(), hasla);
        }
    }

    public void indexAppearance(String[] hasla) {
        indexAppearance(root, hasla);
    }

    private void preOrder(BSTNode node) {
        if (node != null) {
            System.out.println(node.getKey());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void postOrder(BSTNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getKey());
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private BSTNode create(int n) {
        Scanner sc = new Scanner(System.in);
        if (n != 0) {
            BSTNode temp = new BSTNode();
            temp.setLeft(create(n / 2));
            if (temp.getLeft() != null) {
                temp.getLeft().setFather(temp);
            }
            temp.setKey(sc.nextInt());
            temp.setRight(create((n - (n / 2) - 1)));
            if (temp.getRight() != null) {
                temp.getRight().setFather(temp);
            }
            return temp;
        } else {
            return null;
        }

    }

    public void createTree(int n) {
        root = create(n);
    }

    private void show(BSTNode node, int w) {
        if (node != null) {
            show(node.getRight(), w + 10);
            System.out.format("%" + w + "d\n", node.getKey());
            show(node.getLeft(), w + 10);
        }
    }

    public void show() {
        show(root, 1);
    }

    private boolean find(BSTNode node, Comparable value) {
        if (node == null) {
            return false;
        } else {
            if (node.getKey().compareTo(value) == 0) {
                return true;
            } else {
                if (node.getKey().compareTo(value) < 0) {
                    return find(node.getRight(), value);
                } else {
                    return find(node.getLeft(), value);
                }
            }
        }
    }

    public boolean find(Comparable value) {
        return find(root, value);
    }

    public boolean findTwo(Comparable value) {
        BSTNode rob;
        rob = root;
        while (rob != null) {
            if (rob.getKey().compareTo(value) == 0) {
                return true;
            } else {
                if (rob.getKey().compareTo(value) < 0) {
                    rob = rob.getRight();
                } else {
                    rob = rob.getLeft();
                }
            }
        }
        return false;
    }

    private BSTNode add(BSTNode node, Comparable key) {
        if (node == null) {
            node = new BSTNode();
            node.setKey(key);
        } else {
            if (node.getKey().compareTo(key) < 0) {
                node.setRight(add(node.getRight(), key));
                node.getRight().setFather(node);
            } else if (node.getKey().compareTo(key) > 0) {
                node.setLeft(add(node.getLeft(), key));
                node.getLeft().setFather(node);
            }
        }
        return node;
    }

    public void add(Comparable key) {
        root = add(root, key);
    }

    private int weight(BSTNode node) {
        if (node == null) {
            return 0;
        } else {
            return weight(node.getLeft()) + weight(node.getRight()) + 1;
        }
    }

    public int weight() {
        return weight(root);
    }

    private int leaves(BSTNode node) {
        if (node == null) {
            return 0;
        } else if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else {
            return leaves(node.getLeft()) + leaves(node.getRight());
        }
    }

    public int leaves() {
        return leaves(root);
    }

    public void remove() {
        if (isEmpty() || (root.getLeft() == null && root.getRight() == null)) {
            root = null;
        } else if (root.getRight() == null) {
            root = root.getLeft();
            root.setFather(null);
        } else if (root.getLeft() == null) {
            root = root.getRight();
            root.setFather(null);

        } else {
            BSTNode rob = root;
            rob = rob.getLeft();
            while (rob.getRight() != null) {
                rob = rob.getRight();
            }
            root.setKey(rob.getKey());
            if (rob.getFather() == root) {
                root.setLeft(rob.getLeft());
            } else {
                rob.getFather().setRight(rob.getLeft());
            }
            if (rob.getLeft() != null) {
                rob.getLeft().setFather(rob.getFather());
            }
        }
    }

//   public void showTree(){ //wyswietlanie poziomami
//       Queque<BSTNode> kolejka = new Queque();
//       if(!isEmpty()){
//           kolejka.attach(root);
//           while(){
//           
//          }
//       }     
//       
//   }
//    public static void main(String[] args) {
//
//        BSTree bst = new BSTree();
//
//        bst.createTree(6);
//
//        //System.out.println(bst.weight());
//        //System.out.println(bst.leaves());
//        bst.remove();
//        bst.show();
//
//    }
}
