public class DriverMain{
    public static void main(String[] args){
        BST<Integer> tree = new BST<Integer>(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(1);
        tree.insert(6);
        tree.insert(13);
        tree.insert(16);
        tree.insert(14);
        tree.print();
        BST<String> tree2 = new BST<String>();
        tree2.print();
        tree2.insert("F");
        tree2.insert("B");
        tree2.insert("I");
        tree2.insert("A");
        tree2.insert("C");
        tree2.insert("H");
        tree2.insert("G");
        tree2.insert("K");
        tree2.print();
    }
}
