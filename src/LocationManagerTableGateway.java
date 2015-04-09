
public class LocationManagerTableGateway {
    
    private Connection mConnection;
    
    private static final String TABLE_NAME = "location manager";
    private static final String COLUMN_LOCATIONMANGERID = "locationManagerID";
    private static final String COLUMN_VENUEID = "venueID";
    private static final String COLUMN_FNAME = "fName";
    private static final String COLUMN_LNAME = "lName";
    private static final String COLUMN_PHONENUM = "phoneNum";
    private static final String COLUMN_EMAIL = "email";
    
    public LocationManagerTableGateway(Connection connection){
        mConnection = connection;
    }
    
    public int insertLocationManager(int vid, String fn, String ln, String pn, String e)throws SQLException{
        String query;
        PreparedStatement stmt;
        int numRowsAffected;
        int LocationManagerID = -1;
        
        query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_VENUEID + ", "+
                COLUMN_FNAME + ", "+
                COLUMN_LNAME + ", "+
                COLUMN_PHONENUM + ", "+
                COLUMN_EMAIL + ", "+
                ") VALUES(?, ?, ?, ?, ?)";
        
        stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, vid);
        stmt.setString(2, fn);
        stmt.setString(3, ln);
        stmt.setString(4, pn);
        stmt.setString(5, e);
        
        numRowsAffected = stmt.executeUpdate();
        if (numRowsAffected == 1) {
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();
        }
        
        return LocationManagerID;
        
    }
    
     public boolean deleteLocationManager(int locationManager) throws SQLException {
         String query;
         PreparedStatement stmt;
         int numRowsAffected;
         
         query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_LOCATIONMANAGERID + " = ?";
         
         stmt = mConnection.prepareStatement(query);
         stmt.setInt(1, locationManagerID);
         
         numRowsAffected = stmt.executeUpdate();
         
        return (numRowsAffected == 1);
        
     }
     
     public List<LocationManager> getLocationManagers() throws SWLException{
         String query;
         Statement stmt;
         ResultSet rs;
         List<LocationManager> locationManagers;
         
         int venueID
         String fName, lName, phoneNum, email;
         LocationManager lm;
         
         query = "SELECT * FROM " + TABLE_NAME;
         stmt = this.mConnection.createStatement();
         rs = stmt.executeQuery(query);
         
         locationManagers = new ArrayList<LocationManager>();
         while (rs.next()) {
            locationManagerID = rs.getInt(COLUMN_LOCATIONMANGERID);
            venueID = rs.getInt(COLUMN_VENUEID);
            fname = rs.getString(COLUMN_FNAME);
            lname = rs.getString(COLUMN_LNAME);
            phoneNum = rs.getString(COLUMN_PHONENUM);
            email = rs.getString(COLUMN_EMAIL);

            lm = new LocationManager(locationManagerID, venueID, fName, lName, phoneNum, email);
            locationManagers.add(lm);
        }        
         
        return locationManagers;
     }
     
     boolean updateLocationManager(LocationManager lm) throws SQLException {
        String query;
        PreparedStatement stmt;
        int numRowsAffected;
        
        query = "UPDATE " + TABLE_NAME + " SET " +
                COLUMN_VENUEID      + " = ?, " +
                COLUMN_FNAME    + " = ?, " +
                COLUMN_LNAME + " = ? " +
                COLUMN_PHONENUM + " = ? " +
                COLUMN_EMAIL + " = ? " +
                " WHERE " + COLUMN_LOCATIONMANGERID + " = ?";
        
        stmt = mConnection.prepareStatement(query);
        stmt.setInt(1, lm.getVenueID());
        stmt.setString(2, lm.getFName());
        stmt.setString(3, lm.getLName());
        stmt.setString(4, lm.getPhoneNum());
        stmt.setString(5, lm.getEmail());
        
        numRowsAffected = stmt.executeUpdate();
        
        return (numRowsAffected == 1);
     }
}
