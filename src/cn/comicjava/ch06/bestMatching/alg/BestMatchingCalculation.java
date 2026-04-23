package cn.comicjava.ch06.bestMatching.alg;

import cn.comicjava.ch06.bestMatching.common.BestMatchingData;

import java.util.List;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public interface BestMatchingCalculation {
    BestMatchingData getBestMatchingWords(String word, List<String> dictionary);
}
