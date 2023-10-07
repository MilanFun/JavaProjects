package Archiver;

import java.io.IOException;

public class TestArchiver {
  public static void main(String[] args) {
    ArchiverZip zip = new ArchiverZip();
    try {
      zip.createZipArchiveWithFile(args[0], args[1]);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Success!");
  }
}
