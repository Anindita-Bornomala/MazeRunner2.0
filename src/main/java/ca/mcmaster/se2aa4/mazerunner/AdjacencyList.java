package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    private ArrayList<ArrayList<Integer>> mazeData;
    Map<Coordinate, List<Coordinate>> adjacencyList;
    
    public AdjacencyList(Maze maze) {
        this.mazeData = maze.getData();
        this.adjacencyList = new HashMap<>();
        createAdjacencyList();
        // printAdjacencyList();
    }

    public List<Coordinate> getNeighbors(Coordinate coordinate) {
        return adjacencyList.get(coordinate);
    }

    // DELETE LATER
    public void printAdjacencyList() {
        for (Map.Entry<Coordinate, List<Coordinate>> entry : adjacencyList.entrySet()) {
            System.out.println(entry);
        }
    }

    public Map<Coordinate, List<Coordinate>> createAdjacencyList() {
        for (Integer i = 0; i < mazeData.size(); i++) {
            for (Integer j = 0; j < mazeData.get(i).size(); j++) {
                
                if (mazeData.get(i).get(j) == 0) { // If it's a path cell
                    Coordinate currentNode = new Coordinate(j, i);

                    List<Coordinate> neighbors = new ArrayList<>();
                    if (i > 0 && mazeData.get(i - 1).get(j) == 0) { // adds north node
                        neighbors.add(new Coordinate(j, i - 1));
                    }
                    if (i < mazeData.size() - 1 && mazeData.get(i + 1).get(j) == 0) { // adds south node
                        neighbors.add(new Coordinate(j, i + 1));
                    }
                    if (j > 0 && mazeData.get(i).get(j - 1) == 0) { // adds west node
                        neighbors.add(new Coordinate(j - 1, i));
                    }
                    if (j < mazeData.get(i).size() - 1 && mazeData.get(i).get(j + 1) == 0) { // adds east node
                        neighbors.add(new Coordinate(j + 1, i));
                    }
                    adjacencyList.put(currentNode, neighbors);
                }
            }
        }
        return adjacencyList;
    }
}

