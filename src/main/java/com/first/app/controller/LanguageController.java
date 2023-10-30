package com.first.app.controller;

import com.first.app.model.Language;
import com.first.app.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping(path = "/retrieve")
    public List<Language> listLambdaLanguages() throws Exception{
        Language language = new Language();
        language.setName("JAVA");
        saveLanguage(language);
        return languageService.getLangauges();
    }

    @PutMapping(path = "/save")
    public void saveLanguage(@RequestBody Language language) throws Exception{
        languageService.saveLanguage(language);
    }

}