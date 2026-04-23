package cn.comicjava.ch06.bestMatching;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public class Main {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("./data/UK Advanced Cryptics Dictionary.txt"), StandardCharsets.ISO_8859_1);) {
            List<String> list = lines.toList();
            System.out.println(list.get(7));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
