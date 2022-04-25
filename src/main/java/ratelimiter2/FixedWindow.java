package ratelimiter2;

import java.util.HashMap;
import java.util.Map;

public class FixedWindow extends RateLimiter{
    private Map<Long, Integer> requestsMap = new HashMap<>();
    public FixedWindow(int MAX_REQUEST_SECOND) {
        super(MAX_REQUEST_SECOND);
    }

    @Override
    boolean accept() {
        synchronized (this) {
            long windowKey = System.currentTimeMillis() / 1000 * 1000;
            if (!requestsMap.containsKey(windowKey)) {
                requestsMap.clear();
                requestsMap.put(windowKey, 0);
            }
            int requests = requestsMap.get(windowKey);
            if (requests < this.MAX_REQUEST_SECOND) {
                requests++;
                requestsMap.put(windowKey, requests);
                return true;
            }
            return false;
        }
    }
}
