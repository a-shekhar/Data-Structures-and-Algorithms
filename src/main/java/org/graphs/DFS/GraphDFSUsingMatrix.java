

package org.graphs.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphDFSUsingMatrix {
    ArrayList<GraphNodeDFSUsingMatrix> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public GraphDFSUsingMatrix(ArrayList<GraphNodeDFSUsingMatrix>  nodeList){
        this.nodeList = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j){
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (GraphNodeDFSUsingMatrix graphNode : nodeList) {
            s.append(graphNode.name).append(" ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name).append(": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j)).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // get neighbours
    public ArrayList<GraphNodeDFSUsingMatrix> getNeighbours(GraphNodeDFSUsingMatrix node) {
        ArrayList<GraphNodeDFSUsingMatrix> neighbours = new ArrayList<>();
        int nodeIndex = node.index;
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            if(adjacencyMatrix[nodeIndex][i] == 1){
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    // BFS internal
     void bfsVisit(GraphNodeDFSUsingMatrix node) {
        LinkedList<GraphNodeDFSUsingMatrix> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeDFSUsingMatrix currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNodeDFSUsingMatrix> neighbors = getNeighbours(currentNode);
            for(GraphNodeDFSUsingMatrix neighbor : neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }


    public void bfs(){
        for(GraphNodeDFSUsingMatrix node : nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }



    // DFS internal
    void dfsVisit(GraphNodeDFSUsingMatrix node) {
        Stack<GraphNodeDFSUsingMatrix> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNodeDFSUsingMatrix currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeDFSUsingMatrix neighbor : getNeighbours(currentNode)){
                if(!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void dfs(){
        for(GraphNodeDFSUsingMatrix node : nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<GraphNodeDFSUsingMatrix> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeDFSUsingMatrix("A", 0));
        nodeList.add(new GraphNodeDFSUsingMatrix("B", 1));
        nodeList.add(new GraphNodeDFSUsingMatrix("C", 2));
        nodeList.add(new GraphNodeDFSUsingMatrix("D", 3));
        nodeList.add(new GraphNodeDFSUsingMatrix("E", 4));
        GraphDFSUsingMatrix graph = new GraphDFSUsingMatrix(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);

        System.out.println(graph.toString());

        graph.bfs();
        graph.dfs();
    }
}