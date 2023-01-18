package com.mfadhili.cheri.service.autism_record;

import com.mfadhili.cheri.data.domain.Admin_Home.caregiver.Caregiver;
import com.mfadhili.cheri.data.domain.autism_record.Autism_record;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Communication;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Other_items;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Social;
import com.mfadhili.cheri.data.domain.child_guardian.child.Children;
import com.mfadhili.cheri.data.repository.CaregiverRepository;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.autism_record.Autism_recordRepository;
import com.mfadhili.cheri.data.repository.autism_record.CommunicationRepository;
import com.mfadhili.cheri.data.repository.autism_record.Other_itemsRepository;
import com.mfadhili.cheri.data.repository.autism_record.SocialRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.ActivityRepository;
import com.mfadhili.cheri.data.requestBodies.AutismRecRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutismRecServiceImpl implements AutismRecService {
    @Autowired
    CaregiverRepository caregiverRepository;
    @Autowired
    ChildrenRepository childrenRepository;
    @Autowired
    Autism_recordRepository autism_recordRepository;
    @Autowired
    CommunicationRepository communicationRepository;
    @Autowired
    SocialRepository socialRepository;
    @Autowired
    Other_itemsRepository other_itemsRepository;

    @Override
    public Autism_record addAutismRecord(Long childId, AutismRecRequest autismRecRequest) {
        Autism_record newAutism_record = new Autism_record();

        /**TODO: Replace Mock Caregiver with source from authentication principle */
        Caregiver caregiver = caregiverRepository.findCaregiverId(Long.valueOf("1"));

        /** Check child exists*/
        Optional<Children> oldChild = childrenRepository.findById(childId);

        if (oldChild.isEmpty()) {
            throw new IllegalStateException("Child of Id "+ childId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(childId);
            newAutism_record.setChildren(child);
            newAutism_record.setCaregiver(caregiver);

            autism_recordRepository.save(newAutism_record);
            return newAutism_record;
        }
    }

    @Override
    public Autism_record addAutismRecordAll(Long childId, AutismRecRequest autismRecRequest) {
        Autism_record newAutism_record = new Autism_record();

        /**TODO: Replace Mock Caregiver with source from authentication principle */
        Caregiver caregiver = caregiverRepository.findCaregiverId(Long.valueOf("1"));

        /** Check child exists*/
        Optional<Children> oldChild = childrenRepository.findById(childId);

        if (oldChild.isEmpty()) {
            throw new IllegalStateException("Child of Id "+ childId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(childId);
            newAutism_record.setChildren(child);
            newAutism_record.setCaregiver(caregiver);
            Autism_record savedRecord = autism_recordRepository.save(newAutism_record);

            /** Adding Autism Communication Record */
            Communication newCommunication = new Communication();
            newCommunication.setAutism_record(savedRecord);
            newCommunication.setConversation_friendly(autismRecRequest.getCommunication_conversation_friendly());
            newCommunication.setTugs_to_make_requests(autismRecRequest.getCommunication_tugs_to_make_requests());
            newCommunication.setSpeech_delay(autismRecRequest.getCommunication_speech_delay());
            newCommunication.setSound_tolerant(autismRecRequest.getCommunication_sound_tolerant());
            newCommunication.setResponse_selective(autismRecRequest.getCommunication_response_selective());
            newCommunication.setNeeds_communication_challenges(autismRecRequest.getCommunication_needs_communication_challenges());
            newCommunication.setMinimal_speech(autismRecRequest.getCommunication_minimal_speech());
            newCommunication.setInterested_in_stories(autismRecRequest.getCommunication_interested_in_stories());
            newCommunication.setGesture_difficulty(autismRecRequest.getCommunication_gesture_difficulty());
            newCommunication.setEchoes_words(autismRecRequest.getCommunication_echoes_words());
            newCommunication.setEchoes_sounds(autismRecRequest.getCommunication_echoes_sounds());
            newCommunication.setBody_lang_difficulty(autismRecRequest.getCommunication_body_lang_difficulty());
            communicationRepository.save(newCommunication);

            /** Adding Autism Social Record*/
            Social newSocial = new Social();
            newSocial.setAutism_record(savedRecord);
            newSocial.setWithdraws_from_crowds(autismRecRequest.getSocial_withdraws_from_crowds());
            newSocial.setUses_adults_as_toys(autismRecRequest.getSocial_uses_adults_as_toys());
            newSocial.setUnable_to_understand_feelings(autismRecRequest.getSocial_unable_to_understand_feelings());
            newSocial.setSurroundings_unaware(autismRecRequest.getSocial_surroundings_unaware());
            newSocial.setSpends_time_alone(autismRecRequest.getSocial_spends_time_alone());
            newSocial.setSocial_interaction_responsive(autismRecRequest.getSocial_social_interaction_responsive());
            newSocial.setSmiles_back(autismRecRequest.getSocial_smiles_back());
            newSocial.setShares_observations(autismRecRequest.getSocial_shares_observations());
            newSocial.setReaches_for_hugs(autismRecRequest.getSocial_reaches_for_hugs());
            newSocial.setPlays_with_older_ppl(autismRecRequest.getSocial_plays_with_older_ppl());
            newSocial.setImpatient(autismRecRequest.getSocial_impatient());
            newSocial.setImitates_during_play(autismRecRequest.getSocial_imitates_during_play());
            newSocial.setGroup_play_difficulty(autismRecRequest.getSocial_group_play_difficulty());
            newSocial.setGrabs_things(autismRecRequest.getSocial_grabs_things());
            newSocial.setFew_friends(autismRecRequest.getSocial_few_friends());
            newSocial.setDisinterested_in_others(autismRecRequest.getSocial_disinterested_in_others());
            newSocial.setDifficulty_detaching_toys(autismRecRequest.getSocial_difficulty_detaching_toys());
            newSocial.setDemands_met_instant(autismRecRequest.getSocial_demands_met_instant());
            newSocial.setActive_in_play(autismRecRequest.getSocial_active_in_play());
            socialRepository.save(newSocial);

            /** Adding Autism Other Record*/
            Other_items newOther_items = new Other_items();
            newOther_items.setAutism_record(savedRecord);
            newOther_items.setSocial_interactions(autismRecRequest.getOther_social_interactions());
            newOther_items.setSensory_processing(autismRecRequest.getOther_sensory_processing());
            newOther_items.setLanguage_skills(autismRecRequest.getOther_language_skills());
            newOther_items.setGross_motor(autismRecRequest.getOther_gross_motor());
            newOther_items.setGeneral_behaviour(autismRecRequest.getOther_general_behaviour());
            newOther_items.setFine_motor(autismRecRequest.getOther_fine_motor());
            newOther_items.setConcurring_conditions(autismRecRequest.getOther_concurring_conditions());
            newOther_items.setComments(autismRecRequest.getOther_comments());
            newOther_items.setActivities_of_dailyLiving(autismRecRequest.getOther_activities_of_dailyLiving());
            newOther_items.setAcademic_preparedness(autismRecRequest.getOther_academic_preparedness());
            other_itemsRepository.save(newOther_items);

            return newAutism_record;
        }
    }

    @Override
    public Optional<Autism_record> updateAutismRecAll(Long childId, Autism_record autism_record) {
        return Optional.empty();
    }

    @Override
    public Optional<Autism_record> getAutism_Rec_By_Id(Long medRec_Id) {
        return Optional.empty();
    }

    @Override
    public List<Autism_record> getAllAutism_Rec() {
        return null;
    }

    @Override
    public List<Autism_record> getAutism_Rec_By_ChildId(Long ChildId) {
        return null;
    }

    @Override
    public String deleteAutism_Rec(Long childId) {
        return null;
    }
}
z