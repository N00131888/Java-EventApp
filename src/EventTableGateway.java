package EventAppNB;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventTableGateway {
    private static final String TABLE_NAME = "events";
    private static final String COLUMN_ID = "id";
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
        String query;       // the SQL query to execute
        Statement stmt;     // the java.sql.Statement object used to execute the
                            // SQL query
        ResultSet rs;       // the java.sql.ResultSet representing the result of
                            // SQL query 
        List<Event> events;   // the java.util.List containing the Programmer objects
                            // created for each row in the result of the query
        int id;             // the id of a event
        String title, description, startDateTime, endDateTime, name, email;
        int maxAttendees;
        double cost;
        Event ev;       // a Programmer object created from a row in the result of
                            // the query

        // execute an SQL SELECT statement to get a java.util.ResultSet representing
        // the results of the SELECT statement
        query = "SELECT * FROM " + TABLE_NAME;
        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);

        // iterate through the result set, extracting the data from each row
        // and storing it in a Programmer object, which is inserted into an initially
        // empty ArrayList
        events = new ArrayList<Event>();
        while (rs.next()) {
            id = rs.getInt(COLUMN_ID);
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