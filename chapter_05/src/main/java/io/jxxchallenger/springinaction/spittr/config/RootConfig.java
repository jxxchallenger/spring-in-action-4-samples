package io.jxxchallenger.springinaction.spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {DataConfig.class})
public class RootConfig {

}
