package framework.lesson.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("player")
public class MusicPlayer {
  private Music music1;
  private Music music2;

  private List<Music> list = new ArrayList<>();

  @Value("${player.name}")
  private String name;
  @Value("${player.volume}")
  private int volume;

  public String getName() {
    return name;
  }

  public int getVolume() {
    return volume;
  }

  public MusicPlayer(List<Music> list) {
    this.list = list;
  }

  //DI
  @Autowired
  public MusicPlayer(@Qualifier("classicalMusic") Music music1, @Qualifier("rockMusic") Music music2) {
    this.music1 = music1;
    this.music2 = music2;
  }

  public MusicPlayer(Music music1) {
    this.music1 = music1;
  }

  public MusicPlayer(){}

//  @Override
//  public String toString() {
//    return "Playing " + this.music1.getSong();
//  }

  @Override
  public String toString() {
    int i = (int) (Math.random() * 3);
    return this.list.get(i).getSong();
  }

  public <T extends Enum<T>> void playMusic(T[] val) {
    for (T t : val) {
      if (t == Genre.CLASSICAL) {
        int k = (int) (Math.random() * 3);
        System.out.println(this.music1.getSongByInt(k));
      }
      if (t == Genre.ROCK) {
        int k = (int) (Math.random() * 3);
        System.out.println(this.music2.getSongByInt(k));
      }
    }
  }
}
