package com.mfadhili.cheri.data.requestBodies;

import javax.persistence.Column;

public class MedicalRequest {

    /** Activity Request fields*/
    private String Activity_feeding_eating;
    private String Activity_dressing_skills;
    private String Activity_hygiene_skills;
    private String Activity_domestic_skills;
    private String Activity_communication_skills;


    /** Cognitive Ability */
    private String Cognitive_planning;
    private String Cognitive_memory;
    private String Cognitive_organisational;

    /** Physique Record*/
    private String Physique_head_circumference;
    private String Physique_hair_col_dist;
    private String Physique_observable_features;
    private String Physique_body_alignment;
    private String Physique_auditory;
    private String Physique_olfactory;
    private String Physique_gastro;
    private String Physique_tactile;
    private String Physique_perceptual;
    private String Physique_visual;
    private String Physique_balance;
    private String Physique_scars_deforms;
    private String Physique_play_leisure;
    private String Physique_other_conditions;

    /** Occupation Therapy */
    private String Therapy_need_for_therapy;
    private String Therapy_wellness_support;
    private String Therapy_extensive_support;
    private String Therapy_referral_followup;

    /** Overview*/
    private String Overview_feeding_eating_overview;
    private String Overview_dx;
    private String Overview_problems_identified;
    private String Overview_ot_issues;

    /** Personal History*/
    private String History_language;
    private String History_inquiry_referral;
    private String History_social_status;
    private String History_postnatal_immunisation;
    private String History_chief_complain;

    /** Summary */
    private String Summary_allergies;
    private String Summary_hearing_condition;
    private String Summary_physical_condition;
    private String Summary_skin_condition;
    private String Summary_speaking_condition;
    private String Summary_psychological_condition;
    private String Summary_others;


    /** Getters and Setters*/
    public String getActivity_Feeding_eating() {
        return Activity_feeding_eating;
    }

    public void setActivity_Feeding_eating(String feeding_eating) {
        this.Activity_feeding_eating = feeding_eating;
    }

    public String getActivity_dressing_skills() {
        return Activity_dressing_skills;
    }

    public void setActivity_dressing_skills(String activity_dressing_skills) {
        this.Activity_dressing_skills = activity_dressing_skills;
    }

    public String getActivity_hygiene_skills() {
        return Activity_hygiene_skills;
    }

    public void setActivity_hygiene_skills(String activity_hygiene_skills) {
        this.Activity_hygiene_skills = activity_hygiene_skills;
    }

    public String getActivity_domestic_skills() {
        return Activity_domestic_skills;
    }

    public void setActivity_domestic_skills(String activity_domestic_skills) {
        this.Activity_domestic_skills = activity_domestic_skills;
    }

    public String getActivity_communication_skills() {
        return Activity_communication_skills;
    }

    public void setActivity_communication_skills(String activity_communication_skills) {
        this.Activity_communication_skills = activity_communication_skills;
    }

    public String getCognitive_planning() {
        return Cognitive_planning;
    }

    public void setCognitive_planning(String cognitive_planning) {
        Cognitive_planning = cognitive_planning;
    }

    public String getCognitive_memory() {
        return Cognitive_memory;
    }

    public void setCognitive_memory(String cognitive_memory) {
        Cognitive_memory = cognitive_memory;
    }

    public String getCognitive_organisational() {
        return Cognitive_organisational;
    }

    public void setCognitive_organisational(String cognitive_organisational) {
        Cognitive_organisational = cognitive_organisational;
    }

    public String getPhysique_head_circumference() {
        return Physique_head_circumference;
    }

    public void setPhysique_head_circumference(String physique_head_circumference) {
        Physique_head_circumference = physique_head_circumference;
    }

    public String getPhysique_hair_col_dist() {
        return Physique_hair_col_dist;
    }

    public void setPhysique_hair_col_dist(String physique_hair_col_dist) {
        Physique_hair_col_dist = physique_hair_col_dist;
    }

    public String getPhysique_observable_features() {
        return Physique_observable_features;
    }

    public void setPhysique_observable_features(String physique_observable_features) {
        Physique_observable_features = physique_observable_features;
    }

    public String getPhysique_body_alignment() {
        return Physique_body_alignment;
    }

    public void setPhysique_body_alignment(String physique_body_alignment) {
        Physique_body_alignment = physique_body_alignment;
    }

    public String getPhysique_auditory() {
        return Physique_auditory;
    }

    public void setPhysique_auditory(String physique_auditory) {
        Physique_auditory = physique_auditory;
    }

    public String getPhysique_olfactory() {
        return Physique_olfactory;
    }

    public void setPhysique_olfactory(String physique_olfactory) {
        Physique_olfactory = physique_olfactory;
    }

    public String getPhysique_gastro() {
        return Physique_gastro;
    }

    public void setPhysique_gastro(String physique_gastro) {
        Physique_gastro = physique_gastro;
    }

    public String getPhysique_tactile() {
        return Physique_tactile;
    }

    public void setPhysique_tactile(String physique_tactile) {
        Physique_tactile = physique_tactile;
    }

    public String getPhysique_perceptual() {
        return Physique_perceptual;
    }

