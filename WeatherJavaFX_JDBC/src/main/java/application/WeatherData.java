package application;


public class WeatherData {
private int id; // optional, from DB
private String city;
private String temperature;
private String description;


public WeatherData(String city, String temperature, String description) {
this.city = city;
this.temperature = temperature;
this.description = description;
}


public WeatherData(int id, String city, String temperature, String description) {
this.id = id;
this.city = city;
this.temperature = temperature;
this.description = description;
}


public int getId() { return id; }
public String getCity() { return city; }
public String getTemperature() { return temperature; }
public String getDescription() { return description; }


public void setId(int id) { this.id = id; }
}