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
    private Graph graph; 

    public BreadthFirstSearch(Maze maze) {
        this.startCond = maze.startCoord();
        this.endCond = maze.endCoord();
        this.list = new AdjacencyList(maze);
        this.graph = new Graph(maze);
        // list.printAdjacencyList();
    }

    public List<Coordinate> findPath() {
        System.out.println("Start: " + startCond); // TEST
        System.out.println("End: " + endCond); // TEST
        BFSQueue queue = new BFSQueue();
        queue.enqueue(startCond);
        Map<Coordinate, Coordinate> parent = new HashMap<>();
        parent.put(startCond, null);
    
        while (!queue.isEmpty()) {
            Coordinate currentCoord = queue.dequeue(); // dequeue the next node  
            System.out.println("Current Coord: " + currentCoord); // TEST

            if (currentCoord.equals(endCond)) {
                System.out.println("Reached end coordinate");
                List<Coordinate> path = reconstructPath(parent, startCond, endCond);
                System.out.println("Path: " + path);
                return path; // return the path when we reach the end
                // return reconstructPath(parent, startCond, endCond); // return the path when we reach the end
            }
    
            // Coordinate testCoord = new Coordinate(2, 3);
            // System.out.println("YIPPEE");
            // System.out.println(list);
            // System.out.println(list.getNeighbors(testCoord));
            
            for (Coordinate neighbor : list.getNeighbors(currentCoord)) {
                System.out.println("YEEHAW");
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
            System.out.println("Adding to path: " + currentCoord);  // TEST
            currentCoord = parent.get(currentCoord);
            System.out.println("Next coordinate: " + currentCoord); // TEST
        }
        
        Collections.reverse(path);
        return path;
    }


    public void coordsToPath(List<Coordinate> path) {
        String result = "";
        Compass heading = new Compass(Direction.EAST);
        // ArrayList<ArrayList<Integer>> mazeData = maze.getData();
        Coordinate currentCoord = path.get(0);

        for (Integer i = 1; i < path.size() - 1; i++) {
            // System.out.println("YIKES");
            if (graph.checkForward(path.get(i),heading.getHeading())) {
                result = result + "F";
                currentCoord = graph.getForward(currentCoord,heading.getHeading());
            } else if (graph.checkLeft(path.get(i),heading.getHeading())) {
                result = result + "LF";
                heading.turnLeft();
                currentCoord = graph.getLeft(currentCoord,heading.getHeading());
            } else if (graph.checkRight(path.get(i),heading.getHeading())) {
                result = result + "RF";
                heading.turnRight();
                currentCoord = graph.getRight(currentCoord,heading.getHeading());
            }
        }
        System.out.println(result);
        
    }

}
