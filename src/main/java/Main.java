import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node node = new Node("abcd", "1234");
        Node node1 = new Node("efgh", "5678");
        Node node2 = new Node("ijkl", "9123");

        CompositeNode compositeNode = new CompositeNode("dcba", "4321");
        CompositeNode compositeNode1 = new CompositeNode("hgfe", "8765");
        CompositeNode compositeNode2 = new CompositeNode("ljki", "3219");
        
        MyStructure myStructure1 = new MyStructure();
        myStructure1.addNodes(node);
        myStructure1.addNodes(node1);
        myStructure1.addNodes(compositeNode2);




        System.out.println(myStructure1.findByCode("abcd"));
        System.out.println(myStructure1.findByRenderer("5678"));
        System.out.println(myStructure1.findByRenderer("3219"));


    }
}
