package yarieva.test;


import org.junit.jupiter.api.Test;

public class StudentsRegistrationWithPageObjectsTests extends TestBase {


    @Test
    void fillFormTest() {
        registrationsPage.openPage()
                .typeFirstName()
                .typeLastName()
                .typeEmail()
                .choseGender("Female")
                .typePhoneNumber()
                .chooseDateOfBirth("10", "September", "2007")
                .chooseSubject("Hindi")
                .chooseHobbies("Music")
                .uploadPicture("src/test/resources/img/JoyCorp.jpg")
                .typeCurrentAddress()
                .chooseState("Haryana")
                .chooseCity("Karnal")
                .clickSubmit();


        //assert
        registrationsPage.checkResultsValue("Student Name", registrationsPage.firstName + " " + registrationsPage.lastName)
                .checkResultsValue("Student Email", registrationsPage.email)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", registrationsPage.phone)
                .checkResultsValue("Date of Birth", "10 September,2007")
                .checkResultsValue("Subjects", "Hindi")
                .checkResultsValue("Hobbies", "Music")
                .checkResultsValue("Picture", "JoyCorp.jpg")
                .checkResultsValue("Address", registrationsPage.streetAddress)
                .checkResultsValue("State and City", "Haryana" + " " + "Karnal");

    }

}