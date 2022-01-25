package qaguru_hw7;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FilesTests {
    @Disabled
    @Test
    @DisplayName("Загрузка jpg файла")
    void filenameShouldDisplayedAfterUploadActionFromClasspathTest() {
        open("https://demoqa.com/upload-download");
        $("input[type='file']").uploadFromClasspath("not_pass.jpg");
        $("#uploadFile").click();
        $("#uploadedFilePath").shouldHave(text("C:\\fakepath\\not_pass.jpg"));
    }

    @Test
    @DisplayName("Скачивание XLS-файла")
    void xlsFileDownloadTest() throws IOException {
        open("https://ckmt.ru/price-download.html");
        File file = $$("a[href*='https://ckmt.ru/TehresursPrice.xls']")
                .find(text("Скачать"))
                .download();

        XLS parsedXls = new XLS(file);
        boolean checkPassed = parsedXls.excel
                .getSheetAt(0)
                .getRow(8)
                .getCell(3)
                .getStringCellValue()
                .contains("от упаковки");

        assertTrue(checkPassed);
    }
}
