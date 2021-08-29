package me.gabreuw.who_unfollowed_me.command;

import lombok.RequiredArgsConstructor;
import me.gabreuw.who_unfollowed_me.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GitHubUserInfoCommand {

    private final GitHubService gitHubService;

    @ShellMethod("Show basic info from a GitHub user")
    public String info(String username) {
        return gitHubService
                .fetchGitHubUserInfo(username)
                .toString();
    }

    @ShellMethod("Show followers from a GitHub user")
    public void followers(String username) {
        gitHubService
                .fetchGitHubUserFollowers(username)
                .forEach(System.out::println);
    }

    @ShellMethod("Show following from a GitHub user")
    public void following(String username) {
        gitHubService
                .fetchGitHubUserFollowing(username)
                .forEach(System.out::println);
    }

}
