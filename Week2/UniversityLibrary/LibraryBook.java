package UniversityLibrary;

public class LibraryBook {
    private String title;
    private String writer;
    private String isbnCode; 

    // Getter and Setter for Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for Writer
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }

    // Getter and Setter for ISBN Code
    public String getIsbnCode() { 
        return isbnCode;
    }
    public void setIsbnCode(String isbnCode) { 
        this.isbnCode = isbnCode;
    }  

    // Overridden toString method for displaying Book details
    @Override
    public String toString() {
        return "Title: " + title + " | Writer: " + writer + " | ISBN Code: " + isbnCode;
    }
}
