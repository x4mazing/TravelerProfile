package Project1_3;

public class TravProf {

                                //initialize all the variables in instance of the class
    private String  travAgentID = "temp",
            firstName = "temp",
            lastName = "temp",
            address = "temp",
            phone = "temp",
            travelType = "temp",
            paymentType = "temp";
    private float tripCost = 0;
    private MedCond medcond;

                                 //CONSTRUCTOR GIVEN ALL ARGUMENTS
    public TravProf(String newtravAgentID, String newfirstName, String newlastName, String newaddress, String newphone,
                    String newtravelType, String newpaymentType, float newtripCost, MedCond newmedCondInfo){
        travAgentID = newtravAgentID;
        firstName = newfirstName;
        lastName = newlastName;
        address = newaddress;
        phone = newphone;
        travelType = newtravelType;
        paymentType = newpaymentType;
        tripCost = newtripCost;
        medcond = newmedCondInfo;
    }

                                    //implementing the get functions of the class
    public String gettravAgentID(){
        return travAgentID;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public float getTripCost(){
        return tripCost;
    }
    public String getTravelType(){
        return travelType;
    }
    public String getPaymentType(){
        return paymentType;
    }
    public MedCond getMedCondInfo(){
        return medcond;
    }

                                    //implement the update functions of the class

    public void updateFirstName(String name){
        firstName = name;
    }
    public void updateLastName(String name){
        lastName = name;
    }
    public void updateAddress(String addy){
        address = addy;
    }
    public void updatePhone(String Phone){
        phone = Phone;
    }
    public void updateTripCost(String cost){
        tripCost = Float.parseFloat(cost);
    }
    public void updateTravelType(String travtype){
        travelType = travtype;
    }
    public void updatePaymentType(String paytype){
        paymentType = paytype;
    }
    public void updateMedCondInfo(MedCond cond){
        medcond = cond;
    }
}
