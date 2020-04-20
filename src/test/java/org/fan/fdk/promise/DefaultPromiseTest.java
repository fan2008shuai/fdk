package org.fan.fdk.promise;

import io.netty.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


public class DefaultPromiseTest {

    public static void main(String[] args) {

        EventExecutor executorService = new DefaultEventExecutor();

        Promise<Integer> promise = new DefaultPromise<Integer>(executorService);

        promise.addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("success: " + future.get());
                } else {
                    System.out.println("failed: " + future.cause());
                }
            }
        }).addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                System.out.println("complete!");
            }
        });

        executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                TimeUnit.SECONDS.sleep(2);

//                promise.setSuccess(555);
                promise.setFailure(new RuntimeException("error!"));

                return null;
            }
        });

        try {
            promise.sync();
//            promise.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        catch (Throwable throwable) {
//            System.out.println("here");
//            throwable.printStackTrace();
//        }
        System.out.println("main over");

    }
}
