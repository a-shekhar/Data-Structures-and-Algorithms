package org.graphs.BFS;

import java.util.ArrayList;

public class GraphNodeBFSUsingAdjacencyList {
    public String name;
    public int index;
    public boolean isVisited;
    public ArrayList<GraphNodeBFSUsingAdjacencyList> neighbors = new ArrayList<>();

    public GraphNodeBFSUsingAdjacencyList(String name, int index) {
        this.name = name;
        this.index = index;
        this.isVisited = false;
    }
}

