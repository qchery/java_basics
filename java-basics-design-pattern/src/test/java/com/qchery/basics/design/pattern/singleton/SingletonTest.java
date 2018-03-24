package com.qchery.basics.design.pattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Chery
 * @date 2018/3/24 15:56
 */
public class SingletonTest {

    @Test
    public void testHungrySingleton() {
        generate(HungrySingletonTask.class);
    }

    @Test
    public void testLazySingleton() {
        generate(LazySingletonTask.class);
    }

    @Test
    public void testStaticHolderSingleton() {
        generate(StaticHolderSingletonTask.class);
    }

    @Test
    public void testEnumSingleton() {
        generate(EnumSingletonTask.class);
    }

    private void generate(Class<? extends Runnable> taskClass) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int taskCount = 20;
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);
        for (int j = 0; j < taskCount; j++) {
            try {
                Constructor<? extends Runnable> constructor = taskClass.getConstructor(CountDownLatch.class);
                executorService.submit(constructor.newInstance(countDownLatch));
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(countDownLatch.getCount());
        executorService.shutdown();
    }

}

abstract class MultiTask implements Runnable {

    private CountDownLatch countDownLatch;

    MultiTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                doRun();
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    abstract void doRun();
}

class HungrySingletonTask extends MultiTask {
    public HungrySingletonTask(CountDownLatch countDownLatch) {
        super(countDownLatch);
    }

    @Override
    public void doRun() {
        System.out.println(HungrySingleton.getInstance());
    }
}

class LazySingletonTask extends MultiTask {
    public LazySingletonTask(CountDownLatch countDownLatch) {
        super(countDownLatch);
    }

    @Override
    public void doRun() {
        System.out.println(LazySingleton.getInstance());
    }
}

class StaticHolderSingletonTask extends MultiTask {
    public StaticHolderSingletonTask(CountDownLatch countDownLatch) {
        super(countDownLatch);
    }

    @Override
    void doRun() {
        System.out.println(StaticHolderSingleton.getInstance());
    }
}

class EnumSingletonTask extends MultiTask {

    public EnumSingletonTask(CountDownLatch countDownLatch) {
        super(countDownLatch);
    }

    @Override
    void doRun() {
        System.out.println(EnumSingleton.INSTANCE);
    }
}