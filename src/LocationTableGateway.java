import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LocationTableGateway {
    
    private Connection mConnection;
    
    private static final String TABLE_NAME = "location";
    private static final String COLUMN_LOCATIONID = "locationID";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_LOCMAXATTENDEES = "locMaxAttendees";
    private static final String COLUMN_MANNAME = "manName";
    private static final String COLUMN_MANEMAIL = "manEmail";
    private static final String COLUMN_MANMOBILE = "manMobile";
    
    public LocationTableGateway(Connection connection){
        mConnection = connection;
    }
    
    public int insertLocation(String n, String a, int lma, String mn, String me, String mm) throws SQLException{
        String query;
        PreparedStatement stmt;
        int numRowsAffected;
        int locationID = -1;
        
        query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_NAME + ", " +
                COLUMN_ADDRESS + ", " +
                COLUMN_LOCMAXATTENDEES + ", " +
                COLUMN_MANNAME + ", " +
                COLUMN_MANEMAIL + ", " +
                COLUMN_MANMOBILE + ", " +
                ") VALUES (?, ?, ?, ?, ?, ?)";
        
        stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, n);
        stmt.setString(2, a);
        stmt.setInt(3, lma);
        stmt.setString(4, mn);
        stmt.setString(5, me);
        stmt.setString(6, mm);
        
        numRowsAffected = stmt.executeUpdate();
        if(numRowsAffected == 1);{
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();
            
            locationID = keys.getInt(1);
        }
        
        return locationID;
    }
    
    public boolean deleteMAnager(int locationID) throws SQLException{
        String query;
        PreparedStatement stmt;
        int numRowsAffected;
        
        query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_LOCATIONID + " = ?";
        
        stmt = mConnection.prepareStatement(query);
        stmt.setInt(1, locationID);
        
        numRowsAffected = stmt.executeUpdate();
        
        return (numRowsAffected == 1);
        
    }
    
    public List<Location> getLocations(String address, int locMaxAttendees, int locationID, String manName, String manEmail, String manMobile) throws SQLException{
        String query;
        Statement stmt;
        ResultSet rs;
        List<Location> locations;
        
        String name, office, extension;
        int id;
        Location l;
        
        query = "SELECT * FROM " + TABLE_NAME;
        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);
        
        locations = new ArrayList<Location>();
        while (rs.next()) {
            locationID = rs.getInt(COLUMN_LOCATIONID);
            name = rs.getString(COLUMN_NAME);
            address = rs.getString(COLUMN_ADDRESS);
            locMaxAttendees = rs.getInt(COLUMN_LOCMAXATTENDEES);
            manName = rs.getString(COLUMN_MANNAME);
            manEmail = rs.getString(COLUMN_MANEMAIL);
            manMobile = rs.getString(COLUMN_MANMOBILE);
            
            l = new Location(locationID, name, address, locMaxAttendees, manName, manEmail, manMobile);
            locations.add(l);
            
            return locations;
        }
        
        
       /* boolean updateLocation(Location l) throws SQLException{
            String query;
            PreparedStatement stmt;
            int numRowsAffected;
            
            query = "UPDATE " + TABLE_NAME + " SET " +
                COLUMN_NAME      + " = ?, " +
                COLUMN_ADDRESS    + " = ?, " +
                COLUMN_LOCMAXATTENDEES + " = ? " +
                COLUMN_MANNAME + " = ? " +
                COLUMN_MANEMAIL + " = ? " +
                COLUMN_MANMOBILE + " = ? " +
                " WHERE " + COLUMN_LOCATIONID + " = ?";
            
            stmt = mConnection.prepareStatement(query);
            stmt.setString(1, l.getName());
            stmt.setString(2, l.getAddress());
            stmt.setInt(3, l.getLocMaxAttendees());
            stmt.setString(4, l.getManName());
            stmt.setString(5, l.getManEmail());
            stmt.setString(6, l.getManMobile());
            
            numRowsAffected = stmt.executeUpdate();
            
            return (numRowsAffected == 1);
           
    } */
        return null;
    
    }
}
