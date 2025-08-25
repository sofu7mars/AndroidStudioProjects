package pl.pollub.lab_8_ex_1;

public class Country {
    private int photo, pmail, pphone;
    private String name, mail, phone;
    public Country(int photo, String name, String mail, String phone) {
        this.photo = photo;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.pmail = pmail;
        this.pphone = pphone;
    }
    public int getPhoto() {return photo;}
    public String getName() {return name;}
    public String getMail() {return mail;}
    public String getPhone() {return phone;};
}
