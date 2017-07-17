package ru.itis.inform.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.models.User;

import java.util.ArrayList;
import java.util.List;

import static ru.itis.inform.security.user.Roles.ADMIN;
import static ru.itis.inform.security.user.Roles.USER;

/**
 * Created by Yoko on 16.07.2017.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        User user = userDao.findByToken(token);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRole().equals(ADMIN.toString())) {
            authorities.add(new SimpleGrantedAuthority(ADMIN.toString()));
        } else {
            authorities.add(new SimpleGrantedAuthority(USER.toString()));
        }
        return new UserDetailsImpl(user.getLogin(), user.getHashPassword(), authorities);
    }
}
