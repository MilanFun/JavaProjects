package framework.lesson.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
  @Bean
  public RockMusic rockMusic() {
    return RockMusic.getInstance();
  }

  @Bean
  public ClassicalMusic classicalMusic() {
    return ClassicalMusic.getInstance();
  }
//
//  @Bean
//  public MusicPlayer musicPlayer1() {
//    return new MusicPlayer(rockMusic());
//  }
//
//  @Bean
//  public MusicPlayer musicPlayer2() {
//    return new MusicPlayer(classicalMusic());
//  }
  @Bean
  public JazzMusic jazzMusic() {
    return new JazzMusic();
  }

  @Bean
  public List<Music> list() {
    return Arrays.asList(rockMusic(), jazzMusic(), classicalMusic());
  }

  @Bean
  public MusicPlayer musicPlayer() {
    return new MusicPlayer(list());
  }

}
