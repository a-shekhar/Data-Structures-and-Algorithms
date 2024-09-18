

package org.graphs.BFS;

import org.graphs.GraphNodeMatrix;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphBFSMatrix {
    ArrayList<GraphNodeMatrix> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public GraphBFSMatrix(ArrayList<GraphNodeMatrix>  nodeList){
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
        for (GraphNodeMatrix graphNode : nodeList) {
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
    public ArrayList<GraphNodeMatrix> getNeighbours(GraphNodeMatrix node) {
        ArrayList<GraphNodeMatrix> neighbours = new ArrayList<>();
        int nodeIndex = node.index;
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            if(adjacencyMatrix[nodeIndex][i] == 1){
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    // BFS internal
     void bfsVisit(GraphNodeMatrix node) {
        LinkedList<GraphNodeMatrix> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeMatrix currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNodeMatrix> neighbors = getNeighbours(currentNode);
            for(GraphNodeMatrix neighbor : neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void bfs(){
        for(GraphNodeMatrix node : nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }



    public static void main(String[] args) {
        ArrayList<GraphNodeMatrix> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeMatrix("A", 0));
        nodeList.add(new GraphNodeMatrix("B", 1));
        nodeList.add(new GraphNodeMatrix("C", 2));
        nodeList.add(new GraphNodeMatrix("D", 3));
        nodeList.add(new GraphNodeMatrix("E", 4));
        GraphBFSMatrix graph = new GraphBFSMatrix(nodeList);
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