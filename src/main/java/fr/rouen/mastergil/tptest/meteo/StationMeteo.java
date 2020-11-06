package fr.rouen.mastergil.tptest.meteo;

import org.codehaus.jettison.json.JSONException;

import java.util.List;

public class StationMeteo {

    private IWeatherProvider weatherProvider;

    public StationMeteo(IWeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public static void main(String[] args) throws JSONException {
        System.out.println(
                new StationMeteo(new OpenWeatherMapProvider())
                        .majPrevision("Paris,FR")
        );
    }

    public List<Prevision> majPrevision(String city) throws JSONException {
        if (null == city) {
            throw new IllegalArgumentException("City is not optional");
        }

        return weatherProvider.getForecastByCity(city);
    }
}
