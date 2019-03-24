public class Speed {
    private double magnitude;
    private Unit unit;


    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double newMagnitude) {
        if (newMagnitude < 0) throw new RuntimeException("Magnitude can not be negative");
        this.magnitude = newMagnitude;
    }

    public Unit getUnit() {
        return unit;
    }

    public Speed(Unit unit,double magnitude) {
        setMagnitude(magnitude);
        setUnit(unit);
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void increasePercentage(double percent){
        if (percent <0) throw new NegativePercentageException("Percentage can not be negative");
        setMagnitude(getMagnitude()*((100+percent)/100));
    }

    public void changeUnit(Unit newUnit){
        setMagnitude(getMagnitude()*newUnit.getRatio()/unit.getRatio());
        unit=newUnit;
    }
}
