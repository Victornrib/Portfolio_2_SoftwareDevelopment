class Edge{
    Town from;
    Town to;
    Integer dist;
    public Edge(Town from,Town to, Integer dist){
        this.from = from;
        this.to = to;
        this.dist = dist;
        from.OutEdges.add(this); //adds an edge to the list of OutEdges ???
    }
}