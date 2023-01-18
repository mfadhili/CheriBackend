package com.mfadhili.cheri.data.domain.autism_record.sub_records;

/** This file offers an EMBEDDABLE called Social
 *  It will be used as a collection by Autism Record ENTITY
 *  */
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.Hibernate;


import java.util.Objects;

@Embeddable
public class Social {
    @Column(name = "grabs_things")
    private String grabs_things;

    @Column(name = "reaches_for_hugs")
    private String reaches_for_hugs;

    @Column(name = "spends_time_alone")
    private String spends_time_alone;

    @Column(name = "group_play_difficulty")
    private String group_play_difficulty;

    @Column(name = "social_interaction_responsive")
    private String social_interaction_responsive;

    @Column(name = "shares_observations")
    private String shares_observations;

    @Column(name = "few_friends")
    private String few_friends;

    @Column(name = "plays_with_older_ppl")
    private String plays_with_older_ppl;

    @Column(name = "imitates_during_play")
    private String imitates_during_play;

    @Column(name = "difficulty_detaching_toys")
    private String difficulty_detaching_toys;

    @Column(name = "withdraws_from_crowds")
    private String withdraws_from_crowds;

    @Column(name = "surroundings_unaware")
    private String surroundings_unaware;

    @Column(name = "unable_to_understand_feelings")
    private String unable_to_understand_feelings;

    @Column(name = "disinterested_in_others")
    private String disinterested_in_others;

    @Column(name = "active_in_play")
    private String active_in_play;

    @Column(name = "uses_adults_as_toys")
    private String uses_adults_as_toys;

    @Column(name = "smiles_back")
    private String smiles_back;

    @Column(name = "demands_met_instant")
    private String demands_met_instant;

    @Column(name = "impatient")
    private String impatient;

    public String getImpatient() {
        return impatient;
    }

    public void setImpatient(String impatient) {
        this.impatient = impatient;
    }

    public String getDemands_met_instant() {
        return demands_met_instant;
    }

    public void setDemands_met_instant(String demands_met_instant) {
        this.demands_met_instant = demands_met_instant;
    }

    public String getSmiles_back() {
        return smiles_back;
    }

    public void setSmiles_back(String smiles_back) {
        this.smiles_back = smiles_back;
    }

    public String getUses_adults_as_toys() {
        return uses_adults_as_toys;
    }

    public void setUses_adults_as_toys(String uses_adults_as_toys) {
        this.uses_adults_as_toys = uses_adults_as_toys;
    }

    public String getActive_in_play() {
        return active_in_play;
    }

    public void setActive_in_play(String active_in_play) {
        this.active_in_play = active_in_play;
    }

    public String getDisinterested_in_others() {
        return disinterested_in_others;
    }

    public void setDisinterested_in_others(String disinterested_in_others) {
        this.disinterested_in_others = disinterested_in_others;
    }

    public String getUnable_to_understand_feelings() {
        return unable_to_understand_feelings;
    }

    public void setUnable_to_understand_feelings(String unable_to_understand_feelings) {
        this.unable_to_understand_feelings = unable_to_understand_feelings;
    }

    public String getSurroundings_unaware() {
        return surroundings_unaware;
    }

    public void setSurroundings_unaware(String surroundings_unaware) {
        this.surroundings_unaware = surroundings_unaware;
    }

    public String getWithdraws_from_crowds() {
        return withdraws_from_crowds;
    }

    public void setWithdraws_from_crowds(String withdraws_from_crowds) {
        this.withdraws_from_crowds = withdraws_from_crowds;
    }

    public String getDifficulty_detaching_toys() {
        return difficulty_detaching_toys;
    }

    public void setDifficulty_detaching_toys(String difficulty_detaching_toys) {
        this.difficulty_detaching_toys = difficulty_detaching_toys;
    }

    public String getImitates_during_play() {
        return imitates_during_play;
    }

    public void setImitates_during_play(String imitates_during_play) {
        this.imitates_during_play = imitates_during_play;
    }

