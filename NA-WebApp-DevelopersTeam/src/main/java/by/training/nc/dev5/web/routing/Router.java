package by.training.nc.dev5.web.routing;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.entity.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Nikita on 27.04.2017.
 */
public class Router {
    private static final Properties routerProps;

    static {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream propsInputStream = cl.getResourceAsStream(
                "path.page.properties");

        routerProps = new Properties();
        try {
            routerProps.load(propsInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void forward(HttpServletRequest request,
                               HttpServletResponse response,
                               String pageKey)
            throws ServletException, IOException {

        String path = pageKey;
        RequestDispatcher rq;

        if ("home".equals(path)) {
            Person user = (Person) request.getSession().getAttribute("user");

            path = resolveHome(user);
        }
        if (path == null) {
            path = "path.page.index";
        }
        path = resolvePath(path);

        rq = request.getRequestDispatcher(path);
        rq.forward(request, response);
    }

    public static void redirect(HttpServletRequest request,
                                HttpServletResponse response,
                                String pageKey)
            throws IOException {

        String path = pageKey;

        if ("home".equals(path)) {
            Person user = (Person) request.getSession().getAttribute("user");

            path = resolveHome(user);
        }
        if (path.startsWith("path.page.")) {
            path = resolvePath(pageKey);
        }

        response.sendRedirect(path);
    }

    private static String resolvePath(String pageKey) {
        return routerProps.getProperty(pageKey, null);
    }

    private static String resolveHome(Person user) {
        if (user == null) {
            return "path.page.index";
        }

        if (UserRole.CUSTOMER.equals(user.getUserRole())) {
            return "path.page.customer.main";
        } else if (UserRole.MANAGER.equals(user.getUserRole())) {
            return "path.page.manager.main";
        } else if (UserRole.DEVELOPER.equals(user.getUserRole())) {
            return "path.page.developer.main";
        } else {
            return "path.page.index";
        }
    }
}