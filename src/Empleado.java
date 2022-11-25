public class Empleado {
    private String id;
    private String firtsName;
    private String lastName;
    private String photo;
    
    public Empleado(String id, String firtsName, String lastName, String photo) {
        this.id = id;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.photo = photo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirtsName() {
        return firtsName;
    }
    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
