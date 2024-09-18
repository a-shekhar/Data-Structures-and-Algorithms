package org.graphs.SSSPP;

import org.graphs.GraphNodeList;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Implement a graph data structure using adjacency matrix.
*/
public class BFSUsingList {
    ArrayList<GraphNodeList> nodeList = new ArrayList<>();

    public BFSUsingList(ArrayList<GraphNodeList> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNodeList first = nodeList.get(i);
        GraphNodeList second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    // For printing Graph to the console

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size()-1 ) {
                    s.append((nodeList.get(i).neighbors.get(j).name) );
                } else {
                    s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }



    public static void pathPrint(GraphNodeList node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    // Time Complexity - O(E)
    // Space Complexity - O(V)
    public void BFSForSSSPP(GraphNodeList node){
        LinkedList<GraphNodeList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeList currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print("Printing path for node " + currentNode.name
                     + ": ");
            pathPrint(currentNode);
            System.out.println();
            for(GraphNodeList neighbour : currentNode.neighbors){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                }
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<GraphNodeList> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeList("A", 0));
        nodeList.add(new GraphNodeList("B", 1));
        nodeList.add(new GraphNodeList("C", 2));
        nodeList.add(new GraphNodeList("D", 3));
        nodeList.add(new GraphNodeList("E", 4));
        nodeList.add(new GraphNodeList("F", 5));
        nodeList.add(new GraphNodeList("G", 6));

        BFSUsingList newGraph = new BFSUsingList(nodeList);
        newGraph.addUndirectedEdge(0, 1);
        newGraph.addUndirectedEdge(0, 2);
        newGraph.addUndirectedEdge(1, 3);
        newGraph.addUndirectedEdge(1, 6);
        newGraph.addUndirectedEdge(2, 3);
        newGraph.addUndirectedEdge(2, 4);
        newGraph.addUndirectedEdge(3, 5);
        newGraph.addUndirectedEdge(4, 5);
        newGraph.addUndirectedEdge(5, 6);

        System.out.println(newGraph.toString());

        newGraph.BFSForSSSPP(nodeList.get(0));
    }
}
