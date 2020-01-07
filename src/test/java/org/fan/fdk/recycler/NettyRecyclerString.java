package org.fan.fdk.recycler;

import io.netty.util.Recycler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by fan.shuai on 2020/1/7.
 */
public class NettyRecyclerString {
    private String value;

    private transient final Recycler.Handle handle;

    private static final Recycler<NettyRecyclerString> recyclers = new Recycler<NettyRecyclerString>(512) {

        @Override
        protected NettyRecyclerString newObject(final Handle handle) {
            return new NettyRecyclerString(handle);
        }
    };

    public NettyRecyclerString(Recycler.Handle handle) {
        this.handle = handle;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void recycle() {
//        recyclers.recycle(this, handle);
        handle.recycle(this);
    }

    public static NettyRecyclerString getInstance() {
        return recyclers.get();
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        final NettyRecyclerString recyclerString = NettyRecyclerString.getInstance();

        recyclerString.setValue("hello fdk");
        recyclerString.recycle();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("in other thread, before recycle");
                    recyclerString.recycle();
                    System.out.println("in other thread, after recycle");
                    NettyRecyclerString recyclerString2 = NettyRecyclerString.getInstance();
                    System.out.println("in other thread, " + recyclerString2.getValue());
                } catch (Exception e) {
                    System.out.println("in thread error!");
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        try {
            // sleep使得recyclerString在thread线程中被回收。(此处用CountDownLatch更好)
            // 如果不sleep，有可能thread还没有回收recyclerString，导致后面的recyclerString1.getValue返回null
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recyclerString.recycle();

        NettyRecyclerString recyclerString1 = NettyRecyclerString.getInstance();

        System.out.println(recyclerString1.getValue());

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
