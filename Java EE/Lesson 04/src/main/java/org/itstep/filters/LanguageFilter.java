package org.itstep.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LanguageFilter implements Filter {
    String lang = "";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        lang = filterConfig.getInitParameter("lang");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        var cookies = req.getCookies();
        Cookie cookie = null;

        if (cookies != null) {
            cookie = Arrays.stream(cookies).filter(c -> c.getName().equals("lang"))
                    .findFirst()
                    .orElse(null);
        }

        if (cookie == null) {
            var langCookie = new Cookie("lang", lang);
            resp.addCookie(langCookie);
        }

        //продолжение выполнения запроса по цепочке
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
