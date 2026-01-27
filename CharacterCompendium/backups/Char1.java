/*
Name: Summer Star Isakson
Lab Date: 2026-01-20
*/

// Char1.java
// Default class with a constructor that inializes the name

public class Char1 {
        private String name; //instance variable
        private String type;
        private String relationship;
        private String bio;

        //constructor initializes name with parameter name
        public Char1(String name, String type, String relationship, String bio) { //constructor name is class name
                this.name = name;
                this.type = type;
                this.relationship = relationship;
                this.bio = bio;
            } // end of constructor method

            //method to set the name in the object
            public void setName(String name) {
                this.name = name; //store this name
            } // end of setName method

            // method to retrieve the name from the object
            public String getName() {
                return name;
            } //end of getName

            // method to retrieve the Type from the object
            public String getType() {
                return type;
            } //end of getType
            
            // method to retrieve the relationship from the object
            public String getRelationship() {
                return relationship;
             } //end of getRelationship

             // method to retrieve the bio from the object
             public String getBio() {
                return bio;
             } //end of getBio


 } // end of Default class