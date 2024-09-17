package org.graphs.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*
Implement a graph data structure using adjacency matrix.
*/
public class GraphDFSUsingList {
    ArrayList<GraphNodeDFSUsingList> nodeList = new ArrayList<>();

    public GraphDFSUsingList(ArrayList<GraphNodeDFSUsingList> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNodeDFSUsingList first = nodeList.get(i);
        GraphNodeDFSUsingList second = nodeList.get(j);
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
    void bfsVisit(GraphNodeDFSUsingList node){
        LinkedList<GraphNodeDFSUsingList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeDFSUsingList currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeDFSUsingList neighbour : currentNode.neighbors){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void bfs(){
        for(GraphNodeDFSUsingList node : nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    //
    void dfsVisit(GraphNodeDFSUsingList node){
        Stack<GraphNodeDFSUsingList> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            GraphNodeDFSUsingList currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");

            for(GraphNodeDFSUsingList neighbor : currentNode.neighbors){
                if(!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }
    
    public void dfs(){
        for(GraphNodeDFSUsingList node : nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<GraphNodeDFSUsingList> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeDFSUsingList("A", 0));
        nodeList.add(new GraphNodeDFSUsingList("B", 1));
        nodeList.add(new GraphNodeDFSUsingList("C", 2));
        nodeList.add(new GraphNodeDFSUsingList("D", 3));
        nodeList.add(new GraphNodeDFSUsingList("E", 4));
        GraphDFSUsingList graph = new GraphDFSUsingList(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);

        System.out.println(graph.toString());

        // graph.bfs();
        graph.dfs();
    }
}
