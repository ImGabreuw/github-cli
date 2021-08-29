package me.gabreuw.who_unfollowed_me.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(value = "login")
    private String username;

    @JsonProperty(value = "html_url")
    private String url;

    private Integer followers;

    private Integer following;

    @Override
    public String toString() {
        return String.format(
                "Usuário: %s (%d seguidores / %d seguindo) - %s",
                username,
                followers,
                following,
                url
        );
    }
}
