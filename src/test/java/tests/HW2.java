package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HW2 {
    static Logger log = LoggerFactory.getLogger(HW2.class);
    @BeforeAll
    static void setUpConfig() {
        log.info("@BeforeAll");
        Configuration.startMaximized = true;
    }
    @Test
    void selenideFormFill() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("FName");
        $("#lastName").setValue("LName");
        $("#userEmail").setValue("gori@vadu.du");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("7322223322");
        $("[id=dateOfBirthInput]").click();     //календарь
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1980");
        $("[aria-label='Choose Monday, January 7th, 1980']").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/testpic.jpg"));
        $("#currentAddress").setValue("RU,MO");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo().click();
        $(".table").shouldHave(text("FName"), text("LName"), text("gori@vadu.du"), text("Male"), text("7322223322"),
                text("7 January,1980"), text("Hindi"), text("RU,MO"), text("NCR"),text("Delhi"));
    }
}


