public class DemoBuildHouse {
    public static void main(String[] args) {

        BuildHouse normalHouse = new BuildHouse(3, "white", false);
        FancyHouse fancyHouse = new FancyHouse(5, "black", true, true);

        normalHouse.buildFoundation();
        normalHouse.describe();
        normalHouse.inspectRoof();
        System.out.println();

        fancyHouse.buildFoundation();
        fancyHouse.describe();
        fancyHouse.inspectRoof();

    }

}
