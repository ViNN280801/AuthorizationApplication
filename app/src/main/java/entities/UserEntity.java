package entities;

public class UserEntity {

    private String name = "";
    private String surname = "";
    private int mark = 0;
    private int GPA = 0;
    private String Faculty = "";
    private String University = "";
    private String Address = "";
    private String Country = "";
    private String bannerImage = "";
    private String BannerTitle = "";

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getMark() {
        return mark;
    }

    public int getGPA() {
        return GPA;
    }

    public String getFaculty() {
        return Faculty;
    }

    public String getUniversity() {
        return University;
    }

    public String getAddress() {
        return Address;
    }

    public String getCountry() {
        return Country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mark=" + mark +
                ", GPA=" + GPA +
                ", Faculty='" + Faculty + '\'' +
                ", University='" + University + '\'' +
                ", Address='" + Address + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getBannerTitle() {
        return BannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        BannerTitle = bannerTitle;
    }
}