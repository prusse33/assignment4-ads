public class Experiment {

    public void runTraversals(Graph g) {

        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();

        long bfsTime = endBfs - startBfs;

        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();

        long dfsTime = endDfs - startDfs;

        System.out.println("BFS Time: " + bfsTime + " ns");
        System.out.println("DFS Time: " + dfsTime + " ns");
    }

    public void runMultipleTests() {

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {

            System.out.println("\n============================");
            System.out.println("Testing graph with " + size + " vertices");
            System.out.println("============================");

            Graph graph = createGraph(size);

            if (size == 10) {
                graph.printGraph();
            }

            runTraversals(graph);
        }
    }

    private Graph createGraph(int size) {

        Graph graph = new Graph();

        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {
            graph.addEdge(i, i + 1);

            if (i + 2 < size) {
                graph.addEdge(i, i + 2);
            }
        }

        return graph;
    }

    public void printResults() {
        System.out.println("\nExperiments completed successfully.");
    }
}