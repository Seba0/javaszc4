package javaszc4.zajecia.podstawy._2.zbiory.set.zadania.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class ZipFile {
    public static void main(String[] args) throws IOException {
        File fIn = new File(args[0]);
        File fOut = new File(args[1]);
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(fIn));
             FileInputStream in = new FileInputStream(fOut)) {
            ZipEntry e = new ZipEntry(fIn.getName());
            out.putNextEntry(e);
            byte[] buffor = new byte[1024];
            int size;
            while ((size = in.read(buffor)) > -1) {
                out.write(buffor, 0, size);
            }
            out.closeEntry();
        }
    }
}
