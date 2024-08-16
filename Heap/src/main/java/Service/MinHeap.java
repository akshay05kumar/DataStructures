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
        heapifyFromTop(0);

        return topValue;
    }

    @Override
    public void deleteKey(int index) {
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

    private void heapifyFromTop(int index) {
        int currentIndex = index, minIndex = index;
        while(true) {
            if (leftChild(currentIndex) < currentHeapSize && heap[leftChild(currentIndex)] < heap[currentIndex])
                minIndex = leftChild(currentIndex);
            if (rightChild(currentIndex) < currentHeapSize && heap[rightChild(currentIndex)] < heap[minIndex])
                minIndex = rightChild(currentIndex);
            if(currentIndex == minIndex)
                return;
            swapNodes(currentIndex, minIndex);
            currentIndex = minIndex;
        }
    }
}

