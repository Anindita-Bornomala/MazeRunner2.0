package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    // private ArrayList<ArrayList<Integer>> graph;
    private ArrayList<ArrayList<Integer>> mazeData;
    Map<Coordinate, List<Coordinate>> adjacencyList;
    
    public AdjacencyList(Maze maze) {
        this.mazeData = maze.getData();
        this.adjacencyList = new HashMap<>();
    }

    public List<Coordinate> getNeighbors(Coordinate coordinate) {
        return adjacencyList.get(coordinate);
    }

    public void printAdjacencyList() {
        Map<Coordinate, List<Coordinate>> printList = createAdjacencyList();
        for (Map.Entry<Coordinate, List<Coordinate>> entry : printList.entrySet()) {
            System.out.println(entry);
        }
    }

    public Map<Coordinate, List<Coordinate>> createAdjacencyList() {
        // this.adjacencyList = new HashMap<>();
        for (Integer i = 0; i < mazeData.size(); i++) {
            for (Integer j = 0; j < mazeData.get(i).size(); j++) {
                if (mazeData.get(i).get(j) == 0) { // If it's a path cell
                    Coordinate currentNode = new Coordinate(i, j);
                    List<Coordinate> neighbors = new ArrayList<>();
                    if (i > 0 && mazeData.get(i - 1).get(j) == 0) {
                        neighbors.add(new Coordinate(i - 1, j));
                        // neighbors.add(List.of(i - 1, j)); // Add top neighbor
                    }
                    if (i < mazeData.size() - 1 && mazeData.get(i + 1).get(j) == 0) {
                        neighbors.add(new Coordinate(i + 1, j));
                        // neighbors.add(List.of(i + 1, j)); // Add bottom neighbor
                    }
                    if (j > 0 && mazeData.get(i).get(j - 1) == 0) {
                        neighbors.add(new Coordinate(i, j - 1));
                        // neighbors.add(List.of(i, j - 1)); // Add left neighbor
                    }
                    if (j < mazeData.get(i).size() - 1 && mazeData.get(i).get(j + 1) == 0) {
                        neighbors.add(new Coordinate(i, j + 1));
                        // neighbors.add(List.of(i, j + 1)); // Add right neighbor
                    }
                    adjacencyList.put(currentNode, neighbors);
                }
            }
        }
        return adjacencyList;
    }
}

