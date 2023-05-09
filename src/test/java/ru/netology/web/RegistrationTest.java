package ru.netology.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {

    CustomData customData = new CustomData();

    //@Disabled
    @Test
    void positiveScriptRegistration() {
        String planningDate = customData.futureLocalDate(5);
        //Configuration.headless = true;
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Владимир");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(customData.futureLocalDate(5));
        $("[name='name']").setValue("Валерко Михаил");
        $("[name='phone']").setValue("+79032423264");
        $$("span").find(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных")).click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }

    @Test
    void positiveScriptRegistrationInteractive() {
        String planningDate = customData.futureLocalDate(5);
        //Configuration.headless = true;
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Вл");
        $$("span").find(exactText("Владикавказ")).click();
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(customData.future(5));
        $("[name='name']").setValue("Валерко Михаил");
        $("[name='phone']").setValue("+79032423264");
        $$("span").find(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных")).click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }

}

