package application;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class WeatherHistoryDAO {


public static void saveWeather(WeatherData weather) {
String sql = "INSERT INTO weather_history (city, temperature, description) VALUES (?, ?, ?)";


try (Connection conn = DatabaseConnection.getConnection();
PreparedStatement ps = conn.prepareStatement(sql)) {


ps.setString(1, weather.getCity());
ps.setString(2, weather.getTemperature());
ps.setString(3, weather.getDescription());
ps.executeUpdate();


} catch (SQLException e) {
e.printStackTrace();
}
}


public static List<WeatherData> getAllHistory() {
List<WeatherData> list = new ArrayList<>();
String sql = "SELECT id, city, temperature, description, searched_at FROM weather_history ORDER BY searched_at DESC";
try (Connection conn = DatabaseConnection.getConnection();
PreparedStatement ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery()) {


while (rs.next()) {
WeatherData wd = new WeatherData(
rs.getInt("id"),
rs.getString("city"),
rs.getString("temperature"),
rs.getString("description")
);
list.add(wd);
}
} catch (SQLException e) {
e.printStackTrace();
}
return list;
}
}