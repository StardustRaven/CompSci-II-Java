// Default1.java
// Default class with a constructor that inializes the name

public class Default1 {
        private String name; //instance variable

        //constructor initializes name with parameter name
        public Default1(String name) { //constructor name is class name
                this.name = name;
            } // end of constructor method

            //method to set the name in the object
            public void setName(String name) {
                this.name = name; //store this name
            } // end of setName method

            // method to retrieve the name from the object
            public String getName() {
                return name;
            } //end of getName
 } // end of Default class