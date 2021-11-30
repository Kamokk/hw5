package yarieva.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import yarieva.pages.components.CalendarComponent;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationsPage {
    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    public CalendarComponent calendar = new CalendarComponent();
    Faker faker = new Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String phone = faker.phoneNumber().subscriberNumber(10);
    private final SelenideElement
            formTitle = $(".practice-form-wrapper");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement resultsTable = $(".table-responsive");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderRadioButton = $("#genterWrapper");
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    private final SelenideElement pictureButton = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateDropDownList = $("#state");
    private final SelenideElement cityDropDownList = $("#city");
    private final SelenideElement submitButton = $("#submit");

    // actions
    public RegistrationsPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }


    public RegistrationsPage typeFirstName() {
        firstNameInput.setValue(firstName);
        return this;
    }


    public RegistrationsPage typeLastName() {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationsPage typeEmail() {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationsPage choseGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationsPage typePhoneNumber() {
        phoneNumberInput.setValue(phone);
        return this;
    }

    public RegistrationsPage chooseDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationsPage chooseSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationsPage chooseHobbies(String value) {
        hobbiesCheckBox.$(byText(value)).click();
        return this;
    }

    public RegistrationsPage uploadPicture(String value) {
        pictureButton.uploadFile(new File(value));
        return this;
    }

    public RegistrationsPage typeCurrentAddress() {

        currentAddress.setValue(streetAddress);
        return this;
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
