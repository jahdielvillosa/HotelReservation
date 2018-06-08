package hotelreserve;

import java.io.*;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hotel{
    
    //CLASS VARIABLES
    private static Room[] myHotel;  //holds all rooms
    private static Client[] guest;  //holds all guests
    private static int guestIndex;  //points to the current guest
    
    //room preference variables
    protected int[] roomNumResult = new int[50];    //holds the result of searched rooms by preference
    private String roomTypeResult; 
    private static int rooomBedResult,resultCount,confirmationCode,stayDuration;
    private static float roomPriceResult;
    private static String startMonth, startDay, startYear;  //start dates
    private static String endMonth, endDay, endYear;           //end dates
    
    //Guest variables
    private static int guestCounter;    //holds the number of guest
    
    //Room variables
    private static int roomCounter;     //holds the number of rooms
    private String roomStartDate, roomEndDate;
    private final int SearhRoomCounter = 10; //counter for searching room with max of 10
   
    
    //current date
    private String month,day,year;  
    
    //SQL variables
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private CallableStatement cs = null;
    
    public Hotel(){
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Derby driver not found.");
        }
        
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MidTownHotelDB;create=true;user=null ;pass=null ");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //START OF THE CLASS METHODS
    
    /*
        This method will get all data from the files indicated
        by calling two other methods for getting data of rooms 
        and of guests using file input.
    */
    public void getDataFromFile() throws SQLException{
       
        //SQL database
        getGuestDate_DB();
        getHotelRoomData_DB();
        updateRoomChanges_DB();
        
        //this.displayAll();
        //this.displayAllRooms();
        
    }
    /**
     * This method will close the connection in the database
     */
    public void extConnection(){
        try {
            con.close(); // exit java_db connection 
        } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
        This method will get the data from the GUEST table in the database
        and transfer all the data to the array called guest. The guestcounter 
        will set the size of the array. By doing so, it will adjust everytime
        a new guest is added.
    */
    
    public void getGuestDate_DB() throws SQLException{
        guest = new Client[50];
        guestCounter = 0;
        
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM APP.GUEST");
            
        while (rs.next()){
                
            int id = rs.getInt("id");
            String fn = rs.getString("fname");
            String mn = rs.getString("mname");
            String ln = rs.getString("lname");
            String bday = rs.getString("birthdate");
            String mobile = rs.getString("mobile");
            String email = rs.getString("email");
            String roomPref = rs.getString("roomPref");
                
            guest[guestCounter] = new Client();
                
            //this will set the values above to the array guest.
            guest[guestCounter].setnewGuest(id, fn, mn, ln,
                    bday, mobile, email, roomPref );
            guestCounter++;
            
            System.out.println(id + " " + fn + " " + mn + " "
                + ln + " " + bday + " " + mobile+ " " + email + " " + roomPref);
        }
        
        stmt.close();
    }
    
    /*
        This method will add a new guest into the GUEST table
        in the database.
    */
    public boolean setGuestData(int accountpin,  String firstname,
            String midname, String lastname, String bmonth,String bday, String byear, 
            String mobileNumber, String email, String roomPref) throws IOException, SQLException{
        
        //SQL command statement
        String sqlstmt = "INSERT INTO \"APP\".\"GUEST\" "
                + "values("+ accountpin +",'"+ firstname +"','"+midname+"','"+lastname+"','"
                + bmonth + "','"+mobileNumber+"','"+email+"','none')";
            
        cs = con.prepareCall(sqlstmt); 
        cs.execute();                   //execute the sql command 
           
        return true;
    }
    
  
    /*
        This method will display all guest present in the array of guest.
    */
    public void displayAll(){
        System.out.println("guestCounter: " + guestCounter);
        for(int i=0;i<guestCounter;i++){
           guest[i].dispGuest();
       }
    }
    
     /*
        This method will get the data from the HOTEL table in the database
        and transfer all the data to the array called myHotel. The roomCounter 
        will set the size of the array.
    */
    public void getHotelRoomData_DB() throws SQLException{
        
        myHotel = new Room[50]; // initialize size of array of hotel rooms
        roomCounter = 0;
        
        stmt = con.createStatement();

        rs = stmt.executeQuery("SELECT * FROM APP.HOTELROOMS");
            
        while (rs.next()){
            int roomNum = rs.getInt("ROOMNUMBER");
            String roomType = rs.getString("ROOMTYPE");
            int bedsNum = rs.getInt("BEDS");
            int roomPrice = rs.getInt("PRICE");
            boolean roomAvailability = rs.getBoolean("ISAVAILABLE");
            String currentGuest = rs.getString("OCCUPANT");
            int currentGuestID = rs.getInt("GUESTID");
            String roomStartDate = rs.getString("STARTDATE");
            String roomEndDate = rs.getString("ENDDATE");
                
            myHotel[roomCounter] = new Room();
            
            //this will set the values above to the array guest.
            myHotel[roomCounter].setHotelRoom(roomNum, roomType, bedsNum, 
                    roomPrice, roomAvailability, currentGuest, 
                    currentGuestID,roomStartDate,roomEndDate);
 
            roomCounter++;
               
           System.out.println(roomNum + " " + roomType + " " + bedsNum + " "
                + roomPrice + " " + roomAvailability + " " + currentGuest+ " " 
                + currentGuestID + " " + roomStartDate + " " + roomEndDate );
            }
        stmt.close();
    }
    
    /*
        This method will transfer/update the changes done
        in the myHotel array to the HOTELROOMS tabale in 
        the database.
    */
    public void updateRoomChanges_DB() throws SQLException{
        
        //update all rooms
        for(int i=0;i<roomCounter;i++){
                 String sqlstmt = "UPDATE \"APP\".\"HOTELROOMS\" "
                    + "SET ISAVAILABLE = "+myHotel[i].getStatus()
                    + ", OCCUPANT = '" + myHotel[i].getOccupant()
                    + "', GUESTID = " + myHotel[i].getOccupantID()
                    + " , STARTDATE = '"+ myHotel[i].getStartDate()
                    + "', ENDDATE = '"+ myHotel[i].getEndDate()
                    + "' WHERE ROOMNUMBER = " + myHotel[i].getRoomNum();
            
                cs = con.prepareCall(sqlstmt); 
                cs.execute(); //execute the sql command 
        }
        
    }
    
     /*
        This method will set the reservation of the guest by assigning
        values of availability to false, Occupant and Occupant id  to guest
        and the reservation dates preferred by the guest. After doing so, 
        it will save the changes to the database.
    */
    public void setMyRoomReservationOK() throws SQLException{
        int guestID = guest[guestIndex].getAccountID();
        int selRoomCount = getSelectedRoomsCounter();
        int[] tempRooms  = getGuestSelRooms();  //Selected room by room number
        
        roomStartDate    = convertMonthToDigit(startMonth) + "/" +startDay+ "/" + startYear;
        roomEndDate      = convertMonthToDigit(endMonth) + "/" +endDay+ "/" + endYear;       
        
        System.out.println("\nSaving reservation");
        System.out.println("roomStartDate" + roomStartDate);
        System.out.println("roomEndDate:" + roomEndDate);
        
        //Searching the reserved room number in the hotel rooms
        for(int i=0;i<selRoomCount;i++){
            for(int i2=0;i2<roomCounter;i2++){
                if(myHotel[i2].getRoomNum() == tempRooms[i]){   
                    //if room number from array is equal to selected room number by guest
                    System.out.println("Room Found:"+tempRooms[i]); 
                    
                    myHotel[i2].setOccupantID(guestID);
                    myHotel[i2].setAvailability(false);
                    myHotel[i2].setOccupant(guest[guestIndex].getName());
                    myHotel[i2].setStartDate(roomStartDate);
                    myHotel[i2].setEndDate(roomEndDate);
                }
            }
        }
        
        updateRoomChanges_DB(); //apply changes to the database
        
        //Updates room preference of the current guest    
        String sqlstmt = "UPDATE APP.GUEST "
                    + " SET ROOMPREF = '" + guest[guestIndex].getPref()
                    + "' WHERE ID = "+ guest[guestIndex].getAccountID();
        
        CallableStatement cs = con.prepareCall(sqlstmt); 
        cs.execute(); //execute the sql command 
        cs.close(); 
    }
    
    /*
        This method will display all rooms present 
        in the array of myHotel.
    */
    public void displayAllRooms(){
        for(int i=0;i<roomCounter;i++){
           myHotel[i].Display();
           System.out.println();
       }
    }
    
    public void setGuestCounter(int newCount){
        guestCounter = newCount;
    }
    
    public int getGuestCounter(){
        return guestCounter;
    }
    
    public void incrementGuestCounter(){
        guestCounter++;
    }
    
    public Client getGuest(){
        return guest[guestIndex];
    }
    
    public int getRoomCounter(){
        return roomCounter;
    }
    
    /*
        This method will check if the input login name and id matches 
        the name and id present in the array of guest. If there is a match, 
        return true, if not return false. The assignment of current guest by 
        locating its index in the array is done here.
    */
    public boolean checkLogin(String loginName, int loginID){
        
        for(int i=0;i<guestCounter;i++){
            if(loginName.equals(guest[i].getName()) && loginID == (guest[i].getAccountID())){
                guestIndex = i;
                return true;
            }
        }
        
        //Display error message.
                System.out.println("Invalid login.");
                JOptionPane.showMessageDialog(null, "Login failed.\nLogin name "
                        + "and login id does not match");
                
        System.out.println(guestIndex);
        return false;
    }
    
    public int getID(){
        return guest[guestIndex].getAccountID();
    }
    
    public String getGuestName(){
        System.out.println("Guest: " + guest[guestIndex].getName());
        return guest[guestIndex].getName();
    }
    
    public void setPrefRoom(String room){
          guest[guestIndex].setPreference(room);
    }
    
    public void setPrefStartDate(String sMonth, String sDay, String sYear){
          System.out.println("Date Start: "+ sMonth + " "+sDay+","+sYear);
          startMonth = sMonth;
          startDay = sDay;
          startYear = sYear;
    }
    
    public void setPrefEndDate(String eMonth, String eDay, String eYear){
          System.out.println("Date End: "+ eMonth + " "+eDay+","+eYear);
          endMonth = eMonth;
          endDay = eDay;
          endYear = eYear;
    }
    
    public String getStartMonth(){
        return startMonth;
    }
    
    public String getStartDay(){
        return startDay;
    }
    
    public String getStartYear(){
        return startYear;
    }
    
    public String getEndMonth(){
        return endMonth;
    }
    public String getEndDay(){
        return endDay;
    }
    public String getEndYear(){
        return endYear;
    }
    
    /*
        This method will display all room numbers
        of the result by search.
    */
    public void dispRoomNum(){
        System.out.print("Available Rooms: ");
        for(int i=0;i<SearhRoomCounter;i++){
            System.out.print(roomNumResult[i]+", ");
        }
         System.out.println();
    }
    
    /*
        This method will find the room type selected by the guest.
        If the room type from the myHotel array matches the room type selected
        by the guest and its status is available for reservation, assign it to the 
        search result by getting its room number.
    */
    public void getRoomNumberbyPref(){
        System.out.println("Room Results: ");
        int i=0;    //result counter
        
        for(int i2=0;i2<roomCounter;i2++){
            //check if the room preference is equal to the room type in the array
            if(guest[guestIndex].getPref().contentEquals(myHotel[i2].getRoomType())){
                
                //display on console
                System.out.print(myHotel[i2].getRoomType()+": ");
                System.out.print(i2+", ");
                
                // if room status(availability) is true, set to results     
                if(myHotel[i2].getStatus()){ 
                    roomNumResult[i] = myHotel[i2].getRoomNum();
                    roomTypeResult = myHotel[i2].getRoomType();
                    rooomBedResult = myHotel[i2].getroomBedNum();
                    roomPriceResult = myHotel[i2].getRoomPrice();
                    i++;
                }else{
                    System.out.println("Room "+myHotel[i2].getRoomNum()+" not available");

                }
            }
        }
        
        System.out.println("");
        resultCount = i;
    }
    
    public void setSelectedRoomOnGuest(int roomNumber, boolean buttonStatus){
        guest[guestIndex].setSelectedRoom(roomNumber,buttonStatus);
    }
    
    public void setSelectedRoomOnGuest(int roomNumber){
        guest[guestIndex].setSelectedRoom(roomNumber);
    }

    public void getGuestInfo(){
        guest[guestIndex].dispGuest();
    }
    
    public int getResultCount(){
        return resultCount;
    }
    
    public int[] getRoomsNumResult(){
        return roomNumResult;
    }
    
    //on client class
    public int[] getGuestSelRooms(){
        return guest[guestIndex].getRoomSelected();
    }
    
    public int getStayDuration(){
        return stayDuration;
    }
    
    
    //CONFIRM FRAME Methods
    public int getSelectedRoomsCounter(){
        return guest[guestIndex].getmyRoomsCounter();
    }
    
    public String getSelectedRoomType(){
        return guest[guestIndex].getPref();
    }
    
    public int getSelectedRoomBed(){
        return rooomBedResult;
    }
    
    public float getSelectedRoomPrice(){
        return roomPriceResult;
    }
    
    public void setRoomCounter(int count){
        guest[guestIndex].setRoomCounter(count);
    }
    
   
    //load/get guest previous room preference
    public String getGuestPrevRoomType(){
        String roomPref = guest[guestIndex].getPref();
        System.out.println("roomPref: " + roomPref);
        return roomPref;
    }
    
    /*
        This method will calculate the total fee by multiplying
        the room price, number of selected rooms and the stay duration 
        selected by the guest. 
    */
    public float calculateTotalFee(){
        int endD   = parseInt(endDay);
        int startD = parseInt(startDay);
        int endM   = parseInt(convertMonthToDigit(endMonth));
        int startM   = parseInt(convertMonthToDigit(startMonth));
        int monthDiff = 0;
        float totalFee = 0;
        //get the stay duration in months
        monthDiff = endM - startM;
        
        System.out.println("CALCULATING TOTAL FEE:");
       
        stayDuration = 1;
        if(monthDiff == 0){ //on the same month
            if(startD == endD){
                stayDuration = 1;
            }else if(startD < endD){ //Same month, diff days
                stayDuration = 1 + (parseInt(endDay) - parseInt(startDay));
            }
        }else if(monthDiff > 0){ //1 month difference
           
            if(startD > endD){ // End day is next month
                switch(startMonth){
                    case "January": case "March": case "May": case "July": case "August": 
                    case "October": case "December":
                        stayDuration = 1 +  ( (31+ parseInt(endDay)) - parseInt(startDay));
                        break;

                    case "April": case "June": case "September":  case "November":
                        stayDuration = 1 +  ((30+ parseInt(endDay)) - parseInt(startDay));
                        break;  
                        
                    case "February":     
                        stayDuration = 1 +  ((29+ parseInt(endDay)) - parseInt(startDay));
                        break;  
                    default:
                        break;
                }
            }else if(startD <= endD){    //if end day is greater than start day
                switch(startMonth){
                    case "January": case "March": case "May": case "July": case "August": 
                    case "October": case "December":
                        stayDuration = 1 + ((parseInt(endDay)) - parseInt(startDay));
                        stayDuration += 31;
                        break;

                    case "April": case "June": case "September":  case "November":
                        stayDuration = 1 +  ( (parseInt(endDay)) - parseInt(startDay));
                        stayDuration += 30;
                        break;  
                        
                    case "February":    
                        stayDuration = 1 +  ( (parseInt(endDay)) - parseInt(startDay));
                        stayDuration += 29;
                        break;  
                        
                    default:
                        break;
                }
            }
        }else if(monthDiff < 0){
            if(startMonth == "December" && endMonth == "January"){
                if(startD > endD){ // End day is next month
                    switch(startMonth){
                        case "January": case "March": case "May": case "July": case "August": 
                        case "October": case "December":
                            stayDuration = 1 +  ( (31+ parseInt(endDay)) - parseInt(startDay));
                            break;

                        case "April": case "June": case "September":  case "November":
                            stayDuration = 1 +  ((30+ parseInt(endDay)) - parseInt(startDay));
                            break;  

                        case "February":     
                            stayDuration = 1 +  ((29+ parseInt(endDay)) - parseInt(startDay));
                            break;  
                        default:
                            break;
                    }
                }else{
                    stayDuration = 1 + ((parseInt(endDay)) - parseInt(startDay));
                    stayDuration += 31;
                }
            }
        }
        
        totalFee = (int) (getSelectedRoomsCounter() * getSelectedRoomPrice());
        totalFee *= stayDuration;
        
        //console log
        System.out.println("stayDuration: "+ stayDuration);
        System.out.println("Total Fee: " + totalFee +"php");
        return totalFee;
    }
    
    /*
        This method will generate the 4 digit confirmation code
        for validation of reservation.
    */
    public void generateConfiramtionCode(){
        
        double tempNum;
        
        //generate random confirmation code (4 - digit)
        try{
            do{
                tempNum = Math.random();
                confirmationCode = (int) (tempNum*10000);
                System.out.println("Confirmation Code: " + confirmationCode);
            }while(confirmationCode<1000);
        }catch(Exception e){}
        
        System.out.println("Confirmation Code: " + confirmationCode);
        JOptionPane.showMessageDialog(null, "Confirmation Code: " + confirmationCode);
    }
    
    /*
        This method will verify if the input code by the guest
        matches the confirmation code generated by the program
    */
    public boolean verifyCode(int inputCode){
        
        if(confirmationCode == inputCode)
            return true;
        else
            return false;
       
    }
    
    public Room[] getGuestRooms(){
        return myHotel;
    }
    
    public Client[] getAllGuest(){
        return guest;
    }
    
    /*
        This method will get the current date 
        and assigning it to the month,day and year 
        variables.
    */
    public void getCurrentDate(){
        Date now = new Date(); //get todays date 
        
        SimpleDateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" ); 
        System.out.println ( "The current date is: " + formatter.format( now ) ); 
        
        month = (String) formatter.format( now ).subSequence(0, 2);
        day = (String) formatter.format( now ).subSequence(3, 5);
        year = (String) formatter.format( now ).subSequence(6, 10);
        
        System.out.println("month: " + month);
        System.out.println("day: " + day);
        System.out.println("year: " + year);
        
    }
    
    /*
        This method will convert the month in String to digit in string
    */
    public String convertMonthToDigit(String newMonth){
        switch(newMonth){
            case "January":
                newMonth = "01";
                break;
            case "February":
                newMonth = "02";
                break;
            case "March":
                newMonth = "03";
                break;
            case "April":
                newMonth = "04";
                break;
            case "May":
                newMonth = "05";
                break;
            case "June":
                newMonth = "06";
                break;
            case "July":
                newMonth = "07";
                break;
            case "August":
                newMonth = "08";
                break;
            case "September":
                newMonth = "09";
                break;
            case "October":
                newMonth = "10";
                break;
            case "November":
                newMonth = "11";
                break;
            case "December":
                newMonth = "12";
                break;      
            default:
                break;
        }
        
        return newMonth;
    }
    
    /*
        This method will check if the starting reservation date
        is valid and is not in the past or today. If the year is 
        next year, the reservation date is valid from today. If the
        reservation year is this year, check if the month and day are
        valid.
    */
    public boolean checkReservationDateFromToday(String resMonth, String resDay, String resYear){
        int daysDiff,monthDiff,yearDiff;    //date difference
        int monthToday,dayToday,yearToday;  //date today
        int monthReserved,dayReserved,yearReserved; //date of reservation
        
        //date of reservation
        String sMonth,sDay,sYear;
        sMonth = resMonth;
        sDay = resDay;
        sYear = resYear;
        
        getCurrentDate();   //call to get current date
        
        boolean dateValid = false;
        sMonth = convertMonthToDigit(sMonth); //convert string month to string number
        
        monthToday = parseInt(month);
        dayToday = parseInt(day);
        yearToday = parseInt(year);
        
        //convert to integer
        monthReserved = parseInt(sMonth);
        dayReserved = parseInt(sDay);
        yearReserved = parseInt(sYear);
        
        //get the difference
        monthDiff = monthReserved - monthToday;
        daysDiff = dayReserved - dayToday;
        yearDiff = yearReserved - yearToday;
        
        System.out.println("startMonth: "+ sMonth);
        System.out.println("yearDiff:  " + yearDiff);
        System.out.println("daysDiff:  " + daysDiff);
        System.out.println("monthDiff: " + monthDiff);
        
        if(yearDiff > 0){   //next year
            return true;
        }
        
        if(yearDiff == 0){  //this year
            if(monthDiff >= 0){
                if(monthDiff == 0 && daysDiff == 0){   //cannot reserve room on the day
                    //invalid day, the date is today
                    dateValid = false;
                    System.out.println("reservation day must not today.");
                }else if(monthDiff==0 && daysDiff < 0){  // same month today, invalid day diff
                    dateValid = false;   
                    System.out.println("reservation day must not in the past");
                }else if(monthDiff>0 && daysDiff < 0){  //not the same month today, accept negative day diff
                    dateValid = true;
                }else{  //the same month and valid future day
                    dateValid = true;
                }
            }else{
                //invalid month
                System.out.println("reservation month must not in the past.");
            }
        }else{
            //invalid year
            System.out.println("reservation year must not in the past.");
        }
        
        return dateValid;
    }
    
    /*
        This method will check if the current guest's ID matches
        with the input guest ID.
    */
    public boolean verifyGuest(int guestID){
        if(guest[guestIndex].getAccountID() == guestID){
            System.out.println("GuestID is valid.");
            return true;
        }else{
            System.out.println("GuestID is invalid.");
            return false;
        }
    }
    
}