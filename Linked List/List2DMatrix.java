/*
Construct a linked list from 2D matrix
Given a matrix.
Convert it into a linked list matrix,
such that each node is connected to its next right and down node.

Example:
Input : 2D matrix
1 2 3
4 5 6
7 8 9

Output :
1 -> 2 -> 3 -> NULL
|    |    |
v    v    v
4 -> 5 -> 6 -> NULL
|    |    |
v    v    v
7 -> 8 -> 9 -> NULL
|    |    |
v    v    v
NULL NULL NULL
*/
/*
Algorithm:
1.  Create 3 pointers - current, rowStart and prev - all initially null.
    The pointer prev traverses the previous row, current traverses the current row,
    and rowStart points to the starting node of each row.
2.  For every element row the matrix (i loop):
3.    For every element in each row (j loop):
4.      If current is null (beginning of each row), then:
5.        Assign a new node containing matrix[i][j] as key.
6.        Set rowStart to current.
7.        And if start is also null (the very first node), set start to current.
8.        End the current iteration and move to the next one (continue).
9.      End if
10.     Else:
11.       Assign current.next to a new node containing matrix[i][j] as key.
12.       If prev != null (i.e., the current row is NOT the first row), then:
13.         prev.down = current (prev.down points to the current node, thus forming a column)
14.         prev = prev.next (Move further in the previous row)
15.       End if
16.       current = current.next (Move further in the current row)
17.       If j == matrix[i].length-1 (If we have reached the end of the current row), then:
18.         prev = rowStart (Move prev pointer to the starting of the current row,
            which will become the previous row in the next iteration)
19.         rowStart = rowStart.down (Always initially null)
20.         current = rowStart (Move to the next row)
21.       End if
22.     End else
23.   End j loop
22. End i loop
*/
class Node
{
  int key;
  Node next, down;

  public Node(int key)
  {
    this.key = key;
  }
}

class LinkedMatrix
{
  private Node start;

  public Node getStart()
  {
    return start;
  }

  private void setStart(Node start)
  {
    this.start = start;
  }

  public void createLinkedMatrix(int[][] matrix)
  {
    Node current = null, rowStart = null, prev = null;
    for(int i=0; i<matrix.length; ++i)
    {
      for(int j=0; j<matrix[i].length; ++j)
      {
        if(current == null)
        {
          current = new Node(matrix[i][j]);
          rowStart = current;
          if(this.start == null)
          {
            this.setStart(current);
          }
          continue;
        }

        current.next = new Node(matrix[i][j]);
        if(prev != null)
        {
          prev.down = current;
          prev = prev.next;
        }

        current = current.next;

        if(j == matrix[i].length-1)
        {
          prev = rowStart;
          rowStart = rowStart.down;
          current = rowStart;
        }
      }
    }
  }

  public void displayLinkedMatrix()
  {
    if(start == null)
    {
      System.out.println("Matrix empty.");
      return;
    }

    Node current = start, rowStart = start;
    while(rowStart != null)
    {
      while(current != null)
      {
        System.out.print(current.key + " ");
        current = current.next;
      }
      System.out.println("");

      rowStart = rowStart.down;
      current = rowStart;
    }
  }
}

public class List2DMatrix
{
  public static void main(String[] args)
  {
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    LinkedMatrix lm = new LinkedMatrix();
    lm.createLinkedMatrix(matrix);
    lm.displayLinkedMatrix();
  }
}
