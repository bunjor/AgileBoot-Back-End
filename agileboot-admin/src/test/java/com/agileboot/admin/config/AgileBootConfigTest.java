package com.agileboot.admin.config;


import com.agileboot.admin.AgileBootAdminApplication;
import com.agileboot.common.config.AgileBootConfig;
import com.agileboot.common.constant.Constants.UploadSubDir;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;

@SpringBootTest(classes = AgileBootAdminApplication.class)
@ExtendWith(SpringExtension.class)
public class AgileBootConfigTest {

    @Resource
    private AgileBootConfig config;

    @Test
    public void testConfig() {
        String fileBaseDir = "D:\\agileboot\\profile";

        Assertions.assertEquals("AgileBoot", config.getName());
        Assertions.assertEquals("1.0.0", config.getVersion());
        Assertions.assertEquals("2022", config.getCopyrightYear());
        Assertions.assertTrue(AgileBootConfig.isDemoEnabled());
        Assertions.assertEquals(fileBaseDir, AgileBootConfig.getFileBaseDir());
        Assertions.assertFalse(AgileBootConfig.isAddressEnabled());
        Assertions.assertEquals("math", AgileBootConfig.getCaptchaType());
        Assertions.assertEquals("math", AgileBootConfig.getCaptchaType());
        Assertions.assertEquals("%s\\import".formatted(fileBaseDir),
            AgileBootConfig.getFileBaseDir() + File.separator + UploadSubDir.IMPORT_PATH);
        Assertions.assertEquals("%s\\avatar".formatted(fileBaseDir),
            AgileBootConfig.getFileBaseDir() + File.separator + UploadSubDir.AVATAR_PATH);
        Assertions.assertEquals("%s\\download".formatted(fileBaseDir),
            AgileBootConfig.getFileBaseDir() + File.separator + UploadSubDir.DOWNLOAD_PATH);
        Assertions.assertEquals("%s\\upload".formatted(fileBaseDir),
            AgileBootConfig.getFileBaseDir() + File.separator + UploadSubDir.UPLOAD_PATH);
    }

}
