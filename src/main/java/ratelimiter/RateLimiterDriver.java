package ratelimiter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RateLimiterDriver {
    public static void main(String[] args) {
        final int MAX_REQUEST_PER_SEC = 50;
        // RateLimiter rateLimiter = RateLimiterFactory.getFixedWindowRateLimiter(MAX_REQUEST_PER_SEC);
        RateLimiter rateLimiter = RateLimiterFactory.getTokenBucketRateLimiter(MAX_REQUEST_PER_SEC);
        // RateLimiter rateLimiter = RateLimiterFactory.getLeakyBucketRateLimiter(MAX_REQUEST_PER_SEC);
        // RateLimiter rateLimiter = RateLimiterFactory.getSlideWindowRateLimiter(MAX_REQUEST_PER_SEC);
//        Thread thread = new Thread(() -> {
////            sendRequest(rateLimiter, 10, 5);
////            sendRequest(rateLimiter, 20, 5);
////            sendRequest(rateLimiter,100, 10);
////            sendRequest(rateLimiter,100, 30);
//            sendRequest(rateLimiter,200, 100);
//        });
//
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        sendRequest(rateLimiter,200, 100);
    }

    private static void sendRequest(RateLimiter rateLimiter, int requestCounts, int requestPerSec) {
        CountDownLatch countDownLatch = new CountDownLatch(requestCounts);
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < requestCounts; i ++) {
            new Thread(() -> {
                while(!rateLimiter.allow()) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                countDownLatch.countDown();
            }).start();
            try {
                TimeUnit.MILLISECONDS.sleep(1000/requestPerSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finishTime = System.currentTimeMillis();
        double durationMSec = finishTime - startTime;
        System.out.println(requestCounts + " requests processed in " + durationMSec + " ms, rate is " + requestCounts/durationMSec*1000 + " per second");
    }

    private static void sendRequest(RateLimiter rateLimiter, int customerId, int requestCounts, int requestPerSec) {
        CountDownLatch countDownLatch = new CountDownLatch(requestCounts);
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < requestCounts; i ++) {
            new Thread(() -> {
                while(!rateLimiter.allow(customerId, requestPerSec)) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                countDownLatch.countDown();
            }).start();
            try {
                TimeUnit.MILLISECONDS.sleep(1000/requestPerSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finishTime = System.currentTimeMillis();
        double durationMSec = finishTime - startTime;
        System.out.println(requestCounts + " requests processed in " + durationMSec + " ms, rate is " + requestCounts/durationMSec*1000 + " per second");
    }
}


