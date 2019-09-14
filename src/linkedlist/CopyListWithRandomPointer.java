/*
Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.



Example 1:

Input:
{
  "$id": "1",
  "next": {
    "$id": "2",
    "next": null,
    "random": {
      "$ref": "2"
    },
    "val": 2
  },
  "random": {
    "$ref": "2"
  },
  "val": 1
}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.



Note:

    You must return the copy of the given head as a reference to the cloned list.

*/
package linkedlist;

import java.util.*;

class CopyListWithRandomPointer {
  static class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
      val = _val;
      next = _next;
      random = _random;
    }
  }

  public static void main(String []args){
    Node next = new Node(1, null, null);
    next.random = next;
    Node n1 = new Node(1, next, next);

    new CopyListWithRandomPointer().copyRandomList(n1);

  }



  public Node copyRandomList(Node head) {
    Map<Integer, Node> idx2Pointer = new HashMap<>();
    Map<Integer,Integer> idx2RandomIdx = new HashMap<>();
    Map<Node,Integer> pointer2Index = new HashMap<>();

    // build original pointers
    int i = 0;
    Node headPointer = head;

    while (headPointer != null) {
      pointer2Index.put(headPointer, i);
      i++;
      headPointer = headPointer.next;
    }

    //build random pointers
    i = 0;
    headPointer = head;

    while(headPointer != null) {
      idx2RandomIdx.put(i++, pointer2Index.get(headPointer.random));
      headPointer = headPointer.next;
    }

    i=0;
    headPointer = head;
    Node newHead = null;
    Node output = null;

    while(headPointer != null){
      if(newHead == null){
        newHead = new Node(headPointer.val, null,null);
        output = newHead;
      } else {
        newHead.next = new Node(headPointer.val, null,null);
        newHead = newHead.next;
      }
      idx2Pointer.put(i++, newHead);
      headPointer = headPointer.next;
    }


    i = 0;

    headPointer = output;

    while (headPointer != null) {
      Node random = idx2Pointer.get(idx2RandomIdx.get(i++));
      headPointer.random = random;
      headPointer = headPointer.next;
    }

    return output;
  }
}