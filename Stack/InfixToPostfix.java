/*
Infix-to-Postfix Conversion.

Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
…..3.2 Else, Pop the operator from the stack
      until the precedence of the scanned operator is less-equal to the precedence of the operator residing on the top of the stack.
      Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty.
*/
import java.util.Stack;

public class InfixToPostfix
{
  public static String infixToPostfix(String infix)
  {
    StringBuilder postfix = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for(int i=0; i<infix.length(); ++i)
    {
      char ch = infix.charAt(i);
      if(Character.isLetterOrDigit(ch))
      {
        postfix.append(ch);
      }
      else if(ch == '(')
      {
        stack.push(ch);
      }
      else if(ch == ')')
      {
        while(!stack.isEmpty() && stack.peek() != '(')
        {
          postfix.append(stack.pop());
        }

        if(!stack.isEmpty() && stack.peek() != '(')
        {
          return "Invalid expression.";
        }
        else
        {
          stack.pop();
        }
      }
      else
      {
        while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
        {
          postfix.append(stack.pop());
        }
        stack.push(ch);
      }
    }

    while(!stack.isEmpty())
    {
      postfix.append(stack.pop());
    }
    return postfix.toString();
  }

  public static int precedence(char operator)
  {
    switch(operator)
    {
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;

      case '^':
        return 3;
    }

    return -1;
  }

  public static void main(String[] args)
  {
    String infix = "a+b*(c^d-e)^(f+g*h)-i";
    String postfix = infixToPostfix(infix);
    System.out.println(postfix);
  }
}
