package Factory;

import Model.HeapType;
import Service.Heap;
import Service.MinHeap;

public class HeapObjectFactory {
    public Heap getHeapObject(HeapType heapType, int heapSize) {
        if(heapType == HeapType.MINHEAP) {
            return new MinHeap(heapSize);
        }
        throw new IllegalArgumentException("Parameters passed to create heap are not correct: heapSize =  " + heapSize + ", heapType = " + heapType);
    }
}
