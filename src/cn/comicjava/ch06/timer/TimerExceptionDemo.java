package cn.comicjava.ch06.timer;

/**
 *
 * @author 鲨鱼不喝Jvaa 抖音号:77283340926
 * @version 1.0
 * @since 2026/4/23
 */

import java.util.Timer;
import java.util.TimerTask;

public class TimerExceptionDemo {
    public static void main(String[] args) {
        Timer timer = new Timer("【Timer-Pkmer】");
        // 任务1：会抛出异常
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("💥 即将抛出异常的任务开始执行");
                throw new RuntimeException("模拟任务执行异常");
            }
        }, 0);

        // 任务2：正常任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("✅ 我是正常任务，但我永远没机会执行了");
            }
        }, 2000);
    }
}