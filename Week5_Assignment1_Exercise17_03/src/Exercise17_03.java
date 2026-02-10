// Name: Summer Isakson
// Lab: Week 5 – Assignment 1 Binary IO (Exercise 17.03)
// Date: 02/9/2026

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Exercise17_03 {

    public static void main(String[] args) {

        //System.out.println("Java is running from: " + System.getProperty("user.dir"));

        String filename = "Exercise17_02.dat";
        long sum = 0; 
        int count = 0;

        try (DataInputStream input = 
            new DataInputStream(new FileInputStream(filename))) {

            while (true) {
                int value = input.readInt();
                sum += value;
                count++;
            }

        } catch (EOFException e) {
            // Normal ending - we reached end of file
            System.out.println("Finished reading: " + filename);
            System.out.println("Integers read: " + count);
            System.out.println("Sum = " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}