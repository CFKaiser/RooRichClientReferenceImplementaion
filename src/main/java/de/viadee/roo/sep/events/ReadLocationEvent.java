package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Location;

public class ReadLocationEvent {

    private Location location;

    public ReadLocationEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
