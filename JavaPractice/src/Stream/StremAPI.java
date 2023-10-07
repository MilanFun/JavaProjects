package Stream;

import javax.swing.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StremAPI {
  public static void main(String[] args) {
//    ArrayList<Integer> lists = new ArrayList<>();
//    lists.add(1);
//    lists.add(5);
//    lists.add(2);
//    lists.add(0);
//
//    for(Integer i : lists) {
//      System.out.println(i);
//    }
//
//    lists.stream().sorted(Integer::compareTo).forEach(s -> System.out.println(s));
//
//    String[] str = new String[] {"Moscow", "Berlin"};
//
//    Stream<String> stream = Stream.of(str);
//    stream.forEach(System.out::println);
//
//    stream.filter(s -> s.length()>2).forEach(System.out::println);
//
//    Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
//    citiesStream.filter(s->s.length()==6).forEach(s->System.out.println(s));

//    Stream<IPhone> streamIphone = Stream.of(new IPhone("iPhone 6", 6000), new IPhone("iPhone 7", 7000), new IPhone("iPhone 8", 8000));
//    streamIphone.filter(i -> i.getPrice() > 6000).forEach(s -> System.out.println(s.toString()));
//    streamIphone.map(s -> s.getName()).forEach(s -> System.out.println(s));
//    streamIphone
//      .flatMap(p -> Stream.of(String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
//                              String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int)(p.getPrice()*0.1))))
//      .forEach(s -> System.out.println(s));

//    Stream<IPhone> phoneStream = Stream.of(new IPhone("iPhone X", "Apple", 600),
//      new IPhone("Pixel 2", "Google", 500),
//      new IPhone("iPhone 8", "Apple",450),
//      new IPhone("Nokia 9", "HMD Global",150),
//      new IPhone("Galaxy S9", "Samsung", 300));
//
//    phoneStream.sorted(new Comparator<IPhone>() {
//      @Override
//      public int compare(IPhone o1, IPhone o2) {
//        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
//      }
//    }).forEach(p->System.out.printf("%s (%s) - %d \n",
//      p.getName(), p.getCompany(), p.getPrice()));

//    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);
//    stream.skip(2).limit(7).filter(s -> s % 2 == 0).forEach(System.out::println);
//
//    Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7);
//    stream1.takeWhile(s -> s < 5).forEach(System.out::println);
//    stream1.dropWhile(s -> s < 5).forEach(System.out::println);
//
//    Stream<String> stringStream1 = Stream.of("A", "B", "C");
//    Stream<String> stringStream2 = Stream.of("A", "B", "C");
//
//    Stream.concat(stringStream1, stringStream2).distinct().forEach(System.out::println);

//    ArrayList<String> strList = new ArrayList<>();
//    strList.addAll(Arrays.asList("Tom", "Bob", "Kate", "Vadim"));
//    System.out.println(strList.stream().count());
//    strList.stream().filter(s -> s.length() > 3).forEach(System.out::println);
//
//    System.out.println(strList.stream().findFirst().get());
//    System.out.println(strList.stream().findAny().get());

//    if(strList.stream().allMatch(s -> s.equals("Bob"))) {
//      System.out.println("Bob has found!");
//    }
//    if(strList.stream().anyMatch(s -> s.length() > 3)) {
//      strList.stream().filter(s -> s.length() > 3).forEach(System.out::println);
//    }
//    if(strList.stream().noneMatch(s -> s.equals("Lol"))) {
//      System.out.println("Lol hasn't found!");
//    }

//    ArrayList<Integer> array = new ArrayList<>();
//    array.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
//    Optional<Integer> min = array.stream().min(new Comparator<Integer>() {
//      @Override
//      public int compare(Integer o1, Integer o2) {
//        return o1.compareTo(o2);
//      }
//    });
//    System.out.println(min.get());
//
//    Optional<Integer> max = array.stream().max(new Comparator<Integer>() {
//      @Override
//      public int compare(Integer o1, Integer o2) {
//        return o1.compareTo(o2);
//      }
//    });
//    System.out.println(max.get());

//      ArrayList<IPhone> phones = new ArrayList<>();
//      phones.addAll(Arrays.asList(new IPhone("iPhone X", "Apple", 600),
//                                  new IPhone("Pixel 2", "Google", 500),
//                                  new IPhone("iPhone 8", "Apple",450),
//                                  new IPhone("Nokia 9", "HMD Global",150),
//                                  new IPhone("Galaxy S9", "Samsung", 300)));
//      System.out.println(phones.stream().max(IPhone::compare).get().toString());
//      System.out.println(phones.stream().min(IPhone::compare).get().toString());

//    ArrayList<Integer> arr = new ArrayList<>();
//    arr.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
//    System.out.println(arr.stream().reduce((x, y) -> x*y).get());

//      ArrayList<IPhone> phones = new ArrayList<>();
//      phones.addAll(Arrays.asList(new IPhone("iPhone X", "Apple", 600),
//                                  new IPhone("Pixel 2", "Google", 500),
//                                  new IPhone("iPhone 8", "Apple",450),
//                                  new IPhone("Nokia 9", "HMD Global",150),
//                                  new IPhone("Galaxy S9", "Samsung", 300)));
//      System.out.println(phones.stream().reduce(0, (x, y) -> {
//        if(y.getPrice() < 500) {
//          return x + y.getPrice();
//        } else {
//          return x + 0;
//        }
//      }, (x, y) -> x + y));

//      ArrayList<Integer> array = new ArrayList<>();
//      array.addAll(Arrays.asList());
//      Optional<Integer> k = array.stream().min(new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//          return o1.compareTo(o2);
//        }
//      });
//      System.out.println(k.orElseThrow(NoSuchElementException::new));
//      System.out.println(k.get());

//    ArrayList<Integer> numbers = new ArrayList<Integer>();
//    numbers.addAll(Arrays.asList(1, 2, 3, 4, 5));
//    Optional<Integer> min = numbers.stream().min(Integer::compare);
//    min.ifPresentOrElse(
//      v -> System.out.println(v),
//      () -> System.out.println("Value not found")
//    );
  }
}