    public String getPlays_with_older_ppl() {
        return plays_with_older_ppl;
    }

    public void setPlays_with_older_ppl(String plays_with_older_ppl) {
        this.plays_with_older_ppl = plays_with_older_ppl;
    }

    public String getFew_friends() {
        return few_friends;
    }

    public void setFew_friends(String few_friends) {
        this.few_friends = few_friends;
    }

    public String getShares_observations() {
        return shares_observations;
    }

    public void setShares_observations(String shares_observations) {
        this.shares_observations = shares_observations;
    }

    public String getSocial_interaction_responsive() {
        return social_interaction_responsive;
    }

    public void setSocial_interaction_responsive(String social_interaction_responsive) {
        this.social_interaction_responsive = social_interaction_responsive;
    }

    public String getGroup_play_difficulty() {
        return group_play_difficulty;
    }

    public void setGroup_play_difficulty(String group_play_difficulty) {
        this.group_play_difficulty = group_play_difficulty;
    }

    public String getSpends_time_alone() {
        return spends_time_alone;
    }

    public void setSpends_time_alone(String spends_time_alone) {
        this.spends_time_alone = spends_time_alone;
    }

    public String getReaches_for_hugs() {
        return reaches_for_hugs;
    }

    public void setReaches_for_hugs(String reaches_for_hugs) {
        this.reaches_for_hugs = reaches_for_hugs;
    }

    public String getGrabs_things() {
        return grabs_things;
    }

    public void setGrabs_things(String grabs_things) {
        this.grabs_things = grabs_things;
    }

    /** equal and hash code generated for performance*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Social social = (Social) o;
        return grabs_things != null && Objects.equals(grabs_things, social.grabs_things)
                && reaches_for_hugs != null && Objects.equals(reaches_for_hugs, social.reaches_for_hugs)
                && spends_time_alone != null && Objects.equals(spends_time_alone, social.spends_time_alone)
                && group_play_difficulty != null && Objects.equals(group_play_difficulty, social.group_play_difficulty)
                && social_interaction_responsive != null && Objects.equals(social_interaction_responsive, social.social_interaction_responsive)
                && shares_observations != null && Objects.equals(shares_observations, social.shares_observations)
                && few_friends != null && Objects.equals(few_friends, social.few_friends)
                && plays_with_older_ppl != null && Objects.equals(plays_with_older_ppl, social.plays_with_older_ppl)
                && imitates_during_play != null && Objects.equals(imitates_during_play, social.imitates_during_play)
                && difficulty_detaching_toys != null && Objects.equals(difficulty_detaching_toys, social.difficulty_detaching_toys)
                && withdraws_from_crowds != null && Objects.equals(withdraws_from_crowds, social.withdraws_from_crowds)
                && surroundings_unaware != null && Objects.equals(surroundings_unaware, social.surroundings_unaware)
                && unable_to_understand_feelings != null && Objects.equals(unable_to_understand_feelings, social.unable_to_understand_feelings)
                && disinterested_in_others != null && Objects.equals(disinterested_in_others, social.disinterested_in_others)
                && active_in_play != null && Objects.equals(active_in_play, social.active_in_play)
                && uses_adults_as_toys != null && Objects.equals(uses_adults_as_toys, social.uses_adults_as_toys)
                && smiles_back != null && Objects.equals(smiles_back, social.smiles_back)
                && demands_met_instant != null && Objects.equals(demands_met_instant, social.demands_met_instant)
                && impatient != null && Objects.equals(impatient, social.impatient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grabs_things,
                reaches_for_hugs,
                spends_time_alone,
                group_play_difficulty,
                social_interaction_responsive,
                shares_observations,
                few_friends,
                plays_with_older_ppl,
                imitates_during_play,
                difficulty_detaching_toys,
                withdraws_from_crowds,
                surroundings_unaware,
                unable_to_understand_feelings,
                disinterested_in_others,
                active_in_play,
                uses_adults_as_toys,
                smiles_back,
                demands_met_instant,
                impatient);
    }
}