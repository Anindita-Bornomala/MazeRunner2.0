package ca.mcmaster.se2aa4.mazerunner;

import java.util.LinkedList;
import java.util.Queue;


public class BFSQueue {
    public Queue<String> queue;

    public BFSQueue() {
        queue = new LinkedList<>();
    }
    public void enqueue(String action) { queue.add(action); }

    public String dequeue() { return queue.poll(); }

    public Boolean isEmpty() {
        if (queue.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }

}