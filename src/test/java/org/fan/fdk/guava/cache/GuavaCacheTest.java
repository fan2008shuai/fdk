package org.fan.fdk.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by fan.shuai on 2019/12/9.
 */
public class GuavaCacheTest {
    Integer i = 0;
    AtomicInteger count = new AtomicInteger(0);

    private final ListeningExecutorService executorService =
            MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());


    @Test
    public void testCacheUse() throws Exception {
        LoadingCache<String, SkuCache> loadingCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(1000, TimeUnit.MILLISECONDS)
                //Prevent data reloading from failing, but the value of memory remains the same
//                .expireAfterWrite(2500, TimeUnit.MILLISECONDS)
                .build(new CacheLoader<String, SkuCache>() {
                    @Override
                    public SkuCache load(String key) {
                        SkuCache skuCache = new SkuCache();
                        skuCache.setSkuCode(key + "---" + (++i));
                        skuCache.setSkuId(key);
                        skuCache.setRealQuantity(100L);
                        System.out.println("load..." + key);
                        return skuCache;
                    }

                    @Override
                    public ListenableFuture<SkuCache> reload(String key, SkuCache oldValue) throws Exception {
//                        ListenableFuture<SkuCache> listenableFuture = executorService.submit(new Callable<SkuCache>() {
//                            @Override
//                            public SkuCache call() throws Exception {
//                                checkNotNull(key);
//
//                                checkNotNull(oldValue);
//                                System.out.println("reload..." + (++i));
//                                //Simulate time consuming operation
//                                // xxxxxxx
//                                Thread.sleep(1000);
//                                return load(key);
//                            }
//                        });
//                        return listenableFuture;

                        //异步实现，get方法可以返回旧数据
                        //如果不是异步实现，则get方法阻塞
                        checkNotNull(key);
                        checkNotNull(oldValue);
                        System.out.println("reload..." + (++i));
                        //Simulate time consuming operation
                        Thread.sleep(1000);
                        return Futures.immediateFuture(load(key));
                    }
                });


        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        getValue(loadingCache);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.in.read();
        System.out.println("finish");
    }


    private void getValue(LoadingCache<String, SkuCache> loadingCache) throws Exception {
        for (int i = 0; i < 7; i++) {
            Thread.sleep(1000l);
            System.out.println(loadingCache.get("sku").toString() + " - " + count.incrementAndGet());
        }
    }
}
