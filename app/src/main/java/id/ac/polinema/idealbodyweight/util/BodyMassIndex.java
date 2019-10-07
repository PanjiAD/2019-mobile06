package id.ac.polinema.idealbodyweight.util;

public class BodyMassIndex {
    private int mass;
    private float height;
    private float index;

    public BodyMassIndex(int mass, float height) {
        this.mass = mass;
        this.height = height;
        this.index = calculate();
    }

    public float getIndex() {
        return index;
    }

    private float calculate() {
        return (mass / (height * height));
    }
}
