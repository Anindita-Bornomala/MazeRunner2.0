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
    private PathTranslator translator;
    private Integer pathCount; 

    public BreadthFirstSearch(Maze maze) {
        this.translator = new PathTranslator();
        this.startCond = maze.startCoord();
        this.endCond = maze.endCoord();
        this.list = new AdjacencyList(maze);
    }

    public String breadthFirstSearch() {
        BFSQueue queue = new BFSQueue();
        queue.enqueue(startCond);
        Map<Coordinate, Coordinate> parent = new HashMap<>();
        parent.put(startCond, null);
    
        while (!queue.isEmpty()) {
            Coordinate currentCoord = queue.dequeue(); 

            if (currentCoord.equals(endCond)) {
                List<Coordinate> path = reconstructPath(parent, startCond, endCond);
                return coordsToPath(path);
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

    public String coordsToPath(List<Coordinate> path) {
        Compass heading = new Compass(Direction.EAST);
        String result = "";
        
        for (Integer i = 0; i < path.size() - 1; i++) {
            Coordinate current = path.get(i);
            Coordinate next = path.get(i + 1);

            if (directionForward(current, next, heading.getHeading())) {
                result = result + "F";
            } else if (directionLeft(current, next, heading)) {
                result = result + "LF";
                heading.turnLeft();
            } else if (directionRight(current, next, heading)) {
                result = result + "RF";
                heading.turnRight();
            }
        }
        this.pathCount = result.length(); // gets the methodCount for speedup
        return translator.translateToFact(result);
    }

    public boolean directionForward(Coordinate current, Coordinate next, Direction heading) {
        switch(heading) {
            case EAST:
                return next.getX() > current.getX();
            case SOUTH:
                return next.getY() > current.getY();
            case WEST:
                return next.getX() < current.getX();
            case NORTH:
                return next.getY() < current.getY();
            default:
                return false;
        }
    }
    
    public Boolean directionLeft(Coordinate current, Coordinate next, Compass heading) {
        Boolean check = directionForward(current, next, heading.getLeft());
        return check;
    }

    public Boolean directionRight(Coordinate current, Coordinate next, Compass heading) {
        Boolean check = directionForward(current, next, heading.getRight());
        return check;
    }

    public Integer getPathCount() {
        return this.pathCount;
    }
}
