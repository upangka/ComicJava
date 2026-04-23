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
public class TimerTaskDuiji {

    private static final Logger log = Logger.getLogger(TimerTaskDuiji.class.getName());
    public static void main(String[] args) {
        Timer timer = new Timer();

        // 安排一个耗时任务（模拟处理大量数据）
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("🐢 耗时任务开始执行...");
                try {
                    Thread.sleep(5000); // 模拟耗时5秒的操作
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                log.info("🐢 耗时任务执行完毕");
            }
        }, 0); // 立即执行

        // 安排一个快速任务，预期每1秒执行一次
        timer.scheduleAtFixedRate(new TimerTask() {
            private int count = 0;

            @Override
            public void run() {
                count++;
                log.info("🐇 快速任务 #" + count + " 执行");
            }
        }, 0, 1000);

        // 程序运行8秒后退出
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        timer.cancel();
    }
}
