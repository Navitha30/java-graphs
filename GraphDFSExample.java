import java.util.ArrayList;

public class GraphDFSExample {
    public static void main(String[] args) {
        int vertices = 6;

        // Create an adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(0);
        graph.get(2).add(5);
        graph.get(3).add(1);
        graph.get(4).add(1);
        graph.get(5).add(2);

        // Print adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : graph.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        // Perform DFS starting from node 0
        boolean[] visited = new boolean[vertices];
        System.out.print("\nDFS Traversal starting from node 0: ");
        dfs(graph, 0, visited);
    }

    // Recursive DFS method
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}
