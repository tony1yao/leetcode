package ratelimiter2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RateLimiterTester {
    public static void main(String[] args) {
        int maxRequestSec = 20;
//        RateLimiter rateLimiter = new FixedWindow(maxRequestSec);
//
//        sendRequest(rateLimiter, 500, 100);

        TokenBucketUser tokenBucketUser = new TokenBucketUser(maxRequestSec);
        new Thread(()->{
            sendRequest(tokenBucketUser, 1, 500, 100);
        }).start();
        new Thread(()->{
            sendRequest(tokenBucketUser, 2, 500, 100);
        }).start();
    }

    private static void sendRequest(TokenBucketUser rateLimiter, int userId, int numOfReq, int requestsPerSec) {
        ExecutorService executorService = Executors.newFixedThreadPool(numOfReq);
        int requestInterval = 1000 / requestsPerSec;
        long startTimeStamp = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(numOfReq);

        for(int i = 0 ; i < numOfReq; i++) {
            executorService.submit(new Thread(()->{
                    while(!rateLimiter.accept(userId)) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // request is accepted;
                countDownLatch.countDown();

            }));
            try {
                TimeUnit.MILLISECONDS.sleep(requestInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //
        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTimeStamp = System.currentTimeMillis();
        long duration = endTimeStamp - startTimeStamp;
        double rate = numOfReq * 1000.0 / duration;

        System.out.println(numOfReq+ " handled in " +duration+ " ms, for user "+userId+" rate is " + rate + "per seconds");
    }
}
