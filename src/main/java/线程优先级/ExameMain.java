package 线程优先级;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExameMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("洗水壶");
                Thread.sleep(2000);
                log.info("烧开水");
                Thread.sleep(5000);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("西茶叶");
                Thread.sleep(1000);
                log.info("拿茶杯");
                Thread.sleep(2000);
                thread.join();
            }
        });

        thread.start();
        thread2.start();
    }
}
