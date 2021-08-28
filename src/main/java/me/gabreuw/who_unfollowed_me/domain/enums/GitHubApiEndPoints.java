package me.gabreuw.who_unfollowed_me.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GitHubApiEndPoints {

    USERS("https://api.github.com/users/");

    @Getter
    private final String url;

}
