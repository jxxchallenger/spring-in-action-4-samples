package io.jxxchallenger.springinaction.spittr.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        //auth.inMemoryAuthentication()
        auth.jdbcAuthentication()
        .dataSource(dataSource)
        .withDefaultSchema()
        .withUser(User.builder().username("user").password("{noop}password").roles("USER"))
        .withUser(User.builder().username("admin").password("{noop}password").roles("ADMIN", "USER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/spitter/register").authenticated()
        .antMatchers(HttpMethod.POST, "/spittles").authenticated()
        //.antMatchers(HttpMethod.POST, "/spittles").hasAnyRole("USER", "ADMIN")
        .anyRequest().permitAll()
        .and()
        .formLogin().loginPage("/login")
        .and()
        .requiresChannel()
        .antMatchers("/spitter/register").requiresSecure()
        .antMatchers("/").requiresInsecure()
        .and().rememberMe().tokenValiditySeconds(102400)
        .and().logout().logoutSuccessUrl("/").invalidateHttpSession(true);
        //.and().csrf().disable(); //禁用CSRF防护
    }

}
