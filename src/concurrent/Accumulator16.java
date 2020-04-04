package concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author niushaokai
 * @date 2020/2/1
 */
public class Accumulator16 {
    static int count;
    // 初始化信号量
    static final Semaphore s
            = new Semaphore(1);

    // 用信号量保证互斥
    static void addOne() throws InterruptedException {
        s.acquire();
        try {
            count += 1;
        } finally {
            s.release();
        }
    }
}