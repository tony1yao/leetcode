package ratelimiter;

public class RateLimiterFactory {
    public static RateLimiter getFixedWindowRateLimiter(int maxRequestPerSecond) {
        return new FixedWindowRateLimiter(maxRequestPerSecond);
    }

    public static RateLimiter getTokenBucketRateLimiter(int maxRequestPerSecond) {
        return new TokenBucketRateLimiter(maxRequestPerSecond);
    }

    public static RateLimiter getLeakyBucketRateLimiter(int maxRequestPerSecond) {
        return new LeakyBucket(maxRequestPerSecond);
    }

    public static RateLimiter getSlideWindowRateLimiter(int maxRequestPerSecond) {
        return new SlideWindow(maxRequestPerSecond);
    }
}
