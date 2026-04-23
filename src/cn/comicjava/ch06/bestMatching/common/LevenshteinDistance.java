package cn.comicjava.ch06.bestMatching.common;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public class LevenshteinDistance {
    public static final LevenshteinDistance instance;
    static{
        instance = new LevenshteinDistance();
    }

    public int minDistance(String word1, String word2) {
        final int rows = word1.length() + 1, cols = word2.length() + 1;
        int[][] dp = initDp(rows, cols);

        // 从左到右,从上到下
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 删除、插入、替换
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    private int[][] initDp(int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = j;
        }
        return dp;
    }
}
