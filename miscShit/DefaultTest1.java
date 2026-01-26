// DefaultTest1.java
// Using the Account constructor to initalze the name instance
// variable at the time each Account object is created.

public class DefaultTest1 {
        public static void main(String[] args) {
            //create two account objects
            Default1 default1 = new Default1("Tanner Vey Ravenshield");
            Default1 default2 = new Default1("Star Vey Ravenshield");
            default1.setName("Commander Ravenshiled");

            // display inital value of name for each account
            System.out.printf("default1 name is %s%n", default1.getName());
            System.out.printf("default2 name is %s%n", default2.getName());
            System.out.printf("updated name is %s%n", default1.getName());
        } //end of main method
    } // end of DefaultTest1 class     