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
            // System.out.println("Current Coord: " + currentCoord); // TEST

            if (currentCoord.equals(endCond)) {
                // System.out.println("Reached end coordinate");
                List<Coordinate> path = reconstructPath(parent, startCond, endCond);
                // System.out.println("Path: " + path);
                return path; // return the path when we reach the end
            }
    
            // Coordinate testCoord = new Coordinate(2, 3);
            // System.out.println("YIPPEE");
            // System.out.println(list);
            // System.out.println(list.getNeighbors(testCoord));
            
            for (Coordinate neighbor : list.getNeighbors(currentCoord)) {
                // System.out.println("YEEHAW");
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
            // System.out.println("Adding to path: " + currentCoord);  // TEST
            currentCoord = parent.get(currentCoord);
            // System.out.println("Next coordinate: " + currentCoord); // TEST
        }
        
        Collections.reverse(path);
        return path;
    }

    public void coordsToPath(List<Coordinate> path) {
        String result = "";
        Compass heading = new Compass(Direction.EAST);
        Coordinate currentCoord = path.get(0);
        

        for (Integer i = 1; i < path.size(); i++) {

            Coordinate current = path.get(i);
            Coordinate next = path.get(i + 1);
            System.out.println("CURRENT");
            System.out.println(current);
            System.out.println("NEXT");
            System.out.println(next);


            if (graph.checkForward(path.get(i), heading.getHeading())) {
                result = result + "F";
                // currentCoord = graph.getRight(currentCoord,heading.getHeading());
            } else if (graph.checkLeft(path.get(i), heading.getHeading(), heading)) {
                result = result + "LF";
                heading.turnLeft();
                // currentCoord = graph.getLeft(currentCoord,heading.getHeading());
            } else if (graph.checkRight(path.get(i), heading.getHeading(), heading)) { // ADDED HEADING AS PARAMETER
                result = result + "RF";
                heading.turnRight();
                // currentCoord = graph.getRight(currentCoord,heading.getHeading());
            }
            currentCoord = path.get(i);
            System.out.println(result);
            System.out.println(heading.getHeading());
        }
        // result = result + "F";
        System.out.println(result);
        
    }


    public void convertCoordinatesToMoves(List<Coordinate> coordinates) {
        String moves = "";
        // StringBuilder moves = new StringBuilder();

        for (int i = 0; i < coordinates.size() - 1; i++) {
            Coordinate current = coordinates.get(i);
            Coordinate next = coordinates.get(i + 1);
            System.out.println("CURRENT");
            System.out.println(current);
            System.out.println("NEXT");
            System.out.println(next);

            if (next.getX() > current.getX()) {
                moves = moves + "F";
                // moves.append("F");
            } else if (next.getY() < current.getY()) {
                moves = moves + "LF";
                // moves.append("L");
            } else if (next.getY() > current.getY()) {
                moves = moves + "RF";
                // moves.append("F");
            }
            System.out.println(moves);
        }

        System.out.println(moves.toString());
        // return moves.toString();
    }


}
