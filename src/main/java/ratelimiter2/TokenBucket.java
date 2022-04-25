package ratelimiter2;

public class TokenBucket extends RateLimiter{
    double token;
    long lastUpdatedTime;

    public TokenBucket(int MAX_REQUEST_SECOND) {
        super(MAX_REQUEST_SECOND);
        this.token = 0;
        this.lastUpdatedTime = System.currentTimeMillis();
    }

    @Override
    boolean accept() {
        synchronized (this) {
            this.refillToken();
            if (token >= 1) {
                token--;
                return true;
            }
            return false;
        }
    }

    private void refillToken() {
        long currentTime = System.currentTimeMillis();
        long durationSinceLastUpdate = currentTime - this.lastUpdatedTime;
        double tokenToRefill = durationSinceLastUpdate / 1000.0 * this.MAX_REQUEST_SECOND;
        if (tokenToRefill > 0) {
            this.token = Math.min(this.token + tokenToRefill, this.MAX_REQUEST_SECOND);
            this.lastUpdatedTime = currentTime;
        }
    }
}
