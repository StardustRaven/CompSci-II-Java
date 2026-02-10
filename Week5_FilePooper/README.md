# FilePooper – Simple Java File I/O

This project demonstrates basic Java file input/output.  
It reads text from an external file and prints the contents to the console.

No frameworks. No libraries. Just Java doing Java things.

---

## Project Structure

FilePooper/
├── src/
│ └── FilePooper.java
├── data/
│ └── input.txt
└── README.md


- `src/` contains the Java source code  
- `data/input.txt` is the external file read at runtime  

---

## How to Run

### Using VS Code

1. Open the **FilePooper** folder as the workspace  
2. Open `src/FilePooper.java`  
3. Click **Run**

### Using the Command Line

From the project root (`FilePooper/):

'bash
javac src/FilePooper.java
java -cp src FilePooper
Notes

The program uses a relative file path: data/input.txt

It must be run from the project root directory for file I/O to work correctly

The input file is included in the repository

Expected Output

The contents of data/input.txt will be printed to the console line by line.