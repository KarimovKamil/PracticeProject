package ru.itis.inform.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.inform.dao.impl.UserDaoImpl;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.models.User;
import ru.itis.inform.services.impl.admin.AdminServiceImpl;
import ru.itis.inform.services.interfaces.admin.AdminService;
import ru.itis.inform.validation.Validation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 05.12.2016.
 *
 * @author Maxim Romanov
 */
@Order(1)
@ComponentScan(value = "ru.itis.inform")
public class TokenAuthenticationFilter extends GenericFilterBean {

    @Autowired
    AdminService adminService;

    public TokenAuthenticationFilter() {
        this.adminService = new AdminServiceImpl();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, AuthenticationException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookie = request.getCookies();
        String token = "";
        if (cookie != null) {
            for (Cookie cookie1 : cookie) {
                if (cookie1.getName().equals("Auth-Token")) {
                    token = cookie1.getValue();
                    break;
                }
            }
        }
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
                        response.sendError(403, "U must be admin");
                    }
                }
            } else {
                if (!token.isEmpty() && !token.equals("")) {
                    User user = adminService.profile(token);
                    if (!isAdminMethod(request)) {
                        List<GrantedAuthority> grantedAuthorities = grantAuthorities(user);
                        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getHashPassword(), grantedAuthorities);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        filterChain.doFilter(request, response);
                    } else {
                        if (user.getRole().equals("ADMIN")) {
                            List<GrantedAuthority> grantedAuthorities = grantAuthorities(user);
                            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getHashPassword(), grantedAuthorities);
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            filterChain.doFilter(request, response);
                        } else {
                            response.sendError(403, "U must be admin");
                        }
                    }
                    filterChain.doFilter(request, response);
                } else {
                    if (isAdminMethod(request)) {
                        ((HttpServletResponse) servletResponse).sendRedirect("/admin/login");
                    } else {
                        ((HttpServletResponse) servletResponse).sendRedirect("/login");
                    }
                }
            }
        }
    }

    private boolean isSecuredMethod(HttpServletRequest request) {
        return !((request.getRequestURI().endsWith("/login") && request.getMethod().equals("POST"))
                || (request.getRequestURI().endsWith("/login") && request.getMethod().equals("GET"))
                || (request.getRequestURI().contains("/hi") && request.getMethod().equals("GET")));
    }

    private boolean isAdminMethod(HttpServletRequest request) {
        return (request.getRequestURI().contains("/admin")) &&
                !(request.getRequestURL().equals("/admin/login"));
    }

    private List<GrantedAuthority> grantAuthorities(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user.getRole().equals(Roles.ADMIN.toString())) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Roles.ADMIN.toString()));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority(Roles.USER.toString()));
        }
        return grantedAuthorities;
    }
}
