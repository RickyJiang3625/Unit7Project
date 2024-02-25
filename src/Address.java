import java.util.Arrays;

public class Address {
    private String houseNum;
    private String streetName;
    private String aptNum;
    private String city;
    private String state;
    private int zipCode;

    public Address(String houseNum,String streetName,String aptNum,String city,String state,int zipCode){
        this.houseNum = houseNum;
        this.streetName=streetName;
        this.aptNum=aptNum;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
    }
    public Address(Address a){
        houseNum=a.getHouseNum();
        streetName=a.getStreetName();
        aptNum=a.getAptNum();
        city=a.getCity();
        state=a.getState();
        zipCode=a.getZipCode();
    }
    public Address(String info){
        String[] fullAddress=info.split(" ");
        houseNum=fullAddress[0];
        streetName=fullAddress[1]+" "+fullAddress[2];
        aptNum=fullAddress[3]+" "+fullAddress[4].replaceAll(",","");
        city=fullAddress[5].replaceAll(",","");
        state=fullAddress[6];
        zipCode= Integer.parseInt(fullAddress[7]);


    }
    public static Address random(){
        return new Address("123 Random Street Apt 3C, City, State "+((int) (Math.random()*99001)+1000));
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAptNum() {
        return aptNum;
    }

    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    public String toString() {
        return houseNum + " " + streetName + " " + aptNum + ", " + city + ", " + state + " " + zipCode;
    }
}
