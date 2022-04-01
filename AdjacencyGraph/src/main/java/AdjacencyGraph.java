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
        //MST is empty at first
        int MST = 0;

        while(!Queue.isEmpty()) {
            Town currentV = Queue.extractMin(); //using minHeap to get min value/dist
            int numOfOutEdges = currentV.OutEdges.size(); //gets specific Town in Towns and finds size of outedges
            for(int potentialVIndex = 0; potentialVIndex < numOfOutEdges; potentialVIndex++)
            {

                Integer potentialdist = currentV.OutEdges.get(potentialVIndex).dist;
                Town v=currentV.OutEdges.get(potentialVIndex).to;//get current V
                if(potentialdist < v.dist) {
                    v.dist = potentialdist;  //distMatrix[u.index][v];
                    v.prev = currentV;
                    int pos = Queue.getPosition(v);
                    Queue.decreasekey(pos); //takes node
                }
            }
            currentV.visited = true;
            MST += currentV.dist;
        }
        System.out.println("MST is " +  MST);
        for(int i = 0; i < Towns.size(); i ++) {
            System.out.println("Parent " + Towns.get(i).prev + " to " + "Edge dist " + Towns.get(i).dist);
        }
    }
}


