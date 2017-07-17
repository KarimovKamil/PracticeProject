package ru.itis.inform.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.models.User;
import ru.itis.inform.validation.Validation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 05.12.2016.
 *
 * @author Maxim Romanov
 */
@Order(1)
public class TokenAuthenticationFilter extends GenericFilterBean {

    @Autowired
    UserDao userDao;
    @Autowired
    private Validation validation;

    public TokenAuthenticationFilter() {
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
            if (!token.isEmpty() && !token.equals("") && validation.userExistenceByToken(token)) {
                if (!isAdminMethod(request)) {
                    filterChain.doFilter(request, response);
                } else {
                    User user = userDao.findByToken(token);
                    if (user.getRole().equals("ADMIN")) {
                        filterChain.doFilter(request, response);
                    } else {
                        response.sendError(403, "U must be admin");
                    }
                }
                filterChain.doFilter(request, response);
            } else {
                ((HttpServletResponse) servletResponse).sendRedirect("/login");
            }
        }
    }

    private boolean isSecuredMethod(HttpServletRequest request) {
        return !((request.getRequestURI().endsWith("/login") && request.getMethod().equals("POST"))
                || (request.getRequestURI().endsWith("/login") && request.getMethod().equals("GET"))
                || (request.getRequestURI().contains("/hi") && request.getMethod().equals("GET")));
    }

    private boolean isAdminMethod(HttpServletRequest request) {
        return (request.getRequestURI().contains("/admin"));
    }
}
