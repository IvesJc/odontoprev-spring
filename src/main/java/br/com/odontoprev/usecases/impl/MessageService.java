package br.com.odontoprev.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private final MessageSource messageSource;

    @Autowired
    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMensagemssage(String chave) {
        return getMessage(chave, Locale.getDefault());
    }

    public String getMessage(String chave, Locale locale) {
        return messageSource.getMessage(chave, null, locale);
    }
}
