# PIP-Proiect
######PIP-Proiect/app/src/main/java/com/plcoding/weatherapp/presentation/HourlyWeatherDisplay.kt

**HourlyWeatherDisplay
The HourlyWeatherDisplay composable function is responsible for displaying the weather information for a specific hour. It takes in a WeatherData object representing the weather data for that hour, along with optional parameters for customizing the appearance.

***Parameters
weatherData: WeatherData: The WeatherData object that contains the weather information for the specific hour.
modifier: Modifier: (optional) Modifier for customizing the layout and behavior of the composable.
textColor: Color: (optional) The color to be used for the text elements in the composable.

**Usage
To use the HourlyWeatherDisplay, simply call it within a Compose function and provide the necessary WeatherData object: HourlyWeatherDisplay(weatherData = myWeatherData)

***Content
The HourlyWeatherDisplay composable consists of the following elements:
Formatted Time: The time for which the weather data is displayed, formatted in the "HH:mm" format.
Weather Icon: An image representing the weather type, obtained from the provided weatherData using the associated icon resource.
Temperature: The temperature in Celsius for the specific hour.
The layout of the composable is a Column with a vertical arrangement, centered horizontally. The elements are arranged vertically with space between them.

Overall, the HourlyWeatherDisplay composable provides a reusable component for displaying hourly weather information, allowing for customization of appearance and text color.

#######PIP-Proiect/app/src/main/java/com/plcoding/weatherapp/presentation/MainActivity.kt
MainActivity
The MainActivity class serves as the main entry point for the WeatherApp application. It extends the ComponentActivity class and is annotated with @AndroidEntryPoint to enable integration with Hilt for dependency injection.

**Functionality
The MainActivity initializes a WeatherViewModel using the by viewModels() delegate provided by the activity-ktx library.
It sets up an ActivityResultLauncher to request location permissions from the user using the registerForActivityResult function.
In the onCreate method, the launcher is invoked to request the necessary permissions: ACCESS_FINE_LOCATION and ACCESS_COARSE_LOCATION.
The UI is composed using Jetpack Compose, and the content is set using setContent with the WeatherAppTheme as the parent composable.
The UI is structured inside a Box composable that occupies the entire screen.
Within the Box, a Column composable is used to arrange the main weather card and weather forecast components vertically.
The WeatherCard composable is used to display the current weather information, using the state from the viewModel. It is wrapped in a Spacer with a height of 16.dp for spacing.
The WeatherForecast composable is used to display the weather forecast, also using the state from the viewModel.
If the isLoading flag in the viewModel.state is true, a CircularProgressIndicator is displayed in the center of the screen.
If an error is present in the viewModel.state, a Text composable is shown with the error message in red, aligned to the center of the screen.

***Permissions Handling
The permissionLauncher is triggered when the app requests location permissions.
It uses the ActivityResultContracts.RequestMultiplePermissions() contract to request multiple permissions at once.
Once the permissions are granted or denied by the user, the viewModel.loadWeatherInfo() function is called to load the weather information.
Overall, the MainActivity sets up the main UI for the WeatherApp, handles location permission requests, and interacts with the WeatherViewModel to retrieve and display weather information.

######PIP-Proiect/app/src/main/java/com/plcoding/weatherapp/presentation/WeatherCard.kt

WeatherCard
The WeatherCard composable is responsible for displaying the current weather information in a card layout. It is part of the WeatherApp presentation package.

