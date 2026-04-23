package cn.comicjava.ch06.bestMatching.common.util;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */

import java.time.Duration;
import java.time.Instant;

public class TimeUtil {

    // 开始计时
    public static Instant start() {
        return Instant.now();
    }

    // 结束计时并打印
    public static void end(Instant start) {
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.printf("执行时间: %d ms (%d ns)%n",
                duration.toMillis(),
                duration.toNanos());
    }

    // 返回耗时（毫秒）
    public static long getElapsedMillis(Instant start) {
        return Duration.between(start, Instant.now()).toMillis();
    }

    // 返回耗时（纳秒，更精确）
    public static long getElapsedNanos(Instant start) {
        return Duration.between(start, Instant.now()).toNanos();
    }
}
