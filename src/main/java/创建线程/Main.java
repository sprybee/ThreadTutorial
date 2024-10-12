package 创建线程;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main {
    public static void main(String[] args) {
        // 创建线程
        Thread thread = new Thread(() -> {
            log.debug("running");
        }, "t1");
        // 启动线程
        thread.start();
        log.debug("running");
    }
}
