//This is base code for minHeap before I implement for our specific conditions.

public class minHeap(){
    int [] heap;
    int size;
    int capacity;

    //constructor
    public minHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        heap = new int[this.capacity+1];
        heap[0]= Integer.MIN_VALUE;
    }

//using The root element will be at Arr[0].
// Arr[(i-1)/2] : Returns the parent node
//• Arr[(2*i)+1] : Returns the left child node
//• Arr[(2*i)+2] : Returns the right child node
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    //checking size
    private boolean hasLeftChild(int index) {   //children must be smaller
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {  //children must be smaller
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {  //parents are at the top
        return getParentIndex(index) >= 0;
    }
    private int leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    //multiple places had this swap but dont know why and if we need it
    //this allows the mst to be organized
    private void swap(int index1, int index2) {
        int element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    // Time Complexity : O(1) --> root element of minHeap
    private int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    // Time Complexity : O( Log n) --> removing nodes/towns
    private int remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int element = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return element;
    }

    // Time Complexity : O( Log n) --> adding nodes/ towns
    public void add(int item) {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    //determines the parent
    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    //determines the smallest child/ order
    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallestChildIndex = getRightChildIndex(index);
            }

            if (heap[index] < heap[smallestChildIndex]) {
                break;
            } else {
                swap(index, smallestChildIndex);
            }
            index = smallestChildIndex;
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + heap[i]
                    +"LEFT CHILD: " +heap[2 * i]
                    +"RIGHT CHILD: " + heap[2 * 1 + 1]);

            System.out.println();
        }
    }

    //If everything checks, all below is written in Main class

//    System.out.println("The Min Heap is ");
//
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
//        minHeap.insert(15);
//
//
//    // Print all elements of the heap
//        minHeap.print();
//
//    // Removing minimum value from above heap
//    // and printing it
//        System.out.println("The Min val is "
//                + minHeap.remove());


}