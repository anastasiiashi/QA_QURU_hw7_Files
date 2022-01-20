package qaguru_hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FilesTests {
    @Test
    @DisplayName("Загрузка jpg файла")
    void filenameShouldDisplayedAfterUploadActionFromClasspathTest() {
        open("https://demoqa.com/upload-download");
        $("input[type='file']").uploadFromClasspath("not_pass.jpg");
        $("#uploadFile").click();
        $("#uploadedFilePath").shouldHave(text("C:\\fakepath\\not_pass.jpg"));
    }
}
