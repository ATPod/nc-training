package by.training.nc.dev5.clinic.commands.doctor.add;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Diagnosis;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.DiagnosisService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddDiagnosisCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String name = request.getParameter(Parameters.DIAGNOSIS_NAME);
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        if(!name.isEmpty()){
            Diagnosis diagnosis = new Diagnosis();
            diagnosis.setName(name);
            diagnosis.setPatientId(patientId);
            DiagnosisService.add(diagnosis);
            List<Diagnosis> list = DiagnosisService.getByPatientId(patientId);
            session.setAttribute(Parameters.DIAGNOSIS_LIST, list);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
        } else{
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_DIAGNOSIS);
        }
        return page;
    }
}
