import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class City {
    int n;
    HashMap<String, Integer> namaToIndex = new HashMap<>();
    LinkedList<Integer>[] adjListArray;
    int index = 0;

    public City(int n) {
        this.n = n;
        adjListArray = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public City() {
        //TODO Auto-generated constructor stub
    }

    public void addKota(String nama) {
        if (!namaToIndex.containsKey(nama)) {
            namaToIndex.put(nama, index);
            index++;
        }
    }

    public void addEdge(String src, String dst) {
        int from = namaToIndex.get(src);
        int to = namaToIndex.get(dst);
        adjListArray[from].add(to);
        adjListArray[to].add(from);
    }

    public String getNamaFromIndex(int index) {
        for (Map.Entry<String, Integer> entry : namaToIndex.entrySet()) {
            if (entry.getValue() == index) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void bfs(String kotaAsal) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int start = namaToIndex.get(kotaAsal);
        visited[start] = true;
        queue.add(start);
        System.out.println("Urutan kunjungan kota terdekat dari " + kotaAsal + ":");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(getNamaFromIndex(node) + " ");
            System.out.println();
            for (int neighbor : adjListArray[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfs(String kotaAsal) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int start = namaToIndex.get(kotaAsal);
        stack.push(start);
        System.out.println("\nUrutan kunjungan kota menjauh dari " + kotaAsal + ":");
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(getNamaFromIndex(node) + " ");
                System.out.println();
                for (int neighbor : adjListArray[node]) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void addCity(String namaKota) {
        addKota(namaKota);
    }
}
