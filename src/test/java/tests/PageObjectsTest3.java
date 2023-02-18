package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PageObjectsTest3 {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    public void toolsQaForm () {
        String UserName = "Oleg";
        String UserLastName = "Petrov";
        String UserEmail = "PetrovOleg@mail.ru";
        String UserGenter = "Male";
        String UserNumber = "9168130220";
        String UserBirthDay_day = "13";
        String UserBirthDay_month = "March";
        String UserBirthDay_year = "1980";
        String UserSubjects = "English";
        String UserHobbies = "Music";
        String UserPictureLocation = "pictures/3.png";
        String UserAddress = "Victory cq 5";
        String UserState = "Uttar Pradesh";
        String UserCity = "Agra";


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
