package com.lex.showcase.java7_features;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 演示Java 7引入的try-with-resource，即把资源放在try的圆括号里就可，这段代码会在资源处理完毕时，自动关闭。
 */
public class TryWithResourceDemo {
    private static Logger log = LoggerFactory.getLogger(TryWithResourceDemo.class);

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String text = br.readLine();
            log.info(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
