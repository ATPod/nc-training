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
import by.training.nc.dev5.clinic.services.*;
import by.training.nc.dev5.clinic.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 09.05.2017.
 */
@Controller
public class DoctorController {

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

    @RequestMapping(value = "/doctormenu", method = RequestMethod.GET)
    public String showDoctorMenuForm(HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
        }
        else{
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return pagePath;
    }

    @RequestMapping(value = "/addpatient", method = RequestMethod.GET)
    public String showAddPatientForm(HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_PATIENT);
        }
        else{
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return pagePath;
    }

    @RequestMapping(value = "/addpatient", method = RequestMethod.POST)
    public String addPatient(@RequestParam(value = Parameters.PATIENT_NAME, required = false) String name,
                             ModelMap model,
                             HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        try{
            if(!name.isEmpty()){
                if(name.length()<= ConfigConstants.MAX_STRING_LENGTH) {
                    if (patientService.isNewPatient(name)) {
                        Patient patient = new Patient();
                        patient.setName(name);
                        patientService.add(patient);
                        List<Patient> list = patientService.getAll();
                        session.setAttribute(Parameters.PATIENTS_LIST, list);
                        pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
                        model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                    } else {
                        pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_PATIENT);
                        model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.PATIENT_EXISTS));
                    }
                }else {
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_PATIENT);
                }
            } else{
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_PATIENT);
            }
        }catch (DAOException e) {
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }

    @RequestMapping(value = "/adddiagnosis", method = RequestMethod.GET)
    public String showAddDiagnosisForm(HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_DIAGNOSIS);
        } else{
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
            session.invalidate();
        }
        return pagePath;
    }

    @RequestMapping(value = "/adddiagnosis", method = RequestMethod.POST)
    public String addDiagnosis(@RequestParam(value = Parameters.DIAGNOSIS_NAME, required = false) String name,
                               ModelMap model,
                               HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        try {
            if (!name.isEmpty()) {
                if(name.length()<= ConfigConstants.MAX_STRING_LENGTH) {
                    Diagnosis diagnosis = new Diagnosis();
                    Patient patient = patientService.getById(patientId);
                    diagnosis.setName(name);
                    diagnosis.setPatient(patient);
                    diagnosisService.add(diagnosis);
                    List<Diagnosis> list = diagnosisService.getByPatient(patient);
                    session.setAttribute(Parameters.DIAGNOSIS_LIST, list);
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                }else {
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_DIAGNOSIS);
                }
            } else {
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_DIAGNOSIS);
            }
        }catch (DAOException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }

    @RequestMapping(value = "/adddrug", method = RequestMethod.GET)
    public String showAddDrugForm(HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_DRUG);
        } else{
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
            session.invalidate();
        }
        return pagePath;
    }

    @RequestMapping(value = "/adddrug", method = RequestMethod.POST)
    public String addDrug(@RequestParam(value = Parameters.DRUG_NAME, required = false) String name,
                          ModelMap model,
                          HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        try {
            if (!name.isEmpty()) {
                if(name.length()<= ConfigConstants.MAX_STRING_LENGTH) {
                    Drug drug = new Drug();
                    Patient patient = patientService.getById(patientId);
                    drug.setName(name);
                    drug.setPatient(patient);
                    drugService.add(drug);
                    List<Drug> list = drugService.getByPatient(patient);
                    session.setAttribute(Parameters.DRUGS_LIST, list);
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                }else {
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_DRUG);
                }
            } else {
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_DRUG);
            }
        }catch (DAOException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }

    @RequestMapping(value = "/addmedprocedure", method = RequestMethod.GET)
    public String showAddMedProcedureForm(HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_MEDPROCEDURE);
        } else{
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
            session.invalidate();
        }
        return pagePath;
    }

    @RequestMapping(value = "/addmedprocedure", method = RequestMethod.POST)
    public String addMedProcedure(@RequestParam(value = Parameters.MEDPROCEDURE_NAME, required = false) String name,
                                  ModelMap model, HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        try {
            if (!name.isEmpty()) {
                if(name.length()<= ConfigConstants.MAX_STRING_LENGTH) {
                    MedProcedure medProcedure = new MedProcedure();
                    Patient patient = patientService.getById(patientId);
                    medProcedure.setName(name);
                    medProcedure.setPatient(patient);
                    medProcedureService.add(medProcedure);
                    List<MedProcedure> list = medProcedureService.getByPatient(patient);
                    session.setAttribute(Parameters.MEDPROCEDURES_LIST, list);
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                }else {
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_MEDPROCEDURE);
                }
            } else {
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_MEDPROCEDURE);
            }
        }catch (DAOException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }

    @RequestMapping(value = "/addsurgery", method = RequestMethod.GET)
    public String showAddSurgeryForm(HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_SURGERY);
        } else{
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
            session.invalidate();
        }
        return pagePath;
    }

    @RequestMapping(value = "/addsurgery", method = RequestMethod.POST)
    public String addSurgery(@RequestParam(value = Parameters.SURGERY_NAME, required = false) String name,
                             ModelMap model,
                             HttpServletRequest request){
        String pagePath;
        HttpSession session = request.getSession();
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        try {
            if (!name.isEmpty()) {
                if(name.length()<= ConfigConstants.MAX_STRING_LENGTH) {
                    Surgery surgery = new Surgery();
                    Patient patient = patientService.getById(patientId);
                    surgery.setName(name);
                    surgery.setPatient(patient);
                    surgeryService.add(surgery);
                    List<Surgery> list = surgeryService.getByPatient(patient);
                    session.setAttribute(Parameters.SURGERIES_LIST, list);
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                }else {
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_SURGERY);
                }
            } else {
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_SURGERY);
            }
        }catch (DAOException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }

    @RequestMapping(value = "/deldiagnosis", method = RequestMethod.POST)
    public String delDiagnosis(@RequestParam(value = Parameters.DIAGNOSIS_ID, required = false) String id,
                               HttpServletRequest request,
                               ModelMap model){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR) {
                if (id != null) {
                    diagnosisService.delete(Integer.valueOf(id));
                    Patient patient = patientService.getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<Diagnosis> list = diagnosisService.getByPatient(patient);
                    session.setAttribute(Parameters.DIAGNOSIS_LIST, list);
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                } else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_CHOICE));
                }
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
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

    @RequestMapping(value = "/delsurgery", method = RequestMethod.POST)
    public String delSurgery(@RequestParam(value = Parameters.SURGERY_ID, required = false) String id,
                             HttpServletRequest request,
                             ModelMap model){
        String pagePath;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR) {
                if (id != null) {
                    surgeryService.delete(Integer.valueOf(id));
                    Patient patient = patientService.getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<Surgery> list = surgeryService.getByPatient(patient);
                    session.setAttribute(Parameters.SURGERIES_LIST, list);
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                } else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_CHOICE));
                }
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
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

    @RequestMapping(value = "/delpatient", method = RequestMethod.POST)
    public String delPatient(HttpServletRequest request, ModelMap model){
        String pagePath=null;
        HttpSession session = request.getSession();
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if (userType == UserType.DOCTOR) {
            try {
                patientService.delete(patientId);
                List<Patient> list = patientService.getAll();
                session.setAttribute(Parameters.PATIENTS_LIST, list);
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));

            } catch (DAOException e) {
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
            }
        }
        return pagePath;
    }
}