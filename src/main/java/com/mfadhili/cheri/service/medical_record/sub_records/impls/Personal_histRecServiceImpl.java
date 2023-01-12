package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Personal_history;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.Personal_historyRepository;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.Personal_histRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Personal_histRecServiceImpl implements Personal_histRecService {
    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private Personal_historyRepository personal_historyRepository;
    @Override
    public Personal_history addMedicalRecPersonal_history(Long ChildId, Personal_history personal_history_record) {
        Personal_history newPersonal_history = new Personal_history();

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);

            /** Adding the record from the activity payload*/
            newPersonal_history.setMedical_record(foundRecord.get(0));
            newPersonal_history.setLanguage(personal_history_record.getLanguage());
            newPersonal_history.setChief_complain(personal_history_record.getChief_complain());
            newPersonal_history.setInquiry_referral(personal_history_record.getInquiry_referral());
            newPersonal_history.setPostnatal_immunisation(personal_history_record.getPostnatal_immunisation());
            newPersonal_history.setSocial_status(personal_history_record.getSocial_status());


            return personal_historyRepository.save(newPersonal_history);
        }
    }

    @Override
    public Optional<Personal_history> getMedicalRecPersonal_history(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Personal_history foundPersonal_history;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundPersonal_history = personal_historyRepository.findByMedical_record(foundMedicalRec.get(0));

            return Optional.ofNullable(foundPersonal_history);
        }
    }

    @Override
    public Personal_history updateMedicalRecPersonal_history(Long ChildId, Personal_history personal_history_record) {
        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        Personal_history foundPersonal_history;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);
            foundPersonal_history = personal_historyRepository.findByMedical_record(foundRecord.get(0));

            /** Adding the record from the activity payload*/
            foundPersonal_history.setMedical_record(foundRecord.get(0));
            foundPersonal_history.setLanguage(personal_history_record.getLanguage());
            foundPersonal_history.setChief_complain(personal_history_record.getChief_complain());
            foundPersonal_history.setInquiry_referral(personal_history_record.getInquiry_referral());
            foundPersonal_history.setPostnatal_immunisation(personal_history_record.getPostnatal_immunisation());
            foundPersonal_history.setSocial_status(personal_history_record.getSocial_status());


            return personal_historyRepository.save(foundPersonal_history);
        }
    }

    @Override
    public String deleteMedicalRecPersonal_history(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Personal_history foundPersonal_history;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundPersonal_history = personal_historyRepository.findByMedical_record(foundMedicalRec.get(0));

            personal_historyRepository.deleteById(foundPersonal_history.getId());
        }
        return "Delete successful!";
    }
}
