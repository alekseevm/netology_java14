package netology_java14;
public class Book extends Product{
    private String name;
    private String author;



    public Book(String name, String author, int id, int price) {
        super(id, name, price);
        this.name = name;
        this.author = author;
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



}
