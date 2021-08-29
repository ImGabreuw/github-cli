package me.gabreuw.who_unfollowed_me.service;

import lombok.RequiredArgsConstructor;
import me.gabreuw.who_unfollowed_me.domain.BaseGitHubUser;
import me.gabreuw.who_unfollowed_me.domain.GitHubUser;
import me.gabreuw.who_unfollowed_me.service.exception.GitHubUserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static me.gabreuw.who_unfollowed_me.domain.enums.GitHubApiEndPoints.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GitHubService {

    private final RestTemplate restTemplate;

    public GitHubUser fetchGitHubUserInfo(String username) {
        ResponseEntity<GitHubUser> response = restTemplate
                .getForEntity(
                        USERS.getUrl() + username,
                        GitHubUser.class
                );

        if (response.getStatusCode() == NOT_FOUND) {
            throw new GitHubUserNotFound(username);
        }

        return response.getBody();
    }

    public List<GitHubUser> fetchGitHubUserFollowers(String username) {
        ResponseEntity<List<GitHubUser>> response = restTemplate
                .exchange(
                        String.format(
                                FOLLOWERS.getUrl(),
                                username
                        ),
                        GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );

        if (response.getStatusCode() == NOT_FOUND) {
            throw new GitHubUserNotFound(username);
        }

        return Objects.requireNonNull(response.getBody())
                .stream()
                .map(BaseGitHubUser::getUsername)
                .map(this::fetchGitHubUserInfo)
                .collect(Collectors.toList());
    }

    public List<GitHubUser> fetchGitHubUserFollowing(String username) {
        ResponseEntity<List<BaseGitHubUser>> response = restTemplate
                .exchange(
                        String.format(
                                FOLLOWING.getUrl(),
                                username
                        ),
                        GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );

        if (response.getStatusCode() == NOT_FOUND) {
            throw new GitHubUserNotFound(username);
        }

        return Objects.requireNonNull(response.getBody())
                .stream()
                .map(BaseGitHubUser::getUsername)
                .map(this::fetchGitHubUserInfo)
                .collect(Collectors.toList());
    }

}
