package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Overview;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.OverviewRepository;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.OverviewRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OverviewRecServiceImpl implements OverviewRecService {
    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private OverviewRepository overviewRepository;
    @Override
    public Overview addMedicalRecOverview(Long ChildId, Overview overview_record) {
        Overview newOverview = new Overview();

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);

            /** Adding the record from the activity payload*/
            newOverview.setMedical_record(foundRecord.get(0));
            newOverview.setProblems_identified(overview_record.getProblems_identified());
            newOverview.setFeeding_eating(overview_record.getFeeding_eating());
            newOverview.setDx(overview_record.getDx());
            newOverview.setOt_issues(overview_record.getOt_issues());

            return overviewRepository.save(newOverview);
        }
    }

    @Override
    public Optional<Overview> getMedicalRecOverview(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Overview foundOverview;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundOverview = overviewRepository.findByMedical_record(foundMedicalRec.get(0));

            return Optional.ofNullable(foundOverview);
        }
    }

    @Override
    public Overview updateMedicalRecOverview(Long ChildId, Overview overview_record) {
        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        Overview foundOverview;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);
            foundOverview = overviewRepository.findByMedical_record(foundRecord.get(0));


            /** Adding the record from the activity payload*/
            foundOverview.setMedical_record(foundRecord.get(0));
            foundOverview.setProblems_identified(overview_record.getProblems_identified());
            foundOverview.setFeeding_eating(overview_record.getFeeding_eating());
            foundOverview.setDx(overview_record.getDx());
            foundOverview.setOt_issues(overview_record.getOt_issues());

            return overviewRepository.save(foundOverview);
        }
    }

    @Override
    public String deleteMedicalRecOverview(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Overview foundOverview;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundOverview = overviewRepository.findByMedical_record(foundMedicalRec.get(0));

            overviewRepository.deleteById(foundOverview.getId());
        }
        return "Delete successful!";
    }
}
