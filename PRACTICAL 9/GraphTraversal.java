import java.util.*;

public class GraphTraversal {
    static void dfs(int vertex, boolean[] visited, List<List<Integer>> graph) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbour : graph.get(vertex)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, graph);
            }
        }
    }

    static void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbour : graph.get(vertex)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

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

        int start = 0;

        System.out.print("DFS: ");
        dfs(start, new boolean[vertices], graph);

        System.out.print("\nBFS: ");
        bfs(start, graph);
    }
}
