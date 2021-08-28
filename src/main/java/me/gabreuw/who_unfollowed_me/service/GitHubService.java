package me.gabreuw.who_unfollowed_me.service;

import lombok.RequiredArgsConstructor;
import me.gabreuw.who_unfollowed_me.domain.GitHubUser;
import me.gabreuw.who_unfollowed_me.service.exception.GitHubUserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static me.gabreuw.who_unfollowed_me.domain.enums.GitHubApiEndPoints.USERS;
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

}
