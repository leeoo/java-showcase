package com.lex.showcase.java8_features.lambda_expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Predicate;

public class FileProcessor {
    private static Logger log = LoggerFactory.getLogger(FileProcessor.class);

    public static void main(String[] args) {
        try {
            String oneLine = processFile((BufferedReader br) -> br.readLine());
            String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
            log.info("One line: {}", oneLine);
            log.info("Two line: {}", twoLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

}
