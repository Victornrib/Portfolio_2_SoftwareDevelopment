import java.util.ArrayList;

class Town implements Comparable<Town>{
    String name;
    Integer dist; //stored in the Town object so that the compareTo method can be used on dist
    Boolean visited;
    Town prev;
    ArrayList<Edge> OutEdges; //edges connected to each Town are stored here

    public Town(String name){
        this.name = name;
        this.dist = Integer.MAX_VALUE; //sets the initial distance of a town to infinity
        this.prev = null; //initial prev is set to null as a placeholder until it is updated by Prims
        this.visited = false; //no towns have been visited yet at start of algorithm
        OutEdges = new ArrayList<>();
    }

    //This method compares distances of different towns
    @Override
    public int compareTo(Town t) {
        return this.dist.compareTo(t.dist);
    }

}

