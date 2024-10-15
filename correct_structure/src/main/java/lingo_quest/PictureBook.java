package lingo_quest;

import java.io.File;

public class PictureBook {
    private File pictureBook;

    // Constructor
    public PictureBook(String name, String description, File pictureBook) {
        super();
        this.pictureBook = pictureBook;
        // Stub implementation
    }

    // Setter for pictureBook
    public void setPictureBook(File book) {
        this.pictureBook = book;
    }

    // Getter for pictureBook
    public File getPictureBook() {
        return this.pictureBook;
    }
}
