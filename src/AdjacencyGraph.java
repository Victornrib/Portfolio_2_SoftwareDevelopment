import java.util.ArrayList;

public class AdjacencyGraph {

    ArrayList<Town> Towns;

    public AdjacencyGraph(){
        Towns = new ArrayList<>();
    }

    public void addTown(Town t){
        Towns.add(t);
    }

    public void addUndirectedEdge(Town from, Town to, Integer dist) {
        if(!(Towns.contains(from) && Towns.contains(to)))
        {
            System.out.println("Towns missing from graph"); //a little check before proceeding to make edges...
            return;
        }
        Edge newEdgeIn = new Edge(from, to, dist);
        Edge newEdgeOut = new Edge(to, from, dist);
    }

    public void printAdjGraph() {
        for (int i = 0; i < Towns.size() ; i++) {
            System.out.println("\n" + Towns.get(i).name + " is connected to: ");
            Town current = Towns.get(i);
            for (Edge e: current.OutEdges) {
                System.out.println(e.to.name + " by a distance of " + e.dist + "km");
            }
        }
    }

    //Minimum spanning tree... Prims algorithm
    public void PrimsMST(){
        //Starting running time
        long startTime = System.nanoTime();
        MinHeap<Town> Queue = new MinHeap<Town>();

        //Only runs algorithm if Towns<> is not empty
        if (Towns.size() > 0) {
            //The first town in the ArrayList is its own parent (is visited) with no distance attached
            Towns.get(0).dist = 0;
            Towns.get(0).visited = true;
            Towns.get(0).prev = Towns.get(0);

            //Inserts all Towns into the MinHeap
            for(int i = 0; i < Towns.size(); i ++) {
                Queue.Insert(Towns.get(i));
            }

            int totalMST_Distance = 0; //Because no towns are connected yet

            //As long as the MinHeap has Towns in it...
            while(!Queue.isEmpty()) {
                Town currentTown = Queue.extractMin(); //Town with the smallest distance is taken out of the MinHeap
                int numOfOutEdges = currentTown.OutEdges.size();
                for (int potentialTownIndex = 0; potentialTownIndex < numOfOutEdges; potentialTownIndex++) {
                    Integer potentialDist = currentTown.OutEdges.get(potentialTownIndex).dist;
                    Town potentialTown = currentTown.OutEdges.get(potentialTownIndex).to;

                    //Checks that the distance from currentTown to potentialTown is less than infinity (or current dist of Town)
                    if (potentialDist < potentialTown.dist) {

                        //Checks that the Town has not already been added to the MST
                        if (!potentialTown.visited) {
                            potentialTown.dist = potentialDist; //Updates to the distance from currentTown to potentialTown
                            potentialTown.prev = currentTown;   //Connects the potentialTown to the currentTown
                            int posInMinHeap = Queue.getPosition(potentialTown); //Finds Town in MinHeap
                            Queue.decreasekey(posInMinHeap);    //Updates position of Town
                        }
                    }
                }
                currentTown.visited = true;
                totalMST_Distance += currentTown.dist;
            }

            for(int i = 1; i < Towns.size(); i ++) {
                System.out.println(Towns.get(i).prev.name + " is connected to " + Towns.get(i).name + " by " + Towns.get(i).dist + " km");
            }
            System.out.println("\nThe total distance of the MST is " +  totalMST_Distance + " km.\n");
            int pricePerKm = 1000000; //1000 kr per meter
            System.out.println("The total cost of the new electrical grid would be " + totalMST_Distance*pricePerKm + " kr.\n");
        }
        else {
            System.out.println("There are no Towns in this Adjacency Graph.");
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("\nRunning time of PrimsMST: " + totalTime + " ns.");
    }
}


