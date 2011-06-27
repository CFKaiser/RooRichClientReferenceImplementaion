package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Location;

public class CreateLocationEvent {

    private Location location;

    public CreateLocationEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
