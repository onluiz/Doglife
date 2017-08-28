package br.com.doglife.config;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringEncryptConfig {

    @Bean
    public ConfigurablePasswordEncryptor passwordEncryptor() {
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm("MD5");
        passwordEncryptor.setStringOutputType("hexadecimal");
        passwordEncryptor.setPlainDigest(true);
        return passwordEncryptor;
    }

}
