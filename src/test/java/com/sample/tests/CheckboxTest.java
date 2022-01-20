package com.sample.tests;

import com.sample.pages.CheckboxPage;
import org.junit.jupiter.api.Test;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkSelectCheckbox() {
        getPage(CheckboxPage.class)
                .open()
                .clickFirstCheckbox()
                .isFirstCheckboxSelected();
    }

    @Test
    public void checkUnselectCheckbox() {
        getPage(CheckboxPage.class)
                .open()
                .clickFirstCheckbox()
                .clickFirstCheckbox()
                .isFirstCheckboxNotSelected();
    }
}
