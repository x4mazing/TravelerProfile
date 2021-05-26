package Project1_3;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class TravProfDB { //INITIALIZE CLASS
    public int numTravelers, currentTravelerIndex;
    public String fileName;
    private TravProf[] travelerList = new TravProf[10];

    public TravProfDB(String newfileName){      //CREATE A NEW DATABASE FILE EACH ITERATION

        fileName = newfileName;
        File file = new File(fileName);
    } //assume .txt included

    public void insertNewProfile(TravProf newProfile){  //EXPANDS THE DATABASE SIZE BY 1
        TravProf newarr[] = new TravProf[numTravelers + 1];

        for(int i = 0; i < numTravelers; i++){
            newarr[i] = travelerList[i];
        }

        newarr[numTravelers] = newProfile;
        travelerList = newarr;
        numTravelers++;
    }

    public TravProf findProfile(String travAgentID, String lastName){ //FIND PROFILE GIVEN AGENT ID AND LAST NAME
        for(int i = 0; i < numTravelers; i++){              //iterate all of the database
            TravProf profile = travelerList[i];
                                                            //check to see if the travel agent or last name matches
            if(profile.gettravAgentID().equals(travAgentID) && profile.getLastName().equals(lastName)){
                return profile;
            }
        }
        return null;                                        //if there are no matches, return null
    }

    public boolean deleteProfile(String travAgentID, String lastname) { //DELETE A PROFILE GIVEN AGENT ID AND LAST NAME

        TravProf temp = findProfile(travAgentID, lastname); // create a temporary travel profile to store found profile

        if(temp == null)    //if there are no matches return false
            return false;

        else {  //else create a temporary travel profile list one smaller than original
            TravProf[] temptravelerList = new TravProf[travelerList.length - 1];
            for (int i = 0, k = 0; i < numTravelers; i++){
                if (!travelerList[i].getLastName().equals(lastname)) { //compare both last names
                    temptravelerList[k++] = travelerList[i];            //copy over traveler profiles
                }
            }
            travelerList = temptravelerList; //swap array with temp array
            numTravelers--;                  //decrement number of travellers
            return true;            //return true as operation was successful
        }
    }

    public TravProf findFirstProfile(){     //FIND THE FIRST PROFILE IN THE TRAVELER LIST
        if(travelerList.length > 0) {
            currentTravelerIndex = 0;
            return travelerList[0];
        }
        else
            return null;
    }

    public TravProf findNextProfile(){      //FIND THE NEXT PROFILE IN THE TRAVELER LIST
        if(numTravelers > 0 && currentTravelerIndex < numTravelers - 1) { //check to see number of travelers
            currentTravelerIndex++;
            return travelerList[currentTravelerIndex];
        }
        else
            return null;
    }

    private void expandSize(){              //HELPER FUNCTION WHEN NOT ENOUGH INDICIES IN TRAVELLER LIST
        TravProf[] newarr = new TravProf[travelerList.length + 10]; //increase the space by 10

        for(int i = 0; i < numTravelers; i++){      //copy over travellers
            newarr[i] = travelerList[i];
        }

        travelerList = newarr;      //swap traveler list
    }
    public void WriteAllTravProf(String fileName) {    //WRITE ALL TRAVELER PROFILES TO DATABASE FILE
        try {

                                                        //define writer
            FileOutputStream outputStream = new FileOutputStream(fileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            BufferedWriter buff = new BufferedWriter(outputStreamWriter);

                                                        //for loop to write all variables to file
            for(int i = 0; i < numTravelers; i++){
                buff.write(travelerList[i].gettravAgentID());
                buff.newLine();

                buff.write(travelerList[i].getFirstName());
                buff.newLine();

                buff.write(travelerList[i].getLastName());
                buff.newLine();

                buff.write(travelerList[i].getAddress());
                buff.newLine();

                buff.write(travelerList[i].getPhone());
                buff.newLine();

                buff.write(travelerList[i].getTravelType());
                buff.newLine();

                buff.write(travelerList[i].getPaymentType());
                buff.newLine();

                buff.write(String.valueOf(travelerList[i].getTripCost())); //cast from float to string
                buff.newLine();

                /////////////////////////////////////////////////////////////////////////////////////////////
                                                                            //medcond section
                buff.write(travelerList[i].getMedCondInfo().getAlgType());
                buff.newLine();

                buff.write(travelerList[i].getMedCondInfo().getIllType());
                buff.newLine();

                buff.write(travelerList[i].getMedCondInfo().getMdContact());
                buff.newLine();

                buff.write(travelerList[i].getMedCondInfo().getMdPhone());
                buff.newLine();

                //create a terminal value for each profile
                buff.newLine();
            }
            buff.write("~\n");
            buff.close();               //close the buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeDatabase(String fileName){    //INITALIZE AN EXISTING DATABASE
        try{
            BufferedReader buff = new BufferedReader(new FileReader(fileName)); //create new buffer

            numTravelers = 0;
            String line;

            while(!((line = buff.readLine()).equals("~"))){     //check for terminal symbol

                if(numTravelers == travelerList.length) {       //expand the size of the traveler list
                    expandSize();
                }

                                                                //create temporary variables
                String travAgentID, FirstName, LastName, Address, Phone, TravelType, PaymentType,
                        AlgType, IllType, MdContact, MdPhone;
                float TripCost;

                travAgentID = line;

                                        //read all of the variables from the file
                line = buff.readLine();
                FirstName = line;

                line = buff.readLine();
                LastName = line;

                line = buff.readLine();
                Address = line;

                line = buff.readLine();
                Phone = line;

                line = buff.readLine();
                TravelType = line;

                line = buff.readLine();
                PaymentType = line;

                line = buff.readLine();
                TripCost = Float.parseFloat(line);

                line = buff.readLine();
                AlgType = line;

                line = buff.readLine();
                IllType = line;

                line = buff.readLine();
                MdContact = line;

                line = buff.readLine();
                MdPhone = line;

                line = buff.readLine();
                                        //create new instances for the database
                MedCond medprofile = new MedCond(AlgType, IllType, MdContact, MdPhone);
                TravProf profile = new TravProf(travAgentID, FirstName, LastName, Address, Phone, TravelType,
                                                PaymentType, TripCost, medprofile);

                travelerList[numTravelers] = profile;
                numTravelers++;
            }
            buff.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        currentTravelerIndex = 0;
    }
}
