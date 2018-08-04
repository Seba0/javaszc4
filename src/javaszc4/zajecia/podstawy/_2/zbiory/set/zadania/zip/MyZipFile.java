package javaszc4.zajecia.podstawy._2.zbiory.set.zadania.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class MyZipFile {

    private static final byte[] BUFFOR = new byte[2048];

    private static void copyStream(InputStream in, OutputStream out) throws IOException {
        int size;
        while ((size = in.read(BUFFOR)) > -1) {
            out.write(BUFFOR, 0, size);
        }
    }

    public static void main(String[] args) throws IOException {
        File fIn = new File(args[0]);
        File fOut = new File(args[1]);
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(fIn));
             InputStream in = new FileInputStream(fOut)) {
            ZipEntry e = new ZipEntry(fIn.getName());
            out.putNextEntry(e);
            copyStream(in, out);
            out.closeEntry();
        }

        try (ZipFile zipFile = new ZipFile(fOut)) {
            ZipEntry entry = zipFile.getEntry(fIn.getName());
            try (InputStream in = zipFile.getInputStream(entry);
                 OutputStream out = new FileOutputStream(fIn)) {
                copyStream(in, out);
            }
        }
    }
}
