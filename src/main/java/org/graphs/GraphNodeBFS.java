package org.graphs;

public class GraphNodeBFS {
    public String name;
    public int index;
    public boolean isVisited;

    public GraphNodeBFS(String name, int index) {
        this.name = name;
        this.index = index;
        this.isVisited = false;
    }
}

