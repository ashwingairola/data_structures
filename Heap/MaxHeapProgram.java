/*
Program to implement max-heap.
Operations:
1. Insertion
2. Deletion
*/
import java.util.Arrays;

class MaxHeap
{
  int[] items;
  int heapSize, maxCapacity;

  public MaxHeap()
  {
    maxCapacity = 10;
    items = new int[maxCapacity];
  }

  // Helper methods
  private int getLeftChildIndex(int index) { return 2 * index + 1; }
  private int getRightChildIndex(int index) { return 2 * index + 2; }
  private int getParentIndex(int index) { return (index - 1) / 2; }

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
      maxCapacity *= 2;
      items = Arrays.copyOf(items, maxCapacity);
    }
  }

  // Method to insert a key into the heap.
  public void insert(int key)
  {
    ensureMaxCapacity();
    items[heapSize++] = key;
    heapifyUp(heapSize - 1);
  }

  // If the current index has its key > its parent's key, float it upwards in the heap.
  private void heapifyUp(int index)
  {
    while(hasParent(index) && parent(index) < items[index])
    {
      swap(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  // Method to delete a key from the heap.
  public void delete(int key)
  {
    int index = search(key);
    if(index == -1)
    {
      return;
    }

    items[index] = items[heapSize - 1];
    items[heapSize - 1] = 0;
    heapSize--;

    if(items[index] > parent(index))
    {
      heapifyUp(index);
    }
    else
    {
      heapifyDown(index);
    }
  }

  // If the current index has its key < its children's keys, sink it downwards in the heap.
  private void heapifyDown(int index)
  {
    // Initially check for the left child only, because a right child can't exist without a left child.
    while(hasLeftChild(index))
    {
      int smallerChildIndex = getLeftChildIndex(index);
      // It can be possible that if a right child exists, it can have the greater key of the two children.
      // If so, set that index as the one to be swapped with.
      if(hasRightChild(index) && rightChild(index) > leftChild(index))
      {
        smallerChildIndex = getRightChildIndex(index);
      }

      if(items[index] < items[smallerChildIndex])
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
    for(int i=0; i<items.length; ++i)
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

// Driver class
public class MaxHeapProgram
{
  public static void main(String[] args)
  {
    MaxHeap maxHeap = new MaxHeap();
    maxHeap.insert(10);
    maxHeap.insert(15);
    maxHeap.insert(20);
    maxHeap.insert(17);
    maxHeap.insert(25);
    System.out.println("\nOriginal max-heap:\n" + maxHeap);
    maxHeap.insert(8);
    System.out.println("\nAfter inserting 8:\n" + maxHeap);
    maxHeap.delete(10);
    System.out.println("\nAfter deleting 10:\n" + maxHeap);
  }
}
