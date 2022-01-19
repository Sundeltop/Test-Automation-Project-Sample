package com.sample.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class CheckboxTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify click checkbox selects it")
    @Test
    public void checkSelectCheckbox() {
        checkboxPage
                .open()
                .clickFirstCheckbox()
                .isFirstCheckboxSelected();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify double click checkbox unselects it")
    @Test
    public void checkUnselectCheckbox() {
        checkboxPage
                .open()
                .clickFirstCheckbox()
                .clickFirstCheckbox()
                .isFirstCheckboxNotSelected();
    }
}
