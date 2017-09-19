package nl.ekholabs.nlp.controller;

import nl.ekholabs.nlp.model.Language;
import nl.ekholabs.nlp.service.LanguageDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class LanguageDetectionController {

  private final LanguageDetectionService languageDetectionService;

  @Autowired
  public LanguageDetectionController(final LanguageDetectionService languageDetectionService) {
    this.languageDetectionService = languageDetectionService;
  }

  @PostMapping(path = "/idLanguage", consumes = TEXT_PLAIN_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
  public Language idLanguage(@RequestBody final String text) {
    final String language = languageDetectionService.identifyLanguage(text);
    return new Language(language);
  }
}
