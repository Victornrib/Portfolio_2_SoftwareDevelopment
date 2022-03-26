import java.util.ArrayList;

//
public class AdjacencyListGraph {
    ArrayList<Town> Towns;

    public AdjacencyListGraph() {
        Towns = new ArrayList<Town>(); 
    }
    public void addTown(Town t){
        Towns.add(t);
    }

//method for edge which goes both ways... not implemented yet.
    public void addUndirectedEdge(Town from, Town to, Integer dist){
        if(!(Towns.contains(from) && Towns.contains(to))) //maybe we can find another way to catch errors to show we changed the code?
        {
            System.out.println("Town missing from graph");
            return;
        }
        Edge newEdgeOut = new Edge(from, to, dist);  //from>to is distance "out" of town
        Edge newEdgeIn = new Edge(to, from, dist);  //to>from is "in" to town
    }

    public void PrintGraph(){
        for(int i = 0; i < Towns.size(); i++){
            Town currentTown = Towns.get(i);
            System.out.println(Towns.get(i).name + " is connected to: ");
            //not sure what following for loop does
            for (Edge dist: currentTown.outEdges) {
                System.out.println(dist.to.name + " by a distance of " + dist.weight + "km");
            }
        }
    }
}

//not sure if variables should be private like in the video?
//vertex class
class Town implements Comparable<Town>{ 
    String name;
    Integer distance = Integer.MAX_VALUE; //set distance to absolut max value possible.
    ArrayList<Edge> outEdges; //i don't rename this because its a good term...
    
    public Town(String name){
        this.name = name;
        outEdges = new ArrayList<>();
    }

    @Override
    //method allows edges to be compared, which is needed for sorting distances
    public int compareTo(Town t) {
        if (this.distance < t.distance)
            return -1;
        if (this.distance > t.distance)
            return 1;
        return 0;
    }
}

//edge class (call it edge because distance is the weight of the edge. so cannot be called Distance Class to avoid confusion)
class Edge {
    Town from;
    Town to;
    Integer weight; //in km
    
    public Edge(Town from, Town to, Integer dist){
        this.from = from;
        this.to = to;
        this.weight = dist;
        from.outEdges.add(this); //not sure how exactly this works -G
    }
}