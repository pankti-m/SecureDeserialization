class Cycle implements java.io.Serializable {

    private int numWheels;
    private String type;
    private String make;

    Cycle(int numWheels, String type, String make) {
        this.numWheels = numWheels;
	this.type = type;
	this.make = make;
    }

    int getNumWheels() {
	return numWheels;
    }

    String getType() {
	return type;
    }

    String getMake() {
	return make;
    }
}
