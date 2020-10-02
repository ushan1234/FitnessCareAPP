package comtechnobyte.example.fitnesscareapp;

public class ExeHelper {
    String ID;

    String pressure;
    String date;


    public ExeHelper() {

    }

    public ExeHelper(String ID, String pressure, String date) {
        this.ID=ID;

        this.pressure = pressure;
        this.date = date;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }



    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
