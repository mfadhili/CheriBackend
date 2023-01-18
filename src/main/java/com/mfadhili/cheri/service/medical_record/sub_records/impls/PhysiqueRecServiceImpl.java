package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_guardian.child.Children;
import com.mfadhili.cheri.data.domain.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.medical_record.subrecords.Physique;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.PhysiqueRepository;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.PhysiqueRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysiqueRecServiceImpl implements PhysiqueRecService {
    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private PhysiqueRepository physiqueRepository;


    @Override
    public Physique addMedicalRecPhysique(Long ChildId, Physique physique_record) {
        Physique newPhysique = new Physique();

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);

            /** Check if the record exist. Solution to prevent multiple records*/
            Optional<Physique> foundPhysique = Optional.ofNullable(physiqueRepository.findByMedical_record(foundRecord.get(0)));
            if (foundPhysique.isPresent()){
                throw new IllegalStateException("Overview record of Child " + ChildId + " exists, please update or delete");
            }
            else {
                /** Adding the record from the activity payload*/
                newPhysique.setMedical_record(foundRecord.get(0));
                newPhysique.setAuditory(physique_record.getAuditory());
                newPhysique.setBalance(physique_record.getBalance());
                newPhysique.setBody_alignment(physique_record.getBody_alignment());
                newPhysique.setGastro(physique_record.getGastro());
                newPhysique.setHair_col_dist(physique_record.getHair_col_dist());
                newPhysique.setHead_circumference(physique_record.getHead_circumference());
                newPhysique.setObservable_features(physique_record.getObservable_features());
                newPhysique.setOlfactory(physique_record.getOlfactory());
                newPhysique.setOther_conditions(physique_record.getOther_conditions());
                newPhysique.setVisual(physique_record.getVisual());
                newPhysique.setVisual(physique_record.getVisual());
                newPhysique.setTactile(physique_record.getTactile());
                newPhysique.setScars_deforms(physique_record.getScars_deforms());
                newPhysique.setPlay_leisure(physique_record.getPlay_leisure());
                newPhysique.setPerceptual(physique_record.getPerceptual());

                return physiqueRepository.save(newPhysique);
            }
        }
    }

    @Override
    public Optional<Physique> getMedicalRecPhysique(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Physique foundPhysique;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundPhysique = physiqueRepository.findByMedical_record(foundMedicalRec.get(0));

            return Optional.ofNullable(foundPhysique);
        }
    }

    @Override
    public Physique updateMedicalRecPhysique(Long ChildId, Physique physique_record) {
        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        Physique foundPhysique;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);
            foundPhysique = physiqueRepository.findByMedical_record(foundRecord.get(0));


            /** Adding the record from the activity payload*/
            foundPhysique.setMedical_record(foundRecord.get(0));
            foundPhysique.setAuditory(physique_record.getAuditory());
            foundPhysique.setBalance(physique_record.getBalance());
            foundPhysique.setBody_alignment(physique_record.getBody_alignment());
            foundPhysique.setGastro(physique_record.getGastro());
            foundPhysique.setHair_col_dist(physique_record.getHair_col_dist());
            foundPhysique.setHead_circumference(physique_record.getHead_circumference());
            foundPhysique.setObservable_features(physique_record.getObservable_features());
            foundPhysique.setOlfactory(physique_record.getOlfactory());
            foundPhysique.setOther_conditions(physique_record.getOther_conditions());
            foundPhysique.setVisual(physique_record.getVisual());
            foundPhysique.setVisual(physique_record.getVisual());
            foundPhysique.setTactile(physique_record.getTactile());
            foundPhysique.setScars_deforms(physique_record.getScars_deforms());
            foundPhysique.setPlay_leisure(physique_record.getPlay_leisure());
            foundPhysique.setPerceptual(physique_record.getPerceptual());

            return physiqueRepository.save(foundPhysique);
        }

    }

    @Override
    public String deleteMedicalRecPhysique(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Physique foundPhysique;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundPhysique = physiqueRepository.findByMedical_record(foundMedicalRec.get(0));

            physiqueRepository.deleteById(foundPhysique.getId());
        }
        return "Delete successful!";
    }
}
