package Structer;

public class DualLinkList<T> {

  public static void main(String[] args) {
    DualLinkList<Integer> a = new DualLinkList<Integer>();
    a.addBack(1);
    a.addBack(2);
    a.addBack(3);
    a.addBack(4);
    a.addFront(1);
    a.print();
  }
  class Node<T> {
    Node next;
    Node prev;
    T n;

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public Node getPrev() {
      return prev;
    }

    public void setPrev(Node prev) {
      this.prev = prev;
    }

    public T getN() {
      return n;
    }

    public void setN(T n) {
      this.n = n;
    }
  }
  Node head;
  Node tail;

  public void addBack(T data) {
    Node<T> tmp = new Node<T>();
    tmp.setN(data);

    if(this.head == null) {
      this.head = tmp;
      this.tail = tmp;
    } else {
      this.tail.setNext(tmp);
      tmp.setPrev(this.tail);
      this.tail = tmp;
    }
  }

  public void addFront(T data) {
    Node<T> tmp = new Node<T>();
    tmp.setN(data);

    if(this.head == null) {
      this.head = tmp;
      this.tail = tmp;
    } else {
      this.head.setPrev(tmp);
      tmp.setNext(this.head);
      this.head = tmp;
    }
  }

  public void print() {
    Node<T> tmp = this.head;
    while(tmp != null) {
      System.out.print(tmp.getN() + " ");
      tmp = tmp.getNext();
    }
  }
}
