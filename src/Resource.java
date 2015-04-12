
public class Resource {
    private int resourceID;
    private String name;
    private String description;
    private String supplier;
    private double cost;
    
    public Resource(int rid, String n, String d, String s, double c){
        this.resourceID = rid;
        this.name = n;
        this.description = d;
        this.supplier = s;
        this.cost = c;
    }
    
    public Resource(String n, String d, String s, double c){
        this(-1, n, d, s, c);
    }
    
    public int getResourceID(){
        return resourceID;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getSupplier(){
        return supplier;
    }
    
    public double getCost(){
        return cost;
    }
    
    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
