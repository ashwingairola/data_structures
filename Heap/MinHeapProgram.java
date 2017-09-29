/*
Program to implement min-heap.
Operations:
1. Insertion
2. Deletion
*/
import java.util.Arrays;

class MinHeap
{
  private int[] items;
  private int heapSize, maxCapacity;

  public MinHeap()
  {
    maxCapacity = 10;
    items = new int[maxCapacity];
  }

  // Helper methods
  private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
  private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
  private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

  private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < heapSize; }
  private boolean hasRightChild(int index) { return getRightChildIndex(index) < heapSize; }
  private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

  private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
  private int rightChild(int index) { return items[getRightChildIndex(index)]; }
  private int parent(int index) { return items[getParentIndex(index)]; }
  //Helper methods end

  // In order to make sure the heap never overflows while inserting.
  private void ensureMaxCapacity()
  {
    if(heapSize == maxCapacity)
    {
      items = Arrays.copyOf(items, maxCapacity * 2);
      maxCapacity *= 2;
    }
  }

  // Method to insert a key into the heap.
  public void insert(int key)
  {
    ensureMaxCapacity();
    items[heapSize++] = key;
    heapifyUp(heapSize - 1);
  }

  // If the current index has its key < its parent's key, float it upwards in the heap.
  private void heapifyUp(int index)
  {
    while(hasParent(index) && parent(index) > items[index])
    {
      swap(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  // Method to delete a key from the heap.
  public void delete(int key)
  {
    int index = search(key);
    if(index == -1) { return; }
    items[index] = items[heapSize - 1];
    items[heapSize - 1] = 0;
    heapSize--;
    if(items[index] < parent(index))
    {
      heapifyUp(index);
    }
    else
    {
      heapifyDown(index);
    }
  }

  // If the current index has its key > its children's keys, sink it downwards in the heap.
  private void heapifyDown(int index)
  {
    // Initially check for the left child only, because a right child can't exist without a left child.
    while(hasLeftChild(index))
    {
      int smallerChildIndex = getLeftChildIndex(index);
      // It can be possible that if a right child exists, it can have the lesser key of the two children.
      // If so, set that index as the one to be swapped with.
      if(hasRightChild(index) && rightChild(index) < leftChild(index))
      {
        smallerChildIndex = getRightChildIndex(index);
      }

      if(items[index] > items[smallerChildIndex])
      {
        swap(index, smallerChildIndex);
        index = smallerChildIndex;
      }
      else
      {
        break;
      }
    }
  }

  // Utility method for swapping two indices.
  private void swap(int index, int otherIndex)
  {
    int temp = items[index];
    items[index] = items[otherIndex];
    items[otherIndex] = temp;
  }

  // Utility method to perform linear search.
  private int search(int key)
  {
    for(int i=0; i<heapSize; ++i)
    {
      if(items[i] == key)
      {
        return i;
      }
    }
    return -1;
  }

  // Overriding toString() method for convenience of printing the entire heap.
  public String toString()
  {
    StringBuilder heapString = new StringBuilder("[ ");
    for(int i=0; i<heapSize; ++i)
    {
      heapString.append(items[i] + " ");
    }
    heapString.append("]");
    return heapString.toString();
  }
}

public class MinHeapProgram
{
  public static void main(String[] args)
  {
    MinHeap minHeap = new MinHeap();
    minHeap.insert(10);
    minHeap.insert(15);
    minHeap.insert(20);
    minHeap.insert(17);
    minHeap.insert(25);
    System.out.println("\nOriginal min-heap:\n" + minHeap);
    minHeap.insert(8);
    System.out.println("\nAfter inserting 8:\n" + minHeap);
    minHeap.delete(10);
    System.out.println("\nAfter deleting 10:\n" + minHeap);
  }
}
