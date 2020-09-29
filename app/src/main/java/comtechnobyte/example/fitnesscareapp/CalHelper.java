package comtechnobyte.example.fitnesscareapp;

public class CalHelper {

    String ID;
    String blood;
    String gender;
    String pressure;
    String sugar;
    String cholesterol;
    String date;

    public CalHelper() {

    }

    public CalHelper(String ID,String blood, String gender, String pressure, String sugar, String cholesterol, String date) {
        this.ID=ID;
        this.blood = blood;
        this.gender = gender;
        this.pressure = pressure;
        this.sugar = sugar;
        this.cholesterol = cholesterol;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
