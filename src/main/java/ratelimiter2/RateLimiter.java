package ratelimiter2;

abstract class RateLimiter {
    protected int MAX_REQUEST_SECOND;

    protected RateLimiter(int MAX_REQUEST_SECOND) {
        this.MAX_REQUEST_SECOND = MAX_REQUEST_SECOND;
    }

    abstract boolean accept();
}
