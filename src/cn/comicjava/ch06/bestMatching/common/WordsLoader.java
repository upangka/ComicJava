package cn.comicjava.ch06.bestMatching.common;

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
public class WordsLoader {
    /**
     * 加载字典
     * @return
     */
    public static List<String> loadDictionary(String path){
        try (Stream<String> lines = Files.lines(Paths.get(path), StandardCharsets.ISO_8859_1);) {
            return lines.toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
