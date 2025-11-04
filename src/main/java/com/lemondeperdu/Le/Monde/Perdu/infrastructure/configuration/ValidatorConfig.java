package com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidatorConfig {

    private static final Pattern PSEUDO_PATTERN = Pattern.compile(
            "^[\\p{L}0-9](?:[\\p{L}0-9_-]{1,18}[\\p{L}0-9])?$",
            Pattern.CASE_INSENSITIVE // ✅ ignore la casse
    );

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,20}$"
    );

    private static final Set<String> SQL_KEYWORDS = new HashSet<>(Arrays.asList(
            "SELECT", "INSERT", "UPDATE", "DELETE", "DROP", "ALTER",
            "CREATE", "TRUNCATE", "EXEC", "UNION", "MERGE", "CALL"
    ));

    public static boolean isSafePseudo(String pseudo) {
        if (pseudo == null) return false;
        if (!PSEUDO_PATTERN.matcher(pseudo).matches()) return false;
        return !SQL_KEYWORDS.contains(pseudo.toUpperCase());
    }

    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}

