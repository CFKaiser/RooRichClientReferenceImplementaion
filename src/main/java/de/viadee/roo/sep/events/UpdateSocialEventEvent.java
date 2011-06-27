package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.SocialEvent;

public class UpdateSocialEventEvent {

    private SocialEvent socialEvent;

    public UpdateSocialEventEvent(SocialEvent socialEvent) {
        this.socialEvent = socialEvent;
    }

    public SocialEvent getSocialEvent() {
        return socialEvent;
    }
}
