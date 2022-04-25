package ratelimiter;

public abstract class RateLimiter {
    protected final int maxRequestsPerSec;

    protected RateLimiter(int maxRequestsPerSec) {
        this.maxRequestsPerSec = maxRequestsPerSec;
    }

    public abstract boolean allow();
    public abstract boolean allow(int custmerId, int requestCounts);
}
