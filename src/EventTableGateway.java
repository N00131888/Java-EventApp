package EventAppNB;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventTableGateway {
    private static final String TABLE_NAME = "event";
    private static final String COLUMN_EVENTID = "eventID";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_START_DATE_TIME = "startDateTime";
    private static final String COLUMN_END_DATE_TIME = "endDateTime";
    private static final String COLUMN_COST = "cost";
    private static final String COLUMN_MAX_ATTENDEES = "maxAttendees";
	private static final String COLUMN_NAME = "name";
	private static final String COLUMN_EMAIL = "email";

    private Connection mConnection;

    public EventTableGateway(Connection connection) {
        mConnection = connection;
    }
    public List<Event> getEvents() throws SQLException {
        String query;      
        Statement stmt;    
                           
        ResultSet rs;      
                            
        List<Event> events;   
                            
        int id;            
        String title, description, startDateTime, endDateTime, name, email;
        int maxAttendees;
        double cost;
        Event ev;       
                        

        
        
        query = "SELECT * FROM " + TABLE_NAME;
        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);

        events = new ArrayList<Event>();
        while (rs.next()) {
            id = rs.getInt(COLUMN_EVENTID);
            title = rs.getString(COLUMN_TITLE);
            description = rs.getString(COLUMN_DESCRIPTION);
            startDateTime = rs.getString(COLUMN_START_DATE_TIME);
			endDateTime = rs.getString(COLUMN_END_DATE_TIME);
			cost = rs.getDouble(COLUMN_COST);
            maxAttendees = rs.getInt(COLUMN_MAX_ATTENDEES);
            name = rs.getString(COLUMN_NAME);
			email = rs.getString(COLUMN_EMAIL);
            

            ev = new Event(title, description, startDateTime, endDateTime, cost, maxAttendees, name, email);
            events.add(ev);
        }

        return events;
    }
    
}