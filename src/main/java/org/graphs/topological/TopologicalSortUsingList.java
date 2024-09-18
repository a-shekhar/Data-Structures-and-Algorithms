package org.graphs.topological;

import org.graphs.GraphNodeList;

import java.util.ArrayList;
import java.util.Stack;

/*
Implement a graph data structure using adjacency matrix.
*/
public class TopologicalSortUsingList {
    ArrayList<GraphNodeList> nodeList = new ArrayList<>();

    public TopologicalSortUsingList(ArrayList<GraphNodeList> nodeList) {
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


    // topological sort
    public void addDirectedEdge(int i, int j){
        GraphNodeList first = nodeList.get(i);
        GraphNodeList second = nodeList.get(j);
        first.neighbors.add(second);
    }

    void topologicalVisit(GraphNodeList node, Stack<GraphNodeList> stack){
        for(GraphNodeList neighbor : node.neighbors){
            if(!neighbor.isVisited){
                topologicalVisit(neighbor, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void topologicalSort(){
        Stack<GraphNodeList> stack = new Stack<>();
        for(GraphNodeList node : nodeList){
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
        System.out.println();
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
        nodeList.add(new GraphNodeList("H", 7));

        TopologicalSortUsingList newGraph = new TopologicalSortUsingList(nodeList);
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
