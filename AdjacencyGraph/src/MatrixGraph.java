import java.util.Arrays;

public class MatrixGraph {
    boolean[][] EdgeMatrix;
    int[][]  WeightMatrix;
    public MatrixGraph(int Vertices){
        EdgeMatrix=new boolean[Vertices][Vertices];
        for(int i=0;i<Vertices;i++)
            Arrays.fill(EdgeMatrix[i],false);
        WeightMatrix=new int[Vertices][Vertices];
        for(int i=0;i<Vertices;i++)
            Arrays.fill(WeightMatrix[i],-1);
    }
    public void addEdge(int from,int to, int weight){
        EdgeMatrix[from][to]=true;
        WeightMatrix[from][to]=weight;
    }

    public void addUnDirectedEdge(int from,int to, int weight){
        EdgeMatrix[from][to]=true;
        WeightMatrix[from][to]=weight;
        EdgeMatrix[to][from]=true;
        WeightMatrix[to][from]=weight;
    }
    public void PrintGraph(){
        for(int i =0; i<EdgeMatrix.length;i++) {
            System.out.println(" Vertex " + i + " is connect to : ");
            for (int j=0;j<EdgeMatrix.length;j++){
                if(EdgeMatrix[i][j])
                    System.out.println(j+" with weight: "+ WeightMatrix[i][j]);
            }
        }
    }
}
