import Factory.HeapObjectFactory;
import Model.HeapType;
import Service.Heap;

import java.util.Scanner;

public class Main {
    public static void main(String args[])  //static method
    {
        System.out.println("Hello from main method");
        Scanner scanner = new Scanner(System.in);

        //we need an object of factory
        HeapObjectFactory heapObjectFactory = new HeapObjectFactory();
        try{
            Heap heap = heapObjectFactory.getHeapObject(HeapType.MINHEAP, 7);

            while(true) {
                try{
                    System.out.println("Chose operation:");
                    int input = scanner.nextInt();

                    if(input == 1) {
                        heap.printHeap();
                        continue;
                    }
                    if(input == 2) {
                        System.out.println("Enter key to insert");
                        int key = scanner.nextInt();
                        heap.insertKey(key);
                        continue;
                    }
                    if(input == 3) {
                        int key = heap.extractTopElement();
                        System.out.println("extracted top element = " + key);
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }

            }
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

