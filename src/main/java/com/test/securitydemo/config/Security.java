package com.test.securitydemo.config;

import com.test.securitydemo.util.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/script/**","/image/**","/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //        1) authorizeRequests 밑으로 antMatchers 들을 통해 url 에 대한 권한을 부여할 수 있습니다.
        //        2) formLogin 밑으로로그인에 대한 설정(파라미터, url, 핸들러 등등) 할 수 있습니다.
        //        3) logout 밑으로 로그아웃에 대한 설정(url, 세션, 쿠키 등등)을 할 수 있습니다.
        //        4) csrf CSRF 공격에 대해 방어 하고 토큰을 보낼지 여부.
        //        loginPage는 로그인 뷰 페이지를 연결하고, loginProcessingUrl은 Post로 로그인을 처리할 Url

//        http
//                .authorizeRequests()
//                .antMatchers("/**")
//                .permitAll()
//                .and()
//                .formLogin()
//                .usernameParameter("id")
//                .passwordParameter("password")
////                .loginProcessingUrl("/login")
//                .loginPage("/login")
//                .defaultSuccessUrl("/members")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true)
//                .permitAll()
//                .and()
//                .csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("id")
                .passwordParameter("password")
                .defaultSuccessUrl("/members")
                .failureUrl("/login")
                .and()
                .logout()
                .and()
                .csrf().disable();



    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
