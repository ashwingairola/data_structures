public class ArrayRotation
{
  public static void main(String[] args)
  {
    int d = 2, i = 0, n = 7;
    int[] arr = {1,2,3,4,5,6,7}, temp = new int[d];

    for(i=0; i<d; ++i)
    {
      temp[i] = arr[i];
    }

    for(i=d; i<n; ++i)
    {
      arr[i-d] = arr[i];
    }

    int x=0;
    for(i=n-d; i<n; ++i)
    {
      arr[i] = temp[x];
      x++;
    }

    for(i=0; i<n; ++i)
    {
      System.out.print(arr[i] + " ");
    }
  }
}