**Functionality
The WeatherCard composable takes the state parameter of type WeatherState, which holds the weather information to be displayed, and the backgroundColor parameter of type Color to customize the background color of the card. It also accepts an optional modifier parameter of type Modifier to apply additional styling.
Inside the composable function, the let function is used to safely access the currentWeatherData from state.weatherInfo. If the data is available, the card is rendered.
The card is implemented using the Card composable from the Material Design library. It has a rounded corner shape defined by RoundedCornerShape(10.dp). The background color is set using the backgroundColor parameter, and padding of 16.dp is applied using the modifier.padding function.
Inside the Card, a Column composable is used to arrange the content vertically. It occupies the full width and has additional padding of 16.dp using the modifier.fillMaxWidth and modifier.padding functions.
The weather information is displayed in the following order:
A Text composable is used to display the current time with the format "Today HH:mm". It is aligned to the end using Modifier.align(Alignment.End).
A Spacer with a height of 16.dp provides spacing between the time and the weather icon.
An Image composable displays the weather icon using the painterResource function and the data.weatherType.iconRes as the resource ID. It has a fixed width of 200.dp.
Another Spacer with a height of 16.dp provides spacing between the weather icon and the temperature.
A Text composable displays the temperature in Celsius using the data.temperatureCelsius value. It has a font size of 50.sp and a white color.
Another Spacer with a height of 16.dp provides spacing between the temperature and the weather description.
A Text composable displays the weather description using data.weatherType.weatherDesc. It has a font size of 20.sp and a white color.
Another Spacer with a height of 32.dp provides spacing between the weather description and the weather data.
Inside a Row composable, three instances of the WeatherDataDisplay composable are used to display additional weather data: pressure, humidity, and wind speed. Each instance receives the respective value, unit, icon, icon tint color, and text style.

***Dependencies and Customization
The WeatherCard composable relies on the Material Design library and Compose UI dependencies.
It also references vector drawable resources (R.drawable.ic_pressure, R.drawable.ic_drop, R.drawable.ic_wind) for the weather data icons.
Overall, the WeatherCard composable provides a visually appealing and informative card layout to display the current weather information, including time, weather icon, temperature, weather description, and additional weather data.

#######PIP-Proiect/app/src/main/java/com/plcoding/weatherapp/presentation/WeatherDataDisplay.kt

WeatherDataDisplay
The WeatherDataDisplay composable is responsible for displaying a single weather data item, including an icon and a value with its unit. It is part of the WeatherApp presentation package.

**Functionality
The WeatherDataDisplay composable takes the following parameters:
value: An integer representing the value of the weather data.
unit: A string representing the unit of the weather data.
icon: An ImageVector representing the icon for the weather data.
modifier: Optional Modifier parameter to apply additional styling.
textStyle: Optional TextStyle parameter to customize the text style of the value.
iconTint: Optional Color parameter to customize the tint color of the icon.
Inside the composable function, a Row composable is used to arrange the icon and the value horizontally. The verticalAlignment parameter is set to Alignment.CenterVertically to align the contents vertically in the center.
An Icon composable is used to display the weather data icon. It takes the icon parameter as the ImageVector resource, sets the contentDescription to null, and applies the iconTint color using the tint parameter. The icon size is set to 25.dp using Modifier.size(25.dp).
A Spacer with a width of 4.dp provides spacing between the icon and the value.
A Text composable is used to display the value and unit of the weather data. The text parameter is set to "$value$unit", and the style parameter is set to textStyle.

***Dependencies and Customization
The WeatherDataDisplay composable does not have any external dependencies apart from the Compose UI library.
It references an ImageVector resource for the weather data icon, specified by the icon parameter.
The WeatherDataDisplay composable allows customization of the text style, icon tint color, and overall styling using the modifier parameter.
Overall, the WeatherDataDisplay composable provides a reusable component to display a single weather data item with an icon and value. It offers flexibility for customizing the text style, icon tint color, and other styling properties to fit different UI requirements.


#####PIP-Proiect/app/src/main/java/com/plcoding/weatherapp/presentation/WeatherForecast.kt

WeatherForecast
The WeatherForecast composable is responsible for displaying the weather forecast for a specific day. It is part of the WeatherApp presentation package.

**Functionality
The WeatherForecast composable takes the following parameters:
state: A WeatherState object containing the weather information.
modifier: Optional Modifier parameter to apply additional styling.
Inside the composable function, the weather forecast data for the current day is obtained from the weatherDataPerDay list in the state.weatherInfo. The data is retrieved for the first day (get(0)) in the list.
A Column composable is used to arrange the forecast information vertically. The modifier parameter is used to control the width and apply horizontal padding.
A Text composable is used to display the label "Today" for the forecast section. The text parameter is set to "Today", and the fontSize is set to 20.sp. The text color is set to Color.White.
A Spacer with a height of 16.dp provides vertical spacing between the label and the forecast items.
A LazyRow composable is used to display the hourly weather forecast items horizontally. It uses the content parameter to define the content of the row.
Inside the LazyRow, the items function is used to iterate over the data list, which contains the hourly weather forecast for the day. For each weatherData item, the HourlyWeatherDisplay composable is called to display the weather information. The modifier parameter is used to control the height and apply horizontal padding to each item.

