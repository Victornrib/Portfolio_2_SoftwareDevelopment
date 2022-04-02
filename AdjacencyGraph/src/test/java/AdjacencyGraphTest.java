import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyGraphTest {


    @Test
    void createAdjacencyGraph() {

        Town T0 = new Town("Esklidstrup");
        Town T1 = new Town("Haslev");
        Town T2 = new Town("Holbaek");
        Town T3 = new Town("Jaegerspris");
        Town T4 = new Town("Kalundborg");
        Town T5 = new Town("Korsoer");

        ArrayList<Town> towns = new ArrayList<Town>();
        towns.add(T0);
        towns.add(T1);
        towns.add(T2);
        towns.add(T3);
        towns.add(T4);
        towns.add(T5);

        AdjacencyGraph adjacencyGraph = new AdjacencyGraph();
        adjacencyGraph.addTown(T0);
        adjacencyGraph.addTown(T1);
        adjacencyGraph.addTown(T2);
        adjacencyGraph.addTown(T3);
        adjacencyGraph.addTown(T4);
        adjacencyGraph.addTown(T5);

        for (int i = 0; i < 6; i++) {
            assertEquals(towns.get(i), adjacencyGraph.Towns.get(i));
        }
    }



    @Test
    void createAdjacencyGraphError() {

        Town T0 = new Town("Esklidstrup");

        AdjacencyGraph adjacencyGraph = new AdjacencyGraph();
        adjacencyGraph.addTown(T0);

        assertNotEquals(new Town("Slagelse"), adjacencyGraph.Towns.get(0));
    }

}