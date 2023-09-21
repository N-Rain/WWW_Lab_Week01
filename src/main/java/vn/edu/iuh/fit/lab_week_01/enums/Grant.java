package vn.edu.iuh.fit.lab_week_01.enums;

public enum Grant {
    ENABLE (1),
    DISABLE (0);
    private int value;

    Grant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}