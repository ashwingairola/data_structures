/*
Program to implement Heapsort.

Algorithm:
1. Take an array as input.
2. Convert it into a max-heap.
3. Working in a bottom-up manner, for all elements:
4. Swap the element with the one at the root.
5. Restore the heap property.
*/
class MaxHeap
{
  int[] arr;
  int heapSize, maxCapacity;

  public MaxHeap(int[] arr)
  {
    this.arr = arr;
    maxCapacity = heapSize = arr.length;
  }

  // Utility method for swapping at two indices.
  private void swap(int index, int otherIndex)
  {
    int temp = arr[index];
    arr[index] = arr[otherIndex];
    arr[otherIndex] = temp;
  }

  // Restores the heap property for the current index.
  private void maxHeapify(int index)
  {
    // 1. Get the left and the right child indices.
    int left = 2 * index + 1;
    int right = 2 * index + 2;

    // 2. If the left child index is within heap size and heap property is violated,
    // set largest to left else to current index.
    int largest = (left < heapSize && arr[left] > arr[index]) ? left : index;

    // 3. If the right child index is within heap size and heap property is violated,
    // set largest to right else leave it be.
    largest = (right < heapSize && arr[right] > arr[largest]) ? right : largest;

    // 4. If largest is not the same as the current index,
    // swap the elements at largest and the current index, and
    // make a recursive call to restore the heap property at largest.
    if(largest != index)
    {
      swap(index, largest);
      maxHeapify(largest);
    }
  }

  // Converts the array into a max-heap.
  private void buildMaxHeap()
  {
    // We only need to work bottom-up on the first half of the heap since the
    // second half consists of only leaves and has no children.
    for(int i = heapSize / 2 - 1; i >= 0; --i)
    {
      maxHeapify(i);
    }
  }

  // The heapsort method. Follows the above algorithm.
  public void heapSort()
  {
    buildMaxHeap();
    for(int i = arr.length - 1; i > 0; --i)
    {
      swap(0, i);
      heapSize--;
      maxHeapify(0);
    }
  }

  // Utility method for printing the heap.
  public String toString()
  {
    StringBuilder result = new StringBuilder("[ ");
    for(int key : arr)
    {
      result.append(key + " ");
    }
    result.append("]");
    return result.toString();
  }
}

public class HeapSortProgram
{
  public static void main(String[] args)
  {
    MaxHeap heap = new MaxHeap(new int[]{16, 4, 9, 14, 7, 10, 3, 2, 8, 1});
    System.out.println("\nBefore Heapsort:\n" + heap);
    heap.heapSort();
    System.out.println("\nAfter Heapsort:\n" + heap);
  }
}
