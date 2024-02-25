import java.math.RoundingMode;
import java.text.DecimalFormat;
public class PostageCalculator {
    private static final double baseCost=3.75;
    public static String calculate(int zip1,int zip2,double weight,double l,double w,double h){
        DecimalFormat format=new DecimalFormat("#.00");
        format.setRoundingMode(RoundingMode.HALF_UP);

        double cost=baseCost;
        if(weight<40) {
            cost += (weight * 0.5);
        }
        else{
            cost+=(weight * 0.5)+((weight-40)*0.5);
        }
        String firstZip=String.valueOf(zip1);
        String secondZip=String.valueOf(zip2);
        int county1= Integer.parseInt(firstZip.substring(0,3));
        int county2= Integer.parseInt(secondZip.substring(0,3));
        if(county2>county1){
        cost+=(double) (county2-county1)/100;
        }
        else{
            cost+=(double) (county1-county2)/100;
        }
        if(l+w+h>36){
            cost+=((l+w+h)-36)*0.1;
        }
        return format.format(cost);
    }
    public static String calculate(Address address1,Address address2,double weight,double w,double l,double h){
        DecimalFormat format=new DecimalFormat("#.00");
        format.setRoundingMode(RoundingMode.HALF_UP);

        double cost=baseCost;
        if(weight<40) {
            cost += (weight % .10 * 0.5);
        }
        else{
            cost+=(weight % .10 * 0.5)+(((weight-40)%.10)*0.5);
        }
        String firstZip=String.valueOf(address1.getZipCode());
        String secondZip=String.valueOf(address2.getZipCode());
        int county1= Integer.parseInt(firstZip.substring(0,3));
        int county2= Integer.parseInt(secondZip.substring(0,3));
        if(county2>county1){
            cost+=(double) (county2-county1)/100;
        }
        else{
            cost+=(double) (county1-county2)/100;
        }
        if(l+w+h>36){
            cost+=(l+w+h)*0.1;
        }
        return format.format(cost);
    }
    public static String calculate(Package pack){
        DecimalFormat format=new DecimalFormat("#.00");
        format.setRoundingMode(RoundingMode.HALF_UP);

        double cost=baseCost;
        if(pack.getWeight()<40) {
            cost += (pack.getWeight() % .10 * 0.5);
        }
        else{
            cost+=(pack.getWeight() % .10 * 0.5)+(((pack.getWeight()-40)%.10)*0.5);
        }
        String firstZip=String.valueOf(pack.getOrigin().getZipCode());
        String secondZip=String.valueOf(pack.getDestination().getZipCode());
        int county1= Integer.parseInt(firstZip.substring(0,3));
        int county2= Integer.parseInt(secondZip.substring(0,3));
        if(county2>county1){
            cost+=(double) (county2-county1)/100;
        }
        else{
            cost+=(double) (county1-county2)/100;
        }
        if(pack.getHeight()+pack.getLength()+pack.getWidth()>36){
            cost+=(pack.getLength()+ pack.getWeight()+ pack.getHeight())*0.1;
        }
        return format.format(cost);
    }


}
