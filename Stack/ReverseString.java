import java.io.*;

public class ReverseString
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter a string");
    String str = br.readLine();
    char[] stack = new char[str.length()];
    push(stack, str);
    StringBuilder reverse = pop(stack);
    System.out.println(reverse);
  }

  public static void push(char[] stack, String str)
  {
    for(int top=0; top<str.length(); ++top)
    {
      stack[top] = str.charAt(top);
    }
  }

  public static StringBuilder pop(char[] stack)
  {
    StringBuilder reverse = new StringBuilder();
    for(int top=stack.length-1; top>=0; --top)
    {
      reverse.append(stack[top]);
      stack[top] = '\u0000';
    }
    return reverse;
  }
}
