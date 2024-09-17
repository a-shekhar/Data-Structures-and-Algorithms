package org.graphs.DFS;

import java.util.ArrayList;

public class GraphNodeDFSUsingList {
    public String name;
    public int index;
    public boolean isVisited;
    public ArrayList<GraphNodeDFSUsingList> neighbors = new ArrayList<>();

    public GraphNodeDFSUsingList(String name, int index) {
        this.name = name;
        this.index = index;
        this.isVisited = false;
    }
}

