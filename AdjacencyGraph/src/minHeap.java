import java.util.Arrays;
//import java.util.NoSuchElementException;
//
//// import java.util.NoSuchElementException;
//
//// //My minHeap implementation
//
//  public Class minHeap(){
//    int [] heap;
//    int size;
//    int capacity;
//
////    //constructor
//    private minHeap(int capacity) {
//    this.capacity = capacity;
//    this.heap = new int[capacity];
//  }
//
////using The root element will be at Arr[0].
//// Arr[(i-1)/2] : Returns the parent node
////• Arr[(2*i)+1] : Returns the left child node
////• Arr[(2*i)+2] : Returns the right child node
//   private int getLeftChildIndex(int parentIndex) {
//       return 2 * parentIndex + 1;
//   }
//
//   private int getRightChildIndex(int parentIndex) {
//       return 2 * parentIndex + 2;
//   }
//
//   private int getParentIndex(int childIndex) {
//       return (childIndex - 1) / 2;
//   }
//
//   //checking size
//   private boolean hasLeftChild(int index) {   //children must be smaller
//       return getLeftChildIndex(index) < size;
//   }
//
//   private boolean hasRightChild(int index) {  //children must be smaller
//       return getRightChildIndex(index) < size;
//   }
//
//   private boolean hasParent(int index) {  //parents are at the top
//       return getParentIndex(index) >= 0;
//   }
//   private int leftChild(int parentIndex) {
//       return heap[getLeftChildIndex(parentIndex)];
//   }
//
//   private int rightChild(int parentIndex) {
//       return heap[getRightChildIndex(parentIndex)];
//   }
//
//   private int parent(int childIndex) {
//       return heap[getParentIndex(childIndex)];
//   }
//
////Determining the order
//   private void swap(int index1, int index2) {
//       int element = heap[index1];
//       heap[index1] = heap[index2];
//       heap[index2] = element;
//   }
//
//   private void ensureCapacity() {
//       if (size == capacity) {
//           heap = Arrays.copyOf(heap, capacity * 2);
//           capacity = capacity * 2;
//       }
//   }
//
//   // Time Complexity : O(1) --> root element of minHeap
//   private int peek() {
//       if (size == 0) {
//           throw new NoSuchElementException();
//       }
//       return heap[0];
//   }
//
//   // Time Complexity : O( Log n) --> removing nodes/towns
//   private int remove() {
//       if (size == 0) {
//           throw new NoSuchElementException();
//       }
//
//       int element = heap[0];
//
//       heap[0] = heap[size - 1];
//       size--;
//       heapifyDown();
//       return element;
//   }
//
//   // Time Complexity : O( Log n) --> adding nodes/ towns
//   public void add(int item) {
//       ensureCapacity();
//       heap[size] = item;
//       size++;
//       heapifyUp();
//   }
//
//   //determines the parent
//   private void heapifyUp() {
//       int index = size - 1;
//
//       while (hasParent(index) && parent(index) > heap[index]) {
//           swap(getParentIndex(index), index);
//           index = getParentIndex(index);
//       }
//   }
//
//   //determines the smallest child/ order
//   private void heapifyDown() {
//       int index = 0;
//
//       while (hasLeftChild(index)) {
//           int smallestChildIndex = getLeftChildIndex(index);
//
//           if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
//               smallestChildIndex = getRightChildIndex(index);
//           }
//
//           if (heap[index] < heap[smallestChildIndex]) {
//               break;
//           } else {
//               swap(index, smallestChildIndex);
//           }
//           index = smallestChildIndex;
//       }
//   }
//
//   public void print() {
//       for (int i = 1; i <= size / 2; i++) {
//
//           // Printing the parent and both childrens
//           System.out.print(
//                   " PARENT : " + heap[i]
//                   +"LEFT CHILD: " +heap[2 * i]
//                   +"RIGHT CHILD: " + heap[2 * 1 + 1]);
//
//           System.out.println();
//       }
//   }
//
//}

//Line's code
 import java.util.HashMap;

 public class MinHeap<Town extends Comparable<Town> >{
    HashMap<Town,Integer> positionTable=new HashMap<>();

    // root is at index 0
    ArrayList<Town> minheap;
    private int size;
    public MinHeap(){
        this.minheap=new ArrayList<Town>();
        this.size=0;
    }
    public int getPosition(Town item){
        return positionTable.get(item);
    }
    public boolean isEmpty(){
        return size <= 0;
    }
    private int Parent(int pos){
        return (pos-1)/2;
    }
    private int leftChild(int pos){
        return pos*2 +1;
    }
    private int rightChild(int pos){
        return pos*2 +2;
    }
    private void swap(int pos1, int pos2){
        Town dummy= minheap.get(pos1);

        minheap.set(pos1, minheap.get(pos2));
        minheap.set(pos2,dummy);
        positionTable.put(minheap.get(pos1),pos1);
        positionTable.put(minheap.get(pos2),pos2);
    }
    public void Insert(Town item){
        minheap.add(item);
        positionTable.put(item,size);
        size++;
        decreasekey(size-1);
    }
    public void decreasekey(int pos){
        int currentpos=pos;
        while (minheap.get(currentpos).compareTo(minheap.get(Parent(currentpos)))<0){
            swap(currentpos,Parent(currentpos));
            currentpos=Parent(currentpos);
        }
    }

    public Town viewMin(){
        return minheap.get(0);
    }
    private boolean movedown(int pos){
        boolean leftsmaller = leftChild(pos)<size
                && (minheap.get(leftChild(pos)).compareTo(minheap.get(pos))<0);
        boolean rightsmaller = rightChild(pos)<size
                && (minheap.get(rightChild(pos)).compareTo(minheap.get(pos))<0);
        return leftsmaller || rightsmaller;
    }
    public void increasekey(int pos){
        int currentpos=pos;
        while (movedown(currentpos))
        {
            int rpos= rightChild(currentpos);
            int lpos= leftChild(currentpos);
            if (rpos< size && minheap.get(rpos).compareTo(minheap.get(lpos))<0){
                swap(rpos,currentpos);
                currentpos=rpos;
            }
            else{
                swap(lpos,currentpos);
                currentpos=lpos;
            }
        }
    }
    dont have this??
    public Town extractMin(){
        Town min = minheap.get(0);
        minheap.set(0, minheap.get(size-1));
        positionTable.put(minheap.get(0),0);
        size--;
        increasekey(0);
        return min;
    }
 }

    
  