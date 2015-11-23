package demo.webapp.modle;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Leon on 2015/11/23.
 */
public class AclUser implements UserDetails {
    private String username;
    private String password;
    private Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    public AclUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority auth = new GrantedAuthority() {
            public String getAuthority() {
                return "ROLE_LOGIN";
            }
        };

        authorities.add(auth);
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
