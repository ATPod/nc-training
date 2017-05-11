package by.training.nc.dev5.clinic.controllers;

import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.prescribings.Diagnosis;
import by.training.nc.dev5.clinic.entities.prescribings.Drug;
import by.training.nc.dev5.clinic.entities.prescribings.MedProcedure;
import by.training.nc.dev5.clinic.entities.prescribings.Surgery;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.services.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 09.05.2017.
 */
@Controller
public class DoctorAndNurseController {

    @RequestMapping(value = "/choosepatient", method = RequestMethod.GET)
    public String showChoosePatientForm(HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR || userType == UserType.NURSE){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
        }
        else{
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return pagePath;
    }

    @RequestMapping(value = "/choosepatient", method = RequestMethod.POST)
    public String choosePatient(ModelMap model,
                                @RequestParam(value = Parameters.PATIENT_ID, required = false) String patientId,
                                HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try{
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
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                } else if (userType == UserType.NURSE) {
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.NURSE_MENU);
                } else {
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
                    session.invalidate();
                }
            }else {
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_CHOICE));
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
            }
        }catch (DAOException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }

    @RequestMapping(value = "/deldrug", method = RequestMethod.POST)
    public String delDrug(@RequestParam(value = Parameters.DRUG_ID, required = false) String id,
                          HttpServletRequest request,
                          ModelMap model){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR || userType == UserType.NURSE) {
                if (id != null) {
                    DrugService.getInstance().delete(Integer.valueOf(id));
                    Patient patient = PatientService.getInstance().getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<Drug> list = DrugService.getInstance().getByPatient(patient);
                    session.setAttribute(Parameters.DRUGS_LIST, list);
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                } else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_CHOICE));
                }
                if (userType == UserType.DOCTOR) {
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                } else {
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.NURSE_MENU);
                }
            } else {
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
                session.invalidate();
            }
        }catch (DAOException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }

    @RequestMapping(value = "/delmedprocedure", method = RequestMethod.POST)
    public String delMedProcedure(@RequestParam(value = Parameters.MEDPROCEDURE_ID, required = false) String id,
                                  HttpServletRequest request,
                                  ModelMap model){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR || userType == UserType.NURSE) {
                if (id != null) {
                    MedProcedureService.getInstance().delete(Integer.valueOf(id));
                    Patient patient = PatientService.getInstance().getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<MedProcedure> list = MedProcedureService.getInstance().getByPatient(patient);
                    session.setAttribute(Parameters.MEDPROCEDURES_LIST, list);
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                } else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_CHOICE));
                }
                if (userType == UserType.DOCTOR) {
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                } else {
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.NURSE_MENU);
                }
            } else {
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
                session.invalidate();
            }
        }catch (DAOException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }
}
