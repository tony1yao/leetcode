package ratelimiter;

public class TokenBucketRateLimiter extends RateLimiter{
    private int token;
    private long lastUpdateTime;

    public TokenBucketRateLimiter(int maxRequestPerSec) {
        super(maxRequestPerSec);
        this.token = maxRequestPerSec;
        this.lastUpdateTime = System.currentTimeMillis();
    }

    @Override
    public boolean allow() {
        synchronized (this) {
            this.reFillToken();
            if (this.token > 0) {
                this.token --;
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean allow(int custmerId, int requestCounts) {
        return false;
    }

    private void reFillToken() {
        long now = System.currentTimeMillis();
        double timeGap = (now - lastUpdateTime) / 1000.0;
        int tokenToFill = (int) (timeGap * maxRequestsPerSec);
        if (tokenToFill > 0) {
            this.token = Math.min(this.token + tokenToFill, this.maxRequestsPerSec);
            this.lastUpdateTime = now;
        }
    }
}
