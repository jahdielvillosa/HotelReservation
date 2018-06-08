
/*
    This class holds the properties and 
    methods of a room needed in a hotel.
*/
package hotelreserve;

public class Room{
    private int roomNumber; 
    private String roomType;
    private int roomBedNum;
    private float roomPrice;
    private boolean isAvailable;
    private String occupant,startDate,endDate;
    private int occupantID;
    
    public Room(){
        roomType = null;
        roomNumber = 101;
        roomBedNum = 1;
        occupant = "none";
        roomPrice = 1500;
        isAvailable = true;
        startDate = "none";
        endDate = "none";
    }
    
    public int getRoomNum(){
        return this.roomNumber;
    }
    
     public boolean getStatus(){
        return this.isAvailable;
    }
     
    public int getroomBedNum(){
         return this.roomBedNum;
    }
    public String getRoomType(){
        return this.roomType;
    }
    
    public float getRoomPrice(){
        return this.roomPrice;
    }
    
    public String getOccupant(){
        return this.occupant;
    }
    
    public int getOccupantID(){
        return this.occupantID;
    }
     
    public String getStartDate(){
        return this.startDate;
    }
    public String getEndDate(){
        return this.endDate;
    }
    
    
    public void setHotelRoom(int roomNum, String RoomType,int BedNum, 
            float price, boolean roomStatus, String Guest, int GuestID,
            String newStartDate, String newEndDate){
        this.roomNumber  = roomNum;
        this.roomType    = RoomType;
        this.roomBedNum  = BedNum;
        this.roomPrice   = price;
        this.isAvailable = roomStatus;
        this.occupant    = Guest;
        this.occupantID  = GuestID;
        this.startDate   = newStartDate;
        this.endDate     = newEndDate;
    }
    
    
    public void setOccupant(String guestName){
        this.occupant = guestName;
    }
    
    public void setOccupantID(int ID){
        this.occupantID = ID;
    }
    
    public void setAvailability(boolean status){
        this.isAvailable = status;
    }
    
    public void setStartDate(String newStartDate){
         this.startDate = newStartDate;
    }
    public void setEndDate(String newEndDate){
         this.endDate = newEndDate;
    }

    public void Display(){
       System.out.println("ROOM NUM: " + this.roomNumber); 
       System.out.println("ROOM type: " + this.roomType);
       System.out.println("ROOM number of beds: " + this.roomBedNum);
       System.out.println("ROOM price: " + this.roomPrice+"php");
       System.out.println("Available: " + this.isAvailable);
       System.out.println("Occupant: " + this.occupant);
       System.out.println("StartDate: " + this.getStartDate());
       System.out.println("EndDate: " + this.getEndDate());
    }

}

    