import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Sıkıştırılacak dosyaların yollarını belirt
        String[] filesToZip = {"path/to/file1.txt", "path/to/file2.txt"};
        String zipFileName = "compressed_files.zip";

        try {
            ZipCompressor.compressFiles(zipFileName, filesToZip);
            System.out.println("Dosyalar başarıyla sıkıştırıldı: " + zipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}