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
        decreaseKey(size -1); //not sure what this does, perhaps put a comment (why -1??)
    }

    //shuffles Towns along into place in the MinHeap by comparing and swapping (is this correct K?)
    public void decreaseKey(int pos){
        int currentPos = pos;
        while (minHeapTowns.get(currentPos).compareTo(minHeapTowns.get(Parent(currentPos))) < 0){
            swap(currentPos, Parent(currentPos));
            currentPos = Parent(currentPos);
        }
    }

    //Organises the MinHeap (this is your comment, but it is not what it does - delete?)
    public Town viewMin() {
        return minHeapTowns.get(0);
    }

    //please make comment here
    private boolean moveDown(int pos) {
        boolean leftSmaller = leftChild(pos) < size
                && (minHeapTowns.get(leftChild(pos)).compareTo(minHeapTowns.get(pos)) < 0);
        boolean rightSmaller = rightChild(pos) < size
                && (minHeapTowns.get(rightChild(pos)).compareTo(minHeapTowns.get(pos)) < 0);
        return leftSmaller || rightSmaller;
    }

    //Shuffles Towns up the MinHeap (is this what it does?)
    public void increaseKey(int pos) {
        int currentPos = pos;
        while (moveDown(currentPos))
        {
            int rightPos = rightChild(currentPos);
            int leftPos = leftChild(currentPos);
            if (rightPos < size && minHeapTowns.get(rightPos).compareTo(minHeapTowns.get(leftPos)) < 0){
                swap(rightPos, currentPos);
                currentPos = rightPos;
            }
            else{
                swap(leftPos, currentPos);
                currentPos = leftPos;
            }
        }
    }

    //returning the minHeap (---it just gives the min, does it also "return" it?? ...the following comment is mine which is what i think it actually does)

    //Takes out and returns the minTown (index 0) from the MinHeap and moves shuffles/bubbles rest of Towns up the heap
    public Town extractMin() {
        Town minTown = minHeapTowns.get(0);
        minHeapTowns.set(0, minHeapTowns.get(size -1));
        townPositionIndex.put(minHeapTowns.get(0), 0);
        size--;
        increaseKey(0);
        return minTown;
    }
}