package models;

public class BookAuthor {
    private String fullName;
    private int yearOfBirth;
    private String shortBiography;

    public BookAuthor(String fullName, int yearOfBirth, String shortBiography) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.shortBiography = shortBiography;
    }

    // Getters (nếu cần)
    public String getFullName() { return fullName; }
    // ...

    @Override
    public String toString() {
        // Định dạng theo yêu cầu của tài liệu [cite: 186-188]
        return this.fullName + " (" + this.yearOfBirth + ", " + this.shortBiography + ")";
    }
}