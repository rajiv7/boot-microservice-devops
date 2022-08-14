package com.github.rajiv7.ms.api.department.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
	
	@Value ("${env.secret.pwd}")
	private String pwd;
	
	@Value ("${env.secret.algo}")
	private String algo;
	
	private static SimpleStringPBEConfig getSimpleStringPBEConfig(String pwd, String algo) {
        final SimpleStringPBEConfig pbeConfig = new SimpleStringPBEConfig();
        pbeConfig.setPassword("supersecretz");
        pbeConfig.setAlgorithm("PBEWithMD5AndDES");
        pbeConfig.setKeyObtentionIterations("1000");
        pbeConfig.setPoolSize("1");
        pbeConfig.setProviderName("SunJCE");
        pbeConfig.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        pbeConfig.setStringOutputType("base64");
 
        return pbeConfig;
    }
	
	@Bean(name = "jasyptStringEncryptor")
    public StringEncryptor encryptor() {
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(getSimpleStringPBEConfig(pwd, algo));
         return pbeStringEncryptor;
    }
}