package me.devtarix.TestBox;

public class SimController {

    public double x,l;

    public SimController() {
        l = 0;
    }

    public void setL(double L) {
        l = L;
    }

    public double getL() {
        return l;
    }

    public void setX() {
        this.x = (2*Math.pow(l,2) + ((-3)*l) - 2);
    }

    public double getX() {
        return x;
    }
}
