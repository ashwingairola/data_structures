import java.util.Scanner;

public class ArrayRotationJuggling
{
  public static int[] rotateArray(int[] arr, int l, int d)
  {
    int gcd = gcd(l, d);
    for(int i=0; i<d; ++i)
    {
      while(i < d)
      {
        int temp = arr[i];
        //arr[i] = ((i - d) < 0) ? arr[l - d + i] : arr[i - d];
        if((i - d) < 0)
        {
          arr[i] = arr[l - d + i];
          arr[l - d + i] = temp;
        }
        else
        {
          arr[i] = arr[i - d];
          arr[i - d] = temp;
        }
      }
    }

    return arr;
  }

  private static int gcd(int a, int b)
  {
    if(b == 0)
    {
      return a;
    }
    else
    {
      return gcd(b, a % b);
    }
  }

  public static void displayArr(int[] arr)
  {
    for(int num: arr)
    {
      System.out.print(num + " ");
      System.out.println("");
    }
  }

  public static void main(String[] args)
  {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    displayArr(arr);
    arr = rotateArray(arr, arr.length, 2);
    displayArr(arr);
  }
}
