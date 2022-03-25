import java.util.ArrayList;

//
public class AdjacencyGraph {
    ArrayList<Town> Towns;

    public AdjacencyGraph() {
        Towns = new ArrayList<Town>(); 
    }
    public void addTown(Town t){
        Towns.add(t);
    }
    public void addDistance(Town from, Town to, Integer dist){
        if(!(Towns.contains(from) && Towns.contains(to)))
        {
            System.out.println("Vertices missing from graph");
            return;
        }
        Distance newDist = new Distance(from, to, dist); //im not actually sure where newDist gets used
    }

//method for edge which goes both ways... not implemented yet.
//    public void addUndirectedDistance(Town from, Town to, Integer dist){
//        if(!(Towns.contains(from) && Towns.contains(to))) //maybe we can find another way to catch errors to show we changed the code?
//        {
//            System.out.println("Vertices missing from graph");
//            return;
//        }
//        Distance newDistOut = new Distance(from, to, dist);  //from>to is distance "out" of town
//        Distance newDistIn = new Distance( to, from, dist);  //to>from is "in" to town
//    }

    public void PrintGraph(){
        for(int i = 0; i < Towns.size(); i++){
            System.out.println("Town " + Towns.get(i).name +" is connected to: ");
            Town current = Towns.get(i);
            //not sure what following for loop does
            for (Distance dist: current.OutEdge) {
                System.out.println(dist.to.name +" by a distance of " + dist.dist + "km");
            }
        }
    }
}

class Town {
    String name;
    ArrayList<Distance> OutEdge; //i don't rename this because its a good term...
    public Town(String name){
        this.name = name;
        OutEdge = new ArrayList<Distance>();
    }
}

class Distance {
    Town from;
    Town to;
    Integer dist; //in km
    public Distance(Town from, Town to, Integer dist){
        this.from = from;
        this.to = to;
        this.dist = dist;
        from.OutEdge.add(this); //not sure how this works
    }
}