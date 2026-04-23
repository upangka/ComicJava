package cn.comicjava.ch06.bestMatching.alg.concurrency;

import cn.comicjava.ch06.bestMatching.alg.BestMatchingCalculation;
import cn.comicjava.ch06.bestMatching.common.BestMatchingData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 并发处理方式
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public class BestMatchingBasicConcurrentCalculation implements BestMatchingCalculation {
    private final int numCores = Runtime.getRuntime().availableProcessors();
    private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(
            numCores
    );

    @Override
    public BestMatchingData getBestMatchingWords(String word, List<String> dictionary) {
        int startIndex, endIndex, step = dictionary.size() / numCores;
        List<Future<BestMatchingData>> results = new ArrayList<>();
        for (int i = 0; i < numCores; i++) {
            startIndex = i * step;
            if(i == numCores - 1){
                endIndex = dictionary.size();
            }else{
                endIndex = startIndex + step;
            }
            // 异步提交
            Future<BestMatchingData> future = executor.submit(new BasicTask(startIndex, endIndex, dictionary, word));
            results.add(future);
        }

        executor.shutdown();

        // 合并结果
        List<String> words = new ArrayList<>();
        int distance = Integer.MAX_VALUE;
        for (Future<BestMatchingData> future : results) {
            try {
                BestMatchingData data = future.get();
                if(data.distance() < distance){
                    words.clear();
                    words.addAll(data.words());
                    distance = data.distance();
                }else if(data.distance() == distance){
                    words.addAll(data.words());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return new BestMatchingData(distance, words);
    }
}
