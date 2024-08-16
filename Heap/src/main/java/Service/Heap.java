package Service;

public abstract class Heap {
    private int heapSize;
    public int currentHeapSize;
    public int[] heap;

    public Heap(int heapSize) {
        this.heapSize = heapSize;
        heap = new int[heapSize];
        currentHeapSize = 0;
    }

    public int parent(int i) {
        return (i-1)/2;
    }

    public int leftChild(int i) {
        return 2*i+1;
    }

    public int rightChild(int i) {
        return 2*i+2;
    }

    public int returnTopElement() throws Exception {
        if(isHeapFull()) {
            throw new Exception("Heap is full");
        }
        return heap[0];
    }

    public void printHeap() {
        if(currentHeapSize == 0) {
            System.out.println("Heap is empty");
            return;
        }

        for (int i=0; i<currentHeapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println("");
    }

    public void insertKey(int key) {
        if(isHeapFull()) {
            throw new ArrayIndexOutOfBoundsException("Heap is full, can't insert the key");
        }
        currentHeapSize++;
        heap[currentHeapSize-1] = key;
        heapifyFromBottom();
    }

    public abstract void heapifyFromBottom();

    public int extractTopElement() {
        if(isHeapEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        int topValue = heap[0];

        if(currentHeapSize == 1) {
            currentHeapSize--;
            return topValue;
        }
        heap[0] = heap[currentHeapSize-1];
        currentHeapSize--;
        heapifyFromTop(0);

        return topValue;
    }

    public void deleteKey(int index){
        if(isHeapEmpty()) {
            throw new RuntimeException("Heap is already empty");
        }
        if(index >=currentHeapSize) {
            throw new RuntimeException("Provided index is out of current heap size");
        }
        currentHeapSize--;
        if(currentHeapSize == 0) {
            System.out.println("Key is deleted");
            return;
        }

        //replace the index value with last element
        heap[index] = heap[currentHeapSize];
        heapifyFromTop(index);
        System.out.println("Key is deleted");
    }

    public abstract void changeValueAtIndex(int index, int newValue);

    public abstract void heapifyFromTop(int index);

    //validate base case
    public boolean isHeapFull() {
        if(currentHeapSize == heapSize) {
            return true;
        }
        return false;
    }

    public boolean isHeapEmpty() {
        if(currentHeapSize == 0)
            return true;
        return false;
    }
}
