package seba0.javaszc4.wzorce.zadania.dekorator;

import javafx.scene.paint.Color;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

/**
 *
 * @author sebastian
 */
public class CarDecoratorNGIT {

    @Test
    public void testMakeFullUpgradedCar() {
        SoftAssertions.assertSoftly(softly -> {
            Car car = new CarBasic(Color.BURLYWOOD, Spoiler.SPORT, 14);

            softly.assertThat(car.getBodyColor()).isEqualTo(Color.BURLYWOOD);
            softly.assertThat(car.getSpoiler()).isEqualTo(Spoiler.SPORT);
            softly.assertThat(car.getWheelsSize()).isEqualTo(14);

            car = new CarBodyColorDecorator(Color.AQUA, car);

            softly.assertThat(car.getBodyColor()).isEqualTo(Color.AQUA);
            softly.assertThat(car.getSpoiler()).isEqualTo(Spoiler.SPORT);
            softly.assertThat(car.getWheelsSize()).isEqualTo(14);

            car = new CarWheelsSizeDecorator(20, car);

            softly.assertThat(car.getBodyColor()).isEqualTo(Color.AQUA);
            softly.assertThat(car.getSpoiler()).isEqualTo(Spoiler.SPORT);
            softly.assertThat(car.getWheelsSize()).isEqualTo(20);

            car = new CarSpoilerDecorator(Spoiler.STANDARD, car);

            softly.assertThat(car.getBodyColor()).isEqualTo(Color.AQUA);
            softly.assertThat(car.getSpoiler()).isEqualTo(Spoiler.STANDARD);
            softly.assertThat(car.getWheelsSize()).isEqualTo(20);
        });
    }
}
