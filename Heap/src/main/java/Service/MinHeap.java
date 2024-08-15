package Service;

public class MinHeap extends Heap{
    public MinHeap(int heapSize) {
        super(heapSize);
    }

    @Override
    public void insertKey(int key) {
        if(isHeapFull()) {
            throw new ArrayIndexOutOfBoundsException("Heap is full, can't insert the key");
        }

        currentHeapSize++;
        heap[currentHeapSize-1] = key;
        heapify();
    }

    @Override
    public int extractTopElement() {
        return 0;
    }

    @Override
    public void deleteKey(int index) {

    }

    @Override
    public void changeValueAtIndex(int index, int newValue) {

    }

    private void heapify() {
        int index = currentHeapSize-1;
        while (parent(index) >= 0 && heap[parent(index)] > heap[index]) {
            swapNodes(index, parent(index));
            index = parent(index);
        }
    }

    private void swapNodes(int firstIndex, int secondIndex) {
        int temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }
}
