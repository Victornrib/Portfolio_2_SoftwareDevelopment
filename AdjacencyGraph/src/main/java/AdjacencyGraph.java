import java.util.ArrayList;

public class AdjacencyGraph {

    ArrayList<Town> Towns;

    public AdjacencyGraph(){
        Towns=new ArrayList<Town>();
    }


    public void addTown(Town v){
        Towns.add(v);
    }

/*
    public void addEdge(Town from, Town to, Integer dist){
        if(!(Towns.contains(from) && Towns.contains(to)))
        {
            System.out.println("Towns missing from graph");
            return;
        }
        Edge newE=new Edge(from, to, dist);

    }
*/

    public void addUndirectedEdge(Town from, Town to, Integer dist){
        if(!(Towns.contains(from) && Towns.contains(to)))
        {
            System.out.println("Towns missing from graph");
            return;
        }
        Edge newE=new Edge(from, to, dist);
        Edge newE2=new Edge( to, from, dist);
    }


    public void PrintGraph(){
        for(int i=0;i<Towns.size();i++){
            System.out.println(" com.company.Town "+Towns.get(i).name+" is connecte to: ");
            Town current=Towns.get(i);
            for (Edge e: current.OutEdges) {
                System.out.println(e.to.name +" with dist: "+e.dist);
            }
        }
    }


    public void PrimsMST(){
        MinHeap<Town> Queue = new MinHeap<Town>();
        if (Towns.size() > 0) {
            Towns.get(0).dist = 0;
            Towns.get(0).visited = true;
        }
        //filling both arraylists with max.values and indices
        for(int i = 0; i < Towns.size(); i ++) {
            Queue.Insert(Towns.get(i)); //Town pairs inserted into Q<> so when Town pairs are updated, Q is updated too
        }
        //totalMST_Distance is empty at first
        int totalMST_Distance = 0;

        while(!Queue.isEmpty()) {
            Town currentTown = Queue.extractMin(); //using minHeap to get min value/dist
            int numOfOutEdges = currentTown.OutEdges.size(); //gets specific Town in Towns and finds size of outedges
            for(int potentialTownIndex = 0; potentialTownIndex < numOfOutEdges; potentialTownIndex++)
            {
                Integer potentialDist = currentTown.OutEdges.get(potentialTownIndex).dist;
                Town potentialTown = currentTown.OutEdges.get(potentialTownIndex).to;//get current V
                if(potentialDist < potentialTown.dist) {
                    potentialTown.dist = potentialDist;
                    potentialTown.prev = currentTown;
                    int pos = Queue.getPosition(potentialTown); //rename pos
                    Queue.decreasekey(pos); //takes node
                }
            }
            currentTown.visited = true;
            totalMST_Distance += currentTown.dist;
        }
        System.out.println("\nThe total distance of the MST is " +  totalMST_Distance + "km.\n");
        for(int i = 0; i < Towns.size(); i ++) {
            System.out.println("The distance from " + Towns.get(i).prev + " to " + Towns.get(i).name + " is " + Towns.get(i).dist + " km.");
        }
    }
}


