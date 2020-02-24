import org.junit.jupiter.api.*;


class MyStructureTest {


    Node node = new Node("abcd", "1234");
    Node node1 = new Node("efgh", "5678");
    Node node2 = new Node("ijkl", "9123");

    CompositeNode compositeNode = new CompositeNode("dcba", "4321");
    CompositeNode compositeNode1 = new CompositeNode("hgfe", "8765");
    CompositeNode compositeNode2 = new CompositeNode("ljki", "3219");

    MyStructure myStructureFull;
    MyStructure myStructureEmpty;



    @BeforeEach
    public void start(){
        myStructureEmpty = new MyStructure();

        myStructureFull = new MyStructure();
        myStructureFull.addNodes(node);
        myStructureFull.addNodes(node1);
        myStructureFull.addNodes(compositeNode);
    }



    @Test
    public void findByCodeShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {myStructureFull.findByCode(null);});

    }
//
    @Test
    public  void findByCodeShouldFoundNode(){
        Assertions.assertEquals(node,myStructureFull.findByCode("abcd"));
    }

    @Test
    void findByRendererShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {myStructureEmpty.findByCode(null);});
    }
    
    @Test
    void findByRendererShouldFoundNode() {
        Assertions.assertEquals(node1, myStructureFull.findByRenderer("5678"));
    }

    @Test
    void countShouldBeNotEmpty() {
        Assertions.assertNotNull(myStructureFull.count());


    }
}