// Find whether an array is subset of another array.
// Given two arrays: arr[0..m-1] and brr[0..n-1].
// Find whether arr2[] is a subset of arr1[] or not.
// Both the arrays are not in sorted order.
import java.util.HashSet;

public class ArraySubset
{
  public static void main(String[] args)
  {
    int[] arr = {11, 1, 13, 21, 3, 3, 7};
    int[] brr = {11, 3, 7};
    if(isSubset(arr, brr))
      System.out.println("2nd array is a subset of the 1st.");
    else
      System.out.println("Not a subset.");
  }

  public static boolean isSubset(int[] arr, int[] brr)
  {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<arr.length; ++i)
    {
      set.add(arr[i]);
    }

    for(int i=0; i<brr.length; ++i)
    {
      if(!set.contains(brr[i]))
      {
        return false;
      }
    }
    return true;
  }
}
