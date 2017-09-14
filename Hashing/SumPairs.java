// Given an array A[] and a number x, check for pair in A[] with sum as x:
// Write a program that, given an array A[] of n numbers and another number x, 
// determines whether or not there exist two elements in S whose sum is exactly x.
import java.util.HashSet;

public class SumPairs
{
  public static boolean hasPair(int[] arr, int sum)
  {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<arr.length; ++i)
    {
      set.add(arr[i]);
    }
    for(int i=0; i<arr.length; ++i)
    {
      if(set.contains(sum - arr[i]))
      {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args)
  {
    int[] arr = {1, 4, 45, 6, 10, 8};
    int sum = 16;
    if(hasPair(arr, sum))
      System.out.println("The array has at least a pair whose sum equals to the given sum.");
    else
      System.out.println("No pairs found.");
  }
}