***Dependencies and Customization
The WeatherForecast composable does not have any external dependencies apart from the Compose UI library.
It relies on the WeatherState object to access the weather forecast data.
The WeatherForecast composable allows customization of the overall styling using the modifier parameter.
Overall, the WeatherForecast composable provides a component to display the weather forecast for a specific day. It arranges the forecast information in a column, with a label for the day and a horizontal list of hourly weather forecast items. The composable allows customization of the styling and can be used to present the weather forecast in a visually appealing and informative way.

######PIP-Proiect/app/src/main/java/com/plcoding/weatherapp/presentation/WeatherState.kt

WeatherState
The WeatherState class is a data class that represents the state of the weather in the WeatherApp presentation package.

**Properties
weatherInfo: An optional WeatherInfo object representing the weather information. It defaults to null.
isLoading: A Boolean value indicating whether the weather data is currently being loaded. It defaults to false.
error: An optional String representing any error that occurred while retrieving the weather data. It defaults to null.

***Usage
The WeatherState class is typically used in conjunction with the view model or state management system to hold and update the state of the weather information in the application. It allows components to react to changes in the weather data, loading status, and error state.
When the weather data is being loaded, the isLoading property can be set to true, and the UI can display a loading indicator or handle the loading state accordingly. Once the weather data is fetched successfully, it can be stored in the weatherInfo property. In case of any error during the data retrieval process, the error property can be set to a descriptive error message.
By observing and reacting to changes in the WeatherState object, the UI components can update and display the appropriate weather information or error messages to the user.

**Dependencies
The WeatherState class does not have any external dependencies. It represents the internal state of the weather data in the WeatherApp presentation package.

Overall, the WeatherState class provides a structured way to hold the state of the weather information in the application. It allows for easy handling of loading and error states, as well as providing a container for the weather data itself.

########PIP-Proiect/app/src/main/java/com/plcoding/weatherapp/presentation/WeatherViewModel.kt

WeatherViewModel
The WeatherViewModel class is a ViewModel class that handles the logic and data management related to the weather information in the WeatherApp presentation package.

**Dependencies
repository: An instance of the WeatherRepository interface, which provides methods for retrieving weather data.
locationTracker: An instance of the LocationTracker interface, which is responsible for tracking the user's location.
Properties
state: A mutable state property of type WeatherState that represents the current state of the weather information. It is updated using the mutableStateOf delegate and allows for observing changes in the state.

***Methods
loadWeatherInfo(): A function that initiates the process of loading the weather information. It is called by the UI when weather data needs to be fetched. It updates the state property to reflect the loading state and triggers the retrieval of weather data. It uses coroutines and the viewModelScope to launch a new coroutine for handling the asynchronous task.
First, it sets the isLoading property of the state to true and clears any previous error message.
It then uses the locationTracker to get the current location. If the location is available, it proceeds to fetch the weather data using the repository.
If the weather data retrieval is successful (Resource.Success), it updates the state with the fetched weather data, sets isLoading to false, and clears any error message.
If an error occurs during the weather data retrieval (Resource.Error), it updates the state with a null weatherInfo, sets isLoading to false, and assigns the error message to the error property.
If the location is not available, it updates the state with an appropriate error message, indicating that the location couldn't be retrieved.

**Usage
The WeatherViewModel class is responsible for managing the state of the weather information and coordinating the retrieval of weather data. It provides a way for the UI components to observe and react to changes in the weather state.
By calling the loadWeatherInfo() method, the ViewModel triggers the retrieval of weather data and updates the state accordingly. The UI components can observe the state property and update their display based on the loading state, weather data, or error message.
The WeatherViewModel utilizes coroutines and the viewModelScope to handle the asynchronous tasks in a structured manner, ensuring proper cancellation and lifecycle management.

*Dependencies
The WeatherViewModel class has the following dependencies:
WeatherRepository: An interface that provides methods for retrieving weather data.
LocationTracker: An interface responsible for tracking the user's location.
These dependencies need to be injected into the WeatherViewModel using a dependency injection framework, such as Hilt.

Overall, the WeatherViewModel class acts as the intermediary between the UI components and the data sources, handling the logic and state management related to the weather information in the WeatherApp presentation package.

#####
