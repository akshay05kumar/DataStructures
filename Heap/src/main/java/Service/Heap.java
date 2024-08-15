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

    public int returnTopElement() {
        if(isHeapFull()) {
            throw new RuntimeException("Heap is full");
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
    }

    public abstract void insertKey(int key);

    public abstract int extractTopElement();

    public abstract void deleteKey(int index);

    public abstract void changeValueAtIndex(int index, int newValue);

    //validate base case
    public boolean isHeapFull() {
        if(heap.length == currentHeapSize-1) {
            return true;
        }
        return false;
    }


}
