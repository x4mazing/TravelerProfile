package Project1_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravProfInterface {
    private final TravProfDB database;
    private JFrame mainFrame;
    private boolean repeated = false;
                                            //CREATE A DATABASE OBJECT FOR EACH ITERATION
    public TravProfInterface(String newfileName){
        database = new TravProfDB(newfileName);
        initDB();
        getUserChoice();
    }

    private void getUserChoice(){    //GET USER SELECTED OPERATIONS

        if(!repeated){
            mainFrame = new JFrame("Integrated Travel System");
            mainFrame.setSize(400,400);
            mainFrame.setLayout(null);
        }


        JLabel Header;
        JRadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5;
        JButton btn;

        Header = new JLabel("Integrated Travel System");
        Header.setBounds(100,10,150,20);
        mainFrame.add(Header);

        rbtn1 = new JRadioButton("Create Profile");
        rbtn1.setBounds(100,50,120,20);
        mainFrame.add(rbtn1);

        rbtn2 = new JRadioButton("Delete Profile");
        rbtn2.setBounds(100,80,120,20);
        mainFrame.add(rbtn2);

        rbtn3 = new JRadioButton("Update Profile");
        rbtn3.setBounds(100,110,120,20);
        mainFrame.add(rbtn3);

        rbtn4 = new JRadioButton("Find/Display Profile");
        rbtn4.setBounds(100,140,150,20);
        mainFrame.add(rbtn4);

        rbtn5 = new JRadioButton("Display All Profiles");
        rbtn5.setBounds(100,170,150,20);
        mainFrame.add(rbtn5);

        ButtonGroup group = new ButtonGroup();
        group.add(rbtn1);
        group.add(rbtn2);
        group.add(rbtn3);
        group.add(rbtn4);
        group.add(rbtn5);

        btn = new JButton("Select");
        btn.setBounds(110,200,100,30);
        mainFrame.add(btn);

        repeated = true;
        mainFrame.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();

                if(rbtn1.isSelected())
                    createNewTravProf();
                else if(rbtn2.isSelected())
                    deleteTravProf();
                else if(rbtn3.isSelected())
                    updateTravProf();
                else if(rbtn4.isSelected())
                    findTravProf();
                else if(rbtn5.isSelected())
                    displayAllTravProf();
            }
        });
    }


    public void createNewTravProf(){        //CREATE A NEW TRAVELLER PROFILE IN MEMORY
//        Scanner sc = new Scanner(System.in);

        final String[] travAgentID = new String[1];
        final String[] FirstName = new String[1];
        final String[] LastName = new String[1];
        final String[] Address = new String[1];
        final String[] Phone = new String[1];
        final String[] TravelType = new String[1];
        final String[] PaymentType = new String[1];
        final String[] AlgType = new String[1];
        final String[] IllType = new String[1];
        final String[] MdContact = new String[1];
        final String[] MdPhone = new String[1];
        final float[] TripCost = new float[1];

        JLabel Header, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12;
        JTextField txt1, txt2, txt3, txt4, txt5, txt8, txt9, txt10, txt11, txt12;
        JComboBox box6, box7;
        JButton btn, backbtn;

        Header = new JLabel("Create Profile");
        Header.setBounds(100,10,150,20);
        mainFrame.add(Header);

        lb1 = new JLabel("Traveler ID: ");
        lb1.setBounds(10,50,120,20);
        mainFrame.add(lb1);

        txt1 = new JTextField();
        txt1.setBounds(120,50,150,20);
        mainFrame.add(txt1);

        lb2 = new JLabel("First Name: ");
        lb2.setBounds(10,70,120,20);
        mainFrame.add(lb2);

        txt2 = new JTextField();
        txt2.setBounds(120,70,150,20);
        mainFrame.add(txt2);

        lb3 = new JLabel("Last Name: ");
        lb3.setBounds(10,90,120,20);
        mainFrame.add(lb3);

        txt3 = new JTextField();
        txt3.setBounds(120,90,150,20);
        mainFrame.add(txt3);

        lb4 = new JLabel("Address: ");
        lb4.setBounds(10,110,120,20);
        mainFrame.add(lb4);

        txt4 = new JTextField();
        txt4.setBounds(120,110,150,20);
        mainFrame.add(txt4);

        lb5 = new JLabel("Phone: ");
        lb5.setBounds(10,130,120,20);
        mainFrame.add(lb5);

        txt5 = new JTextField();
        txt5.setBounds(120,130,150,20);
        mainFrame.add(txt5);

        lb6 = new JLabel("Travel Type: ");
        lb6.setBounds(10,150,120,20);
        mainFrame.add(lb6);

        String[] list1 = {"Select", "Personal", "Business"};
        box6 = new JComboBox<>(list1);
        box6.setBounds(120,150,150,20);
        mainFrame.add(box6);

        lb7 = new JLabel("Payment Type: ");
        lb7.setBounds(10,170,120,20);
        mainFrame.add(lb7);

        String[] list2 = {"Select", "Credit", "Check", "Debit", "Invoice"};
        box7 = new JComboBox<>(list2);
        box7.setBounds(120,170,150,20);
        mainFrame.add(box7);

        lb8 = new JLabel("Trip Cost: ");
        lb8.setBounds(10,190,120,20);
        mainFrame.add(lb8);

        txt8 = new JTextField();
        txt8.setBounds(120,190,150,20);
        mainFrame.add(txt8);

        lb9 = new JLabel("Allergies: ");
        lb9.setBounds(10,210,120,20);
        mainFrame.add(lb9);

        txt9 = new JTextField();
        txt9.setBounds(120,210,150,20);
        mainFrame.add(txt9);

        lb10 = new JLabel("Illnesses: ");
        lb10.setBounds(10,230,120,20);
        mainFrame.add(lb10);

        txt10 = new JTextField();
        txt10.setBounds(120,230,150,20);
        mainFrame.add(txt10);

        lb11 = new JLabel("Medical Contact: ");
        lb11.setBounds(10,250,120,20);
        mainFrame.add(lb11);

        txt11 = new JTextField();
        txt11.setBounds(120,250,150,20);
        mainFrame.add(txt11);

        lb12 = new JLabel("Contact Phone: ");
        lb12.setBounds(10,270,120,20);
        mainFrame.add(lb12);

        txt12 = new JTextField();
        txt12.setBounds(120,270,150,20);
        mainFrame.add(txt12);

        btn = new JButton("Submit");
        btn.setBounds(120, 300, 100, 30);
        mainFrame.add(btn);

        backbtn = new JButton("Back");
        backbtn.setBounds(10,300,100,30);
        mainFrame.add(backbtn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                travAgentID[0] = txt1.getText();
                FirstName[0] = txt2.getText();
                LastName[0] = txt3.getText();
                Address[0] = txt4.getText();
                Phone[0] = txt5.getText();
                TravelType[0] = (String) box6.getSelectedItem();
                PaymentType[0] = (String) box7.getSelectedItem();
                TripCost[0] = Float.parseFloat(txt8.getText());
                AlgType[0] = txt9.getText();
                IllType[0] = txt10.getText();
                MdContact[0] = txt11.getText();
                MdPhone[0] = txt12.getText();

                                                    //use temporary variables and create traveler profiles and medconds
                MedCond medcondinfo = new MedCond(AlgType[0], IllType[0], MdContact[0], MdPhone[0]);
                TravProf profile = new TravProf(travAgentID[0], FirstName[0], LastName[0], Address[0], Phone[0], TravelType[0], PaymentType[0], TripCost[0], medcondinfo);

                database.insertNewProfile(profile);

                writeToDB();

                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();
                getUserChoice();
            }
        });

        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();
                getUserChoice();
            }
        });
    }

    public void deleteTravProf(){                   //DELETE A TRAVEL PROFILE

        JLabel Header, lb1, lb2;
        JTextField txt1, txt2;
        JButton btn1, backbtn;

        Header = new JLabel("Delete Profile");
        Header.setBounds(100,10,150,20);
        mainFrame.add(Header);

        lb1 = new JLabel("Traveler ID: ");
        lb1.setBounds(10,50,120,20);
        mainFrame.add(lb1);

        txt1 = new JTextField();
        txt1.setBounds(120,50,150,20);
        mainFrame.add(txt1);

        lb2 = new JLabel("Last Name: ");
        lb2.setBounds(10,70,120,20);
        mainFrame.add(lb2);

        txt2 = new JTextField();
        txt2.setBounds(120,70,150,20);
        mainFrame.add(txt2);

        btn1 = new JButton("Delete");
        btn1.setBounds(120, 100, 100, 30);
        mainFrame.add(btn1);

        backbtn = new JButton("Back");
        backbtn.setBounds(10, 100, 100, 30);
        mainFrame.add(backbtn);


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = txt1.getText();
                String lastName = txt2.getText();

                mainFrame.getContentPane().remove(txt1);
                mainFrame.getContentPane().remove(lb2);
                mainFrame.getContentPane().remove(txt2);
                mainFrame.getContentPane().remove(btn1);
                mainFrame.revalidate();
                mainFrame.repaint();

                lb1.setBounds(100,50,100,30);
                if(database.deleteProfile(ID,lastName)){
                    lb1.setText("Profile Deleted.");
                }
                else{
                    lb1.setText("Profile not found.");
                }

                writeToDB();

                backbtn.setText("OK");
                backbtn.setBounds(100,100,100,30);
            }
        });

        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();
                getUserChoice();
            }
        });
    }

    public void updateTravProf(){                       //UPDATE ANY OF THE VARIABLES IN A PROFILE.

        JLabel Header, lb1, lb2, lb3;
        JTextField txt1;
        JTextField txt2;
        final JTextField[] txt3 = new JTextField[1];
        JComboBox box;
        JButton btn1, btn2, backbtn;
        final TravProf[] profile = new TravProf[1];

        Header = new JLabel("Update Profile");
        Header.setBounds(100,10,150,20);
        mainFrame.add(Header);

        lb1 = new JLabel("Traveler ID: ");
        lb1.setBounds(10,50,120,20);
        mainFrame.add(lb1);

        txt1 = new JTextField();
        txt1.setBounds(120,50,150,20);
        mainFrame.add(txt1);

        lb2 = new JLabel("Last Name: ");
        lb2.setBounds(10,70,120,20);
        mainFrame.add(lb2);

        txt2 = new JTextField();
        txt2.setBounds(120,70,150,20);
        mainFrame.add(txt2);

        lb3 = new JLabel("Update Field: ");
        lb3.setBounds(10,100,150,20);
        mainFrame.add(lb3);

        String[] list = {"Select","Address", "Phone number", "Travel type", "Payment type", "Trip cost", "Allergies", "Illnesses","Medical Contact", "Medical contact phone"};
        box = new JComboBox<>(list);
        box.setBounds(120,100,150,20);
        mainFrame.add(box);

        btn1 = new JButton("Find");
        btn1.setBounds(120,130,100,30);
        mainFrame.add(btn1);

        backbtn = new JButton("Back");
        backbtn.setBounds(10,130,100,30);
        mainFrame.add(backbtn);

        btn2 = new JButton("Submit");
        btn2.setBounds(120,130,100,30);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = txt1.getText();
                String lastName = txt2.getText();

                profile[0] = database.findProfile(ID,lastName);

                mainFrame.getContentPane().remove(txt1);
                mainFrame.getContentPane().remove(txt2);
                mainFrame.getContentPane().remove(box);
                mainFrame.getContentPane().remove(btn1);
                mainFrame.revalidate();
                mainFrame.repaint();

                Header.setText("Update");
                Header.setBounds(150,10,150,20);

                lb1.setText("Traveler ID  -  " + ID);
                lb2.setText("Last Name  -  " + lastName);

                lb3.setText((String) box.getSelectedItem() + ": ");
                txt3[0] = new JTextField();
                txt3[0].setBounds(120,100,150,20);
                mainFrame.add(txt3[0]);

                mainFrame.add(btn2);
            }
        });

        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();
                getUserChoice();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = txt3[0].getText();

                int picked = box.getSelectedIndex();
                if(picked == 1)
                    profile[0].updateAddress(value);
                if(picked == 2)
                    profile[0].updatePhone(value);
                if(picked == 3)
                    profile[0].updateTravelType(value);
                if(picked == 4)
                    profile[0].updatePaymentType(value);
                if(picked == 5)
                    profile[0].updateTripCost(value);
                if(picked == 6)
                    profile[0].getMedCondInfo().updateAlgType(value);
                if(picked == 7)
                    profile[0].getMedCondInfo().updateIllType(value);
                if(picked == 8)
                    profile[0].getMedCondInfo().updateMdContact(value);
                if(picked == 9)
                    profile[0].getMedCondInfo().updateMdPhone(value);

                writeToDB();

                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();
                getUserChoice();
            }
        });
    }

    public void findTravProf(){                     //FIND PROFILE AND DISPLAY IT

        JLabel Header, lb1, lb2;
        JTextField txt1, txt2;
        JButton btn, backbtn;

        Header = new JLabel("Find Profile");
        Header.setBounds(100,10,150,20);
        mainFrame.add(Header);

        lb1 = new JLabel("Traveler ID: ");
        lb1.setBounds(10,50,120,20);
        mainFrame.add(lb1);

        txt1 = new JTextField();
        txt1.setBounds(120,50,150,20);
        mainFrame.add(txt1);

        lb2 = new JLabel("Last Name: ");
        lb2.setBounds(10,70,120,20);
        mainFrame.add(lb2);

        txt2 = new JTextField();
        txt2.setBounds(120,70,150,20);
        mainFrame.add(txt2);

        btn = new JButton("Find");
        btn.setBounds(120,100,100,30);
        mainFrame.add(btn);

        backbtn = new JButton("Back");
        backbtn.setBounds(10,100,100,30);
        mainFrame.add(backbtn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = txt1.getText();
                String lastName = txt2.getText();

                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();

                displayTravProf(database.findProfile(ID, lastName));
            }
        });

        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();
                getUserChoice();
            }
        });
    }

    public void displayTravProf(TravProf traveler){ //DISPLAY THE PROFILE PROVIDED

        JLabel Header, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12;
        JButton btn;

        Header = new JLabel("Traveler Profile");
        Header.setBounds(100,10,150,20);
        mainFrame.add(Header);

        btn = new JButton("Close");

        if(traveler == null){
            lb1 = new JLabel("Profile not found.");
            lb1.setBounds(100,50,150,20);
            mainFrame.add(lb1);

            btn.setBounds(120,90,100,30);
            mainFrame.add(btn);
        }
        else{
            lb1 = new JLabel("Traveler ID:  " + traveler.gettravAgentID());
            lb1.setBounds(10,50,300,20);
            mainFrame.add(lb1);

            lb2 = new JLabel("First Name:  " + traveler.getFirstName());
            lb2.setBounds(10,70,300,20);
            mainFrame.add(lb2);

            lb3 = new JLabel("Last Name:  " + traveler.getLastName());
            lb3.setBounds(10,90,300,20);
            mainFrame.add(lb3);

            lb4 = new JLabel("Address:  " + traveler.getAddress());
            lb4.setBounds(10,110,300,20);
            mainFrame.add(lb4);

            lb5 = new JLabel("Phone:  " + traveler.getPhone());
            lb5.setBounds(10,130,300,20);
            mainFrame.add(lb5);

            lb6 = new JLabel("Travel type:  " + traveler.getTravelType());
            lb6.setBounds(10,150,300,20);
            mainFrame.add(lb6);

            lb7 = new JLabel("Payment type:  " + traveler.getPaymentType());
            lb7.setBounds(10,170,300,20);
            mainFrame.add(lb7);

            lb8 = new JLabel("Trip cost:  " + Float.toString(traveler.getTripCost()));
            lb8.setBounds(10,190,300,20);
            mainFrame.add(lb8);

            lb9 = new JLabel("Allergies:  " + traveler.getMedCondInfo().getAlgType());
            lb9.setBounds(10,210,300,20);
            mainFrame.add(lb9);

            lb10 = new JLabel("Illnesses:  " + traveler.getMedCondInfo().getIllType());
            lb10.setBounds(10,230,300,20);
            mainFrame.add(lb10);

            lb11 = new JLabel("Medical contact:  " + traveler.getMedCondInfo().getMdContact());
            lb11.setBounds(10,250,300,20);
            mainFrame.add(lb11);

            lb12 = new JLabel("Medical Contact Phone:  " + traveler.getMedCondInfo().getMdPhone());
            lb12.setBounds(10,270,300,20);
            mainFrame.add(lb12);

            btn.setBounds(120,300,100,30);
            mainFrame.add(btn);
        }

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();
                getUserChoice();
            }
        });
    }

    public void displayAllTravProf(){                //INTERATE ENTIRETY OF THE TRAVELER LIST AND DISPLAY THEM

        JLabel Header;
        final JLabel[] lb1 = new JLabel[1];
        final JLabel[] lb2 = new JLabel[1];
        final JLabel[] lb3 = new JLabel[1];
        final JLabel[] lb4 = new JLabel[1];
        final JLabel[] lb5 = new JLabel[1];
        final JLabel[] lb6 = new JLabel[1];
        final JLabel[] lb7 = new JLabel[1];
        final JLabel[] lb8 = new JLabel[1];
        final JLabel[] lb9 = new JLabel[1];
        final JLabel[] lb10 = new JLabel[1];
        final JLabel[] lb11 = new JLabel[1];
        final JLabel[] lb12 = new JLabel[1];
        JTextField txt1;
        JButton btn1, backbtn;
        final JButton[] btn2 = new JButton[1];
        TravProf[] profiles = new TravProf[database.numTravelers];
        final int[] j = {0}, i = {0};

        Header = new JLabel("Display All Profiles");
        Header.setBounds(100,10,150,20);
        mainFrame.add(Header);

        lb1[0] = new JLabel("Traveler ID: ");
        lb1[0].setBounds(10,50,120,20);
        mainFrame.add(lb1[0]);

        txt1 = new JTextField();
        txt1.setBounds(120,50,150,20);
        mainFrame.add(txt1);

        btn1 = new JButton("Find");
        btn1.setBounds(120,80,100,30);
        mainFrame.add(btn1);

        backbtn = new JButton("Back");
        backbtn.setBounds(10,80,100,30);
        mainFrame.add(backbtn);

        btn2[0] = new JButton("Next");
        btn2[0].setBounds(270,300,100,30);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TravProf profile = database.findFirstProfile(); //create a temporary profile to iterate TravelerList

                String ID = txt1.getText();

                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();


                for(int i = 0; i < database.numTravelers; i++){
                    if(profile.gettravAgentID().equals(ID)) {
                        profiles[j[0]] = profile;
                        j[0]++;
                    }
                    profile = database.findNextProfile();
                }

                mainFrame.add(Header);

                lb1[0] = new JLabel("Traveler ID:  " + profiles[i[0]].gettravAgentID());
                lb1[0].setBounds(10,50,300,20);
                mainFrame.add(lb1[0]);

                lb2[0] = new JLabel("First Name:  " + profiles[i[0]].getFirstName());
                lb2[0].setBounds(10,70,300,20);
                mainFrame.add(lb2[0]);

                lb3[0] = new JLabel("Last Name:  " + profiles[i[0]].getLastName());
                lb3[0].setBounds(10,90,300,20);
                mainFrame.add(lb3[0]);

                lb4[0] = new JLabel("Address:  " + profiles[i[0]].getAddress());
                lb4[0].setBounds(10,110,300,20);
                mainFrame.add(lb4[0]);

                lb5[0] = new JLabel("Phone:  " + profiles[i[0]].getPhone());
                lb5[0].setBounds(10,130,300,20);
                mainFrame.add(lb5[0]);

                lb6[0] = new JLabel("Travel type:  " + profiles[i[0]].getTravelType());
                lb6[0].setBounds(10,150,300,20);
                mainFrame.add(lb6[0]);

                lb7[0] = new JLabel("Payment type:  " + profiles[i[0]].getPaymentType());
                lb7[0].setBounds(10,170,300,20);
                mainFrame.add(lb7[0]);

                lb8[0] = new JLabel("Trip cost:  " + Float.toString(profiles[i[0]].getTripCost()));
                lb8[0].setBounds(10,190,300,20);
                mainFrame.add(lb8[0]);

                lb9[0] = new JLabel("Allergies:  " + profiles[i[0]].getMedCondInfo().getAlgType());
                lb9[0].setBounds(10,210,300,20);
                mainFrame.add(lb9[0]);

                lb10[0] = new JLabel("Illnesses:  " + profiles[i[0]].getMedCondInfo().getIllType());
                lb10[0].setBounds(10,230,300,20);
                mainFrame.add(lb10[0]);

                lb11[0] = new JLabel("Medical contact:  " + profiles[i[0]].getMedCondInfo().getMdContact());
                lb11[0].setBounds(10,250,300,20);
                mainFrame.add(lb11[0]);

                lb12[0] = new JLabel("Medical Contact Phone:  " + profiles[i[0]].getMedCondInfo().getMdPhone());
                lb12[0].setBounds(10,270,300,20);
                mainFrame.add(lb12[0]);

                backbtn.setBounds(120,300,100,30);
                backbtn.setText("Close");
                mainFrame.add(backbtn);

                if(i[0] < j[0]-1)
                    mainFrame.add(btn2[0]);

                i[0]++;
            }
        });

        btn2[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();

                if(i[0] != j[0]){
                    mainFrame.add(Header);

                    lb1[0] = new JLabel("Traveler ID:  " + profiles[i[0]].gettravAgentID());
                    lb1[0].setBounds(10,50,300,20);
                    mainFrame.add(lb1[0]);

                    lb2[0] = new JLabel("First Name:  " + profiles[i[0]].getFirstName());
                    lb2[0].setBounds(10,70,300,20);
                    mainFrame.add(lb2[0]);

                    lb3[0] = new JLabel("Last Name:  " + profiles[i[0]].getLastName());
                    lb3[0].setBounds(10,90,300,20);
                    mainFrame.add(lb3[0]);

                    lb4[0] = new JLabel("Address:  " + profiles[i[0]].getAddress());
                    lb4[0].setBounds(10,110,300,20);
                    mainFrame.add(lb4[0]);

                    lb5[0] = new JLabel("Phone:  " + profiles[i[0]].getPhone());
                    lb5[0].setBounds(10,130,300,20);
                    mainFrame.add(lb5[0]);

                    lb6[0] = new JLabel("Travel type:  " + profiles[i[0]].getTravelType());
                    lb6[0].setBounds(10,150,300,20);
                    mainFrame.add(lb6[0]);

                    lb7[0] = new JLabel("Payment type:  " + profiles[i[0]].getPaymentType());
                    lb7[0].setBounds(10,170,300,20);
                    mainFrame.add(lb7[0]);

                    lb8[0] = new JLabel("Trip cost:  " + Float.toString(profiles[i[0]].getTripCost()));
                    lb8[0].setBounds(10,190,300,20);
                    mainFrame.add(lb8[0]);

                    lb9[0] = new JLabel("Allergies:  " + profiles[i[0]].getMedCondInfo().getAlgType());
                    lb9[0].setBounds(10,210,300,20);
                    mainFrame.add(lb9[0]);

                    lb10[0] = new JLabel("Illnesses:  " + profiles[i[0]].getMedCondInfo().getIllType());
                    lb10[0].setBounds(10,230,300,20);
                    mainFrame.add(lb10[0]);

                    lb11[0] = new JLabel("Medical contact:  " + profiles[i[0]].getMedCondInfo().getMdContact());
                    lb11[0].setBounds(10,250,300,20);
                    mainFrame.add(lb11[0]);

                    lb12[0] = new JLabel("Medical Contact Phone:  " + profiles[i[0]].getMedCondInfo().getMdPhone());
                    lb12[0].setBounds(10,270,300,20);
                    mainFrame.add(lb12[0]);

                    backbtn.setBounds(120,300,100,30);
                    backbtn.setText("Close");
                    mainFrame.add(backbtn);

                    if(i[0] < j[0]-1)
                        mainFrame.add(btn2[0]);

                    i[0]++;
                }
            }
        });

        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.revalidate();
                mainFrame.repaint();
                getUserChoice();
            }
        });
    }

    public void writeToDB(){                        //WRITE ALL PROFILES TO DATABASE
        database.WriteAllTravProf(database.fileName);
    }

    public void initDB(){                          //INITIALIZE ALL OF THE PROFILES IN DATABASE TO MEMORY
        database.initializeDatabase(database.fileName);
    }

    public static void main(String[] args){

        JFrame fileframe = new JFrame("Integrated Travel System");
        fileframe.setSize(400,200);
        fileframe.setLayout(null);

        JLabel Header = new JLabel("Integrated Travel System");
        Header.setBounds(100,10,150,20);
        fileframe.add(Header);

        JLabel lb = new JLabel("Database filename (include .txt): ");
        lb.setBounds(10,50,200,20);
        fileframe.add(lb);

        JTextField filetxt = new JTextField();
        filetxt.setBounds(200,50,150,20);
        fileframe.add(filetxt);

        JButton btn = new JButton("Search");
        btn.setBounds(100,80,100,30);
        fileframe.add(btn);

        fileframe.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = filetxt.getText();
                TravProfInterface face = new TravProfInterface(fileName);
            }
        });
    }
}
