package com.model;

public class Route {

    private Destination fromLocation;
    private Destination toLocation;

    public Route(Destination fromLocation, Destination toLocation) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public Destination getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Destination fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Destination getToLocation() {
        return toLocation;
    }

    public void setToLocation(Destination toLocation) {
        this.toLocation = toLocation;
    }
}
