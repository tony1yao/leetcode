package ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter extends RateLimiter{
    //TODO: clean the map
    private Map<Integer, Map<Long, Integer>> fixedWindowByCustomer= new ConcurrentHashMap<>();
    private Map<Long, AtomicInteger> fixedWindow = new ConcurrentHashMap<>();
    public FixedWindowRateLimiter(int maxRequestsPerSec) {
        super(maxRequestsPerSec);
    }

    @Override
    public boolean allow() {
        long windowKey = System.currentTimeMillis()/1000*1000;
        fixedWindow.putIfAbsent(windowKey, new AtomicInteger(0));
        return fixedWindow.get(windowKey).incrementAndGet() <= this.maxRequestsPerSec;
    }

    @Override
    public boolean allow(int customerId, int requestCounts) {
        fixedWindowByCustomer.putIfAbsent(customerId, new ConcurrentHashMap<>());
        long windowKey = (System.currentTimeMillis()/1000) * 1000;
        fixedWindowByCustomer.get(customerId).putIfAbsent(windowKey, 0);
        Integer count = fixedWindowByCustomer.get(customerId).get(windowKey);
        count += requestCounts;
        return count <= this.maxRequestsPerSec;
    }
}
