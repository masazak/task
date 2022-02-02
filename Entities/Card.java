package Entities;


public class Card {

    private String number;

    private int vcc;


    public Card(String number, int vcc) {
        this.number = number;
        this.vcc = vcc;
    }

    public int getVcc() {
        return vcc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setVcc(int vcc) {
        this.vcc = vcc;
    }
}
