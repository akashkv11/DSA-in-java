import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinHeap {

    List<Integer> heap = new ArrayList<>();

    public MinHeap() {

    }

    public MinHeap(List<Integer> array) {
        buildHeap(array);
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(3, 2, 4));

        MinHeap heap = new MinHeap(array);

        heap.display();
        heap.insert(7)
        ;
        heap.insert(88);
        heap.insert(19);
        heap.display();
        heap.remove();
        heap.display();
    }

    private void buildHeap(List<Integer> array) {
        heap = array;
        int i = parent(heap.size() - 1);
        while (i > -1) {
            shiftDown(i);
            i--;
        }
    }

    private void shiftDown(int currentIdx) {
        int endIndex = heap.size() - 1;
        int leftIndex = leftChild(currentIdx);
        while (leftIndex <= endIndex) {
            int rightIndex = rightChild(currentIdx);
            int indexToShift;
            if (rightIndex <= endIndex && heap.get(rightIndex) < heap.get(leftIndex)) {
                indexToShift = rightIndex;

            } else {
                indexToShift = leftIndex;
            }
            if (heap.get(currentIdx) > heap.get(indexToShift)) {
                Collections.swap(heap, currentIdx, indexToShift);
                currentIdx = indexToShift;
                leftIndex = leftChild(currentIdx);

            } else {
                return;

            }


        }
    }

    private void shiftUp(int currentIdx) {
        int parentIndex = parent(currentIdx);
        while (currentIdx > 0 && heap.get(parentIndex) > heap.get(currentIdx)) {
            Collections.swap(heap, currentIdx, parentIndex);
            currentIdx = parentIndex;
            parentIndex = parent(currentIdx);
        }

    }

    public int peek() {
        if (heap.isEmpty()) {
            System.out.println("No elements in heap");
            return 0;
        }
        return heap.get(0);
    }


    public void remove() {
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        shiftDown(0);
    }

    public void insert(int value) {
        heap.add(value);
        shiftUp(heap.size() - 1);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    public void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap.get(i));
        }
    }

}
