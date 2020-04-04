package concurrent;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author niushaokai
 * @date 2020/2/1
 */

class ObjPool16<T, R> {
    final List<T> pool;
    // 用信号量实现限流器
    final Semaphore sem;

    // 构造函数
    ObjPool16(int size, T t) {
        pool = new Vector<T>();
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    // 利用对象池的对象，调用 func
    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建对象池
        ObjPool16<Long, String> poolMain = new ObjPool16<Long, String>(10, 2l);
        // 通过对象池获取 t，之后执行
        poolMain.exec(t ->
        {
            System.out.println(t);
            return t.toString();
        });
    }
}


