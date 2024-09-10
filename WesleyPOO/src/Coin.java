import java.text.DecimalFormat;

enum Coin implements Valuable {
    C10(0.10, 1, "M10"),
    C25(0.25, 2, "M25"),
    C50(0.50, 3, "M50"),
    C100(1.00, 4, "M100");

    private double value;
    private int volume;
    private String label;

    private Coin(double value, int volume, String label) {
        this.value = value;
        this.volume = volume;
        this.label = label;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00");
        return this.label + ":" + d.format(this.value) + ":" + this.volume;
    }
}
