package project.notepad;

public class Person implements Comparable{
  private String name;

  public Person(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }

  @Override
  public int compareTo(Object o) {
    if(o.equals(this.name)) {
      return 0;
    }

    if(!o.equals(this.name)) {
      return -1;
    }

    return 1;
  }
}
