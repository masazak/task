package Entities;


public class Snack  extends Item{
    private String code;

    private String name;

    private float price;


    public Snack(String code, String name, float price) {
        super(code, name, price);
    }


    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "Snack{" +
                "snackName='" + name + '\'' +
                ", snackPrice=" + price +
                '}';
    }
}
