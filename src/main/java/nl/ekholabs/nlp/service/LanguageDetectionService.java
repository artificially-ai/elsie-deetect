package nl.ekholabs.nlp.service;

import org.apache.tika.language.LanguageIdentifier;
import org.springframework.stereotype.Service;

@Service
public class LanguageDetectionService {

  public String identifyLanguage(final String text) {
    final LanguageIdentifier identifier = new LanguageIdentifier(text);
    return identifier.getLanguage();
  }
}