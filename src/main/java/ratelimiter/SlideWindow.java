package ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlideWindow extends RateLimiter{
    int lastSecCount;
    long lastUpdateTime;
    Map<Long, Integer> timeWindowCount = new ConcurrentHashMap<>();
    public SlideWindow (int maxRequestPerSec) {
        super(maxRequestPerSec);
        lastSecCount = 0;
        lastUpdateTime = System.currentTimeMillis();
    }
    @Override
    public boolean allow() {
        synchronized (this) {
            long currentTime = System.currentTimeMillis();
            long currentWindowKey= currentTime / 1000 * 1000;
            timeWindowCount.putIfAbsent(currentWindowKey, 0);
            long lastWindowKey = currentWindowKey - 1000;
            double currentWindowPercentage = (currentTime - currentWindowKey) / 1000.0;
            double lastWindowPercentage = 1 - currentWindowPercentage;
            int lastWindowCount = timeWindowCount.getOrDefault(lastWindowKey, 0);
            int currentWindowCount = timeWindowCount.get(currentWindowKey);
            int count = (int)(lastWindowCount * lastWindowPercentage + currentWindowCount);
            if (count < maxRequestsPerSec) {
                timeWindowCount.replace(currentWindowKey, ++currentWindowCount);
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean allow(int custmerId, int requestCounts) {
        return false;
    }
}
