package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Location;

public class DeleteLocationEvent {

    private Location location;

    public DeleteLocationEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
