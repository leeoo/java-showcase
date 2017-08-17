package com.lex.showcase.java8_features.lambda_expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;

public class FindHiddenFile {
    private static Logger log = LoggerFactory.getLogger(FindHiddenFile.class);

    public static void main(String[] args) {
        // 旧式写法——匿名内部类
        File[] hiddenFilesOld = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        // 新式写法——Java 8 方法引用
        File[] hiddenFiles = new File(".").listFiles(File::isHidden); // 将方法引用File::isHidden传递给listFiles方法
        log.info("Hidden files: {}", hiddenFiles);
    }
}
