package org.postsnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsDTO {

    private String login;
    private char[] password;

    @Override
    public String toString() {
        return "CredentialsDTO{" +
                "login='" + login + '\'' +
                ", password=" + new String(password) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialsDTO that = (CredentialsDTO) o;
        return java.util.Arrays.equals(password, that.password) &&
                java.util.Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        int result = java.util.Objects.hash(login);
        result = 31 * result + java.util.Arrays.hashCode(password);
        return result;
    }
}
