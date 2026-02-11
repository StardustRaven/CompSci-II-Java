public class BuildHouse extends AbstractHouse {
    private int rooms;
    private String color;
    private boolean hasCatDoor;

    public BuildHouse(int rooms, String color, boolean hasCatDoor) {
        this.rooms = rooms;
        this.color = color;
        this.hasCatDoor = hasCatDoor;
    }

     @Override
        public String getRoofType() {
            return "shingle";
        }

    @Override
        public void buildFoundation() {
            System.out.println("Pouring standard concrete foundation.");
        }    

    public void describe() {
        
       
        System.out.println("Rooms: " + rooms);
        System.out.println("Color: " + color);
        System.out.println("Cat door: " + hasCatDoor);

    }

    public void repaint(String newColor) {
        color=newColor;        
    }
}
