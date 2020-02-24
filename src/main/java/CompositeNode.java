import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class CompositeNode  extends Node implements ICompositeNode{

    private List<INode> nodesList = new LinkedList<>();

    public CompositeNode(String code, String renderer) {
        super(code, renderer);
    }

    @Override
    public List<INode> getNodes() {
        return this.nodesList;
    }

    @Override
    public Stream<INode> iNodeToStream(){
        return Stream.concat(super.iNodeToStream(),nodesList.stream().flatMap(INode::iNodeToStream));

    }

    public void addNode(INode iNode){
        nodesList.add(iNode);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompositeNode that = (CompositeNode) o;
        return Objects.equals(nodesList, that.nodesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nodesList);
    }
}
