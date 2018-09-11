package seba0.javaszc4.wzorce.zadania.kompozyt;

import java.util.Optional;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

/**
 *
 * @author sebastian
 */
public class OrganizationITNGIT {

    @Test
    public void createOrganizationAndListEmployees() {
        SoftAssertions.assertSoftly((SoftAssertions softly) -> {
            Manager mainManager = new Manager("Main Manager");

            softly.assertThat(mainManager)
                    .isNotNull();
            softly.assertThat(mainManager.getName())
                    .isNotNull()
                    .isEqualTo("Main Manager");

            OrganizationIT organization = new OrganizationIT("Org.IT", mainManager);

            softly.assertThat(organization)
                    .isNotNull();
            softly.assertThat(organization.getName())
                    .isNotNull()
                    .isEqualTo("Org.IT");

            softly.assertThat(organization.getMainManager())
                    .isNotNull()
                    .isSameAs(mainManager);

            Developer mainDeveloper = new Developer("Main Developer");

            softly.assertThat(mainDeveloper)
                    .isNotNull();

            softly.assertThat(mainDeveloper.getName())
                    .isNotNull()
                    .isEqualTo("Main Developer");

            Optional<Employee> employeer = organization.findEmployeer("Main Manager");
            softly.assertThat(employeer)
                    .isNotNull()
                    .isNotEmpty()
                    .hasValue(mainManager);

            softly.assertThat(mainManager.getEmployees().add(mainDeveloper))
                    .isNotNull()
                    .isTrue();

            softly.assertThat(mainManager.getEmployees().add(mainDeveloper))
                    .isNotNull()
                    .isFalse();

            employeer = organization.findEmployeer("Main Developer");
            softly.assertThat(employeer)
                    .isNotNull()
                    .isNotEmpty()
                    .hasValue(mainDeveloper);

            Manager subManager1 = new Manager("Sub Manager 1");
            Manager subManager2 = new Manager("Sub Manager 2");

            softly.assertThat(mainManager.getEmployees().add(subManager1))
                    .isNotNull()
                    .isTrue();

            softly.assertThat(mainManager.getEmployees().add(subManager2))
                    .isNotNull()
                    .isTrue();

            employeer = organization.findEmployeer("Sub Manager 1");
            softly.assertThat(employeer)
                    .isNotNull()
                    .isNotEmpty()
                    .hasValue(subManager1);

            employeer = organization.findEmployeer("Sub Manager 2");
            softly.assertThat(employeer)
                    .isNotNull()
                    .isNotEmpty()
                    .hasValue(subManager2);

            employeer = organization.findEmployeer("None Employeer");
            softly.assertThat(employeer)
                    .isNotNull()
                    .isEmpty();

            Developer subDeveloper11 = new Developer("Sub Developer 1/1");
            Developer subDeveloper12 = new Developer("Sub Developer 1/2");
            Developer subDeveloper21 = new Developer("Sub Developer 2/1");
            Developer subDeveloper22 = new Developer("Sub Developer 2/2");

            softly.assertThat(subManager1.getEmployees().add(subDeveloper11))
                    .isNotNull()
                    .isTrue();

            softly.assertThat(subManager1.getEmployees().add(subDeveloper12))
                    .isNotNull()
                    .isTrue();

            softly.assertThat(subManager2.getEmployees().add(subDeveloper21))
                    .isNotNull()
                    .isTrue();

            softly.assertThat(subManager2.getEmployees().add(subDeveloper22))
                    .isNotNull()
                    .isTrue();

            employeer = organization.findEmployeer("Sub Developer 2/1");
            softly.assertThat(employeer)
                    .isNotNull()
                    .isNotEmpty()
                    .hasValue(subDeveloper21);

            employeer = subManager1.findEmployeer("Sub Developer 2/1");
            softly.assertThat(employeer)
                    .isNotNull()
                    .isEmpty();

            softly.assertThat(organization.getEmployes())
                    .isNotNull()
                    .isNotEmpty()
                    .containsOnly(
                            mainManager,
                            mainDeveloper,
                            subManager1,
                            subDeveloper11,
                            subDeveloper12,
                            subManager2,
                            subDeveloper21,
                            subDeveloper22);
        });
    }

}
