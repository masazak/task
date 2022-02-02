package Entities;

public class MoneySlot {
    private float value;

    private String code;

    // Coin or note
    private String type;


    public MoneySlot(float value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public float getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
