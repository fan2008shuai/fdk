package org.fan.fdk.recycler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by fan.shuai on 2020/1/7.
 */
public class RecyclerString {

    private String value;

    private transient final Recyclers.Handle handle;

    private static final Recyclers<RecyclerString> recyclers = new Recyclers<RecyclerString>(512) {

        @Override
        protected RecyclerString newObject(final Handle handle) {
            return new RecyclerString(handle);
        }
    };

    public RecyclerString(Recyclers.Handle handle) {
        this.handle = handle;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void recycle() {
        recyclers.recycle(this, handle);
    }

    public static RecyclerString getInstance() {
        return recyclers.get();
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        final RecyclerString recyclerString = RecyclerString.getInstance();

        recyclerString.setValue("hello fdk");
//        recyclerString.recycle();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("in other thread, before recycle");
                    recyclerString.recycle();
                    System.out.println("in other thread, after recycle");
                    RecyclerString recyclerString2 = RecyclerString.getInstance();
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

        RecyclerString recyclerString1 = RecyclerString.getInstance();

        System.out.println(recyclerString1.getValue());

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
