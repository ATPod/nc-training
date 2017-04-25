package by.training.nc.dev5.clinic.commands.doctor.add;

import by.training.nc.dev5.clinic.entities.MedProcedure;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.PatientService;
import by.training.nc.dev5.clinic.services.MedProcedureService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddMedProcedureCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String name = request.getParameter(Parameters.MEDPROCEDURE_NAME);
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        if(!name.isEmpty()){
            MedProcedure medProcedure = new MedProcedure();
            Patient patient = PatientService.getById(patientId);
            medProcedure.setName(name);
            medProcedure.setPatient(patient);
            MedProcedureService.add(medProcedure);
            List<MedProcedure> list = MedProcedureService.getByPatient(patient);
            session.setAttribute(Parameters.MEDPROCEDURES_LIST, list);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
        } else{
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_MEDPROCEDURE);
        }
        return page;
    }

}
