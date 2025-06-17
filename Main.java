public class Main {
    public static void main(String[] args) {
        City graph = new City(9); // Initialize with number of cities

        graph.addCity("Paris (France)");
        graph.addCity("Brussels (Belgium)");
        graph.addCity("Zurich (Switzerland)");
        graph.addCity("Amsterdam (Netherlands)");
        graph.addCity("Vienna (Austria)");
        graph.addCity("Prague (Czechia)");
        graph.addCity("Hamburg (Jerman)");
        graph.addCity("Warsaw (Poland)");
        graph.addCity("Budapest(Hungary)");
    

        graph.addEdge("Paris (France)", "Brussels (Belgium)");
        graph.addEdge("Paris (France)", "Zurich (Switzerland)");
        graph.addEdge("Brussels (Belgium)", "Amsterdam (Netherlands)");
        graph.addEdge("Brussels (Belgium)", "Zurich (Switzerland)");
        graph.addEdge("Zurich (Switzerland)", "Vienna (Austria)");
        graph.addEdge("Zurich (Switzerland)", "Prague (Czechia)");
        graph.addEdge("Amsterdam (Netherlands)", "Prague (Czechia)");
        graph.addEdge("Amsterdam (Netherlands)", "Hamburg (Jerman)");
        graph.addEdge("Vienna (Austria)", "Prague (Czechia)");
        graph.addEdge("Vienna (Austria)", "Budapest(Hungary)");
        graph.addEdge("Prague (Czechia)", "Hamburg (Jerman)");
        graph.addEdge("Hamburg (Jerman)", "Warsaw (Poland)");
        graph.addEdge("Warsaw (Poland)", "Budapest(Hungary)");
        graph.addEdge("Prague (Czechia)", "Warsaw (Poland)");

        System.out.println();
        graph.bfs("Paris (France)");
        System.out.println();
        graph.dfs("Paris (France)");
    }
}
