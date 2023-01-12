package com.mfadhili.cheri.web.controller.MedicalRecord.subRecords;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.*;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medical_rec/{childId}")
public class MedicalSubRecordsController {

    @Autowired
    ActivityRecService activityRecService;
    @Autowired
    CognitiveRecService cognitiveRecService;
    @Autowired
    Occup_therapyRecService occup_therapyRecService;
    @Autowired
    OverviewRecService overviewRecService;
    @Autowired
    Personal_histRecService personal_histRecService;
    @Autowired
    PhysiqueRecService physiqueRecService;
    @Autowired
    SummaryRecService summaryRecService;


    /** ***************************************************************************************************************/

    /** TODO: Activity Subrecords */
    /** Adding the Activity record*/
    @PutMapping("/activityRec/add")
    public ResponseEntity<Activity> addActivityRec(@PathVariable Long childId, @RequestBody Activity activityReq){
        Activity newActivity = activityRecService.addMedicalRecActivity(childId,activityReq);

        return new ResponseEntity<>(newActivity, HttpStatus.OK);
    }

    /** Update Activity record*/
    @PatchMapping("/activityRec/update")
    public ResponseEntity<Activity> updateActivityRec(@PathVariable Long childId, @RequestBody Activity activityReq){
        Activity activityUpdate = activityRecService.updateMedicalRecActivity(childId, activityReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /** Get activity sub_record by child Id*/
    @GetMapping("/activityRec/get")
    public ResponseEntity<Optional<Activity>>getActivityRec(@PathVariable Long childId){
        Optional<Activity> foundActivityRec = activityRecService.getMedicalRecActivity(childId);
        return new ResponseEntity<>(foundActivityRec, HttpStatus.OK);
    }

    /** Delete Activity record */
    @DeleteMapping("/activityRec/delete")
    public ResponseEntity<?> deleteActivityRec(@PathVariable Long childId){
        activityRecService.deleteMedicalRecActivity(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** ***************************************************************************************************************/
    /** TODO: Cognitive Sub-records*/

    /** Adding the Cognitive record*/
    @PutMapping("/cognitiveRec/add")
    public ResponseEntity<Cognitive_ability> addCognitiveRec(@PathVariable Long childId, @RequestBody Cognitive_ability cognitive_abilityReq){
        Cognitive_ability newCognitive_ability = cognitiveRecService.addMedicalRecCognitive_ability(childId,cognitive_abilityReq);

        return new ResponseEntity<>(newCognitive_ability, HttpStatus.OK);
    }

    /** Update cognitive record*/
    @PatchMapping("/cognitiveRec/update")
    public ResponseEntity<Cognitive_ability> updateCognitiveRec(@PathVariable Long childId, @RequestBody Cognitive_ability cognitive_abilityReq){
        Cognitive_ability cognitive_abilityUpdate = cognitiveRecService.updateMedicalRecCognitive_ability(childId, cognitive_abilityReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** Get cognitive sub_record by child Id*/
    @GetMapping("/cognitiveRec/get")
    public ResponseEntity<Optional<Cognitive_ability>>getCognitiveRec(@PathVariable Long childId){
        Optional<Cognitive_ability> foundCognitive_ability = cognitiveRecService.getMedicalRecCognitive_ability(childId);
        return new ResponseEntity<>(foundCognitive_ability, HttpStatus.OK);
    }

    /** Delete Cognitive record */
    @DeleteMapping("/cognitiveRec/delete")
    public ResponseEntity<?> deleteCognitiveRec(@PathVariable Long childId){
        cognitiveRecService.deleteMedicalRecCognitive_ability(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /** ***************************************************************************************************************/

    /** TODO: Occup_Therapy Sub-records*/
    /** Adding the Occup_Therapy record*/
    @PutMapping("/occupRec/add")
    public ResponseEntity<Occup_therapy> addOccupTherapy(@PathVariable Long childId, @RequestBody Occup_therapy occup_therapyReq){
        Occup_therapy newOccup_therapy = occup_therapyRecService.addMedicalRecOccup_therapy(childId,occup_therapyReq);

        return new ResponseEntity<>(newOccup_therapy, HttpStatus.OK);
    }

    /** Update Occup_Therapy record*/
    @PatchMapping("/occupReq/update")
    public ResponseEntity<Occup_therapy> updateOccupTherapy(@PathVariable Long childId, @RequestBody Occup_therapy occup_therapyReq){
        Occup_therapy occup_therapyUpdate = occup_therapyRecService.updateMedicalRecOccup_therapy(childId, occup_therapyReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** Get Occup_Therapy sub_record by child Id*/
    @GetMapping("/occupReq/get")
    public ResponseEntity<Optional<Occup_therapy>>getOccup_therapyRec(@PathVariable Long childId){
        Optional<Occup_therapy> foundOccup_therapy_ability = occup_therapyRecService.getMedicalRecOccup_therapy(childId);
        return new ResponseEntity<>(foundOccup_therapy_ability, HttpStatus.OK);
    }

    /** Delete Occup_Therapy record */
    @DeleteMapping("/occupReq/delete")
    public ResponseEntity<?> deleteOccup_therapyRec(@PathVariable Long childId){
        occup_therapyRecService.deleteMedicalRecOccup_therapy(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /** ***************************************************************************************************************/

    /** TODO: Overview Sub-records*/

    /** Adding the Overview record*/
    @PutMapping("/overviewRec/add")
    public ResponseEntity<Overview> addOverviewRec(@PathVariable Long childId, @RequestBody Overview overviewReq){
         Overview newOverview = overviewRecService.addMedicalRecOverview(childId,overviewReq);

        return new ResponseEntity<>(newOverview, HttpStatus.OK);
    }

    /** Update Overview record*/
    @PatchMapping("/overviewRec/update")
    public ResponseEntity<Overview> updateOverviewRec(@PathVariable Long childId, @RequestBody Overview overviewReq){
        Overview overviewUpdate = overviewRecService.updateMedicalRecOverview(childId, overviewReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** Get Overview sub_record by child Id*/
    @GetMapping("/overviewRec/get")
    public ResponseEntity<Optional<Overview>>getOverviewRec(@PathVariable Long childId){
        Optional<Overview> foundOverviewRec = overviewRecService.getMedicalRecOverview(childId);
        return new ResponseEntity<>(foundOverviewRec, HttpStatus.OK);
    }

    /** Delete Overview record */
    @DeleteMapping("/overviewRec/delete")
    public ResponseEntity<?> deleteOverviewRec(@PathVariable Long childId){
        overviewRecService.deleteMedicalRecOverview(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** ***************************************************************************************************************/

    /** TODO: Personal History Sub-records*/

    /** Adding the Personal History record*/
    @PutMapping("/personalHist/add")
    public ResponseEntity<Personal_history> addPersonalHistRec(@PathVariable Long childId, @RequestBody Personal_history personal_histReq){
        Personal_history newPersonal_history = personal_histRecService.addMedicalRecPersonal_history(childId,personal_histReq);

        return new ResponseEntity<>(newPersonal_history, HttpStatus.OK);
    }

    /** Update Personal History record*/
    @PatchMapping("/personalHist/update")
    public ResponseEntity<Personal_history> updatePersonalHistyRec(@PathVariable Long childId, @RequestBody Personal_history personal_historyReq){
        Personal_history personal_historyUpdate = personal_histRecService.updateMedicalRecPersonal_history(childId, personal_historyReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** Get Personal_history sub_record by child Id*/
    @GetMapping("/personalHist/get")
    public ResponseEntity<Optional<Personal_history>>getPersonal_historyRec(@PathVariable Long childId){
        Optional<Personal_history> foundPersonal_historyRec = personal_histRecService.getMedicalRecPersonal_history(childId);
        return new ResponseEntity<>(foundPersonal_historyRec, HttpStatus.OK);
    }

    /** Delete Personal_history record */
    @DeleteMapping("/personalHist/delete")
    public ResponseEntity<?> deletePersonal_historyRec(@PathVariable Long childId){
        overviewRecService.deleteMedicalRecOverview(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** ***************************************************************************************************************/

    /** TODO: Physique Sub-records*/

    /** Adding the Personal History record*/
    @PutMapping("/physique/add")
    public ResponseEntity<Physique> addPhysiqueRec(@PathVariable Long childId, @RequestBody Physique physique_req){
        Physique newPhysique = physiqueRecService.addMedicalRecPhysique(childId,physique_req);

        return new ResponseEntity<>(newPhysique, HttpStatus.OK);
    }

    /** Update Physique record*/
    @PatchMapping("/physique/update")
    public ResponseEntity<Physique> updatePhysiqueRec(@PathVariable Long childId, @RequestBody Physique physiqueReq){
        Physique physiqueUpdate = physiqueRecService.updateMedicalRecPhysique(childId, physiqueReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** Get Physique sub_record by child Id*/
    @GetMapping("/physique/get")
    public ResponseEntity<Optional<Physique>>getPhysiqueRec(@PathVariable Long childId){
        Optional<Physique> foundPhysiqueRec = physiqueRecService.getMedicalRecPhysique(childId);
        return new ResponseEntity<>(foundPhysiqueRec, HttpStatus.OK);
    }

    /** Delete Physique record */
    @DeleteMapping("/physique/delete")
    public ResponseEntity<?> deletePhysiqueRec(@PathVariable Long childId){
        physiqueRecService.deleteMedicalRecPhysique(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /** ***************************************************************************************************************/

    /** TODO: Summary Sub-records*/

    /** Adding the Personal History record*/
    @PutMapping("/summary/add")
    public ResponseEntity<Summary> addSummaryRec(@PathVariable Long childId, @RequestBody Summary summary_req){
        Summary newSummary = summaryRecService.addMedicalRecSummary(childId,summary_req);

        return new ResponseEntity<>(newSummary, HttpStatus.OK);
    }

    /** Update Summary record*/
    @PatchMapping("/summary/update")
    public ResponseEntity<Summary> updateSummaryRec(@PathVariable Long childId, @RequestBody Summary summaryReq){
        Summary summaryUpdate = summaryRecService.updateMedicalRecSummary(childId, summaryReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** Get Summary sub_record by child Id*/
    @GetMapping("/summary/get")
    public ResponseEntity<List<Summary>>getSummaryRec(@PathVariable Long childId){
        List<Summary> foundSummaryRec = summaryRecService.getMedicalRecSummary(childId);
        return new ResponseEntity<>(foundSummaryRec, HttpStatus.OK);
    }

    /** Delete Summary record */
    @DeleteMapping("/summary/delete")
    public ResponseEntity<?> deleteSummaryRec(@PathVariable Long childId){
        summaryRecService.deleteMedicalRecSummary(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
