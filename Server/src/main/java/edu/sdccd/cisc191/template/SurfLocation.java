package edu.sdccd.cisc191.template;

public class SurfLocation {
    private String beachName;
    private boolean suitableForBeginners; // true or false
    private String surfEnvironment; // three types: beach breaks, point breaks, reef breaks

    @Override //overrides the base class, which is Object
    public String toString() {
        return "SurfLocation{" +
                "beachName='" + beachName + '\'' +
                ", suitableForBeginners=" + suitableForBeginners +
                ", surfEnvironment='" + surfEnvironment + '\'' +
                '}';
    }

    public SurfLocation(String beachName, boolean suitableForBeginners, String surfEnvironment) {
        this.beachName = beachName;
        this.suitableForBeginners = suitableForBeginners;
        this.surfEnvironment = surfEnvironment;
    }

    public void setBeachName(String beachName) {
        this.beachName = beachName;
    }

    public void setSuitableForBeginners(boolean suitableForBeginners) {
        this.suitableForBeginners = suitableForBeginners;
    }

    public void setSurfEnvironment(String surfEnvironment) {

        this.surfEnvironment = surfEnvironment;
    }

    public String getBeachName() {
        return this.beachName;
    }

    public boolean isSuitableForBeginners() {
        return this.suitableForBeginners;
    }

    public String getSurfEnvironment() {
        return this.surfEnvironment;
    }

}

