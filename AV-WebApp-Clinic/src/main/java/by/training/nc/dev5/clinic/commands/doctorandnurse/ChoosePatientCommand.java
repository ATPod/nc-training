package by.training.nc.dev5.clinic.commands.doctorandnurse;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Diagnosis;
import by.training.nc.dev5.clinic.beans.patient.prescribing.Drug;
import by.training.nc.dev5.clinic.beans.patient.prescribing.Procedure;
import by.training.nc.dev5.clinic.beans.patient.prescribing.Surgery;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChoosePatientCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        String patientId = request.getParameter(Parameters.PATIENT_ID);
        if(patientId != null){
            String patientName = PatientService.getById(Integer.valueOf(patientId)).getName();
            session.setAttribute(Parameters.PATIENT_ID, patientId);
            session.setAttribute(Parameters.PATIENT_NAME, patientName);
            List<Diagnosis> diagnosises = DiagnosisService.getByPatientId(Integer.valueOf(patientId));
            List<Drug> drugs = DrugService.getByPatientId(Integer.valueOf(patientId));
            List<Procedure> procedures = ProcedureService.getByPatientId(Integer.valueOf(patientId));
            List<Surgery> surgeries = SurgeryService.getByPatientId(Integer.valueOf(patientId));
            session.setAttribute(Parameters.DIAGNOSIS_LIST, diagnosises);
            session.setAttribute(Parameters.DRUGS_LIST, drugs);
            session.setAttribute(Parameters.PROCEDURES_LIST, procedures);
            session.setAttribute(Parameters.SURGERIES_LIST, surgeries);
            if(userType == UserType.DOCTOR) {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
            } else if(userType == UserType.NURSE){
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.NURSE_MENU);
            } else{
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                session.invalidate();
            }
        } else {
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_CHOICE));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_PATIENTS_PAGE);
        }
        return page;
    }
}
/*if(!((List)session.getAttribute(Parameters.PATIENTS_LIST)).isEmpty())*/