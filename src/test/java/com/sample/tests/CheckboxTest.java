package com.sample.tests;

import com.automation.remarks.junit5.Video;
import com.sample.annotations.Screenshot;
import com.sample.pages.CheckboxPage;
import org.junit.jupiter.api.Test;

public class CheckboxTest extends BaseTest {

    @Test
    @Screenshot
    public void checkSelectCheckbox() {
        getPage(CheckboxPage.class)
                .clickFirstCheckbox()
                .isFirstCheckboxSelected();
    }

    @Test
    @Video
    public void checkUnselectCheckbox() {
        getPage(CheckboxPage.class)
                .clickFirstCheckbox()
                .clickFirstCheckbox()
                .isFirstCheckboxNotSelected();
    }
}
