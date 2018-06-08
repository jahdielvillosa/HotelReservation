/**
 * Exam 2 - Hotel Reservation System
 * 
 *  This program is a online hotel reservation system. The 
 * process of a reserving hotel rooms will be done in this 
 * program by the guest. For the guest to be able to reserve
 * a hotel room, the guest have have an account registered
 * in this program. Registration form is given in the login 
 * frame and information about the guest is stored in a 
 * database. When the login is successful, can now either view his
 * account and reservations or proceed to reservation of rooms.
 * 
 *  In reservation of rooms, the will be ask for his preferred 
 * room type and desired dates for the room to be reserved. 
 * After this, the program will display for the list of rooms
 * available from the guest's room preference. The guest must 
 * select at least one room to proceed. After selecting rooms, 
 * payment window is opened by using credit card or paypal which 
 * will be deducted by the reservation fees. After it, confirmation
 * window is opened and confirmation code must be entered for the
 * reservation to be successful.
 * 
 * In manage account, the guest can cancel his room reservations
 * in the table given. The cancellation of room reservation cannot
 * be undo after the cancellation is successfully done.
 * 
 * The program uses Apache database as database to handle its data storage.
 * 
 * Submitted by: Villosa, Jahdiel & Jaso Joannes Paulus
 *               September 2015
 */

package hotelreserve;

public class HotelReserve{
    
    public static void main(String[] args){
        // calls GUI class
        LoginFrame main = new LoginFrame(); 
        main.displaylogin();
    }
    
}
