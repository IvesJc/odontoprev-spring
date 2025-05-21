package br.com.odontoprev.infra;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleUtil {
    public Locale resolveLocale(String acceptLanguageHeader) {
        if (acceptLanguageHeader == null || acceptLanguageHeader.isEmpty()) {
            return Locale.getDefault();
        }
        String languageTag = acceptLanguageHeader.split(",")[0].trim();
        return Locale.forLanguageTag(languageTag);
    }
}
