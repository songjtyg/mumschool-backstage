package com.sjt.cai.mumschool.web.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "weixin")
public class WeixinContextProperties {
	Map<String,String> conf = new HashMap<>();
}
