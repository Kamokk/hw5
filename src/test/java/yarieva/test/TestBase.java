package yarieva.test;

import com.codeborne.selenide.Configuration;
import yarieva.pages.RegistrationsPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationsPage registrationsPage = new RegistrationsPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

}