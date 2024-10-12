package 线程优先级;

import lombok.extern.slf4j.Slf4j;

/**
 * 实现线程优先级 、 线程 yield 方法
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 0;
                while (true) {
                    log.info("t1 count: {}", count);
                    count++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long count = 0;
                while (true) {
                    log.info("t2 count: {}", count);
                    count++;
                    Thread.yield();
                }
            }
        });

//        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
