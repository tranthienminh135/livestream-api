package com.phuong.livestreamapi.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtils {
    private final MessageSource resources;

    public MessageUtils(@Qualifier("messageSource") MessageSource resources) {
        this.resources = resources;
    }

    public String getMessage(String code, @Nullable Object[] args) {
        return resources.getMessage(code, args, getLocale());
    }

    private Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }
}
