import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompressor {

    public static void compressFiles(String zipFileName, String[] files) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            for (String filePath : files) {
                File fileToZip = new File(filePath);
                try (FileInputStream fis = new FileInputStream(fileToZip)) {
                    ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                    zipOut.closeEntry();
                }
            }
        }
    }
}


//- filesToZip dizisine sıkıştırmak istediğin dosyaların yollarını ekle.
//- zipFileName değişkenine oluşturulacak ZIP dosyasının adını belirt.
//- Programı çalıştırdığında belirtilen dosyalar sıkıştırılacak ve compressed_files.zip adında bir ZIP dosyası oluşturulacaktır.
