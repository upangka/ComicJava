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
public class TimerFixRateV2 {
    private static final Logger LOGGER = Logger.getLogger(TimerFixRateV2.class.getName());
    public static void main(String[] args) {
        Timer timer = new Timer("【Pkmer-timer】");
        LOGGER.info("启动定时器");
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LOGGER.info("开始执行任务");
                try {
                    Thread.sleep(3000L);

                } catch (InterruptedException e) {
                }
                LOGGER.info("执行任务结束");
            }
        },0,1000);
    }
}
