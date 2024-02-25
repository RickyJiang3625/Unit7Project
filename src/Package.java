public class Package {
    private Address origin;
    private Address destination;
    private double weight;
    private double length;
    private double height;
    private double width;
    public Package(Address o, Address d, double lbs, double w, double l, double h) {
        origin = o;
        destination = d;
        weight = lbs;
        width = w;
        length = l;
        height = h;
    }
    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }
}
