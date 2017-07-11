package by.training.nc.dev5.web.tag;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.service.QualificationService;
import by.training.nc.dev5.service.impl.QualificationServiceImpl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
public class QualificationSelectTag extends SimpleTagSupport {
    // TODO: add qualificationList attribute
    // TODO: replace with spring's select tag

//    private QualificationService qualificationService;
    private String controlName;
    private String formId;
    private String idAttr;
    private Iterable<QualificationDto> qualifications;

//    private static DaoFactory daoFactory;

    static {
//        daoFactory = DaoFactory.getDaoFactory();
    }

    {
//        QualificationDao qualificationDao = daoFactory.getQualificationDao();
//        qualificationService = new QualificationServiceImpl(qualificationDao);
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String formIdAttr;
        String id;
//        Collection<QualificationDto> qualifications = qualificationService
//                .getQualifications();

        if (formId == null) {
            formIdAttr = "";
        } else {
            formIdAttr = String.format("form='%s'", formId);
        }

        if (idAttr == null) {
            id = "";
        } else {
            id = String.format("id='%s'", idAttr);
        }

        // TODO: add optionCss attr
        out.print(String.format(
                "<select class='form-control' %s %s name='%s'>",
                formIdAttr, id, controlName));

        out.print("<option value=''>All</option>");
        for (QualificationDto qualification : getQualifications()) {
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

    /**
     * Gets the value of qualifications
     *
     * @return the value of qualifications.
     */
    public Iterable<QualificationDto> getQualifications() {
        return qualifications;
    }

    /**
     * Sets the value of qualifications
     *
     * @param qualifications the new value of qualifications.
     */
    public void setQualifications(Iterable<QualificationDto> qualifications) {
        this.qualifications = qualifications;
    }

    /**
     * Sets the value of idAttr
     *
     * @param idAttr the new value of idAttr.
     */
    public void setIdAttr(String idAttr) {
        this.idAttr = idAttr;
    }
}
