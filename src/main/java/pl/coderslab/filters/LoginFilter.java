package pl.coderslab.filters;

import org.springframework.web.filter.OncePerRequestFilter;
import pl.coderslab.model.entities.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/*"})
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final String url = req.getRequestURL().toString();

        if (allowedToEveryone(url)) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession sess = req.getSession();
        User user = (User) sess.getAttribute("loggedInUser");

        if (user == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(req.getContextPath() + "/privBet");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean allowedToEveryone(final String url) {
        if (url.endsWith("/user/register")
                || url.endsWith("/user/login") || url.endsWith("/privBet") || url.endsWith("/*.css")) {
            return true;
        }

        return false;
    }
}
