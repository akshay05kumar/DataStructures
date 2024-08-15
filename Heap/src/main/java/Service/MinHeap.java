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
        heapifyFromTop();

        return topValue;
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

    private void heapifyFromTop() {
        int currentIndex = 0, minIndex = 0;
        while(currentIndex < currentHeapSize) {
            if (leftChild(currentIndex) < currentHeapSize && heap[leftChild(currentIndex)] < heap[currentIndex])
                minIndex = leftChild(currentIndex);
            if (rightChild(currentIndex) < currentHeapSize && heap[rightChild(currentIndex)] < heap[minIndex])
                minIndex = rightChild(currentIndex);
            if(currentIndex != minIndex) {
                swapNodes(currentIndex, minIndex);
                heapifyFromTop();
            }
        }
    }
}
