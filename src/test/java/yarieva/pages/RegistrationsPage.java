package yarieva.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import yarieva.pages.components.CalendarComponent;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {
    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive"),
           emailInput = $("#userEmail"),
    genderRadioButton=$("#genterWrapper").$(byText("Female")),
    phoneNumberInput=$("#userNumber"),
    subjectInput=$("#subjectsInput"),
    hobbiesCheckBox=$("#hobbiesWrapper"),
       pictureButton=$("#uploadPicture"),
    currentAddress=$("#currentAddress"),
    stateDropDownList=$("#state"),
    cityDropDownList=$("#city"),
    submitButton=$("#submit");



    public CalendarComponent calendar = new CalendarComponent();


  // Faker faker = new Faker(new Locale("ru"));

    // actions
    public RegistrationsPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }

    public RegistrationsPage typeFirstName(String value) {
       firstNameInput.setValue(value);

        return this;
    }


    public RegistrationsPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public  RegistrationsPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationsPage choseGender(String value) {
genderRadioButton.click();
return this;
    }

    public RegistrationsPage typePhoneNumber(String value) {
phoneNumberInput.setValue(value);
return this;
    }

   // public RegistrationsPage choeseDateOfBirh (String day, String month, String year) {
   //    calendar.setDate(10, 9, 2007);
    //   return this;
  //  }

    public  RegistrationsPage chooseSubject(String value) {
subjectInput.setValue(value).pressEnter();
return this;
    }

    public RegistrationsPage chooseHobbies(String value) {
        hobbiesCheckBox.$(byText(value)).click();
        return this;
    }
    public  RegistrationsPage uploadPicture(String value) {
        pictureButton.uploadFromClasspath(value);
        return this;
    }
    public  RegistrationsPage typeCurrentAddress(String value) {
currentAddress.setValue(value);
return  this;
    }

public RegistrationsPage chooseState(String value) {
        stateDropDownList.click();
$("#stateCity-wrapper").$(byText((value))).click();
return this;
}

public RegistrationsPage chooseCity(String value) {
    cityDropDownList.click();
    $("#stateCity-wrapper").$(byText(value)).click();
    return this;
}
public void clickSubmit() {
        submitButton.click();
}

    public RegistrationsPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

}
