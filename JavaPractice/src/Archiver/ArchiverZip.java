package Archiver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiverZip implements Archiver{
  @Override
  public void createZipArchiveWithFile(String zipArchivName, String fileName) throws IOException {
    ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipArchivName));
    File file = new File(fileName);
    FileInputStream fis = new FileInputStream(file);
    ZipEntry ze = new ZipEntry(file.getName());
    zos.putNextEntry(ze);

    writeFromFisToZos(fis, zos);

    fis.close();
    zos.closeEntry();
    zos.close();
  }

  protected void writeFromFisToZos(FileInputStream fis, ZipOutputStream zos) throws IOException {
    byte[] buffer = new byte[8000];
    int length;
    while(true) {
      length = fis.read(buffer);
      if(length < 0) {
        break;
      } else {
        zos.write(buffer, 0, length);
      }
    }
  }
}
