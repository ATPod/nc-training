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
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Created by user on 09.05.2017.
 */
@Controller
public class DoctorAndNurseController {

    @Autowired
    private IDiagnosisService diagnosisService;
    @Autowired
    private IDrugService drugService;
    @Autowired
    private IMedProcedureService medProcedureService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private ISurgeryService surgeryService;
    @Autowired
    private PagePathManager pagePathManager;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/choosepatient", method = RequestMethod.GET)
    public String showChoosePatientForm(HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR || userType == UserType.NURSE){
            pagePath = pagePathManager.getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
        }
        else{
            pagePath = pagePathManager.getProperty(ConfigConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return pagePath;
    }

    @RequestMapping(value = "/choosepatient", method = RequestMethod.POST)
    public String choosePatient(ModelMap model,
                                @RequestParam(value = Parameters.PATIENT_ID, required = false) String patientId,
                                HttpServletRequest request, Locale locale){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try{
            if (patientId != null) {
                String patientName = patientService.getById(Integer.valueOf(patientId)).getName();
                session.setAttribute(Parameters.PATIENT_ID, patientId);
                session.setAttribute(Parameters.PATIENT_NAME, patientName);
                List<Diagnosis> diagnosises = diagnosisService.getByPatient(patientService.getById(Integer.valueOf(patientId)));
                List<Drug> drugs = drugService.getByPatient(patientService.getById(Integer.valueOf(patientId)));
                List<MedProcedure> medProcedures = medProcedureService.getByPatient(patientService.getById(Integer.valueOf(patientId)));
                List<Surgery> surgeries = surgeryService.getByPatient(patientService.getById(Integer.valueOf(patientId)));
                session.setAttribute(Parameters.DIAGNOSIS_LIST, diagnosises);
                session.setAttribute(Parameters.DRUGS_LIST, drugs);
                session.setAttribute(Parameters.MEDPROCEDURES_LIST, medProcedures);
                session.setAttribute(Parameters.SURGERIES_LIST, surgeries);
                if (userType == UserType.DOCTOR) {
                    return "redirect:/doctormenu";
                } else if (userType == UserType.NURSE) {
                    return "redirect:/nursemenu";
                } else {
                    session.invalidate();
                    return "redirect:/login";
                }
            }else {
                model.put(Parameters.OPERATION_MESSAGE, messageSource.getMessage(MessageConstants.EMPTY_CHOICE, null, locale));
                pagePath = pagePathManager.getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
            }
        }catch (DAOException e){
            return "redirect:/error";}
        return pagePath;
    }

    @RequestMapping(value = "/nursemenu", method = RequestMethod.GET)
    public String showNurseMenuForm(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.NURSE){
            return pagePathManager.getProperty(ConfigConstants.NURSE_MENU);
        } else{
            session.invalidate();
            return "redirect:/login";
        }
    }
    /*
    * public String delPatient(HttpServletRequest request, ModelMap model, Locale locale, RedirectAttributes redirectAttributes){
        HttpSession session = request.getSession();
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR) {
                patientService.delete(patientId);
                List<Patient> list = patientService.getAll();
                session.setAttribute(Parameters.PATIENTS_LIST, list);
                redirectAttributes.addFlashAttribute(Parameters.OPERATION_MESSAGE, messageSource.getMessage(MessageConstants.SUCCESS_OPERATION, null, locale));
                return "redirect:/doctormenu";
            } else {
                session.invalidate();
                return "redirect:/login";
            }
        } catch (DAOException e) {
            return "redirect:/error";
        }
    }*/
    @RequestMapping(value = "/deldrug", method = RequestMethod.POST)
    public String delDrug(@RequestParam(value = Parameters.DRUG_ID, required = false) String id,
                          HttpServletRequest request, Locale locale, RedirectAttributes redirectAttributes){
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR || userType == UserType.NURSE) {
                if (id != null) {
                    drugService.delete(Integer.valueOf(id));
                    Patient patient = patientService.getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<Drug> list = drugService.getByPatient(patient);
                    session.setAttribute(Parameters.DRUGS_LIST, list);
                    redirectAttributes.addFlashAttribute(Parameters.OPERATION_MESSAGE, messageSource.getMessage(MessageConstants.SUCCESS_OPERATION, null, locale));
                } else {
                    redirectAttributes.addFlashAttribute(Parameters.OPERATION_MESSAGE, messageSource.getMessage(MessageConstants.EMPTY_CHOICE, null, locale));
                }
                if (userType == UserType.DOCTOR) {
                    return "redirect:/doctormenu";
                } else {
                    return "redirect:/nursemenu";
                }
            } else {
                session.invalidate();
                return "redirect:/login";
            }
        }catch (DAOException e){
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/delmedprocedure", method = RequestMethod.POST)
    public String delMedProcedure(@RequestParam(value = Parameters.MEDPROCEDURE_ID, required = false) String id,
                                  HttpServletRequest request, Locale locale, RedirectAttributes redirectAttributes){
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR || userType == UserType.NURSE) {
                if (id != null) {
                    medProcedureService.delete(Integer.valueOf(id));
                    Patient patient = patientService.getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<MedProcedure> list = medProcedureService.getByPatient(patient);
                    session.setAttribute(Parameters.MEDPROCEDURES_LIST, list);
                    redirectAttributes.addFlashAttribute(Parameters.OPERATION_MESSAGE, messageSource.getMessage(MessageConstants.SUCCESS_OPERATION, null, locale));
                } else {
                    redirectAttributes.addFlashAttribute(Parameters.OPERATION_MESSAGE, messageSource.getMessage(MessageConstants.EMPTY_CHOICE, null, locale));
                }
                if (userType == UserType.DOCTOR) {
                    return "redirect:/doctormenu";
                } else {
                    return "redirect:/nursemenu";
                }
            } else {
                session.invalidate();
                return "redirect:/login";
            }
        }catch (DAOException e){
            return "redirect:/error";
        }
    }
}
