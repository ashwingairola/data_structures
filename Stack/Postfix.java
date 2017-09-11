public class Postfix
{
  static int[] stack;
  static int top = -1;
  public static void main(String[] args)
  {
    String postfix = "231*+9-";
    evaluatePostfix(postfix);
  }

  public static void evaluatePostfix(String postfix)
  {
    stack = new int[postfix.length()];
    for(int i=0; i<postfix.length(); ++i)
    {
      char ch = postfix.charAt(i);
      int x1, x2;
      switch(ch)
      {
        case '+':
          x1 = pop();
          x2 = pop();
          push(x2 + x1);
          break;

        case '-':
          x1 = pop();
          x2 = pop();
          push(x2 - x1);
          break;

        case '*':
          x1 = pop();
          x2 = pop();
          push(x2 * x1);
          break;

        case '/':
          x1 = pop();
          x2 = pop();
          push(x2 / x1);
          break;

        default:
          push(ch - '0');
      }
    }
    System.out.println(stack[0]);
  }

  public static void push(int num)
  {
    if(top == stack.length)
    {
      System.out.println("Stack overflow");
    }
    else
    {
      stack[++top] = num;
    }
  }

  public static int pop()
  {
    if(top < 0)
    {
      System.out.println("Stack underflow");
      return -9999;
    }
    else
    {
      int popped = stack[top--];
      return popped;
    }
  }
}
