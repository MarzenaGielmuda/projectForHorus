//Poniżej przekazujemy zadanie z prośbą o analizę poniższego kodu i zaimplementowanie metod findByCode, findByRenderer, count w klasie MyStructure
// - najchętniej unikając powielania kodu i umieszczając całą logikę w klasie MyStructure.
// Z uwzględnieniem w analizie i implementacji interfejs ICompositeNode!
//***********************
//interface IMyStructure {
//  // zwraca węzeł o podanym kodzie lub null
//  INode findByCode(String code);
//  // zwraca węzeł o podanym rendererze lub null
//  INode findByRenderer(String renderer);
//  //zwraca liczbę węzłów
//  int count();
//}
//
//public class MyStructure implements IMyStructure {
//  private List<INode> nodes;
//}
//
//interface INode {
//  String getCode();
//  String getRenderer();
//}
//
//interface ICompositeNode extends INode {
//  List<INode> getNodes();
//}

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Predicate;

public class MyStructure implements IMyStructure {

    private List<INode> nodes = new LinkedList<>();

    public INode findByCode(String code) {
        if( code != null){
           return checkOption(x->code.equals(x.getCode()));
        }else{
            throw new IllegalArgumentException("Code is null");
        }

    }


    public INode findByRenderer(String renderer) {
        if (renderer != null){
            return checkOption(x->renderer.equals(x.getRenderer()));
        }else{
            throw new IllegalArgumentException("Renderer is null");
        }
    }

    public int count() {
        int countI = (int) nodes.stream().flatMap(INode::iNodeToStream).count();
        return countI;
    }

    private INode checkOption(Predicate<INode> predicate){
        return nodes.stream().flatMap(INode::iNodeToStream).filter(predicate).findFirst().orElse(null);
    }

}







