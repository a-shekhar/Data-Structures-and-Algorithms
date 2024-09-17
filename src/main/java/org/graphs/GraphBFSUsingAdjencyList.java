package org.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Implement a graph data structure using adjacency matrix.
*/
public class GraphBFSUsingAdjencyList {
    ArrayList<GraphNodeBFSUsingAdjacencyList> nodeList = new ArrayList<>();

    public GraphBFSUsingAdjencyList(ArrayList<GraphNodeBFSUsingAdjacencyList> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNodeBFSUsingAdjacencyList first = nodeList.get(i);
        GraphNodeBFSUsingAdjacencyList second = nodeList.get(j);
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

    // BFS internal
    void bfsVisit(GraphNodeBFSUsingAdjacencyList node){
        LinkedList<GraphNodeBFSUsingAdjacencyList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeBFSUsingAdjacencyList currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeBFSUsingAdjacencyList neighbour : currentNode.neighbors){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void bfs(){
        for(GraphNodeBFSUsingAdjacencyList node : nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<GraphNodeBFSUsingAdjacencyList> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeBFSUsingAdjacencyList("A", 0));
        nodeList.add(new GraphNodeBFSUsingAdjacencyList("B", 1));
        nodeList.add(new GraphNodeBFSUsingAdjacencyList("C", 2));
        nodeList.add(new GraphNodeBFSUsingAdjacencyList("D", 3));
        nodeList.add(new GraphNodeBFSUsingAdjacencyList("E", 4));
        GraphBFSUsingAdjencyList graph = new GraphBFSUsingAdjencyList(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);

        System.out.println(graph.toString());

        graph.bfs();
    }
}
