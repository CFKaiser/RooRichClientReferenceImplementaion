package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Location;

public class UpdateLocationEvent {

    private Location location;

    public UpdateLocationEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
