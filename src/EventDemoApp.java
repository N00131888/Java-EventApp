package EventAppNB;

import java.util.List;
import java.util.Scanner;

public class EventDemoApp {

    public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
                Model model = Model.getInstance();
		
                Event ev;
		
		int opt;
		do{
			System.out.println("1. Create new Event");
			System.out.println("2. Delete existing Event");
			System.out.println("3. View all events");
			System.out.println("4. Exit");
			
			System.out.print("Enter option: ");
			String line = keyboard.nextLine();
			opt = Integer.parseInt(line);
			
			System.out.println("You chose option " + opt);
			switch(opt){
				case 1: {
					System.out.println("Creating Event");
					ev = readEvent(keyboard);
					model.addEvent(ev);
                                        
					break;
				}
				case 2: {
					System.out.println("Deleting Event");
					deleteEvent(keyboard, model);
				
					break;
				}
				case 3: {
                    System.out.println("Viewing events");
                    viewEvents(model);
                    break;
			}
		}
    }
		while (opt != 4);
		System.out.println("Goodbye");
}

	
	
	private static Event readEvent(Scanner keyb){
		String title, description, startDateTime, endDateTime;
        int maxAttendees;
        double cost;
        String line;
        String name, email;
        
        title = getString(keyb, "Enter title: ");
        description = getString(keyb, "Enter description: ");
        startDateTime = getString(keyb, "Enter a Start Date and Time(dd/mm/yyyy): ");
        endDateTime = getString(keyb, "Enter a End Date and Time(dd/mm/yyyy): ");
        line = getString(keyb, "Enter cost: ");
        cost = Double.parseDouble(line);
        line = getString(keyb, "Enter maximum attendance: ");
        maxAttendees = Integer.parseInt(line);
        name = getString(keyb, "Enter name: ");
        email = getString(keyb, "Enter email: ");
        
        Event ev = 
                new Event(title, description, startDateTime, endDateTime, 
                        cost, maxAttendees, name, email);
		
        return ev;
        
	}
	
	private static void deleteEvent(Scanner kb, Model m){
		System.out.print("Enter the max attendance of the event to delete:");
		int maxAttendees = Integer.parseInt(kb.nextLine());
        Event ev;
        
        ev = m.findEventByMaxAttendees(maxAttendees);
        if (ev != null) {
            if (m.removeEvent(ev)) {
                System.out.println("Event deleted");
            }
            else {
                System.out.println("Event not deleted");
            }
        }
        else {
            System.out.println("Event not found");
        }
	}
	private static void viewEvents(Model model) {
        List<Event> events = model.getEvents();
        for (Event ev : events) {
            System.out.println("Name: " + ev.getName());
        }
    }

	private static String getString(Scanner keyboard, String prompt) {
		System.out.print(prompt);
		return keyboard.nextLine();
	}
    
}
