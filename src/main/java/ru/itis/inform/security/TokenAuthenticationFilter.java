package ru.itis.inform.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.inform.exceptions.PermissionException;
import ru.itis.inform.exceptions.TokenAuthenticationException;
import ru.itis.inform.security.user.Roles;
import ru.itis.inform.validation.Validation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Yoko on 16.07.2017.
 */
public class TokenAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private final UserDetailsService userDetailsService;
    @Autowired
    private TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint;
    @Autowired
    private PermissionEntryPoint permissionEntryPoint;
    @Autowired
    private Validation validation;

    public TokenAuthenticationFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, AuthenticationException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("Auth-Token");

        if (!isSecuredMethod(request)) {
            filterChain.doFilter(request, response);
        } else {
            if (null != SecurityContextHolder.getContext() && null != SecurityContextHolder.getContext().getAuthentication()) {
                SecurityContext contextHolder = SecurityContextHolder.getContext();
                UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) contextHolder.getAuthentication();
                ArrayList<GrantedAuthority> authorities = (ArrayList<GrantedAuthority>) authentication.getAuthorities();
                if (authorities.get(0).toString().equals(Roles.ADMIN.toString())) {
                    filterChain.doFilter(request, response);
                } else {
                    if (!isAdminMethod(request)) {
                        filterChain.doFilter(request, response);
                    } else {
                        permissionEntryPoint.commence(request, response, new PermissionException("You do not have permissions for this"));
                    }
                }
            } else {
                if (null != token && !token.isEmpty() && validation.userExistenceByToken(token)) {
                    UserDetails user = userDetailsService.loadUserByUsername(token);

                    if (isAdminMethod(request)) {
                        ArrayList<GrantedAuthority> grantedAuthorities = (ArrayList<GrantedAuthority>) user.getAuthorities();
                        if (grantedAuthorities.get(0).toString().equals(Roles.ADMIN.toString())) {
                            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            filterChain.doFilter(request, response);
                        } else {
                            permissionEntryPoint.commence(request, response, new PermissionException("You do not have permissions for this"));
                        }
                    } else {
                        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        filterChain.doFilter(request, response);
                    }
                } else {
                    tokenAuthenticationEntryPoint.commence(request, response, new TokenAuthenticationException("Token not found"));
                }
            }
        }
    }

    private boolean isSecuredMethod(HttpServletRequest request) {
        return !((request.getRequestURI().endsWith("/login") && request.getMethod().equals("POST"))
                || (request.getRequestURI().contains("/hi") && request.getMethod().equals("GET")));
    }

    private boolean isAdminMethod(HttpServletRequest request) {
        return (request.getRequestURI().contains("/admin"));
    }

}
