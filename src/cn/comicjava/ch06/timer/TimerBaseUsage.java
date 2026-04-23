package cn.comicjava.ch06.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */
public class TimerBaseUsage {
    private static final Logger LOGGER = Logger.getLogger(TimerBaseUsage.class.getName());
    public static void main(String[] args) {
        Timer timer = new Timer("【Pkmer-timer】");
        LOGGER.info("启动定时器");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               LOGGER.info("执行任务中");
            }
        },1000,2000);
    }
}
