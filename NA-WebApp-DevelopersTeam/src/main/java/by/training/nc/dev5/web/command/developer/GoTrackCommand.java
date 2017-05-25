package by.training.nc.dev5.web.command.developer;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.TimeSheetDto;
import by.training.nc.dev5.service.TimeTrackingService;
import by.training.nc.dev5.service.TimeTrackingServiceImpl;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Nikita on 11.05.2017.
 */
public class GoTrackCommand implements Command {
    private TimeTrackingService timeTrackingService;
    private Router router;

    {
        timeTrackingService = new TimeTrackingServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        DeveloperDto user = (DeveloperDto) request.getSession()
                .getAttribute("user");
        Collection<TimeSheetDto> timeSheets =
                timeTrackingService.getTimeSheets(user);

        request.setAttribute("timeSheets", timeSheets);

        router.forward(request, response, "path.page.developer.track");
    }
}
