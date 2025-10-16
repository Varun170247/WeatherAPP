package application;
public class WeatherController {


@FXML
private TextField cityField;
@FXML
private Button fetchButton;
@FXML
private Label tempLabel;
@FXML
private Label descLabel;
@FXML
private TableView<WeatherData> historyTable;
@FXML
private TableColumn<WeatherData, String> cityCol;
@FXML
private TableColumn<WeatherData, String> tempCol;
@FXML
private TableColumn<WeatherData, String> descCol;


private final ObservableList<WeatherData> historyObservable = FXCollections.observableArrayList();


@FXML
public void initialize() {
// configure table columns (using simple property extraction because WeatherData has getters)
cityCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCity()));
tempCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTemperature()));
descCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDescription()));


historyTable.setItems(historyObservable);
loadHistoryFromDB();
}


private void loadHistoryFromDB() {
List<WeatherData> list = WeatherHistoryDAO.getAllHistory();
historyObservable.setAll(list);
}


@FXML
private void fetchWeather() {
String city = cityField.getText().trim();
if (city.isEmpty()) {
Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a city name.", ButtonType.OK);
alert.showAndWait();
return;
}


// TODO: Replace this stub with real API call to fetch weather
// For demonstration we create a fake result
String temperature = "25°C"; // replace with API response
String description = "Clear sky"; // replace with API response


tempLabel.setText(temperature);
descLabel.setText(description);


WeatherData weather = new WeatherData(city, temperature, description);
WeatherHistoryDAO.saveWeather(weather);


// refresh table
loadHistoryFromDB();
}
}