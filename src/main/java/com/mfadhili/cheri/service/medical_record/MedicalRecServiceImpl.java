package com.mfadhili.cheri.service.medical_record;

import com.mfadhili.cheri.data.domain.Admin_Home.caregiver.Caregiver;
import com.mfadhili.cheri.data.domain.child_guardian.child.Children;
import com.mfadhili.cheri.data.domain.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.medical_record.subrecords.*;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.*;
import com.mfadhili.cheri.data.requestBodies.MedicalRequest;
import com.mfadhili.cheri.data.repository.CaregiverRepository;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecServiceImpl implements MedicalRecService {
    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private CaregiverRepository caregiverRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private Cognitive_abilityRepository cognitive_abilityRepository;
    @Autowired
    private PhysiqueRepository physiqueRepository;
    @Autowired
    private Occup_therapyRepository occup_therapyRepository;
    @Autowired
    private OverviewRepository overviewRepository;
    @Autowired
    private Personal_historyRepository personal_historyRepository;
    @Autowired
    private SummaryRepository summaryRepository;


    @Override
    /** Instantiate a medical record*/
    public Medical_record addMedicalRecord(Long childId, Medical_record medical_record) {
        Medical_record newMedical_record = new Medical_record();

        /**TODO: Replace Mock Caregiver with source from authentication principle */
        Caregiver caregiver = caregiverRepository.findCaregiverId(Long.valueOf("1"));

        /** Check child exists*/
        Optional<Children> oldChild = childrenRepository.findById(childId);
        
        if (oldChild.isEmpty()) {
            throw new IllegalStateException("Child of Id "+ childId + " Does not exist");
        }
        else {
            Children child = childrenRepository.findChildId(childId);
            newMedical_record.setChildren_id(child);
            newMedical_record.setCaregiver(caregiver);

            medical_recordRepository.save(newMedical_record);
            return newMedical_record;
        }
    }

    @Override
    public Medical_record addMedicalRecordAll(Long childId, MedicalRequest medicalRequest) {
        Medical_record newMedical_record = new Medical_record();

        /**TODO: Replace Mock Caregiver with source from authentication principle */
        Caregiver caregiver = caregiverRepository.findCaregiverId(Long.valueOf("1"));

        /** Check child exists*/
        Optional<Children> oldChild = childrenRepository.findById(childId);

        if (oldChild.isEmpty()) {
            throw new IllegalStateException("Child of Id "+ childId + " Does not exist");
        }
        else {
            /** Check if a medical Record exists. Avoiding duplicates*/
            Children child = childrenRepository.findChildId(childId);
            /** Adding Medical layout base*/
            newMedical_record.setChildren_id(child);
            newMedical_record.setCaregiver(caregiver);
            Medical_record saved_record = medical_recordRepository.save(newMedical_record);

            /** Adding Activity Record*/
            Activity newActivity = new Activity();
            newActivity.setMedical_record(saved_record);
            newActivity.setCommunication_skills(medicalRequest.getActivity_communication_skills());
            newActivity.setDomestic_skills(medicalRequest.getActivity_domestic_skills());
            newActivity.setDressing_skills(medicalRequest.getActivity_dressing_skills());
            newActivity.setFeeding_eating(medicalRequest.getActivity_Feeding_eating());
            newActivity.setHygiene_skills(medicalRequest.getActivity_hygiene_skills());
            activityRepository.save(newActivity);

            /** Adding Cognitive Ability record*/
            Cognitive_ability newCognitive_ability = new Cognitive_ability();
            newCognitive_ability.setMedical_record(saved_record);
            newCognitive_ability.setMemory(medicalRequest.getCognitive_memory());
            newCognitive_ability.setPlanning(medicalRequest.getCognitive_planning());
            newCognitive_ability.setOrganisational(medicalRequest.getCognitive_organisational());
            cognitive_abilityRepository.save(newCognitive_ability);

            /** Adding Physique Record*/
            Physique newPhysique = new Physique();
            newPhysique.setMedical_record(saved_record);
            newPhysique.setAuditory(medicalRequest.getPhysique_auditory());
            newPhysique.setBalance(medicalRequest.getPhysique_balance());
            newPhysique.setBody_alignment(medicalRequest.getPhysique_body_alignment());
            newPhysique.setGastro(medicalRequest.getPhysique_gastro());
            newPhysique.setHair_col_dist(medicalRequest.getPhysique_hair_col_dist());
            newPhysique.setHead_circumference(medicalRequest.getPhysique_head_circumference());
            newPhysique.setObservable_features(medicalRequest.getPhysique_observable_features());
            newPhysique.setOlfactory(medicalRequest.getPhysique_olfactory());
            newPhysique.setOther_conditions(medicalRequest.getPhysique_other_conditions());
            newPhysique.setVisual(medicalRequest.getPhysique_visual());
            newPhysique.setTactile(medicalRequest.getPhysique_tactile());
            newPhysique.setScars_deforms(medicalRequest.getPhysique_scars_deforms());
            newPhysique.setPlay_leisure(medicalRequest.getPhysique_play_leisure());
            newPhysique.setPerceptual(medicalRequest.getPhysique_perceptual());
            physiqueRepository.save(newPhysique);

            /**Adding Occupation Therapy */
            Occup_therapy newOccupTherapyRec = new Occup_therapy();
            newOccupTherapyRec.setMedical_record(saved_record);
            newOccupTherapyRec.setNeed_for_therapy(medicalRequest.getTherapy_need_for_therapy());
            newOccupTherapyRec.setExtensive_support(medicalRequest.getTherapy_extensive_support());
            newOccupTherapyRec.setReferral_followup(medicalRequest.getTherapy_referral_followup());
            newOccupTherapyRec.setWellness_support(medicalRequest.getTherapy_wellness_support());
            occup_therapyRepository.save(newOccupTherapyRec);

            /** Adding Overview*/
            Overview newOverview = new Overview();
            newOverview.setMedical_record(saved_record);
            newOverview.setProblems_identified(medicalRequest.getOverview_problems_identified());
            newOverview.setFeeding_eating(medicalRequest.getActivity_Feeding_eating());
            newOverview.setDx(medicalRequest.getOverview_dx());
            newOverview.setOt_issues(medicalRequest.getOverview_ot_issues());
            overviewRepository.save(newOverview);

            /** Adding Personal History*/
            Personal_history newPersonal_history = new Personal_history();
            newPersonal_history.setMedical_record(saved_record);
            newPersonal_history.setLanguage(medicalRequest.getHistory_language());
            newPersonal_history.setChief_complain(medicalRequest.getHistory_chief_complain());
            newPersonal_history.setInquiry_referral(medicalRequest.getHistory_inquiry_referral());
            newPersonal_history.setPostnatal_immunisation(medicalRequest.getHistory_postnatal_immunisation());
            newPersonal_history.setSocial_status(medicalRequest.getHistory_social_status());
            personal_historyRepository.save(newPersonal_history);

            /** Adding Summary */
            Summary newSummary = new Summary();
            newSummary.setMedical_record(saved_record);
            newSummary.setAllergies(medicalRequest.getSummary_allergies());
            newSummary.setSpeaking_condition(medicalRequest.getSummary_speaking_condition());
            newSummary.setSkin_condition(medicalRequest.getSummary_skin_condition());
            newSummary.setPsychological_condition(medicalRequest.getSummary_psychological_condition());
            newSummary.setPhysical_condition(medicalRequest.getSummary_physical_condition());
            newSummary.setHearing_condition(medicalRequest.getSummary_hearing_condition());
            newSummary.setOthers(medicalRequest.getSummary_others());
            summaryRepository.save(newSummary);

            return newMedical_record;
        }
    }

    @Override
    public Optional<Medical_record> updateMedicalRecAll(Long childId, MedicalRequest medicalRequest) {
        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(childId);
        List<Medical_record> foundRecord;

        /** Initialise sub records*/
        Activity foundActivityRec;
        Cognitive_ability foundCognitive_ability;
        Occup_therapy foundOccup_therapy;
        Overview foundOverview;
        Personal_history foundPersonal_history;
        Physique foundPhysique;
        Summary foundSummary;

        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + childId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(childId);
            foundRecord = medical_recordRepository.findByChildren_id(child);
            
            foundActivityRec = activityRepository.findByMedical_record(foundRecord.get(0));
            foundCognitive_ability = cognitive_abilityRepository.findByMedical_record(foundRecord.get(0));
            foundOccup_therapy = occup_therapyRepository.findByMedical_record(foundRecord.get(0));
            foundOverview = overviewRepository.findByMedical_record(foundRecord.get(0));
            foundPersonal_history = personal_historyRepository.findByMedical_record(foundRecord.get(0));
            foundPhysique = physiqueRepository.findByMedical_record(foundRecord.get(0));
            foundSummary = summaryRepository.findByMedical_record2(foundRecord.get(0));

            /** If summary record does not exist, a new one is created*/
            boolean exist2 = activityRepository.existsById(foundActivityRec.getId());
            if (!exist2) {
                foundActivityRec = new Activity();
            }
            boolean exist3 = cognitive_abilityRepository.existsById(foundCognitive_ability.getId());
            if (!exist3) {
                foundCognitive_ability = new Cognitive_ability();
            }
            boolean exist4 = occup_therapyRepository.existsById(foundOccup_therapy.getId());
            if (!exist4) {
                foundOccup_therapy = new Occup_therapy();
            }
            boolean exist5 = overviewRepository.existsById(foundOverview.getId());
            if (!exist5) {
                foundOverview = new Overview();
            }
            boolean exist6 = personal_historyRepository.existsById(foundPersonal_history.getId());
            if (!exist6) {
                foundPersonal_history = new Personal_history();
            }
            boolean exist7 = physiqueRepository.existsById(foundPhysique.getId());
            if (!exist7) {
                foundPhysique = new Physique();
            }
            boolean exist = summaryRepository.existsById(foundSummary.getId());
            if (!exist) {
                foundSummary = new Summary();
            }
            
            /** Adding the record from Activity payload*/
            foundActivityRec.setMedical_record(foundRecord.get(0));
            foundActivityRec.setCommunication_skills(medicalRequest.getActivity_communication_skills());
            foundActivityRec.setDomestic_skills(medicalRequest.getActivity_domestic_skills());
            foundActivityRec.setDressing_skills(medicalRequest.getActivity_dressing_skills());
            foundActivityRec.setFeeding_eating(medicalRequest.getActivity_Feeding_eating());
            foundActivityRec.setHygiene_skills(medicalRequest.getActivity_hygiene_skills());
            activityRepository.save(foundActivityRec);

            /** Adding Cognitive Ability record*/
            foundCognitive_ability.setMedical_record(foundRecord.get(0));
            foundCognitive_ability.setMemory(medicalRequest.getCognitive_memory());
            foundCognitive_ability.setPlanning(medicalRequest.getCognitive_planning());
            foundCognitive_ability.setOrganisational(medicalRequest.getCognitive_organisational());
            cognitive_abilityRepository.save(foundCognitive_ability);

            /**Adding Occupation Therapy */
            foundOccup_therapy.setMedical_record(foundRecord.get(0));
            foundOccup_therapy.setNeed_for_therapy(medicalRequest.getTherapy_need_for_therapy());
            foundOccup_therapy.setExtensive_support(medicalRequest.getTherapy_extensive_support());
            foundOccup_therapy.setReferral_followup(medicalRequest.getTherapy_referral_followup());
            foundOccup_therapy.setWellness_support(medicalRequest.getTherapy_wellness_support());
            occup_therapyRepository.save(foundOccup_therapy);

            /** Adding Overview*/
            foundOverview.setMedical_record(foundRecord.get(0));
            foundOverview.setProblems_identified(medicalRequest.getOverview_problems_identified());
            foundOverview.setFeeding_eating(medicalRequest.getActivity_Feeding_eating());
            foundOverview.setDx(medicalRequest.getOverview_dx());
            foundOverview.setOt_issues(medicalRequest.getOverview_ot_issues());
            overviewRepository.save(foundOverview);

            /** Adding Personal History*/
            foundPersonal_history.setMedical_record(foundRecord.get(0));
            foundPersonal_history.setLanguage(medicalRequest.getHistory_language());
            foundPersonal_history.setChief_complain(medicalRequest.getHistory_chief_complain());
            foundPersonal_history.setInquiry_referral(medicalRequest.getHistory_inquiry_referral());
            foundPersonal_history.setPostnatal_immunisation(medicalRequest.getHistory_postnatal_immunisation());
            foundPersonal_history.setSocial_status(medicalRequest.getHistory_social_status());
            personal_historyRepository.save(foundPersonal_history);

            /** Adding Physique Record*/
            foundPhysique.setMedical_record(foundRecord.get(0));
            foundPhysique.setAuditory(medicalRequest.getPhysique_auditory());
            foundPhysique.setBalance(medicalRequest.getPhysique_balance());
            foundPhysique.setBody_alignment(medicalRequest.getPhysique_body_alignment());
            foundPhysique.setGastro(medicalRequest.getPhysique_gastro());
            foundPhysique.setHair_col_dist(medicalRequest.getPhysique_hair_col_dist());
            foundPhysique.setHead_circumference(medicalRequest.getPhysique_head_circumference());
            foundPhysique.setObservable_features(medicalRequest.getPhysique_observable_features());
            foundPhysique.setOlfactory(medicalRequest.getPhysique_olfactory());
            foundPhysique.setOther_conditions(medicalRequest.getPhysique_other_conditions());
            foundPhysique.setVisual(medicalRequest.getPhysique_visual());
            foundPhysique.setTactile(medicalRequest.getPhysique_tactile());
            foundPhysique.setScars_deforms(medicalRequest.getPhysique_scars_deforms());
            foundPhysique.setPlay_leisure(medicalRequest.getPhysique_play_leisure());
            foundPhysique.setPerceptual(medicalRequest.getPhysique_perceptual());
            physiqueRepository.save(foundPhysique);
            
            /** Adding the record from the Summary payload*/
            foundSummary.setMedical_record(foundRecord.get(0));
            foundSummary.setAllergies(medicalRequest.getSummary_allergies());
            foundSummary.setSpeaking_condition(medicalRequest.getSummary_speaking_condition());
            foundSummary.setSkin_condition(medicalRequest.getSummary_skin_condition());
            foundSummary.setPsychological_condition(medicalRequest.getSummary_psychological_condition());
            foundSummary.setPhysical_condition(medicalRequest.getSummary_physical_condition());
            foundSummary.setHearing_condition(medicalRequest.getSummary_hearing_condition());
            foundSummary.setOthers(medicalRequest.getSummary_others());
            summaryRepository.save(foundSummary);

        }

        return Optional.empty();
    }


    @Override
    /** Method finds Medical record by its Id*/
    public Optional<Medical_record> getMed_Rec_By_Id(Long medRec_Id) {
        Optional<Medical_record> medical_record = medical_recordRepository.findById(medRec_Id);

        if (medical_record.isPresent()) {
            return medical_record;
        }
        else {
            throw new IllegalStateException("Medical record of Id "+ medRec_Id + " Does not exist");
        }

    }

    @Override
    public List<Medical_record> getAllMed_Rec() {
        return medical_recordRepository.findAll();
    }


    @Override
    /** finds medical record by childId */
    public List<Medical_record> getMed_Rec_By_ChildId(Long ChildId) {
        /** Check child exists*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id "+ ChildId + " Does not exist");
        }
        else {
            Children child = childrenRepository.findChildId(ChildId);
            return  medical_recordRepository.findByChildren_id(child);
        }

    }

    @Override
    public String deleteMed_Rec(Long childId) {
        boolean exist = childrenRepository.existsById(childId);

        if (!exist) {
            throw new IllegalStateException("Child record of Id "+ childId + " Does not exist");
        }
        else {
            Children child = childrenRepository.findChildId(childId);
            medical_recordRepository.deleteById(medical_recordRepository.findByChildren_id(child).get(0).getId());
        }
        return "Delete Successful!";
    }
}
