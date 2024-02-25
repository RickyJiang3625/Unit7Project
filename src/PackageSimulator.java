import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class PackageSimulator {
ArrayList<Package> packages=new ArrayList<Package>();

public void generate(int amount){
    for (int i = 0; i < amount; i++) {
        packages.add(new Package(Address.random(), Address.random(), (int) (Math.random() * 51.1) + 0.1,  (Math.random() * 19) + 2,  (Math.random() * 19) + 2,  (Math.random() * 19) + 2));
    }
}
    public String generateTotalCost() {
        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double totalCost = 0;
        for (Package p : packages) {
            totalCost += Double.parseDouble(PostageCalculator.calculate(p));
        }
        return df.format(totalCost);
    }
    public String simulationInfo(){
    String info="Randomly generated package info:\n";
    int packageNum=0;
    for(Package yes:packages){
        packageNum++;
    info+="\nPackage " + packageNum + ": ___________________________________________\n" +
            "Origin address: " + yes.getOrigin().toString() + "\n" +
            "Destination address: " + yes.getDestination().toString() + "\n" +
            "Weight: " + yes.getWeight() + " pounds\n" +
            "Height: " + yes.getHeight() + " inches\n" +
            "Length: " + yes.getLength() + " inches\n" +
            "Width: " + yes.getWidth() + " inches\n" +
            "Cost: " + PostageCalculator.calculate(yes) + "\n";

    }
    return info;
    }
    public static String calculationsInfo(){
    String info="There are 3 ways to calculate the cost of a package:\n1. Distance between origin and destination\n2. Size of package\n3. Weight of package\n"+
            "The base cost of a package is $3.75.\nThe price from the distance comes from the difference in county codes(first 3 numbers of zipcode) divided by 100\n"+
"The package gets charged extra if the weight is over 40 pounds. Packages will be charged 50 cents per pound over the 40 pound limit.\n"+
"The package will aso get charged extra if the dimension added is over 36 inches. Packages will be charged 10 cents per inch if over the 36 inch limit.";
return info;}}
