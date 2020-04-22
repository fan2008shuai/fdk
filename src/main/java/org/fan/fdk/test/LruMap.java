package org.fan.fdk.test;

import java.util.*;

public class LruMap {

    private Map<String, String> cache;
    private int size;
    private Map<String, Long> cacheTime;

    public LruMap(int size) {
        this.size = size;
        this.cache = new LinkedHashMap<>(size);
        this.cacheTime = new HashMap<>(size);
    }

    public void put(String key, String value) {
        if (cache.size() == size) {
            deleteTheOldest();
        }

        cache.put(key, value);
        cacheTime.put(key, System.currentTimeMillis());
    }

    private void deleteTheOldest() {
        // delete old
        List<Long> times = new LinkedList<>();
        Map<Long, List<String>> timeToKeys = new HashMap<>();
        for (Map.Entry<String, Long> entry : cacheTime.entrySet()) {
            Long time = entry.getValue();
            times.add(time);
            List<String> keys = timeToKeys.get(time);
            if (keys == null) {
                keys = new LinkedList<>();
                timeToKeys.put(time, keys);
            }
            keys.add(entry.getKey());
        }
        Collections.sort(times);
        Long expiredTime = times.get(0);
        List<String> expiredKeys = timeToKeys.get(expiredTime);
        //如果容忍毫秒级的可以多删一下提升性能，否则只删除第一个
        for (String expiredKey : expiredKeys) {
            cache.remove(expiredKey);
            cacheTime.remove(expiredKey);
        }
    }
}
