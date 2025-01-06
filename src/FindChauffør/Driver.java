package FindChauffør;

class Driver {
    private String name;
    private boolean isBooked;
    private int[] districtCoverage;

    public Driver(String name, int[] districtCoverage) {
        this.name = name;
        this.isBooked = false;
        this.districtCoverage = districtCoverage;
    }

    public String getName() {
        return name;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean coversDistrict(int districtNumber) {
        for (int district : districtCoverage) {
            if (district == districtNumber) {
                return true;
            }
        }
        return false;
    }
}
