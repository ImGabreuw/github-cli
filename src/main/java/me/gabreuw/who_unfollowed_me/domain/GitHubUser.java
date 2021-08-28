package me.gabreuw.who_unfollowed_me.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GitHubUser implements Serializable {

    private String login;

    private Integer followers;

    private Integer following;

    @Override
    public String toString() {
        return String.format(
                "Usuário: %s (%d seguidores / %d seguindo)",
                login,
                followers,
                following
        );
    }
}
