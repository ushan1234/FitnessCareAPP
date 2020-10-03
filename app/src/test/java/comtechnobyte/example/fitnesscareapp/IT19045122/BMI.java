package comtechnobyte.example.fitnesscareapp.IT19045122;

import org.junit.Before;
import org.junit.Test;

import comtechnobyte.example.fitnesscareapp.Male;

import static org.junit.Assert.assertEquals;

public class BMI {

    /************* test for common Attributes************/
    private Male male ;

    @Before
    public void setup(){
        male = new Male();
    }

    @Test
    public void BMI_Test(){

        float results  = male.calBMI(54,175);
        assertEquals(17.632652282714844,results,0.001);
    }
}
