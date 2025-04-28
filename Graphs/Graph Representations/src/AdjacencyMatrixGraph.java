public class AdjacencyMatrixGraph implements IGraphRepresentation{
    private boolean [][] graph;
    private int noOfVertices = 0;

    public AdjacencyMatrixGraph(int noOfVertices) {
        this.noOfVertices = 4;
        this.graph = new boolean[noOfVertices][noOfVertices];
    }

    public void printGraph() {
        if(noOfVertices == 0) {
            System.out.println("Graph is empty");
            return;
        }
        for(int i=0; i<noOfVertices; i++) {
            System.out.print(i + ":");
            for(int j=0; j<noOfVertices; j++) {
                if(graph[i][j]) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }

    public void addEdge(int source, int dest) {
        graph[source][dest] = true;
        graph[dest][source] = true;
    }
}
