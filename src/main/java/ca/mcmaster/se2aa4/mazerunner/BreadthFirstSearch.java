package ca.mcmaster.se2aa4.mazerunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch {
    private Compass heading;
    private Graph graph;
    private PathTranslator translator;


    public BreadthFirstSearch(Maze maze) {
        this.translator = new PathTranslator();
        this.graph = new Graph(maze);
        this.heading = new Compass(Direction.EAST);
    }


    public void findPath(Maze maze) {
        Coordinate startCoord = maze.
    }


    public List<Coordinate> solveMaze(Graph maze, Coordinate start, Coordinate end) {
        BFSQueue queue = new BFSQueue();
        queue.enqueue(start);
        Map<Coordinate, String> parent = new HashMap<>();
        parent.put(start, null);

        // while the queue isn't empty, we dequeue the next node we need to search for 
        while (!queue.isEmpty()) {
            Coordinate coord = queue.dequeue();
            Coordinate currentCoord = new Coordinate(coord.getX(), coord.getY());

            // if the current node == end node, it means we reached the end of the maze!
            if (currentCoord.equals(end)) {
                return reconstructPath(parent, start, end);
            }

            for (Direction direction : Direction.values()) {
                Coordinate nextCoord = maze.nextStep(direction);
            }

        }
        return null;
    }

    private List<Coordinate> reconstructPath(Map<Coordinate, String> parent, Coordinate start, Coordinate end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reconstructPath'");
    }

}


    
    /*
    To use BFS to find the shortest path in a maze grid, you can follow these steps:

    Create a queue to store the cells to be visited and a set to keep track of visited cells.
    Enqueue the starting cell into the queue and mark it as visited.
    While the queue is not empty, dequeue a cell from the queue.
    Check if the dequeued cell is the target cell. If it is, reconstruct the path and return it.
    Otherwise, enqueue all valid neighboring cells that are not walls and have not been visited. Mark them as visited and set their parent to the current cell.
    Repeat steps 3-5 until the queue is empty or the target cell is found.

    */
