package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    // private ArrayList<ArrayList<Integer>> graph;
    private ArrayList<ArrayList<Integer>> mazeData;
    
    public AdjacencyList(Maze maze) {
        this.mazeData = maze.getData();
    }


    public void printAdjacencyList() {
        Map<List<Integer>, List<List<Integer>>> printList = createAdjacencyList();
        for (Map.Entry<List<Integer>, List<List<Integer>>> entry : printList.entrySet()) {
            System.out.println(entry);


        }


    }


    public Map<List<Integer>, List<List<Integer>>> createAdjacencyList() {
        // ArrayList<ArrayList<Integer>> mazeData = maze.getData();
        Map<List<Integer>, List<List<Integer>>> adjacencyList = new HashMap<>();

        for (int i = 0; i < mazeData.size(); i++) {
            for (int j = 0; j < mazeData.get(i).size(); j++) {
                if (mazeData.get(i).get(j) == 0) { // If it's a path cell
                    List<Integer> currentNode = List.of(i, j);
                    List<List<Integer>> neighbors = new ArrayList<>();
                    if (i > 0 && mazeData.get(i - 1).get(j) == 0) {
                        neighbors.add(List.of(i - 1, j)); // Add top neighbor
                    }
                    if (i < mazeData.size() - 1 && mazeData.get(i + 1).get(j) == 0) {
                        neighbors.add(List.of(i + 1, j)); // Add bottom neighbor
                    }
                    if (j > 0 && mazeData.get(i).get(j - 1) == 0) {
                        neighbors.add(List.of(i, j - 1)); // Add left neighbor
                    }
                    if (j < mazeData.get(i).size() - 1 && mazeData.get(i).get(j + 1) == 0) {
                        neighbors.add(List.of(i, j + 1)); // Add right neighbor
                    }
                    adjacencyList.put(currentNode, neighbors);
                }
            }
        }

        return adjacencyList;
    }
}

