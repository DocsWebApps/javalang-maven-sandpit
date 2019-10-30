package LambdaOperations;

public class BookImpl implements Book {
    private String title;
    private final String author;
    private final int published;

    private BookImpl(String title, String author, int published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String bookInfo() {
        return "Book Information: " + this.title + ", written by " + this.author + " in " + this.published +".";
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public void changeMe() {
       this.title = "Shabham my friend - you busted your List";
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublished() {
        return this.published;
    }

    public static class Builder {
        private String title;
        private String author;
        private int published;

        Builder() {
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder published(int published) {
            this.published = published;
            return this;
        }

        public Book build() {
            return new BookImpl(title, author, published);
        }

        public String toString() {
            return "BookImpl.BookImplBuilder(title=" + this.title + ", author=" + this.author + ", published=" + this.published + ")";
        }
    }
}
