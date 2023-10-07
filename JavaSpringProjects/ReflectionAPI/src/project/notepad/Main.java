package project.notepad;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
//      Class class1 = new Class();
//      int number = class1.getNumber();
//      String name = null;
//      System.out.println(name + number);
//      try{
//        Field field = class1.getClass().getDeclaredField("name");
//        field.setAccessible(true);
//        field.set(class1, (String) "new value");
//        name = (String) field.get(class1);
//      } catch (NoSuchFieldException | IllegalAccessException e) {
//        e.printStackTrace();
//      }
//
//      try {
//        Method method = class1.getClass().getDeclaredMethod("printData");
//        method.setAccessible(true);
//        method.invoke(class1);
//      } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//        e.printStackTrace();
//      }

//      Class classTmp = new Class();
//      classTmp.setNumber(101);
//
//      try {
//        Field field = classTmp.getClass().getDeclaredField("name");
//        field.setAccessible(true);
//        field.set(classTmp, (String) "Hello World!");
//
//        Method method = classTmp.getClass().getDeclaredMethod("printData");
//        method.setAccessible(true);
//        method.invoke(classTmp);
//
//      } catch (NoSuchFieldException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
//        e.printStackTrace();
//      }


//      HelloWorld helloWorld = new HelloWorld();
//      try {
//        Field field = helloWorld.getClass().getDeclaredField("greetings");
//        field.setAccessible(true);
//        field.set(helloWorld, (String) "Hello, world!");
//
//        Method method = helloWorld.getClass().getDeclaredMethod("print");
//        method.setAccessible(true);
//        method.invoke(helloWorld);
//
//      } catch (NoSuchFieldException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
//        e.printStackTrace();
//      }
      Set<Person> personSet = new TreeSet<>();
      personSet.add(new Person("C"));
      personSet.add(new Person("A"));
      personSet.add(new Person("B"));

      System.out.println(personSet.stream().sorted(new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
          if(o1.equals(o2)) {
            return 0;
          } else if(!o1.equals(o2)) {
            return -1;
          } else {
            return  1;
          }
        }
      }));
   }

}
