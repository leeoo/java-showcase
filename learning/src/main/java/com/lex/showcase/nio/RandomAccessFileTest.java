package com.lex.showcase.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Lex on 2016/12/14.
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("test.txt", "rw")) {
            int b;
            do {
//                b = raf.read();
//                System.out.print((char) b);
                b = raf.readChar();
                System.out.print((char) b);
            } while (b != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
