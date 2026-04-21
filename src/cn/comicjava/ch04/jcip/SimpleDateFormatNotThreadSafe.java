package cn.comicjava.ch04.jcip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleDateFormatNotThreadSafe {
    
    // 共享的 SimpleDateFormat 实例（非线程安全）
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    // 统计异常数量
    private static final AtomicInteger errorCount = new AtomicInteger(0);
    private static final AtomicInteger successCount = new AtomicInteger(0);
    
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100;
        int tasksPerThread = 100;
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            executor.submit(() -> {
                try {
                    for (int j = 0; j < tasksPerThread; j++) {
                        try {
                            // 准备一个日期字符串
                            String dateStr = "2024-12-25 10:30:00";
                            
                            // 解析为 Date
                            Date date = SDF.parse(dateStr);
                            
                            // 再格式化回字符串
                            String formatted = SDF.format(date);
                            
                            // 验证结果是否正确
                            if (!dateStr.equals(formatted)) {
                                System.out.println(Thread.currentThread().getName() + 
                                    " - 结果不一致！原始: " + dateStr + ", 格式化后: " + formatted);
                                errorCount.incrementAndGet();
                            } else {
                                successCount.incrementAndGet();
                            }
                        } catch (Exception e) {
                            System.out.println(Thread.currentThread().getName() + 
                                " - 抛出异常: " + e.getMessage());
                            errorCount.incrementAndGet();
                        }
                    }
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("\n========== 运行结果统计 ==========");
        System.out.println("总执行次数: " + (threadCount * tasksPerThread));
        System.out.println("成功次数: " + successCount.get());
        System.out.println("失败次数: " + errorCount.get());
        System.out.println("失败率: " + (errorCount.get() * 100.0 / (threadCount * tasksPerThread)) + "%");
        System.out.println("运行时间: " + (endTime - startTime) + "ms");
    }
}
