package cn.comicjava.ch06.bestMatching.alg.serial;

import cn.comicjava.ch06.bestMatching.alg.BestMatchingCalculation;
import cn.comicjava.ch06.bestMatching.common.BestMatchingData;
import cn.comicjava.ch06.bestMatching.common.LevenshteinDistance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public class BestMatchingSerialCalculation implements BestMatchingCalculation {
    private static final LevenshteinDistance levenshteinDistance = new LevenshteinDistance();

    /**
     * 找到与目标最相似的单词
     */
    @Override
    public BestMatchingData getBestMatchingWords(String word, List<String> dictionary){
        List<String> words = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        for (String str : dictionary) {
            int distance = levenshteinDistance.minDistance(word, str);

            if(distance < minDistance){
                words.clear();
                words.add(str);
                minDistance = distance;
            }else if(minDistance == distance){
                words.add(str);
            }
        }
        return new BestMatchingData(minDistance,words);
    }
}
