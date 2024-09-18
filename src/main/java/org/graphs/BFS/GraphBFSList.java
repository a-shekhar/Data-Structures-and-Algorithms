package org.graphs.BFS;

import org.graphs.GraphNodeList;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Implement a graph data structure using adjacency matrix.
*/
public class GraphBFSList {
    ArrayList<GraphNodeList> nodeList = new ArrayList<>();

    public GraphBFSList(ArrayList<GraphNodeList> nodeList) {
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

    // BFS internal
    void bfsVisit(GraphNodeList node){
        LinkedList<GraphNodeList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeList currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeList neighbour : currentNode.neighbors){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void bfs(){
        for(GraphNodeList node : nodeList){
            if(!node.isVisited){
                bfsVisit(node);
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
        GraphBFSList graph = new GraphBFSList(nodeList);
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
