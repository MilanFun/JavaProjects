package framework.lesson;

import framework.lesson.ioc.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSpring {
  public static void main(String[] args) {
//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    TestBean testBean1 = context.getBean("testBean1", TestBean.class);
//    TestBean testBean2 = context.getBean("testBean2", TestBean.class);
//    System.out.println(testBean1.getName());
//    System.out.println(testBean2.getName());
//    context.close();
//
//    //IoC
//    ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    Music music = context1.getBean("musicBean", Music.class);
//    MusicPlayer musicPlayer = new MusicPlayer(music);
//    musicPlayer.playMusic();
//    context1.close();
//
//    ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    Music music1 = context2.getBean("musicBean1", Music.class);
//    MusicPlayer musicPlayer1 = new MusicPlayer(music1);
//    musicPlayer1.playMusic();
//    context2.close();
//
//    ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    Music music2 = context3.getBean("jazzMusic", JazzMusic.class);
//    MusicPlayer musicPlayer2 = new MusicPlayer(music2);
//    musicPlayer2.playMusic();
//    context3.close();
//
//    //DI
//    ClassPathXmlApplicationContext context4 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer3 = context4.getBean("musicPlayer", MusicPlayer.class);
//    musicPlayer3.playMusic();
//    context4.close();
//
//    //DI via setter
//    ClassPathXmlApplicationContext context5 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer4 = context5.getBean("setterMusicPlayer", MusicPlayer.class);
//    musicPlayer4.playMusic();
//    context5.close();
//
//    ClassPathXmlApplicationContext context6 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer5 = context6.getBean("advancedMusicPlayer", MusicPlayer.class);
//    musicPlayer5.playMusic();
//    context6.close();
//
//    //DI via properties file
//    ClassPathXmlApplicationContext context7 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer6 = context7.getBean("musicPlayerProperties", MusicPlayer.class);
//    musicPlayer6.playMusic();
//    context7.close();
//
//    //ArrayList and properties file
//    ClassPathXmlApplicationContext context8 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer7 = context8.getBean("listMusic", MusicPlayer.class);
//    musicPlayer7.playMusicWithList();
//    System.out.println();
//    context8.close();
//
//    //Scope Singleton
//    ClassPathXmlApplicationContext context9 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    ClassPathXmlApplicationContext context10 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer8 = context9.getBean("singletonBean", MusicPlayer.class);
//    MusicPlayer musicPlayer9 = context9.getBean("singletonBean", MusicPlayer.class);
//    MusicPlayer musicPlayer10 = context10.getBean("prototypeBean", MusicPlayer.class);
//
//    if(musicPlayer8 == musicPlayer9) {
//      System.out.println("Singleton: " + true);
//    } else {
//      System.out.println("Prototype: " + false);
//    }
//
//    if(musicPlayer8 != musicPlayer10) {
//      System.out.println("Prototype: " + false);
//    } else {
//      System.out.println("Singleton: " + true);
//    }
//
//    System.out.println();
//    System.out.println("Before changing volume");
//
//    musicPlayer8.playMusic();
//    musicPlayer9.playMusic();
//    musicPlayer10.playMusic();
//
//    musicPlayer8.setVolume(10);
//    System.out.println("After changing volume in singleton");
//    musicPlayer8.playMusic();
//    musicPlayer9.playMusic();
//    musicPlayer10.playMusic();
//
//    musicPlayer10.setVolume(20);
//    System.out.println("After changing volume in prototype");
//    musicPlayer8.playMusic();
//    musicPlayer9.playMusic();
//    musicPlayer10.playMusic();
//    context9.close();

//    //Lifecycle of Bean
//    System.out.println("\n" + "LIFECYCLE BEAN");
//    ClassPathXmlApplicationContext context11 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer11 = context11.getBean("classicalMusic", MusicPlayer.class);
//    musicPlayer11.playMusic();
//    context11.close();
//
//    //Checking for Singleton scope
//    System.out.println("\n" + "LIFECYCLE BEAN");
//    ClassPathXmlApplicationContext context12 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer12 = context12.getBean("classicalMusic", MusicPlayer.class);
//    musicPlayer12.playMusic();
//    context11.close();
//
//    ClassPathXmlApplicationContext context13 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    Music music1 = context13.getBean("classicalMusic", ClassicalMusic.class);
//    MusicPlayer musicPlayer13 = new MusicPlayer(music1);
//    musicPlayer13.playMusic();
//    context13.close();
//
//    ClassPathXmlApplicationContext context14 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    Music music2 = context14.getBean("rapMusic", RapMusic.class);
//    MusicPlayer musicPlayer14 = new MusicPlayer(music2);
//    musicPlayer14.setVolume(78);
//    musicPlayer14.setName("Rap AK-47");
//    musicPlayer14.playMusic();
//    context14.close();
//
//    ClassPathXmlApplicationContext context15 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    Music music3 = context15.getBean("classicalMusic", ClassicalMusic.class);
//    MusicPlayer musicPlayer15 = new MusicPlayer(music3);
//    musicPlayer15.setVolume(56);
//    musicPlayer15.setName("ClassicalMusic class with Factory-pattern");
//    musicPlayer15.playMusic();
//    context15.close();

//    //@Autowired annotation, DI
//    ClassPathXmlApplicationContext context16 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer16 = context16.getBean("player", MusicPlayer.class);
//    MusicPlayer musicPlayer16 = new MusicPlayer(context16.getBean("classicalMusic", ClassicalMusic.class));
//    musicPlayer16.setName("@Autowired");
//    musicPlayer16.setVolume(100);
//    musicPlayer16.playMusic();
//    context16.close();

//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    MusicPlayer musicPlayer = context.getBean("player", MusicPlayer.class);
//    System.out.println(musicPlayer);
//    System.out.println("Name: " + musicPlayer.getName());
//    System.out.println("Volume: " + musicPlayer.getVolume());
//
//    ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
//    ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);
//    System.out.println(classicalMusic1 == classicalMusic2);
//    context.close();

    /*
    Spring Configuration via Class
     */

//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//    MusicPlayer musicPlayer = context.getBean("player", MusicPlayer.class);
//    System.out.println(musicPlayer);
//    System.out.println(musicPlayer.getName());
//    System.out.println(musicPlayer.getVolume());
//    context.close();

//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//    MusicPlayer musicPlayer1 = context.getBean("musicPlayer1", MusicPlayer.class);
//    MusicPlayer musicPlayer2 = context.getBean("musicPlayer2", MusicPlayer.class);
//    System.out.println(musicPlayer1 + " " + musicPlayer1.getName() + " " + musicPlayer1.getVolume());
//    System.out.println(musicPlayer2 + " " + musicPlayer2.getName() + " " + musicPlayer2.getVolume());
//    context.close();

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
    System.out.println(musicPlayer);
    System.out.println(musicPlayer.getName());
    System.out.println(musicPlayer.getVolume());
    context.close();
  }
}
