package framework.lesson.ioc;

import org.springframework.stereotype.Component;

@Component
public class RapMusic implements Music{
  @Override
  public String getSong() {
    return "AK-47";
  }

  @Override
  public String getSongByInt(int i) {
    return "AK-47";
  }
}
