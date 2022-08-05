package ultilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private Locale local = new Locale("en");
    private Faker faker = new Faker(local);

    public static DataHelper getDataHelper() {
        return new DataHelper();
    }

    public String getFirstName() {
        return faker.address().firstName();
    }

    public String getLastName() {
        return faker.address().lastName();
    }

    public String getCityName() {
        return faker.address().city();
    }

    public String getCountryName() {
        return faker.address().country();
    }

    public String getPassword() {
        return faker.internet().password(8, 10, true, true, true);
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

}
