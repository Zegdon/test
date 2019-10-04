package hu.me.iit.malus.thesis.course.controller.helper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class JwtTestHelper {
    @Value("${security.jwt.secret}")
    private String jwtSecret;

    @Value("${security.jwt.inner.header}")
    private String jwtHeader;

    public String createValidJWT(String username, String role) {
        Long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", Arrays.asList(role))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                .compact();
    }

    public String getJwtHeader() {
        return jwtHeader;
    }
}
