// Name: Summer Star Isakson
// Lab Date: 2026-01-20
//
// CharacterEntry.java
// Base class for all entries in the Wheelhaven Compendium.
// This represents the "default" character type that other
// specialized entries (like WatcherEntry) can extend.

public class CharacterEntry {

    // Core fields shared by ALL characters
    private String name;
    private String type;
    private String relationship;
    private String bio;

    // Constructor for a general CharacterEntry
    // Initializes all shared fields at object creation time.
    // Subclasses will call this using super(...).
    public CharacterEntry(String name, String type, String relationship, String bio) {
        this.name = name;
        this.type = type;
        this.relationship = relationship;
        this.bio = bio;
    }

    // Getter for name
    // Used by both the app and subclasses.
    public String getName() {
        return name;
    }

    // Getter for type (Human, Cat, Spoon, Watcher, etc.)
    // For Watchers, this value is set by the subclass constructor.
    public String getType() {
        return type;
    }

    // Getter for relationship to Star / others
    public String getRelationship() {
        return relationship;
    }

    // Getter for bio / description text
    public String getBio() {
        return bio;
    }

    // Default getRank() method.
    // Most characters do NOT have a rank, so this returns an empty string.
    // Subclasses like WatcherEntry override this to provide real data.
    public String getRank() {
        return "";
    }

    // Polymorphic summary method.
    // This version is used for non-Watcher characters.
    // Subclasses can override this to change formatting without
    // changing how the app calls the method.
    public String getSummary() {
        return getName() + " (" + getType() + ") - " + getRelationship();
    }

}
