import java.util.Queue;
import java.util.LinkedList;

public class BST<E extends Comparable<E>>{
    private MyTreeNode<E> root;
    private int size;

    // empty consructor
    BST(){}

    // parametized consructor
    BST(E s){
        root = new MyTreeNode<E>(s);
    }

    // get the size of the tree
    public int getSize(){
        return this.size;
    }

    // insert an element into the tree
    public boolean insert(E s){
        MyTreeNode<E> node = new MyTreeNode<E>(s); // temporary node
        if(this.root == null){
            root = node; // set the root equal to the node if the root == null
        }
        else{
            MyTreeNode<E> parent = null;
            MyTreeNode<E> current = root;
            // looping to find the parent
            while(current!=null){
                if(s.compareTo(current.element) < 0){
                    parent = current;
                    current = current.left;
                }
                else if(s.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                }
                // Incase of duplication
                else
                    return false;
            }

            if(s.compareTo(parent.element) < 0)
                parent.left = node;
            else
                parent.right = node;
        }
        size++;
        return true; // successfully inserted into the tree
    }

    // search for a key within the tree
    public boolean search(E key){
        MyTreeNode<E> current = root;
        // loop through all nodes in the tree
        while(current != null){
            if(key.compareTo(current.element) > 0)
                current = current.right;
            else if(key.compareTo(current.element) < 0)
                current = current.left;
            else
                return true; // key is in the list
        }
        return false; // key is not in the list
    }

    //  level by level , left to right order
    public void BFSTraversal(){
        if(root == null)
            System.out.print("Tree is empty!"); // print if the root equal null
        else{
            Queue<MyTreeNode<E>> q = new LinkedList<MyTreeNode<E>>(); // create a queue to store the tree node
            q.add(root); // add the root as the first element in the queue
            MyTreeNode<E> node; // temporary node
            // continue looping until there is nothing left in the queue
            while(!q.isEmpty()){
                node = q.peek();
                if(node.left != null){
                    q.add(node.left); // add node to the queue
                }
                if(node.right != null){
                    q.add(node.right); // add node to the queue
                }
                System.out.print(node.element+" ");
                q.remove(); // dequeue after printed
            }
        }
        System.out.println(""); // new line
    }

    public void print(){
        BFSTraversal();
    }

}

class MyTreeNode<E>{
    E element;
    MyTreeNode<E> left;
    MyTreeNode<E> right;

    MyTreeNode(E element){
        this.element = element;
    }
}
