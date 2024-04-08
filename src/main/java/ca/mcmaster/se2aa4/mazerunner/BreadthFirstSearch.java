package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch {
    private Coordinate startCond;
    private Coordinate endCond;
    private AdjacencyList list;

    public BreadthFirstSearch(Maze maze) {
        this.startCond = maze.startCoord();
        this.endCond = maze.endCoord();
        this.list = new AdjacencyList(maze);
    }

    public List<Coordinate> findPath() {
        BFSQueue queue = new BFSQueue();
        queue.enqueue(startCond);
        Map<Coordinate, Coordinate> parent = new HashMap<>();
        parent.put(startCond, null);

        while (!queue.isEmpty()) {
            Coordinate currentCoord = queue.dequeue(); // dequeue the next node

            if (currentCoord.equals(endCond)) {
                return reconstructPath(parent, startCond, endCond); // return the path when we reach the end
            }

            for (Coordinate neighbor : list.getNeighbors(currentCoord)) {
                if (!parent.containsKey(neighbor)) {
                    queue.enqueue(neighbor);
                    parent.put(neighbor, currentCoord);
                }
            }
        }
        return null;
    }

    private List<Coordinate> reconstructPath(Map<Coordinate, Coordinate> parent, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate currentCoord = end;

        while (currentCoord != null) {
            path.add(currentCoord);
            currentCoord = parent.get(currentCoord);
        }
        
        Collections.reverse(path);
        return path;
    }

}
