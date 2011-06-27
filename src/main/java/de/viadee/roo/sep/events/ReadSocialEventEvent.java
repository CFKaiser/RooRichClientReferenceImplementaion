package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.SocialEvent;

public class ReadSocialEventEvent {

    private SocialEvent socialEvent;

    public ReadSocialEventEvent(SocialEvent socialEvent) {
        this.socialEvent = socialEvent;
    }

    public SocialEvent getSocialEvent() {
        return socialEvent;
    }
}
