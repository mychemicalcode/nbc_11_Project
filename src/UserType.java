public class UserType {

    private String name;
    private int price;
    private String description;

    public MenuItem (String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {return this.name;}

    public int getPrice() {return this.price;}

    public String getDescription() {return this.description;}

}
