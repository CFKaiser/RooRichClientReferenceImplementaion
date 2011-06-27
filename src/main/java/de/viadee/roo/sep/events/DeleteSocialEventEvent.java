package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.SocialEvent;

public class DeleteSocialEventEvent {

    private SocialEvent socialEvent;

    public DeleteSocialEventEvent(SocialEvent socialEvent) {
        this.socialEvent = socialEvent;
    }

    public SocialEvent getSocialEvent() {
        return socialEvent;
    }
}
