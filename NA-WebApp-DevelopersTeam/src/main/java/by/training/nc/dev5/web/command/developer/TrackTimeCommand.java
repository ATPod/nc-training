package by.training.nc.dev5.web.command.developer;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.service.TimeTrackingService;
import by.training.nc.dev5.service.TimeTrackingServiceImpl;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 11.05.2017.
 */
public class TrackTimeCommand implements Command {
    private TimeTrackingService timeTrackingService;
    private Router router;

    {
        router = Router.getInstance();
        timeTrackingService = new TimeTrackingServiceImpl();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        DeveloperDto user = (DeveloperDto) request.getSession()
                .getAttribute("user");
        int time = Integer.parseInt(request.getParameter("time"));
        String uri = "controller?command=goTrack";

        if (user.getProject() == null) {
            request.setAttribute("trackTimeErrorMessage",
                    "You are not assigned to any project");

            new GoTrackCommand().execute(request, response);
            return;
        }

        timeTrackingService.trackTime(user, time);


        router.redirect(request, response, uri);
    }
}
