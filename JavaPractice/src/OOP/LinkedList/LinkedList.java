package OOP.LinkedList;

public class LinkedList<T> {
  private Node<T> first;
  private int size;

  public LinkedList() {
    first = null;
    size = 0;
  }

  public Node<T> getFirst() {
    return this.first;
  }

  public void setFirst(Node<T> first) {
    this.first = first;
  }

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void add(T data) {
    Node<T> current = first;

    if(current == null) {
      this.first = new Node<>(data);
      this.size++;
    }

    while(current.getNext() != null) {
      current = current.getNext();
    }

    current.setNext(new Node<>(data));
    this.size++;
  }

  public void add(T[] array) {
    for(T data : array) {
      this.add(data);
    }
  }

  public void remove(T data) {
    Node<T> current = first;
    Node<T> next = current.getNext();

    if(first.getData().equals(data)) {
      if(size == 1) {
        first.setData(null);
        size--;
      }
      first.setData(data);
      first = first.getNext();
      size--;
    }

    while(next != null) {
      if(next.getData().equals(data)) {
        current.setNext(next.getNext());
        next = null;
        size--;
      }
      current = next;
      next = current.getNext();
    }
  }

}
