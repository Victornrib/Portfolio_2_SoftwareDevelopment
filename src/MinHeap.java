import java.util.ArrayList;
import java.util.HashMap;
//This code is adopted from the MinHeap implemented in class with Line Reinhardt

public class MinHeap<Town extends Comparable<Town>> {
    HashMap<Town, Integer> townPositionIndex = new HashMap<>();

    //The root is at index [0]
    ArrayList<Town> minHeapTowns;
    private int size;

    public MinHeap() {
        this.minHeapTowns = new ArrayList<Town>();
        this.size = 0;
    }

    //Gets positions of all branches /////////////////????? all branches? or just the position of a town??
    public int getPosition(Town t) {
        return townPositionIndex.get(t);
    }

    //Checks if MinHeap is empty
    public boolean isEmpty() {
        return size <= 0;
    }

    //Not sure what the next 3 methods do, perhaps leave a comment?
    private int Parent(int pos) {
        return (pos-1)/2;
    }
    private int leftChild(int pos) {
        return pos*2 +1;
    }
    private int rightChild(int pos) {
        return pos*2 +2;
    }

    //To swap positions of towns, first create a dummy so that it is not lost
    private void swap(int pos1, int pos2) {
        Town dummyTown = minHeapTowns.get(pos1);
        minHeapTowns.set(pos1, minHeapTowns.get(pos2));
        minHeapTowns.set(pos2, dummyTown);
        townPositionIndex.put(minHeapTowns.get(pos1),pos1);
        townPositionIndex.put(minHeapTowns.get(pos2),pos2);
    }

    //To insert a town into the MinHeap
    public void Insert(Town t){
        minHeapTowns.add(t);
        townPositionIndex.put(t, size);
        size++;
        decreaseKey(size -1); //not sure what this does, perhaps put a comment
    }

    //
    public void decreaseKey(int pos){
        int currentPos=pos;
        while (minHeapTowns.get(currentPos).compareTo(minHeapTowns.get(Parent(currentPos)))<0){
            swap(currentPos,Parent(currentPos));
            currentPos=Parent(currentPos);
        }
    }

    //organizing minHeap
    public Town viewMin(){
        return minHeapTowns.get(0);
    }
    private boolean movedown(int pos){
        boolean leftsmaller = leftChild(pos)<size
                && (minHeapTowns.get(leftChild(pos)).compareTo(minHeapTowns.get(pos))<0);
        boolean rightsmaller = rightChild(pos)<size
                && (minHeapTowns.get(rightChild(pos)).compareTo(minHeapTowns.get(pos))<0);
        return leftsmaller || rightsmaller;
    }
    public void increasekey(int pos){
        int currentpos=pos;
        while (movedown(currentpos))
        {
            int rpos= rightChild(currentpos);
            int lpos= leftChild(currentpos);
            if (rpos< size && minHeapTowns.get(rpos).compareTo(minHeapTowns.get(lpos))<0){
                swap(rpos,currentpos);
                currentpos=rpos;
            }
            else{
                swap(lpos,currentpos);
                currentpos=lpos;
            }
        }
    }
    //returning the minHeap
    public Town extractMin(){
        Town min = minHeapTowns.get(0);
        minHeapTowns.set(0, minHeapTowns.get(size-1));
        townPositionIndex.put(minHeapTowns.get(0),0);
        size--;
        increasekey(0);
        return min;
    }
}