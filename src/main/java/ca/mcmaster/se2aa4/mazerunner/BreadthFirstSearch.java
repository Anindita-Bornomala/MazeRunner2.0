package ca.mcmaster.se2aa4.mazerunner;

public class BreadthFirstSearch {

    
}

    /* BFS Algorithm:
    if queue is empty, refill it
    else
    dequeue one at a time and get element (starting with East, check E, S, W, N)
    if it equals PATH,
    move to that coordinate (keep track of move in canonical)
    - Need to change heading depending on move, so we know whether "F", "R", or "L"
    Repeat process until endCond is reached
    return canonical

    
    */
    // Algorithm:

    /*
    To use BFS to find the shortest path in a maze grid, you can follow these steps:

    Create a queue to store the cells to be visited and a set to keep track of visited cells.
    Enqueue the starting cell into the queue and mark it as visited.
    While the queue is not empty, dequeue a cell from the queue.
    Check if the dequeued cell is the target cell. If it is, reconstruct the path and return it.
    Otherwise, enqueue all valid neighboring cells that are not walls and have not been visited. Mark them as visited and set their parent to the current cell.
    Repeat steps 3-5 until the queue is empty or the target cell is found.

    */


