package by.training.nc.dev5.commands.turor;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddTestCommand  extends AbstractCommand{
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String testName= (String)session.getAttribute("testName");
        int questionAmount=(Integer)session.getAttribute("questionAmount");
        int optionAmount=(Integer)session.getAttribute("optionAmount");
        List<String> questions=new ArrayList<>();
        for(int i=0;i<questionAmount;i++)
        {
            String question=request.getParameter("questionText"+(i+1));
            questions.add(question);
            for(int j=0;j<optionAmount;j++)
            {
            }
        }
        session.setAttribute("questions",questions);
     return JspPaths.ADD_TEST;
    }
}
