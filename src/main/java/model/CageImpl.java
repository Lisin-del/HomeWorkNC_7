package model;

public class CageImpl implements Cage {
    private int numberCage;
    private double area;
    private Condition condition;
    private boolean isVacantCage;


    public CageImpl(int numberCage, double area, Condition condition, boolean isVacantCage) {
        this.numberCage = numberCage;
        this.area = area;
        this.condition = condition;
        this.isVacantCage = isVacantCage;
    }

    public int getNumberCage() {
        return numberCage;
    }

    public void setNumberCage(int numberCage) {
        this.numberCage = numberCage;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setVacantCage(boolean vacantCage) {
        isVacantCage = vacantCage;
    }

    @Override
    public String toString() {
        return "CageImpl{" +
                "numberCage=" + numberCage +
                ", area=" + area +
                ", condition=" + condition +
                ", isVacantCage=" + isVacantCage +
                '}';
    }

    @Override
    public int getNumber() {
        return numberCage;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public Condition getCondition() {
        return condition;
    }

    @Override
    public boolean isVacantCage() {
        return isVacantCage;
    }

}
