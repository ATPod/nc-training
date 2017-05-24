package by.training.nc.dev5.web.tag;

import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.service.QualificationService;
import by.training.nc.dev5.service.QualificationServiceImpl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
public class QualificationSelectTag extends SimpleTagSupport {
    private QualificationService qualificationService;
    private String controlName;
    private String formId;

    {
        qualificationService = new QualificationServiceImpl();
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String formIdAttr;
        Collection<QualificationDto> qualifications = qualificationService
                .getQualifications();

        if (formId == null) {
            formIdAttr = "";
        } else {
            formIdAttr = String.format("form='%s'", formId);
        }

        // TODO: add optionCss attr
        out.print(String.format(
                "<select class='form-control' %s name='%s'>",
                formIdAttr, controlName));

        for (QualificationDto qualification : qualifications) {
            out.print(String.format(
                    "<option value='%d'>%s</option>",
                    qualification.getId(),
                    qualification.getName()
            ));
        }
        out.print("</select>");
    }

    /**
     * Sets the value of controlName
     *
     * @param controlName the new value of controlName.
     */
    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    /**
     * Sets the value of formId
     *
     * @param formId the new value of formId.
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }
}
