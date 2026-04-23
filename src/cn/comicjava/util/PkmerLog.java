package cn.comicjava.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public class PkmerLog {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static void log(String msg){
        System.out.printf("[%s] %s%n",
                LocalTime.now().format(TIME_FORMATTER), msg);
    }
}
