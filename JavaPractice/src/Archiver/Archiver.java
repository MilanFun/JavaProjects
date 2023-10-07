package Archiver;

import java.io.IOException;

public interface Archiver {
  public void createZipArchiveWithFile(String zipArchivName, String fileName) throws IOException;
}
