public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(4);

        adjacencyMatrixGraph.printGraph();
        adjacencyMatrixGraph.addEdge(0,1);
        adjacencyMatrixGraph.addEdge(0,2);
        adjacencyMatrixGraph.addEdge(1,2);
        adjacencyMatrixGraph.addEdge(2,3);

        adjacencyMatrixGraph.printGraph();
    }
}