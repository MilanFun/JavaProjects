package framework.lesson.ioc;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class RockMusic implements Music {
  private final List<String> listOfRockMusic = Arrays.asList("Imagine Dragons", "ACDC", "Group-Alex");
  private final String name = "AC-DC";

  public static RockMusic getInstance() {
    return new RockMusic();
  }

  private RockMusic() {}

//  @Override
//  public String getSong() {
//    return this.listOfRockMusic.toString();
//  }

  @Override
  public String getSong() {
    return this.name;
  }

  public String getSongByInt(int i) {
    return this.listOfRockMusic.get(i);
  }
}
