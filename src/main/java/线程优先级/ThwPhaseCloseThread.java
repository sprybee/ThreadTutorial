package 线程优先级;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

public class ThwPhaseCloseThread {
    public static void main(String[] args) throws InterruptedException {
        ThwPhaseCloseThreadImpl thread = new ThwPhaseCloseThreadImpl();
        thread.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        thread.interrupt();
    }
}

@Slf4j
class ThwPhaseCloseThreadImpl {
    private Thread monitor;

    public void start() {
        monitor = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Thread thread = Thread.currentThread();
                    if (thread.isInterrupted()) {
                        log.info("料理后事 -- 释放锁 -- 关闭流链接");
                        break;
                    }
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                        log.info("执行监控记录信息");
                    } catch (InterruptedException e) {
                        log.info("监控线程被打断 正在关闭系统");
                        thread.interrupt();
                    }
                }
            }
        });
        monitor.start();
    }

    public void interrupt() {
        if (monitor == null) {
            log.info("打断行为异常，当前线程暂未初始化");
            return;
        }
        if (monitor.isInterrupted()) {
            log.info("打断行为异常，当前线程已经被打断");
            return;
        }
        monitor.interrupt();
    }
}
