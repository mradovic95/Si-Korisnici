package com.si.korisnici.security;

import com.si.korisnici.service.TokenService;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

@Aspect
@Configuration
public class SecurityAspect {

    @Value("${servis.sifraServisa}")
    private String sifraServisa;

    private TokenService tokenService;

    public SecurityAspect(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @Around("@annotation(com.si.korisnici.security.CheckSecurity)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        String token = null;


        for (int i = 0; i < methodSignature.getParameterNames().length; i++) {
            if (methodSignature.getParameterNames()[i].equals("Authorization")) {
                if (joinPoint.getArgs()[i].toString().startsWith("Bearer")) {
                    token = joinPoint.getArgs()[i].toString().split(" ")[1];
                }
            }
        }


        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Claims claims = tokenService.parseToken(token);
        if (claims == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        CheckSecurity checkSecurity = method.getAnnotation(CheckSecurity.class);


        List<Object> privilegije = (List<Object>) claims.get("privilegije", Object.class);
        for (Object privilegija : privilegije) {


            if (((LinkedHashMap) privilegija).get("sifraNivoaPristupa").equals(checkSecurity.role())
                    && ((LinkedHashMap) privilegija).get("sifraServisa").equals(sifraServisa)) {

                Object value = joinPoint.proceed();
                return value;
            }
        }


        return new ResponseEntity<>(HttpStatus.FORBIDDEN);

    }


}
