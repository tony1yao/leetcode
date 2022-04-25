package ratelimiter2;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketUser {
    private Map<Integer, TokenDetails> userToken;
    private int MAX_REQ_SEC;

    public TokenBucketUser(int maxRequestSec) {
        this.MAX_REQ_SEC = maxRequestSec;
        this.userToken = new HashMap<>();
    }

    public boolean accept(int userId) {
        synchronized (this) {
            userToken.putIfAbsent(userId, new TokenDetails());
            TokenDetails tokenDetails = userToken.get(userId);
            refillToken(tokenDetails);
            if (tokenDetails.token >=1) {
                tokenDetails.token--;
                System.out.println("Accepted request for user: " + userId);
                return true;
            }
            System.out.println("Rejected request for user: " + userId);
            return false;
        }
    }

    private void refillToken(TokenDetails tokenDetails) {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - tokenDetails.lastUpdateAt;
        double tokenToFill = timePassed / 1000.0 * this.MAX_REQ_SEC;
        if (tokenToFill > 0) {
            tokenDetails.token = Math.min(tokenDetails.token + tokenToFill, this.MAX_REQ_SEC);
            tokenDetails.lastUpdateAt = currentTime;
        }
    }

    private class TokenDetails {
        double token;
        long lastUpdateAt;

        public TokenDetails() {
            token = 0;
            lastUpdateAt = System.currentTimeMillis();
        }
    }
}
