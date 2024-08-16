package Service;

public class MinHeap extends Heap{
    public MinHeap(int heapSize) {
        super(heapSize);
    }

    @Override
    public void changeValueAtIndex(int index, int newValue) {

    }

    @Override
    public void heapifyFromBottom() {
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

    @Override
    public void heapifyFromTop(int index) {
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

