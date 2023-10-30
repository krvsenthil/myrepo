package com.first.app.service;

import com.first.app.model.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getLangauges();
    void saveLanguage(Language language);
}
