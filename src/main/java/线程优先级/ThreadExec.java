package 线程优先级;

import lombok.extern.slf4j.Slf4j;

public class ThreadExec {
    public static void main(String[] args) {
        ThreadFunction01 threadFunction01 = new ThreadFunction01();
        new Thread(threadFunction01).start();
    }
}

@Slf4j
class ThreadFunction01 implements Runnable {
    ThreadFunction02 threadFunction02;

    public ThreadFunction01() {
        this.threadFunction02 = new ThreadFunction02();
    }

    @Override
    public void run() {
        log.info("线程正在启动");
        Thread thread = new Thread(threadFunction02);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Slf4j
class ThreadFunction02 implements Runnable {
    ThreadFunction03 threadFunction03;

    public ThreadFunction02() {
        this.threadFunction03 = new ThreadFunction03();
    }

    @Override
    public void run() {
        log.info("线程正在执行");
        Thread thread = new Thread(threadFunction03);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Slf4j
class ThreadFunction03 implements Runnable {

    @Override
    public void run() {
        log.info("线程正在关闭");
    }
}