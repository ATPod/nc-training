package by.training.nc.dev5.clinic.commands.doctor.add;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Drug;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.DrugService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddDrugCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String name = request.getParameter(Parameters.DRUG_NAME);
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        if(!name.isEmpty()){
            Drug drug = new Drug();
            drug.setName(name);
            drug.setPatientId(patientId);
            DrugService.add(drug);
            List<Drug> list = DrugService.getByPatientId(patientId);
            session.setAttribute(Parameters.DRUGS_LIST, list);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
        } else{
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_DRUG);
        }
        return page;
    }
}
