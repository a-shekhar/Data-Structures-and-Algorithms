

package org.graphs.BFS;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphBFS {
    ArrayList<GraphNodeBFS> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public GraphBFS(ArrayList<GraphNodeBFS>  nodeList){
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
        for (GraphNodeBFS graphNode : nodeList) {
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
    public ArrayList<GraphNodeBFS> getNeighbours(GraphNodeBFS node) {
        ArrayList<GraphNodeBFS> neighbours = new ArrayList<>();
        int nodeIndex = node.index;
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            if(adjacencyMatrix[nodeIndex][i] == 1){
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    // BFS internal
     void bfsVisit(GraphNodeBFS node) {
        LinkedList<GraphNodeBFS> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeBFS currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNodeBFS> neighbors = getNeighbours(currentNode);
            for(GraphNodeBFS neighbor : neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void bfs(){
        for(GraphNodeBFS node : nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }



    public static void main(String[] args) {
        ArrayList<GraphNodeBFS> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeBFS("A", 0));
        nodeList.add(new GraphNodeBFS("B", 1));
        nodeList.add(new GraphNodeBFS("C", 2));
        nodeList.add(new GraphNodeBFS("D", 3));
        nodeList.add(new GraphNodeBFS("E", 4));
        GraphBFS graph = new GraphBFS(nodeList);
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