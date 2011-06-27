package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.SocialEvent;

public class CreateSocialEventEvent {

    private SocialEvent socialEvent;

    public CreateSocialEventEvent(SocialEvent socialEvent) {
        this.socialEvent = socialEvent;
    }

    public SocialEvent getSocialEvent() {
        return socialEvent;
    }
}
