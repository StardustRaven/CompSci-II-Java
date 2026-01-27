// Name: Summer Star Isakson
// Lab Date: 2026-01-20

// WatcherEntry.java
// Subclass of CharacterEntry representing a Watcher.
// Adds Watcher-specific data (rank) and custom behavior.

public class WatcherEntry extends CharacterEntry {

    // Rank is unique to Watchers (ex: Major, General, Captain, etc.)
    private String rank;

    // Constructor for WatcherEntry
    // Calls the parent constructor and stores rank.
    // Type is the "what are they" part (Human, Knife, etc.)
    public WatcherEntry(String name, String type, String relationship, String bio, String rank) {
        super(name, type, relationship, bio);
        this.rank = rank;
    }

    // Override of getRank()
    // Base CharacterEntry returns an empty string by default.
    // WatcherEntry returns the actual rank.
    @Override
    public String getRank() {
        return rank;
    }

    // Override of getSummary()
    // Shows that Watcher is a role, not the type/species.
    @Override
    public String getSummary() {
        return getName() + " (" + getType() + " Watcher - " + rank + ") - " + getRelationship();
    }

}
