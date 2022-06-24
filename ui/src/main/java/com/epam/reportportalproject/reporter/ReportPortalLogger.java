package com.epam.reportportalproject.reporter;

import static com.codeborne.selenide.Selenide.screenshot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReportPortalLogger {
    public static void logFailedTest() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM.dd_HH.mm.ss");
        LocalDateTime currentTime = LocalDateTime.now();
        log.info("RP_MESSAGE#FILE#{}#{}", screenshot("scr_" + dateTimeFormatter.format(currentTime)), "Screenshot on failure");
    }
}
