import java.util.ArrayList;

class Town implements Comparable<Town>{
    String name;
    Integer dist;
    Boolean visited;
    Town prev;

    ArrayList<Edge> OutEdges;
    public Town(String name){
        this.name = name;
        this.dist = Integer.MAX_VALUE;
        this.prev = null;
        this.visited = false;
        OutEdges =new ArrayList<Edge>();

    }
    @Override
    public int compareTo(Town v) {
        return this.dist.compareTo(v.dist);
    }

}

