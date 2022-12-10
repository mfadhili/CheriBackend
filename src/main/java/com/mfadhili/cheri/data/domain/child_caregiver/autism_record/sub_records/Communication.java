package com.mfadhili.cheri.data.domain.child_caregiver.autism_record.sub_records;

/** This file gives an EMBEDDABLE item
 *  It is part of the Autism record file
 *  */

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.Hibernate;


import java.util.Objects;

@Embeddable
public class Communication {
    @Column(name = "speech_delay")
    
    private String speech_delay;

    @Column(name = "echoes_words")

    private String echoes_words;

    @Column(name = "echoes_sounds")

    private String echoes_sounds;

    @Column(name = "response_selective")

    private String response_selective;

    @Column(name = "minimal_speech")

    private String minimal_speech;

    @Column(name = "gesture_difficulty")

    private String gesture_difficulty;

    @Column(name = "body_lang_difficulty")

    private String body_lang_difficulty;

    @Column(name = "needs_communication_challenges")

    private String needs_communication_challenges;

    @Column(name = "interested_in_stories")

    private String interested_in_stories;

    @Column(name = "sound_tolerant")

    private String sound_tolerant;

    @Column(name = "conversation_friendly")

    private String conversation_friendly;

    @Column(name = "tugs_to_make_requests")

    private String tugs_to_make_requests;

    /** getters and setters*/
    public String getTugs_to_make_requests() {
        return tugs_to_make_requests;
    }

    public void setTugs_to_make_requests(String tugs_to_make_requests) {
        this.tugs_to_make_requests = tugs_to_make_requests;
    }

    public String getConversation_friendly() {
        return conversation_friendly;
    }

    public void setConversation_friendly(String conversation_friendly) {
        this.conversation_friendly = conversation_friendly;
    }

    public String getSound_tolerant() {
        return sound_tolerant;
    }

    public void setSound_tolerant(String sound_tolerant) {
        this.sound_tolerant = sound_tolerant;
    }

    public String getInterested_in_stories() {
        return interested_in_stories;
    }

    public void setInterested_in_stories(String interested_in_stories) {
        this.interested_in_stories = interested_in_stories;
    }

    public String getNeeds_communication_challenges() {
        return needs_communication_challenges;
    }

    public void setNeeds_communication_challenges(String needs_communication_challenges) {
        this.needs_communication_challenges = needs_communication_challenges;
    }

    public String getBody_lang_difficulty() {
        return body_lang_difficulty;
    }

    public void setBody_lang_difficulty(String body_lang_difficulty) {
        this.body_lang_difficulty = body_lang_difficulty;
    }

    public String getGesture_difficulty() {
        return gesture_difficulty;
    }

    public void setGesture_difficulty(String gesture_difficulty) {
        this.gesture_difficulty = gesture_difficulty;
    }

    public String getMinimal_speech() {
        return minimal_speech;
    }

    public void setMinimal_speech(String minimal_speech) {
        this.minimal_speech = minimal_speech;
    }

    public String getResponse_selective() {
        return response_selective;
    }

    public void setResponse_selective(String response_selective) {
        this.response_selective = response_selective;
    }

    public String getEchoes_sounds() {
        return echoes_sounds;
    }

    public void setEchoes_sounds(String echoes_sounds) {
        this.echoes_sounds = echoes_sounds;
    }

    public String getEchoes_words() {
        return echoes_words;
    }

    public void setEchoes_words(String echoes_words) {
        this.echoes_words = echoes_words;
    }

    public String getSpeech_delay() {
        return speech_delay;
    }

    public void setSpeech_delay(String speech_delay) {
        this.speech_delay = speech_delay;
    }

    /** equal and hash code generated for performance*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Communication that = (Communication) o;
        return speech_delay != null && Objects.equals(speech_delay, that.speech_delay)
                && echoes_words != null && Objects.equals(echoes_words, that.echoes_words)
                && echoes_sounds != null && Objects.equals(echoes_sounds, that.echoes_sounds)
                && response_selective != null && Objects.equals(response_selective, that.response_selective)
                && minimal_speech != null && Objects.equals(minimal_speech, that.minimal_speech)
                && gesture_difficulty != null && Objects.equals(gesture_difficulty, that.gesture_difficulty)
                && body_lang_difficulty != null && Objects.equals(body_lang_difficulty, that.body_lang_difficulty)
                && needs_communication_challenges != null && Objects.equals(needs_communication_challenges, that.needs_communication_challenges)
                && interested_in_stories != null && Objects.equals(interested_in_stories, that.interested_in_stories)
                && sound_tolerant != null && Objects.equals(sound_tolerant, that.sound_tolerant)
                && conversation_friendly != null && Objects.equals(conversation_friendly, that.conversation_friendly)
                && tugs_to_make_requests != null && Objects.equals(tugs_to_make_requests, that.tugs_to_make_requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speech_delay,
                echoes_words,
                echoes_sounds,
                response_selective,
                minimal_speech,
                gesture_difficulty,
                body_lang_difficulty,
                needs_communication_challenges,
                interested_in_stories,
                sound_tolerant,
                conversation_friendly,
                tugs_to_make_requests);
    }
}