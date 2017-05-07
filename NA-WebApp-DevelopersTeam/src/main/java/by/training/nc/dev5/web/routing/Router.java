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
    private static final Router instance;

    static {
        instance = new Router();
    }

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

    public void forward(HttpServletRequest request,
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
            path = resolvePath("path.page.index");
        }
        path = resolvePath(path);

        rq = request.getRequestDispatcher(path);
        rq.forward(request, response);
    }

    public void redirect(HttpServletRequest request,
                                HttpServletResponse response,
                                String pageKey)
            throws IOException {

        String path = pageKey;

        if ("home".equals(path)) {
            Person user = (Person) request.getSession().getAttribute("user");

            path = resolveHome(user);
        }
        if (path.startsWith("path.page.")) {
            path = String.format("controller?command=go&location=%s", path);
        }

        response.sendRedirect(path);
    }

    public String resolvePath(String pageKey) {
        String path = routerProps.getProperty(pageKey, null);

        if (path == null) {
            path = routerProps.getProperty("path.page." + pageKey,
                    null);
        }

        return path;
    }

    private String resolveHome(Person user) {
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

    public static Router getInstance() {
        return instance;
    }
}
