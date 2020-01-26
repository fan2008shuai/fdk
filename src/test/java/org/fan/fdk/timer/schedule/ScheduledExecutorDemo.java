package org.fan.fdk.timer.schedule;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fan.shuai on 2019/11/23.
 */
public class ScheduledExecutorDemo {

    @Test
    public void testScheduleAtFixedRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            private AtomicInteger count = new AtomicInteger(0);
            @Override
            public void run() {
                count.incrementAndGet();
                System.out.println("task-" + count.get() + " start: " + System.currentTimeMillis());
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task-" + count.get() + " end: " + System.currentTimeMillis());
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main exit");
    }

    @Test
    public void testScheduleAtFixedRate2() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            private AtomicInteger count = new AtomicInteger(0);
            @Override
            public void run() {
                count.incrementAndGet();
                System.out.println("task-" + count.get() + " start: " + System.currentTimeMillis());
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task-" + count.get() + " end: " + System.currentTimeMillis());
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main exit");
    }

    @Test
    public void testScheduleWithFixedDelay() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            private AtomicInteger count = new AtomicInteger(0);
            @Override
            public void run() {
                count.incrementAndGet();
                System.out.println("task-" + count.get() + " start: " + System.currentTimeMillis());
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task-" + count.get() + " end: " + System.currentTimeMillis());
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main exit");
    }

}
