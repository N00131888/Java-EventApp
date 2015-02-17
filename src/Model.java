package EventAppNB;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model{
	
	private static Model instance = null;
	
	public static synchronized Model getInstance(){
		if(instance == null){
			instance = new Model();
		}
		return instance;
	}
	
	private List<Event> events;
	
	private Model(){
		
		try{
			Connection conn = DBConnection.getInstance();
			EventTableGateway gateway = new EventTableGateway(conn);
			
			this.events = gateway.getEvents();
		
		}
		catch (ClassNotFoundException ex) {
			Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
			}
			catch(SQLException ex){
				Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
				
	public List<Event> getEvents(){
		return new ArrayList<Event>(this.events);
	}
	
	public void addEvent(Event ev){
		this.events.add(ev);
	}
	public boolean removeEvent(Event ev){
		return this.events.remove(ev);
	}
	
	public Event findEventByMaxAttendees(int maxAttendees){
		Event ev = null;
		int i = 0;
		boolean found = false;
		while(i < this.events.size() && !found){
			ev = this.events.get(i);
			if(ev.getMaxAtendees() == maxAttendees){
				found = true;
			} else{
				i++;
			}
			}
			if(!found){
				ev = null;
			}
			return ev;
		}
	}