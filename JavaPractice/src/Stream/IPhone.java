package Stream;

public class IPhone {
  private String name;
  private String company;
  private int price;

  public IPhone(String name, String company, int price) {
    this.name = name;
    this.price = price;
    this.company = company;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "IPhone{" +
      "name='" + name + '\'' +
      ", price=" + price +
      '}';
  }


  public int compare(IPhone i) {
    if(this.price < i.getPrice()) {
      return -1;
    } else  {
      return 1;
    }
  }
}
