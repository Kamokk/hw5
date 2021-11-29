package yarieva.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;

public class StudentsRegistrationWithPageObjectsTests extends TestBase {

    Faker faker = new Faker(new Locale("ru"));

    @Test
    void fillFormTest() {
        registrationsPage.openPage()
                .typeFirstName()
                .typeLastName()
                .typeEmail("Mira@mail.ru")
      .choseGender("Female")
       .typePhoneNumber()
        .chooseDateOfBirth("10", "September","2007")
        .chooseSubject("Hindi")
        .chooseHobbies("Music")
        .uploadPicture("img/JoyCorp.jpg")
        .typeCurrentAddress("Volgogradsky prospect, 21 st9")
        .chooseState("Haryana")
        .chooseCity("Karnal")
        .clickSubmit();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
      //  $(".table-responsive").shouldHave(text("Alex Egorov"), text("alex@egorov.com"));
       // registrationsPage
       //         .checkResultsValue("Student Name", "Alex Egorov")
        //        .checkResultsValue("Email", "alex@egorov.com");
    }
}