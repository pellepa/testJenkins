package fr.rouen.mastergil.tptest.meteo;

import static org.assertj.core.api.Assertions.assertThat;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class StationMeteoIntegrationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    public void should() throws JSONException {
        //GIVEN
        //WHEN
        StationMeteo.main(new String[0]);
        //THEN
        assertThat(outContent.toString()).contains("description");
        assertThat(outContent.toString()).contains("tempDay");
    }

}