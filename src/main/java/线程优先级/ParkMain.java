package 线程优先级;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ParkMain {
    public static void main(String[] args) throws InterruptedException {
        ParkThread parkThread = new ParkThread();
        parkThread.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        parkThread.interrupt();


    }
}

@Slf4j
class ParkThread extends Thread {
    @Override
    public void run() {
        log.info("线程正在启动");
        LockSupport.park();
        log.info("线程正在退出");
        //System.out.println(Thread.interrupted());
        LockSupport.park();
    }
}