package demo.webapp.service;

import demo.webapp.modle.AclUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * Created by Leon on 2015/11/23.
 */
public class UserService implements UserDetailsService {

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Assert.hasText(username, "登录名不能为空");

        UserDetails ud = new AclUser(username, username);

        return ud;
    }
}
