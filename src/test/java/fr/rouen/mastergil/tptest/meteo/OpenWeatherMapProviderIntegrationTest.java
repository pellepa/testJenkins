package fr.rouen.mastergil.tptest.meteo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.Test;

import java.util.List;

public class OpenWeatherMapProviderIntegrationTest {


    @Test
    public void shouldGetForecastByCity() {
        //GIVEN
        IWeatherProvider openWeatherMapProvider=    new OpenWeatherMapProvider();
        List<Prevision> lp;
        //WHEN
        lp = openWeatherMapProvider.getForecastByCity("Rouen");
        //THEN
        assertThat(lp).isNotEmpty();
    }

    @Test(expected = RuntimeException.class)
    public void shouldGetForecastByCityWithUnexistingCityReturn404() {
        //GIVEN
        IWeatherProvider openWeatherMapProvider= new OpenWeatherMapProvider();
        List<Prevision> lp;
        //WHEN
        lp = openWeatherMapProvider.getForecastByCity("ugefvuerhvoeiuh");
        //THEN
        fail("RuntimeException should be thrown");
    }
}