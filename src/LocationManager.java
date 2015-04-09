public class LocationManager {
    
    private int locationManagerID;
    private int venueID;
    private String fName;
    private String lName;
    private String phoneNum;
    private String email;
    
    public LocationManager(int id, int vid, String fn, String ln, String pn, String e){
            this.locationManagerID = id;
            this.venueID = vid;
            this.fName = fn;
            this.lName = ln;
            this.phoneNum = pn;
            this.email = e;
    }
    
    public LocationManager(int vid, String fn, String ln, String pn, String e){
        this(-1, vid, fn, ln, pn, e);
    }
    
    public int getID(){
        return locationManagerID;
    }
    
    public String getVenueID(){
        return venueID;
    }
    
    public String getFirstName(){
        return fName;
    }
    
    public String getLastName(){
        return lName;
        }
    
    public String getPhoneNum(){
        return phoneNum;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setID(int locationManagerID){
        this.locationManagerID = locationManagerID;
    }
    
    public void setVenueID(int venueID){
        this.venueID = venueID;
    }
    
    public void setFName(String fName){
            this.fName = fName;
    }
    
    public void setLName(String lName){
        this.lName = lName;
    }
    
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    
}
