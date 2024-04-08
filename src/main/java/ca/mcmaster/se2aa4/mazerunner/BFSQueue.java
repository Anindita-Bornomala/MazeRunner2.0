package ca.mcmaster.se2aa4.mazerunner;

import java.util.LinkedList;
import java.util.Queue;


public class BFSQueue {
    public Queue<Coordinate> queue;

    public BFSQueue() {
        queue = new LinkedList<>();
    }
    public void enqueue(Coordinate coord) { queue.add(coord); }

    public Coordinate dequeue() { return queue.poll(); }

    public Boolean isEmpty() {
        if (queue.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }
}