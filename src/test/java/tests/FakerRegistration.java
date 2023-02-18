package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;



public class FakerRegistration {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    public void toolsQaForm () {
        Faker faker = new Faker();

        String UserName = faker.name().firstName();
        String UserLastName = faker.name().lastName();
        String UserEmail = faker.internet().emailAddress();
        String UserGenter = faker.options().option("Male", "Female", "Other");
        String UserNumber = String.valueOf(faker.number().numberBetween(1000000000, 2009999999));
        String UserBirthDay_day = String.valueOf(faker.number().numberBetween(1, 28));
        String UserBirthDay_month = faker.options().option("January", "February",
                "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String UserBirthDay_year = String.valueOf(faker.number().numberBetween(1950, 2000));
        String UserSubjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
        String UserHobbies = faker.options().option("Music", "Sports", "Reading");
        String UserPictureLocation = "pictures/3.png";
        String UserAddress = faker.address().streetName();
        String UserState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");


        String city = new String();
        if (UserState == "NCR") {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (UserState == "Uttar Pradesh") {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (UserState == "Haryana") {
            city = faker.options().option("Karnal", "Panipat");
        } else {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }

        String UserCity = city;


        registrationPage.openPage();

        registrationPage.setFirstName(UserName);
        registrationPage.setLastName(UserLastName);
        registrationPage.setUserEmail(UserEmail);
        registrationPage.clickUserGenter(UserGenter);
        registrationPage.setUserNumber(UserNumber);
        registrationPage.setBirthDay(UserBirthDay_day, UserBirthDay_month, UserBirthDay_year);
        registrationPage.setSubjects(UserSubjects);
        registrationPage.clickHobbies(UserHobbies);
        registrationPage.setPictures(UserPictureLocation);
        registrationPage.setAddress(UserAddress);
        registrationPage.setState(UserState);
        registrationPage.setCity(UserCity);

        registrationPage.clickSubmit();

        registrationPage.verifyResoultsModal();
        registrationPage.verifyResoults("Student Name", UserName + " " + UserLastName);
        registrationPage.verifyResoults("Student Email", UserEmail);
        registrationPage.verifyResoults("Gender", UserGenter);
        registrationPage.verifyResoults("Mobile", UserNumber);
        registrationPage.verifyResoults("Date of Birth", UserBirthDay_day + " " + UserBirthDay_month + "," + UserBirthDay_year);
        registrationPage.verifyResoults("Subjects", UserSubjects);
        registrationPage.verifyResoults("Hobbies", UserHobbies);
        registrationPage.verifyResoults("Address", UserAddress);
        registrationPage.verifyResoults("State and City", UserState + " " + UserCity);

        registrationPage.clickClose();


    }
}