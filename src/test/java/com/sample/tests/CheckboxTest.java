package com.sample.tests;

import com.sample.pages.CheckboxPage;
import org.junit.jupiter.api.Test;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkSelectCheckbox() {
        getPage(CheckboxPage.class)
                .clickFirstCheckbox()
                .isFirstCheckboxSelected();
    }

    @Test
    public void checkUnselectCheckbox() {
        getPage(CheckboxPage.class)
                .clickFirstCheckbox()
                .clickFirstCheckbox()
                .isFirstCheckboxNotSelected();
    }
}
