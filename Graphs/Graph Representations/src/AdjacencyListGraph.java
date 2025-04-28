import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements IGraphRepresentation{
    List<List<Integer>> graph;

    public AdjacencyListGraph(int noOfVertices) {
        this.graph = new ArrayList<>(noOfVertices);
        for(int i=0; i<noOfVertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    @Override
    public void printGraph() {
        int noOfVertices = graph.size();
        if(graph.isEmpty()) {
            System.out.println("Graph is empty");
            return;
        }
        for(int i=0; i<noOfVertices; i++ ){
            System.out.print(i + " : " );
            for(int e : graph.get(i)) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void addEdge(int source, int dest) {
        graph.get(source).add(dest);
        graph.get(dest).add(source);
    }
}
