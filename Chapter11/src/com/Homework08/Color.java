package com.Homework08;

public enum Color implements In {
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private final int redValue;
    private final int greenValue;
    private final int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("RGB value: R\t" + redValue + "\tG\t" + greenValue + "\tB\t" + blueValue);
    }

    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        Color red = Color.RED;
        red.show();

        Color blue = Color.BLUE;
        blue.show();

        switch (blue) {
            case RED -> System.out.println("RED");
            case GREEN -> System.out.println("GREEN");
            case BLUE -> System.out.println("BLUE");
            default -> System.out.println("NONE");
        }
    }
}
