package org.graphs.SSSPP;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    public ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public Dijkstra(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    // print path of each of the vertex from source
    public static void pathPrint(WeightedNode node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }


    void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()) {
            WeightedNode currentNode = queue.poll();
            for(WeightedNode neighbor : currentNode.neighbors) {
                if(queue.contains(neighbor)) {
                    if (neighbor.distance > (currentNode.distance
                            + currentNode.weightMap.get(neighbor))){
                        neighbor.distance = currentNode.distance
                                + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        for(WeightedNode nodeToCheck : nodeList){
            System.out.print("Node " + nodeToCheck
                    + ", distance " + nodeToCheck.distance
                    + ", path: " );
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    public void addWeightedNode(int i, int j, int d){
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, d);

    }

    public static void main(String[] args) {
        // Implement Dijkstra's shortest path algorithm using adjacency list representation'
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));

        Dijkstra newGraph = new Dijkstra(nodeList);
        newGraph.addWeightedNode(0, 1, 2);
        newGraph.addWeightedNode(0, 2, 5);
        newGraph.addWeightedNode(1, 2, 6);
        newGraph.addWeightedNode(1, 3, 1);
        newGraph.addWeightedNode(1, 4, 3);
        newGraph.addWeightedNode(2, 5, 8);
        newGraph.addWeightedNode(2, 4, 4);
        newGraph.addWeightedNode(4, 6, 9);
        newGraph.addWeightedNode(5, 6, 7);

        System.out.println("Printing Dijkstra from source : A");
        newGraph.dijkstra(nodeList.get(0));  // source node is A
    }
}
