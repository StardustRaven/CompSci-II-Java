public abstract class AbstractHouse {

    protected String roofType;

    // IOU: every real house must say what kind of roof it has
    public String getRoofType() {
        return roofType;
    }    

    // Shared method: the forman can always print the roof type
    public void inspectRoof() {
        System.out.println("Roof Type: " + getRoofType());
    }

    // IOU - every real house must define how foundation is built
    public abstract void buildFoundation();
}