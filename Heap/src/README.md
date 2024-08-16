**Problem Statement:**
1. We need binary heap implementation, at run time we will get to know whether its a min heap or max heap.
2. It should support following operations:
   1. We should be able to initialize the min-heap or maxheap with a size.
   2. We should be able to print all the values of heap in level order traversal.
   3. We should be able to add a value in the heap.
   4. We should be able to extract the top value from heap.
   5. We should be able to delete a value at given index.

**Solution:**
1. We have an abstract class heap that contains all the methods' implementation that are applicable to both heaps like parent for an element, left and right child of element etc.
2. Even other major operations are also same like adding/deleting a value, extracting the min etc. They only differ at heapifying after a change.
3. So we have 2 abstract methods "HeapifyFromTop" and "Heapify from bottom". Min heap and max heap will extend this abstract class and will provide their own implementation.
4. There is a factory class that provides a heap object depending upon user's input at runtime.

**Implementation of maxheap is not provided, yet.**