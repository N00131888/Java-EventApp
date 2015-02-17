package EventAppNB;

public class Event {
    
    private String title;
    private String description;
    private String startDateTime;
    private String endDateTime;
    private double cost;
    private int maxAtendees;
    private String name;
    private String email;
    
    public Event(String t, String d, String sd, String ed, double c, int ma, String n, String e){
        this.title = t;
        this.description = d;
        this.startDateTime = sd;
        this.endDateTime = ed;
        this.cost = c;
        this.maxAtendees = ma;
        this.name = n;
        this. email = e;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;        
    }
    
    public String getDescription(){
        return description;
    }
    
     public void setDescription(String description){
        this.description = description;        
    }
    
    public String getStartDateTime(){
        return startDateTime;
    }
    
    public void setStartDateTime(String startDateTime){
        this.startDateTime = startDateTime;        
    }
    
    public String getEndDateTime(){
        return endDateTime;
    }       
    public void setEndDateTime(String endDateTime){
        this.endDateTime = endDateTime;        
    }
    
    public double getCost(){
        return cost;
    }
    
    public void setCost(double cost){
        this.cost = cost;        
    }
        
    public int getMaxAtendees(){
        return maxAtendees;
    }
    public void setMaxAtendees(int maxAtendees){
        this.maxAtendees = maxAtendees;        
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
        
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}