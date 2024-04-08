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
        BFSQueue queue = new BFSQueue();
        queue.enqueue(startCond);
        Map<Coordinate, Coordinate> parent = new HashMap<>();
        parent.put(startCond, null);
    
        while (!queue.isEmpty()) {
            Coordinate currentCoord = queue.dequeue(); 

            if (currentCoord.equals(endCond)) {
                List<Coordinate> path = reconstructPath(parent, startCond, endCond);
                return path; // return the path when we reach the end
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

    public void coordsToPath(List<Coordinate> path) {
        String result = "";
        Compass heading = new Compass(Direction.EAST);
        Coordinate currentCoord = path.get(0);
        Coordinate nextCoord = path.get(1);
        Integer count = 0;

        /*
        while (nextCoord.getY() != endCond.getY()) {

            if (directionForward(currentCoord, nextCoord, heading.getHeading())) {
                result = result + "F";
            } else if (directionLeft(currentCoord, nextCoord, heading)) {
                result = result + "LF";
                // heading.turnLeft();
            } else if (directionRight(currentCoord, nextCoord, heading)) {
                result = result + "RF";
                // heading.turnRight();
            }
            count++;
            currentCoord = path.get(count);
            nextCoord = path.get(count + 1);
            System.out.println(result);
            System.out.println(heading.getHeading());


        }
        */


        
        for (Integer i = 0; i < path.size() - 1; i++) {

            Coordinate current = path.get(i);
            Coordinate next = path.get(i + 1);
            System.out.println("CURRENT");
            System.out.println(current);
            System.out.println("NEXT");
            System.out.println(next);


            if (directionForward(current, next, heading.getHeading())) {
                result = result + "F";
            } else if (directionLeft(current, next, heading)) {
                result = result + "LF";
                heading.turnLeft();
            } else if (directionRight(current, next, heading)) {
                result = result + "RF";
                heading.turnRight();
            }
            currentCoord = path.get(i);
            System.out.println(result);
            System.out.println(heading.getHeading());
        }
        
        // result = result + "F";
        System.out.println(result);
        
    }


    public Boolean directionForward(Coordinate current, Coordinate next, Direction heading) {
        switch(heading) {
            case Direction.EAST:
                if (next.getX() > current.getX()) {
                    return true;
                } else {
                    return false;
                }
            case Direction.SOUTH:
                if (next.getY() > current.getY()) {
                    return true;
                } else {
                    return false;
                }
            case Direction.WEST:
                if (next.getX() < current.getX()) {
                    return true;
                } else {
                    return false;
                }
            case Direction.NORTH:
                if (next.getY() < current.getY()) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public Boolean directionLeft(Coordinate current, Coordinate next, Compass heading) {
        Boolean check = directionForward(current, next, heading.getLeft());
        return check;
        // Compass compass = heading;
        // compass.turnLeft();
        // return directionForward(current, next, compass);
    }

    public Boolean directionRight(Coordinate current, Coordinate next, Compass heading) {
        Boolean check = directionForward(current, next, heading.getRight());
        return check;
        // Compass compass = heading;
        // compass.turnRight();
        // return directionForward(current, next, compass);
    }


}
