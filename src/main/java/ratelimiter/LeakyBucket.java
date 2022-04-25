package ratelimiter;

public class LeakyBucket extends RateLimiter{
    long nextUpdateTime;
    int TOKEN_INTERVAL;
    public LeakyBucket(int maxRequestPerSec) {
        super(maxRequestPerSec);
        this.TOKEN_INTERVAL = 1000/maxRequestPerSec;
        this.nextUpdateTime = System.currentTimeMillis();
    }
    @Override
    public boolean allow() {
        synchronized (this) {
            long currentTime = System.currentTimeMillis();
            if (currentTime > this.nextUpdateTime + this.TOKEN_INTERVAL) {
                this.nextUpdateTime = currentTime;
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
