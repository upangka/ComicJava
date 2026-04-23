package cn.comicjava.ch06.bestMatching;

import cn.comicjava.ch06.bestMatching.alg.BestMatchingCalculation;
import cn.comicjava.ch06.bestMatching.alg.concurrency.BestMatchingAdvancedConcurrentCalculation;
import cn.comicjava.ch06.bestMatching.common.BestMatchingData;
import cn.comicjava.ch06.bestMatching.common.WordsLoader;
import cn.comicjava.ch06.bestMatching.common.util.TimeUtil;

import java.time.Instant;
import java.util.List;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        //main.runWith(new BestMatchingSerialCalculation());
        // main.runWith(new BestMatchingBasicConcurrentCalculation());
        main.runWith(new BestMatchingAdvancedConcurrentCalculation());
    }

    public void runWith(BestMatchingCalculation cal){
        List<String> dictionary = WordsLoader.loadDictionary("./data/UK Advanced Cryptics Dictionary.txt");
        String word = "Jvaa";
        System.out.println("加载了 " + dictionary.size() + " 个单词");
        Instant start = TimeUtil.start();
        BestMatchingData result = cal.getBestMatchingWords(word, dictionary);
        TimeUtil.end(start);

        System.out.println("Word: " + word);
        System.out.println("Minimun distance: " + result.distance());
        System.out.println("最匹配的单词个数: " + result.words().size());
        result.words().forEach(System.out::println);
    }
}
