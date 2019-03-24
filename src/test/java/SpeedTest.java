

import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class SpeedTest {
    private Speed speed;
    Offset<Double> precision;

    @Before
    public void setup() {
        this.speed = new Speed(Unit.kmPerHour, 10);
        precision = within(0.0001);

    }

    @Test
    public void test001_ASpeedValueWhenIncreasePercentShouldUpdateValue() {
        this.speed.increasePercentage(10d);
        assertThat(speed.getMagnitude()).isEqualTo(11d,precision);
    }

    @Test(expected = RuntimeException.class)
    public void test003_ASpeedValueCanNotBeSetNegative(){
        speed.setMagnitude(-2d);
    }

    @Test (expected = NegativePercentageException.class)
    public void test004_aSpeedValueWhenNegativePercentShouldThrowException() {
        this.speed.increasePercentage(-10d);
    }

    @Test
    public void test005_aSpeedValueInKmPerHourWhenConvertedShouldConvertSuccessfuly() {
        Speed otherSpeed = new Speed(Unit.kmPerHour, 36);
        otherSpeed.changeUnit(Unit.metersPerSecond);
        assertThat(otherSpeed.getMagnitude()).isEqualTo(10d,precision);
        assertThat(otherSpeed.getUnit()).isEqualTo(Unit.metersPerSecond);
    }

}
