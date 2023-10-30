package com.first.app.service;

import com.first.app.model.Language;
import com.first.app.repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService{
    @Autowired
    LanguageRepo languageRepo;

    @Override
    public List<Language> getLangauges() {
        List<Language> languages = languageRepo.findAll();
        return null;
    }

    @Override
    public void saveLanguage(Language language) {
        languageRepo.save(language);
    }
}
