// Name: Summer Star Isakson
// Lab Date: 2026-01-20
//
// PlaceEntry.java
// Basic class representing a location/place in the Wheelhaven Compendium.
// This is NOT wired into CompendiumApp yet — just building the model class first.

public class PlaceEntry {

    // Core place fields
    private String name;        // ex: "The Great Hearth"
    private String placeType;   // ex: "Hall", "Market", "Grove", "Gate", "Forge"
    private String region;      // ex: "Wheel", "Meadow", "Market", "Lighthouse"
    private String description; // 1–2 lines, same idea as character bio
    private String notes;       // optional: lore hooks, rules, details, etc.

    // Constructor: set all fields at creation time
    public PlaceEntry(String name, String placeType, String region, String description, String notes) {
        this.name = name;
        this.placeType = placeType;
        this.region = region;
        this.description = description;
        this.notes = notes;
    }

    // Getters (no setters for now — keep it simple)
    public String getName() {
        return name;
    }

    public String getPlaceType() {
        return placeType;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    // Summary string for quick printing later
    public String getSummary() {
        // Example: "The Great Hearth (Hall) - Wheel"
        return getName() + " (" + getPlaceType() + ") - " + getRegion();
    }

} // end of PlaceEntry class
