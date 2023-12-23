package com.inq.learnease.entity.users;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
    @Column(name = "email", length = 255, nullable = false)
    String value;
    
    private Email(final String value) {
        this.value = value;
    }
    
    public static Email from(final String value) {
        validateEmail(value);
        return new Email(value);
    }
    
    private static void validateEmail(final String value) {
        Matcher matcher = PASSWORD_PATTERN.matcher(value);
        
        if (!matcher.matches()) {
            throw new IllegalArgumentException("OH NO HSB");
        }
    }
}
