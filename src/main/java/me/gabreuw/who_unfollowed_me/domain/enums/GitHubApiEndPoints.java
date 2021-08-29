package me.gabreuw.who_unfollowed_me.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GitHubApiEndPoints {

    USERS("https://api.github.com/users/"),
    FOLLOWERS("https://api.github.com/users/%s/following"),
    FOLLOWING("https://api.github.com/users/%s/following"),
    FOLLOWING_WITH_TARGET("https://api.github.com/users/%s/following/%s");

    @Getter
    private final String url;

}
