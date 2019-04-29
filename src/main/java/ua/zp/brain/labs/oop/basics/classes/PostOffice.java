package ua.zp.brain.labs.oop.basics.classes;

/**
 * Simple Java object that represents PostOffice object
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class PostOffice {

    public static final String TYPE_BAGAGE = "bagage";
    public static final String TYPE_POST = "post";
    public static final String TYPE_MINI = "mini";

    private String codeZIP;
    private String city;
    private String adrressLine;
    private String latitude;
    private String longtitude;
    private String postOfficeType;

    public String getCodeZIP() {
        return codeZIP;
    }

    public void setCodeZIP(String codeZIP) {
        this.codeZIP = codeZIP;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdrressLine() {
        return adrressLine;
    }

    public void setAdrressLine(String adrressLine) {
        this.adrressLine = adrressLine;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getPostOfficeType() {
        return postOfficeType;
    }

    public void setPostOfficeType(String postOfficeType) {
        this.postOfficeType = postOfficeType;
    }

    @Override
    public String toString() {
        return "Имя класса: " + getClass().getName() +
                "\ncodeZIP = " + codeZIP +
                "\ncity = " + city +
                "\nadrressLine = " + adrressLine +
                "\nlatitude = \"" + latitude + '"' +
                "\nlongtitude = \"" + longtitude + '"' +
                "\npostOfficeType = \"" + postOfficeType + '"';
    }
}
