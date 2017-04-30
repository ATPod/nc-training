package by.training.nc.dev5.web.routing;

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

        String path = resolvePath(pageKey);
        RequestDispatcher rq;

        if (path == null) {
            path = resolvePath("path.page.error.notFound");
        }

        rq = request.getRequestDispatcher(path);
        rq.forward(request, response);
    }

    public static void redirect(HttpServletResponse response,
                                String pageKey)
            throws IOException {

        String path = pageKey;

        if (path.startsWith("path.page.")) {
            path = resolvePath(pageKey);
        }

        response.sendRedirect(path);
    }

    private static String resolvePath(String pageKey) {
        return routerProps.getProperty(pageKey, null);
    }
}
