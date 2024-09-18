package org.graphs;

import java.util.ArrayList;

public class GraphNodeList {
    public String name;
    public int index;
    public boolean isVisited;
    public ArrayList<GraphNodeList> neighbors = new ArrayList<>();

    public GraphNodeList(String name, int index) {
        this.name = name;
        this.index = index;
        this.isVisited = false;
    }
}