    public void setPhysique_perceptual(String physique_perceptual) {
        Physique_perceptual = physique_perceptual;
    }

    public String getPhysique_visual() {
        return Physique_visual;
    }

    public void setPhysique_visual(String physique_visual) {
        Physique_visual = physique_visual;
    }

    public String getPhysique_balance() {
        return Physique_balance;
    }

    public void setPhysique_balance(String physique_balance) {
        Physique_balance = physique_balance;
    }

    public String getPhysique_scars_deforms() {
        return Physique_scars_deforms;
    }

    public void setPhysique_scars_deforms(String physique_scars_deforms) {
        Physique_scars_deforms = physique_scars_deforms;
    }

    public String getPhysique_play_leisure() {
        return Physique_play_leisure;
    }

    public void setPhysique_play_leisure(String physique_play_leisure) {
        Physique_play_leisure = physique_play_leisure;
    }

    public String getPhysique_other_conditions() {
        return Physique_other_conditions;
    }

    public void setPhysique_other_conditions(String physique_other_conditions) {
        Physique_other_conditions = physique_other_conditions;
    }

    public String getTherapy_need_for_therapy() {
        return Therapy_need_for_therapy;
    }

    public void setTherapy_need_for_therapy(String therapy_need_for_therapy) {
        Therapy_need_for_therapy = therapy_need_for_therapy;
    }

    public String getTherapy_wellness_support() {
        return Therapy_wellness_support;
    }

    public void setTherapy_wellness_support(String therapy_wellness_support) {
        Therapy_wellness_support = therapy_wellness_support;
    }

    public String getTherapy_extensive_support() {
        return Therapy_extensive_support;
    }

    public void setTherapy_extensive_support(String therapy_extensive_support) {
        Therapy_extensive_support = therapy_extensive_support;
    }

    public String getTherapy_referral_followup() {
        return Therapy_referral_followup;
    }

    public void setTherapy_referral_followup(String therapy_referral_followup) {
        Therapy_referral_followup = therapy_referral_followup;
    }

    public String getOverview_feeding_eating_overview() {
        return Overview_feeding_eating_overview;
    }

    public void setOverview_feeding_eating_overview(String overview_feeding_eating_overview) {
        Overview_feeding_eating_overview = overview_feeding_eating_overview;
    }

    public String getOverview_dx() {
        return Overview_dx;
    }

    public void setOverview_dx(String overview_dx) {
        Overview_dx = overview_dx;
    }

    public String getOverview_problems_identified() {
        return Overview_problems_identified;
    }

    public void setOverview_problems_identified(String overview_problems_identified) {
        Overview_problems_identified = overview_problems_identified;
    }

    public String getOverview_ot_issues() {
        return Overview_ot_issues;
    }

    public void setOverview_ot_issues(String overview_ot_issues) {
        Overview_ot_issues = overview_ot_issues;
    }

    public String getHistory_language() {
        return History_language;
    }

    public void setHistory_language(String history_language) {
        History_language = history_language;
    }

    public String getHistory_inquiry_referral() {
        return History_inquiry_referral;
    }

    public void setHistory_inquiry_referral(String history_inquiry_referral) {
        History_inquiry_referral = history_inquiry_referral;
    }

    public String getHistory_social_status() {
        return History_social_status;
    }

    public void setHistory_social_status(String history_social_status) {
        History_social_status = history_social_status;
    }

    public String getHistory_postnatal_immunisation() {
        return History_postnatal_immunisation;
    }

    public void setHistory_postnatal_immunisation(String history_postnatal_immunisation) {
        History_postnatal_immunisation = history_postnatal_immunisation;
    }

    public String getHistory_chief_complain() {
        return History_chief_complain;
    }

    public void setHistory_chief_complain(String history_chief_complain) {
        History_chief_complain = history_chief_complain;
    }

    public String getSummary_allergies() {
        return Summary_allergies;
    }

    public void setSummary_allergies(String summary_allergies) {
        Summary_allergies = summary_allergies;
    }

    public String getSummary_hearing_condition() {
        return Summary_hearing_condition;
    }

    public void setSummary_hearing_condition(String summary_hearing_condition) {
        Summary_hearing_condition = summary_hearing_condition;
    }

    public String getSummary_physical_condition() {
        return Summary_physical_condition;
    }

    public void setSummary_physical_condition(String summary_physical_condition) {
        Summary_physical_condition = summary_physical_condition;
    }

    public String getSummary_skin_condition() {
        return Summary_skin_condition;
    }

    public void setSummary_skin_condition(String summary_skin_condition) {
        Summary_skin_condition = summary_skin_condition;
    }

    public String getSummary_speaking_condition() {
        return Summary_speaking_condition;
    }

    public void setSummary_speaking_condition(String summary_speaking_condition) {
        Summary_speaking_condition = summary_speaking_condition;
    }

    public String getSummary_psychological_condition() {
        return Summary_psychological_condition;
    }

    public void setSummary_psychological_condition(String summary_psychological_condition) {
        Summary_psychological_condition = summary_psychological_condition;
    }

    public String getSummary_others() {
        return Summary_others;
    }

    public void setSummary_others(String summary_others) {
        Summary_others = summary_others;
    }
}
