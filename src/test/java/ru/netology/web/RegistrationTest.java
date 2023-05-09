package ru.netology.web;

import com.codeborne.selenide.Configuration;
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
        //Configuration.headless = true;
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Владимир");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(customData.future(5));
        $("[name='name']").setValue("Валерко Михаил");
        $("[name='phone']").setValue("+79032423264");
        $$("span").find(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных")).click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void positiveScriptRegistrationInteractive() {
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
    }

}

