package me.gabreuw.who_unfollowed_me.service.exception;

public class GitHubUserNotFound extends RuntimeException {

    public GitHubUserNotFound(String username) {
        super(String.format(
                "Usuário (%s) não encontrado.",
                username
        ));
    }

}
