package com.agileboot.common.config;

import com.agileboot.common.constant.Constants;
import java.io.File;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * TODO 移走  不合适放在这里common包底下
 * @author valarchie
 */
@Component
@ConfigurationProperties(prefix = "agileboot")
@Data
public class AgileBootConfig {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 版权年份
     */
    private String copyrightYear;

    /**
     * 实例演示开关
     */
    @Getter
    @Value("${agileboot.demo-enabled}")
    private static boolean demoEnabled;

    /**
     * 上传路径
     */
    @Getter
    @Value("${agileboot.file-base-dir}")
    private static String fileBaseDir;

    /**
     * 获取地址开关
     */
    @Getter
    @Value("${agileboot.addressEnabled}")
    private static boolean addressEnabled;

    /**
     * 验证码类型
     */
    @Getter
    @Value("${agileboot.captchaType}")
    private static String captchaType;

    /**
     * rsa private key  静态属性的注入！！ set方法一定不能是static 方法
     */
    @Getter
    @Value("${agileboot.rsaPrivateKey}")
    private static String rsaPrivateKey;

    @Getter
    @Value("${agileboot.api-prefix}")
    private static String apiPrefix;

    public void setFileBaseDir(String fileBaseDir) {
        AgileBootConfig.fileBaseDir = fileBaseDir  + File.separator + Constants.RESOURCE_PREFIX;
    }

}
