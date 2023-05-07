package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {

    CustomData customData = new CustomData();

    //@Disabled
    @Test
    void positiveScriptRegistration() {
        //Configuration.headless = true;
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Владимир");
        for(int i = 0; i < 10; i++) {
            $("[data-test-id='date'] input").sendKeys(Keys.BACK_SPACE);
        }
        $("[data-test-id='date'] input").setValue(customData.future(5));
        $("[name='name']").setValue("Валерко Михаил");
        $("[name='phone']").setValue("+79032423264");
        $$("span").find(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных")).click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }

}

