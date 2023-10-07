package Structer;

public class LinkList {
  public static void main(String[] args) {
    LinkList check = new LinkList();
    check.addElementBack(1);
    check.addElementBack(2);
    check.addElementBack(3);
    check.print();
    System.out.println("index of element: " + check.indexOfElem(3));
    System.out.println("element by index: " + check.getElementByIndex(2));
  }

  class Node {
    int n;
    Node next;

    public int getN() {
      return n;
    }

    public void setN(int n) {
      this.n = n;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }

  private Node head;
  private Node tail;

  public void addElemntFront(int data) {
    Node tmp = new Node();
    tmp.setN(data);

    if(this.head == null) {
      this.head = tmp;
      this.tail = tmp;
    } else {
      tmp.setNext(this.head);
      this.head = tmp;
    }
  }

  public void addElementBack(int data) {
    Node tmp = new Node();
    tmp.setN(data);

    if(this.head == null) {
      this.head = tmp;
      this.tail = tmp;
    } else {
      this.tail.setNext(tmp);
      this.tail = tmp;
    }
  }

  public void print() {
    Node tmp = this.head;
    while(tmp != null) {
      System.out.println(tmp.getN() + " ");
      tmp = tmp.getNext();
    }
  }

  public int indexOfElem(int n) {
    Node tmp = this.head;
    int count = -1;
    while(tmp != null) {
      count++;
      if(tmp.getN() == n) {
        return count;
      }
      tmp = tmp.getNext();
    }
    return count;
  }

  public int getElementByIndex(int i) {
    Node tmp  = this.head;
    int count = -1;
    while(tmp != null) {
      count++;
      if(count == i) {
        return tmp.getN();
      }
      tmp = tmp.getNext();
    }
    return count;
  }
}


