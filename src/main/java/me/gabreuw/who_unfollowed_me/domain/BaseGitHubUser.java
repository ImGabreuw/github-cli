package me.gabreuw.who_unfollowed_me.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseGitHubUser implements Serializable {

    @JsonProperty(value = "login")
    protected String username;

    @Override
    public String toString() {
        return "Usuário: " + username;
    }
}
