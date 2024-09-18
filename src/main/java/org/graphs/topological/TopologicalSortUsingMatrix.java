

package org.graphs.topological;

import org.graphs.GraphNodeMatrix;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingMatrix {
    ArrayList<GraphNodeMatrix> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public TopologicalSortUsingMatrix(ArrayList<GraphNodeMatrix>  nodeList){
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

    // topological sort
    public void addDirectedEdge(int i, int j){
        adjacencyMatrix[i][j] = 1;
    }

    void topologicalVisit(GraphNodeMatrix node, Stack<GraphNodeMatrix> stack) {
        ArrayList<GraphNodeMatrix> neighbours = getNeighbours(node);
        for(GraphNodeMatrix neighbour : neighbours){
            if(!neighbour.isVisited){
                topologicalVisit(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    // time and space complexity = O(V+E)
    public void topologicalSort() {
        Stack<GraphNodeMatrix> stack = new Stack<>();
        for(GraphNodeMatrix node : nodeList){
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
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
        nodeList.add(new GraphNodeMatrix("H", 7));

        TopologicalSortUsingMatrix newGraph = new TopologicalSortUsingMatrix(nodeList);
        newGraph.addDirectedEdge(0, 2);
        newGraph.addDirectedEdge(2, 4);
        newGraph.addDirectedEdge(4, 7);
        newGraph.addDirectedEdge(4, 5);
        newGraph.addDirectedEdge(5, 6);
        newGraph.addDirectedEdge(1, 2);
        newGraph.addDirectedEdge(1, 3);
        newGraph.addDirectedEdge(3, 5);

        System.out.println(newGraph.toString());

        newGraph.topologicalSort();
    }
}