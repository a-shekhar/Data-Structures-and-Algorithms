

package org.graphs.SSSPP;

import org.graphs.GraphNodeMatrix;
import org.graphs.GraphNodeMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BFSUsingMatrix {
    ArrayList<GraphNodeMatrix> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public BFSUsingMatrix(ArrayList<GraphNodeMatrix>  nodeList){
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

    // print path of each of the vertex from source
    public static void pathPrint(GraphNodeMatrix node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

     // Time Complexity - O(E)
    // Space Complexity - O(V)
    public void BFSForSSSPP(GraphNodeMatrix node) {
        LinkedList<GraphNodeMatrix> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNodeMatrix currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print("printing path for node " + currentNode.name + ": ");
            pathPrint(currentNode);
            System.out.println();
            for(GraphNodeMatrix neighbour : getNeighbours(currentNode)){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                }
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
        nodeList.add(new GraphNodeMatrix("F", 5));
        nodeList.add(new GraphNodeMatrix("G", 6));

        BFSUsingMatrix newGraph = new BFSUsingMatrix(nodeList);
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