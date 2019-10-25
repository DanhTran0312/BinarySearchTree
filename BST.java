public class BST<E extends Comparable<E>>{
    private MyTreeNode<E> root;
    private int size;


    BST(E s){
        root = new MyTreeNode<E>(s);
    }

    public int getSize(){
        return this.size;
    }

    public boolean insert(E s){
        MyTreeNode<E> node = new MyTreeNode<E>(s);
        if(this.root == null){
            root = node;
        }
        else{
            MyTreeNode<E> parent = null;
            MyTreeNode<E> current = root;
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
            if(s.compareTo(parent.element) < 0){
                parent.left = node;
            }
            else{
                parent.right = node;
            }
        }
        size++;
        return true;
    }

    public boolean search(E key){
        MyTreeNode<E> current = root;
        while(current != null){
            if(key.compareTo(current.element) > 0)
                current = current.right;
            else if(key.compareTo(current.element) < 0)
                current = current.left;
            else
                return true; // key is in the list
        }
        return false;
    }

    public void print(){

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
