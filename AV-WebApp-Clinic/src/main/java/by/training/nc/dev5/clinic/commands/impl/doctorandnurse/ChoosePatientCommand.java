package by.training.nc.dev5.clinic.commands.impl.doctorandnurse;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.entities.prescribings.Diagnosis;
import by.training.nc.dev5.clinic.entities.prescribings.Drug;
import by.training.nc.dev5.clinic.entities.prescribings.MedProcedure;
import by.training.nc.dev5.clinic.entities.prescribings.Surgery;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChoosePatientCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        String patientId = request.getParameter(Parameters.PATIENT_ID);
        try {
            if (patientId != null) {
                String patientName = PatientService.getInstance().getById(Integer.valueOf(patientId)).getName();
                session.setAttribute(Parameters.PATIENT_ID, patientId);
                session.setAttribute(Parameters.PATIENT_NAME, patientName);
                List<Diagnosis> diagnosises = DiagnosisService.getInstance().getByPatient(PatientService.getInstance().getById(Integer.valueOf(patientId)));
                List<Drug> drugs = DrugService.getInstance().getByPatient(PatientService.getInstance().getById(Integer.valueOf(patientId)));
                List<MedProcedure> medProcedures = MedProcedureService.getInstance().getByPatient(PatientService.getInstance().getById(Integer.valueOf(patientId)));
                List<Surgery> surgeries = SurgeryService.getInstance().getByPatient(PatientService.getInstance().getById(Integer.valueOf(patientId)));
                session.setAttribute(Parameters.DIAGNOSIS_LIST, diagnosises);
                session.setAttribute(Parameters.DRUGS_LIST, drugs);
                session.setAttribute(Parameters.MEDPROCEDURES_LIST, medProcedures);
                session.setAttribute(Parameters.SURGERIES_LIST, surgeries);
                if (userType == UserType.DOCTOR) {
                    page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                } else if (userType == UserType.NURSE) {
                    page = PagePathManager.getInstance().getProperty(ConfigConstants.NURSE_MENU);
                } else {
                    page = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
                    session.invalidate();
                }
            } else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_CHOICE));
                page = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
            }
        }catch (DAOException e){
            page = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}