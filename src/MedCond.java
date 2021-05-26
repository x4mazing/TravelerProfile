package Project1_3;
public class MedCond{                        //medical conditions class define variables for the class
    private String  mdContact = "temp",
                    mdPhone = "temp",
                    algType = "temp",
                    illType = "temp";

                                            //CONSTRUCTOR GIVEN ALL ARGUMENTS
    public MedCond(String AlgType, String IllType, String MdContact, String MdPhone){
        algType = AlgType;
        illType = IllType;
        mdContact = MdContact;
        mdPhone = MdPhone;
    }

                                           //create get methods of Medcond
    public String getMdContact(){
        return mdContact;
    }
    public String getMdPhone(){
        return mdPhone;
    }
    public String getAlgType(){
        return algType;
    }
    public String getIllType(){
        return illType;
    }

                                            //create updates methods of medcond
    public void updateMdContact(String update){
        mdContact = update;
    }
    public void updateMdPhone(String update){
        mdPhone = update;
    }
    public void updateAlgType(String update){
        algType = update;
    }
    public void updateIllType(String update){
        illType = update;
    }
}
