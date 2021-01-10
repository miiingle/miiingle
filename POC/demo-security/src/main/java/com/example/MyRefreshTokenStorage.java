package com.example;

import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.errors.IssuingAnAccessTokenErrorCode;
import io.micronaut.security.errors.OauthErrorResponseException;
import io.micronaut.security.token.event.RefreshTokenGeneratedEvent;
import io.micronaut.security.token.refresh.RefreshTokenPersistence;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class MyRefreshTokenStorage implements RefreshTokenPersistence {

    private final Map<String, String> tokens = new HashMap<>();

    @Override
    public void persistToken(RefreshTokenGeneratedEvent event) {
        if (event != null &&
                event.getRefreshToken() != null &&
                event.getUserDetails() != null &&
                event.getUserDetails().getUsername() != null) {
            String payload = event.getRefreshToken();
            tokens.put(payload, event.getUserDetails().getUsername());
        }
    }

    //actual guide: https://guides.micronaut.io/micronaut-security-jwt/guide/index.html
    @Override
    public Publisher<UserDetails> getUserDetails(String refreshToken) {
        return Flowable.create(emitter -> {
            String tokenOpt = tokens.get(refreshToken);
            if (tokenOpt != null) {
                emitter.onNext(new UserDetails(tokenOpt, new ArrayList<>()));
                emitter.onComplete();
            } else {
                emitter.onError(new OauthErrorResponseException(IssuingAnAccessTokenErrorCode.INVALID_GRANT, "refresh token not found", null));
            }
        }, BackpressureStrategy.ERROR);
    }
}