package fr.rouen.mastergil.tptest.meteo;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.Date;


public class PrevisionUnitTest {

    @Test
    public void shouldSetTheDateAndReturnAValidPrevisionWhenCallingSetDate() {
        //GIVEN
        Prevision p= new Prevision();
        Date date = new Date();
        Prevision returnedP;
        //WHEN
        returnedP = p.setDate(date);
        //THEN
        assertThat(returnedP).isEqualToComparingFieldByField(p);
        assertThat(returnedP).isEqualTo(p);
        assertThat(returnedP.getDate()).isEqualTo(date);
    }

    @Test
    public void shouldSetTheTempMinAndReturnAValidPrevisionWhenCallingSetTempMin() {
        //GIVEN
        Prevision p= new Prevision();
        double tempMin = -1.5;
        Prevision returnedP;
        //WHEN
        returnedP = p.setTempMin(tempMin);
        //THEN
        assertThat(returnedP).isEqualToComparingFieldByField(p);
        assertThat(returnedP).isEqualTo(p);
        assertThat(returnedP.getTempMin()).isEqualTo(tempMin);
    }

    @Test
    public void shouldSetTheTempMaxAndReturnAValidPrevisionWhenCallingSetTempMax() {
        //GIVEN
        Prevision p= new Prevision();
        double tempMax = 35.3;
        Prevision returnedP;
        //WHEN
        returnedP = p.setTempMax(tempMax);
        //THEN
        assertThat(returnedP).isEqualToComparingFieldByField(p);
        assertThat(returnedP).isEqualTo(p);
        assertThat(returnedP.getTempMax()).isEqualTo(tempMax);
    }

    @Test
    public void shouldSetTheTempDayAndReturnAValidPrevisionWhenCallingSetTempDay() {
        //GIVEN
        Prevision p= new Prevision();
        double tempDay = 15.3;
        Prevision returnedP;
        //WHEN
        returnedP = p.setTempDay(tempDay);
        //THEN
        assertThat(returnedP).isEqualToComparingFieldByField(p);
        assertThat(returnedP).isEqualTo(p);
        assertThat(returnedP.getTempDay()).isEqualTo(tempDay);
    }

    @Test
    public void shouldSetTheTempNightAndReturnAValidPrevisionWhenCallingSetTempNight() {
        //GIVEN
        Prevision p= new Prevision();
        double tempNight = 05.3;
        Prevision returnedP;
        //WHEN
        returnedP = p.setTempNight(tempNight);
        //THEN
        assertThat(returnedP).isEqualToComparingFieldByField(p);
        assertThat(returnedP).isEqualTo(p);
        assertThat(returnedP.getTempNight()).isEqualTo(tempNight);
    }

    @Test
    public void shouldSetTheDescriptionAndReturnAValidPrevisionWhenCallingSetDescription() {
        //GIVEN
        Prevision p= new Prevision();
        String desc = "Little Description to Check if the Temp is correct";
        Prevision returnedP;
        //WHEN
        returnedP = p.setDescription(desc);
        //THEN
        assertThat(returnedP).isEqualToComparingFieldByField(p);
        assertThat(returnedP).isEqualTo(p);
        assertThat(returnedP.getDescription()).isEqualTo(desc);
    }

}