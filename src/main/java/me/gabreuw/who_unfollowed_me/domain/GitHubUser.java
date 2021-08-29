package me.gabreuw.who_unfollowed_me.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class GitHubUser extends BaseGitHubUser {

    @JsonProperty(value = "html_url")
    private String url;

    private Integer followers;

    private Integer following;

    @Override
    public String toString() {
        return String.format(
                "%s (%d seguidores / %d seguindo) - %s",
                super.toString(),
                followers,
                following,
                url
        );
    }
}

