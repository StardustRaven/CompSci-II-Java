// Name: Summer Star Isakson
// Lab Date: 2026-01-22

public class Textbook extends Book {
    private int gradeLevel;

    public Textbook() {
        super();
    }

    public Textbook(String title, String author, int pages, int gradeLevel) {
        super(title, author, pages);
        this.gradeLevel = gradeLevel;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
     }        
}