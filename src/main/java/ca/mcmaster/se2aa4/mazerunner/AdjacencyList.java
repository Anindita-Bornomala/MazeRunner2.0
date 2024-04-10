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
    }

    public List<Coordinate> getNeighbors(Coordinate coordinate) {
        return adjacencyList.get(coordinate);
    }

    public Map<Coordinate, List<Coordinate>> createAdjacencyList() {
        for (Integer row = 0; row < mazeData.size(); row++) {
            for (Integer col = 0; col < mazeData.get(row).size(); col++) {
                
                if (mazeData.get(row).get(col) == 0) { // If it's a path cell
                    Coordinate currentNode = new Coordinate(col, row);

                    List<Coordinate> neighbors = new ArrayList<>();
                    if (row > 0 && mazeData.get(row - 1).get(col) == 0) { // north node
                        neighbors.add(new Coordinate(col, row - 1));
                    }
                    if (row < mazeData.size() - 1 && mazeData.get(row + 1).get(col) == 0) { // south node
                        neighbors.add(new Coordinate(col, row + 1));
                    }
                    if (col > 0 && mazeData.get(row).get(col - 1) == 0) { // west node
                        neighbors.add(new Coordinate(col - 1, row));
                    }
                    if (col < mazeData.get(row).size() - 1 && mazeData.get(row).get(col + 1) == 0) { // adds east node
                        neighbors.add(new Coordinate(col + 1, row));
                    }
                    adjacencyList.put(currentNode, neighbors);
                }
            }
        }
        return adjacencyList;
    }
}

