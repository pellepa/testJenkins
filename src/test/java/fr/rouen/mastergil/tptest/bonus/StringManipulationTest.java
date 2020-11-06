package fr.rouen.mastergil.tptest.bonus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class StringManipulationTest {

    @Test
    public void shouldGetFalseWhenCallingMethodAWithNullValue() {
        //GIVEN
        boolean result;
        //WHEN
        result = StringManipulation.a(null);
        //THEN
        assertThat(result).isFalse();
    }

    @Test
    public void shouldGetFalseWhenCallingMethodAWithEmptyValue() {
        //GIVEN
        boolean result;
        //WHEN
        result = StringManipulation.a("");
        //THEN
        assertThat(result).isFalse();
    }

    @Test
    public void shouldGetTrueWhenCallingMethodAWithMirrorString() {
        //GIVEN
        boolean result;
        //WHEN
        result = StringManipulation.a("Kayak");
        //THEN
        assertThat(result).isTrue();
    }

    @Test
    public void shouldGetFalseWhenCallingMethodAWithNonMirrorString() {
        //GIVEN
        boolean result;
        //WHEN
        result = StringManipulation.a("Université");
        //THEN
        assertThat(result).isFalse();
    }

    @Test
    public void shouldGetNumberOfDiffferentCharsWhenCallingMethodB() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        int result;
        int nb = 4;
        //WHEN
        result = sm.b("bleu");
        //THEN
        assertThat(result).isEqualTo(nb);
    }

    @Test
    public void shouldGetZeroWhenCallingMethodBWithEmptyString() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        int result;
        int nb = 0;
        //WHEN
        result = sm.b("");
        //THEN
        assertThat(result).isEqualTo(nb);
    }

    @Test
    public void shouldGetCountOfDiffferentFollowingCharsWhenCallingMethodBWithRepeatedChars() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        int result;
        int nb = 7;
        //WHEN
        result = sm.b("Université");
        //THEN
        assertThat(result).isEqualTo(nb);
    }

    @Test
    public void shouldGetEmptyStringWhenCallingMethodCWithSizedZeroArray() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        String result;
        String expected = "";
        //WHEN
        result = sm.c(new String[0]);
        //THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldGetEmptyStringWhenCallingMethodCWithSizedOneEmptyArray() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        String result;
        String[] sa = new String[1];
        sa[0] = "";
        String expected = "";
        //WHEN
        result = sm.c(sa);
        //THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldGetCommonPrefixWhenCallingMethodCWithCommonPrefix() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        String result;
        String[] sa = new String[5];
        sa[0] = "abile";
        sa[1] = "abstract";
        sa[2] = "abstraction";
        sa[3] = "abattu";
        sa[4] = "abbey";
        String expected = "ab";
        //WHEN
        result = sm.c(sa);
        //THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldGetZeroWhenCallingMethodDWithEmptyStrings() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        String a = "";
        String b = "";
        int result;
        int expected = 0;
        //WHEN
        result = sm.d(a, b);
        //THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldGetZeroWhenCallingMethodDWithEmptySecondString() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        String a = "Bulbizarre";
        String b = "";
        int result;
        int expected = 0;
        //WHEN
        result = sm.d(a, b);
        //THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldGetZeroWhenCallingMethodDWithTwoStringsNotEqual() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        String a = "patete";
        String b = "patate";
        int result;
        int expected = 0;
        //WHEN
        result = sm.d(a, b);
        //THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldGetOneWhenCallingMethodDWithTwoEqualStrings() {
        //GIVEN
        StringManipulation sm = new StringManipulation();
        String a = "patate";
        String b = "patate";
        int result;
        int expected = 1;
        //WHEN
        result = sm.d(a, b);
        //THEN
        assertThat(result).isEqualTo(expected);
    }


    //methoe e() is not testable, it's a private function never called in the class
}