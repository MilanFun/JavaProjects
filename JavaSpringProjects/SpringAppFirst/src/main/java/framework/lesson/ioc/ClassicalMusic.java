package framework.lesson.ioc;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

//@Scope("singleton")
//@Scope("prototype")
//Factory-pattern
public class ClassicalMusic implements Music {
  private final List<String> listOfClassicalMusic = Arrays.asList("Mozart", "Rachmaninov", "Bah");
  private final String name = "Mozart";
  private ClassicalMusic() {}

  public static ClassicalMusic getInstance(){
    return new ClassicalMusic();
  }

//  @Override
//  public String getSong() {
//    return this.listOfClassicalMusic.toString();
//  }

  @Override
  public String getSongByInt(int i) {
    return this.listOfClassicalMusic.get(i);
  }

  @Override
  public String getSong() {
    return this.name;
  }

  @PostConstruct
  public void init() {
    System.out.println("Init method");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Destroy method");
  }
}
