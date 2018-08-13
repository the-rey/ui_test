package com.gdn.qa.module.ui.training.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@Component("com.gdn.qa.module.ui.training.properties.CartDataProperties")
@ConfigurationProperties(prefix = "cart")
public class CartDataProperties {
    private HashMap<String, String> data;

    public String get(String name) {
        return data.get(name);
    }
}
