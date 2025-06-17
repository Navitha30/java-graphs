import java.util.ArrayList;
public class SimpleGraph {
    public static void main(String[] args) {
        int vertices = 4;
        int[][] adjMatrix = new int[vertices][vertices];
        adjMatrix[0][1] = 1;
        adjMatrix[1][0] = 1;
        adjMatrix[0][2] = 1;
        adjMatrix[2][0] = 1;
        adjMatrix[1][2] = 1;
        adjMatrix[2][1] = 1;
        adjMatrix[2][3] = 1;
        adjMatrix[3][2] = 1;
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int node : adjList.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
