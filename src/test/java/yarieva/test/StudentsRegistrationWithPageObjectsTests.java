package yarieva.test;

import org.junit.jupiter.api.Test;
import yarieva.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentsRegistrationWithPageObjectsTests extends TestBase {

    public CalendarComponent calendar = new CalendarComponent();

    @Test
    void fillFormTest() {
        registrationsPage.openPage()
                .typeFirstName("Mira")
                .typeLastName("Smith")
       .typeEmail("Mira@mail.ru")
      .choseGender("Female")
       .typePhoneNumber("79802507861")
        .chooseSubject("Hindi")
        .chooseHobbies("Music")
        .uploadPicture("img/JoyCorp.jpg")
        .typeCurrentAddress("Volgogradsky prospect, 21 st9")
        .chooseState("Haryana")
        .chooseCity("Karnal")
        .clickSubmit();
        registrationsPage.calendar.setDate("10", "September", "2007");


     //   $("#uploadPicture").uploadFile(new File("src/test/resources/img/JoyCorp.png"));
    //    $("#uploadPicture").uploadFromClasspath("img/1.png");



        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
      //  $(".table-responsive").shouldHave(text("Alex Egorov"), text("alex@egorov.com"));
       // registrationsPage
       //         .checkResultsValue("Student Name", "Alex Egorov")
        //        .checkResultsValue("Email", "alex@egorov.com");
    }
}