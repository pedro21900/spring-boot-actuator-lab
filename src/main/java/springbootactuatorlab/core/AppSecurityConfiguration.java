package springbootactuatorlab.core;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //Ele permite que o Spring encontre (é um @Configuration e, portanto, @Component) e
// aplica automaticamente a classe ao global WebSecurity.
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .defaultSuccessUrl("/users",true)
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/users").hasAnyRole("USER","ADMIN")
                .antMatchers("/login").permitAll()
                .antMatchers("/").hasAnyRole("USER","ADMIN")
                .anyRequest()
                .authenticated();



    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("pedro.lenonn").password("{noop}admin").roles("USER")
                .and()
                .withUser("foo").password("{noop}foo").roles("ADMIN");

    }



}