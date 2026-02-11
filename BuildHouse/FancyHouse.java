public class FancyHouse extends BuildHouse {

    private boolean hasHotTub;
    
    public FancyHouse(int rooms, String color, boolean hasCatDoor, boolean hasHotTub) {
        super(rooms, color, hasCatDoor);
        this.hasHotTub = hasHotTub;
    }
        public void describeFancyFeatures() {
        System.out.println("Hot tub installed: " + hasHotTub);
    }
    
@Override
public void describe() {
    super.describe();
    System.out.println("Hot tub installed: " + hasHotTub);
}

@Override
public void buildFoundation() {
    System.out.println("Reinfoced concrete with heated subfloor system.");
}
}
