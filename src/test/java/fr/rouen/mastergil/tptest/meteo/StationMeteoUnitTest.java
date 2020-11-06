package fr.rouen.mastergil.tptest.meteo;

import org.codehaus.jettison.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class StationMeteoUnitTest {
    @Mock
    IWeatherProvider weatherProviderMock;

    @InjectMocks
    StationMeteo sm;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIAEWhenMajPrevisionParamIsNull() throws JSONException {
        //GIVEN
        //WHEN
        sm.majPrevision(null);
        //THEN
        fail("IllegalArgumentException should be thrown.");
    }

    @Test
    public void shouldMajPrevisionWithRealParam() throws JSONException {
        //GIVEN
        String city = "Rouen";
        //WHEN
        sm.majPrevision(city);
        //THEN
        Mockito.verify(weatherProviderMock,Mockito.times(1)).getForecastByCity(city);
    }
}