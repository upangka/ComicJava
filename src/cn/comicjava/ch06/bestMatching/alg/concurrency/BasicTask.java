package cn.comicjava.ch06.bestMatching.alg.concurrency;

import cn.comicjava.ch06.bestMatching.common.BestMatchingData;
import cn.comicjava.ch06.bestMatching.common.LevenshteinDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 任务
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public class BasicTask implements Callable<BestMatchingData> {
    private final int startIndex;
    private final int endIndex;
    private final List<String> dictionary;
    private final String targetWord;
    public BasicTask(int startIndex, int endIndex, List<String> dictionary, String targetWord) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.dictionary = dictionary;
        this.targetWord = targetWord;
    }

    @Override
    public BestMatchingData call() throws Exception {
        List<String> words = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            String str = dictionary.get(i);
            int distance = LevenshteinDistance.instance.minDistance(targetWord, str);

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
