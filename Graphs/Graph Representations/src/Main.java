public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        IGraphRepresentation graph = new AdjacencyListGraph(5);

        graph.printGraph();
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,3);

        graph.printGraph();

    }
}