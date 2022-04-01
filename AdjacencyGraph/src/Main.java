public class Main {

    public static void main(String[] args) {
        AdjacencyListGraph adjDirectedG=createDirectedAdj();
        adjDirectedG.PrintGraph();

//    // Creating object opf class in main() methodn
//    minHeap minHeap = new minHeap(15);
//
//    // Inserting element to minHeap
//    // using insert() method
//
//    // Custom input entries
//        minHeap.insert(1);
//        minHeap.insert(2);
//        minHeap.insert(3);
//        minHeap.insert(4);
//        minHeap.insert(5);
//        minHeap.insert(6);
//        minHeap.insert(7);
//        minHeap.insert(8);
//        minHeap.insert(9);
//        minHeap.insert(10);
//        minHeap.insert(11);
//        minHeap.insert(12);
//        minHeap.insert(13);
//        minHeap.insert(14);
//        minHeap.insert(T15);


    // Print all elements of the heap
        //minHeap.print();

    // Removing minimum value from above heap
    // and printing it
        //System.out.println("The Min val is "
          //      + minHeap.remove());


    }

    public static AdjacencyListGraph createDirectedAdj(){
        AdjacencyListGraph newElectricalGrid = new AdjacencyListGraph();

        Town T0 = new Town("Esklidstrup");
        Town T1 = new Town("Haslev");
        Town T2 = new Town("Holbaek");
        Town T3 = new Town("Jaegerspris");
        Town T4 = new Town("Kalundborg");
        Town T5 = new Town("Korsoer");
        Town T6 = new Town("Koege");
        Town T7 = new Town("Maribo");
        Town T8 = new Town("Nakskov");
        Town T9 = new Town("Nykoebing F");
        Town T10 = new Town("Naestved");
        Town T11 = new Town("Ringsted");
        Town T12 = new Town("Roskilde");
        Town T13 = new Town("Slagelse");
        Town T14 = new Town("Soroe");
        Town T15 = new Town("Vordingborg");


        newElectricalGrid.addTown(T0);
        newElectricalGrid.addTown(T1);
        newElectricalGrid.addTown(T2);
        newElectricalGrid.addTown(T3);
        newElectricalGrid.addTown(T4);
        newElectricalGrid.addTown(T5);
        newElectricalGrid.addTown(T6);
        newElectricalGrid.addTown(T7);
        newElectricalGrid.addTown(T8);
        newElectricalGrid.addTown(T9);
        newElectricalGrid.addTown(T10);
        newElectricalGrid.addTown(T11);
        newElectricalGrid.addTown(T12);
        newElectricalGrid.addTown(T13);
        newElectricalGrid.addTown(T14);
        newElectricalGrid.addTown(T15);

        //Eskildstrup
        newElectricalGrid.addUndirectedEdge(T0,T7,28);
        newElectricalGrid.addUndirectedEdge(T0,T9,13);
        newElectricalGrid.addUndirectedEdge(T0,T15,24);
        //Haslev
        newElectricalGrid.addUndirectedEdge(T1,T5,60);
        newElectricalGrid.addUndirectedEdge(T1,T6,24);
        newElectricalGrid.addUndirectedEdge(T1,T10,25);
        newElectricalGrid.addUndirectedEdge(T1,T11,19);
        newElectricalGrid.addUndirectedEdge(T1,T12,47);
        newElectricalGrid.addUndirectedEdge(T1,T13,48);
        newElectricalGrid.addUndirectedEdge(T1,T14,34);
        newElectricalGrid.addUndirectedEdge(T1,T15,40);
        //Holbaek
        newElectricalGrid.addUndirectedEdge(T2,T3,34);
        newElectricalGrid.addUndirectedEdge(T2,T4,44);
        newElectricalGrid.addUndirectedEdge(T2,T5,66);
        newElectricalGrid.addUndirectedEdge(T2,T11,36);
        newElectricalGrid.addUndirectedEdge(T2,T12,32);
        newElectricalGrid.addUndirectedEdge(T2,T13,46);
        newElectricalGrid.addUndirectedEdge(T2,T14,34);
        //Jaegerspris
        newElectricalGrid.addUndirectedEdge(T3,T5,95);
        newElectricalGrid.addUndirectedEdge(T3,T6,58);
        newElectricalGrid.addUndirectedEdge(T3,T11,56);
        newElectricalGrid.addUndirectedEdge(T3,T12,33);
        newElectricalGrid.addUndirectedEdge(T3,T13,74);
        newElectricalGrid.addUndirectedEdge(T3,T14,63);
        //Kalundborg
        newElectricalGrid.addUndirectedEdge(T4,T11,62);
        newElectricalGrid.addUndirectedEdge(T4,T12,70);
        newElectricalGrid.addUndirectedEdge(T4,T13,39);
        newElectricalGrid.addUndirectedEdge(T4,T14,51);
        //Korsoer
        newElectricalGrid.addUndirectedEdge(T5,T10,45);
        newElectricalGrid.addUndirectedEdge(T5,T13,20);
        //Koege
        newElectricalGrid.addUndirectedEdge(T6,T10,45);
        newElectricalGrid.addUndirectedEdge(T6,T11,28);
        newElectricalGrid.addUndirectedEdge(T6,T12,25);
        newElectricalGrid.addUndirectedEdge(T6,T15,60);
        //Maribo
        newElectricalGrid.addUndirectedEdge(T7,T8,27);
        newElectricalGrid.addUndirectedEdge(T7,T9,26);
        //Naestved
        newElectricalGrid.addUndirectedEdge(T10,T12,57);
        newElectricalGrid.addUndirectedEdge(T10,T11,26);
        newElectricalGrid.addUndirectedEdge(T10,T13,37);
        newElectricalGrid.addUndirectedEdge(T10,T14,32);
        newElectricalGrid.addUndirectedEdge(T10,T15,28);
        //Ringsted
        newElectricalGrid.addUndirectedEdge(T11,T12,31);
        newElectricalGrid.addUndirectedEdge(T11,T14,15);
        newElectricalGrid.addUndirectedEdge(T11,T15,58);
        //Slagelse
        newElectricalGrid.addUndirectedEdge(T13,T14,14);

        return newElectricalGrid;
    }
}
