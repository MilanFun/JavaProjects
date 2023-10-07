package framework.lesson.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("computer")
public class Computer {
  private int id;
  private MusicPlayer musicPlayer;

  @Autowired
  public Computer(MusicPlayer musicPlayer) {
    this.id = 1;
    this.musicPlayer = musicPlayer;
  }

  @Override
  public String toString() {
    return "Computer " + this.id + " " + musicPlayer.toString();
  }
}
