package 创建线程;

public class Main {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1");
            }
        },"线程1").start();
    }
}
