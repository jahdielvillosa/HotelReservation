/*
 *  This class stores/holds the properties and 
    methods of a Client.
 */
package hotelreserve;

public class Client {
    private String firstName,lastName, middleName;
    private int stayDuration, myFee, AccountID,myRoomsCounter;
    private String myRoomPreference;
    private int[] myRoomsSelected = new int[20];
    private String birthDate,mobile,email;
    
    public Client(){
        AccountID  = 0;
        firstName  = "firstname";
        lastName   = "lastname";
        middleName = "middleName";
        birthDate  = "birthDate";
        mobile     = "mobile";
        email      = "email";
        myRoomPreference = "none";
    }
    
    public String getName(){
        return lastName;
    }
    public String getfName(){
        return this.firstName;
    }
    public String getMName(){
        return this.middleName;
    }
    public int getStayDuration(){
        return this.stayDuration;
    }
    public int getMyFee(){
        return this.myFee;
    }
    public int getAccountID(){
        return this.AccountID;
    }
    
    public String getPref(){
        return this.myRoomPreference;
    }
    
    
    public int[] getRoomSelected(){
        return this.myRoomsSelected;
    }
    
    public int getmyRoomsCounter(){
        return this.myRoomsCounter;
    }
    
    public String getBday(){
       return this.birthDate;
    }
    
    public String getMobileNum(){
        return this.mobile;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    
     
    public void setName(String fname,String mname, String lname){
        firstName  = fname;
        lastName   = lname;
        middleName = mname;
    }
    
    public void setnewGuest(String fname,String mname,String lname, 
            int userID, String birthMonth, String birthDay, String birthYear, 
            String mobileNum, String newemail, String roomPref){
        
        firstName  = fname;
        lastName   = lname;
        AccountID  = userID;
        middleName = mname;
        birthDate  = birthMonth + " " + birthDay + " " + birthYear;
        mobile     = mobileNum;
        email      = newemail;
        myRoomPreference = roomPref;
        
    }
    
    public void setnewGuest(int userID,String fname,String mname,
            String lname, String birthdate,String mobileNum, 
            String newemail, String roomPref){
        
        firstName  = fname;
        lastName   = lname;
        AccountID  = userID;
        middleName = mname;
        birthDate  = birthdate ;
        mobile     = mobileNum;
        email      = newemail;
        myRoomPreference = roomPref;
        
    }
    
    public void setPreference(String newRoom){
        this.myRoomPreference = newRoom;
    }
    
    public void setID(int newUserID){
        AccountID = newUserID;
    }
    
    public void setBday(String newbday){
        birthDate =newbday;
    }
    
    public void setMobileNum(String newMobileNum){
        mobile = newMobileNum;
    }
    
    public void setEmail(String newEmail){
        email = newEmail;
    }
    
    public void setSelectedRoom(int RoomNum,boolean buttonStatus ){
        int temp;
        if(buttonStatus){
            myRoomsSelected[myRoomsCounter] = RoomNum;
            myRoomsCounter++;
        }else{
            if(myRoomsCounter > 0){
                for(int i=0;i<myRoomsCounter;i++){
                    if(RoomNum == myRoomsSelected[i]){
                        //swap to last selected to room before it and remove last
                        temp = myRoomsSelected[myRoomsCounter-1];   //last element
                        myRoomsSelected[myRoomsCounter-1] = myRoomsSelected[i]; //deselected room asssign to the last element
                        myRoomsSelected[i] = temp;    //switch back element
                    }
                }
                myRoomsCounter--;
            }
            
        }
    }
    
     public void setSelectedRoom(int RoomNum){
        myRoomsSelected[myRoomsCounter] = RoomNum;
        myRoomsCounter++;
    }
    
    public void setRoomCounter(int count){
        myRoomsCounter = count;
    }
    
    public void dispGuest(){
        System.out.println("ID: " + this.AccountID);
        System.out.println("firstName: " + this.firstName);
        System.out.println("LastName: " + this.lastName);
        System.out.println("MiddleName: " + this.middleName);
        System.out.println("Birthday: " + this.birthDate);
        System.out.println("mobile: " + this.mobile);
        System.out.println("email: " + this.email);
        System.out.println("prev RoomType: " + this.myRoomPreference);
        dispAssignedRoom();
    }
    
    public void dispAssignedRoom(){
        System.out.println("Selected Rooms: ");
        for(int i=0;i<myRoomsCounter;i++){
            System.out.print(myRoomsSelected[i]+","); 
        }
        System.out.println();
    }
    
}
