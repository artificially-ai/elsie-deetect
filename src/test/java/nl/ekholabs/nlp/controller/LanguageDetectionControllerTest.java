package nl.ekholabs.nlp.controller;

import java.util.logging.Logger;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class LanguageDetectionControllerTest {

  private static final Logger LOGGER = Logger.getLogger(LanguageDetectionControllerTest.class.getName());

  @Autowired
  private MockMvc mvc;

  @Test
  public void identifyEnglish() throws Exception {

    final String content = "If you just want the body of the xhtml document, without the header, you can chain together a "
        + "BodyContentHandler and a ToXMLContentHandler as shown:";

    final RequestBuilder request = post("/identify")
        .contentType(MediaType.TEXT_PLAIN_VALUE)
        .content(content);

    final String contentAsString = mvc.perform(request)
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertThat(contentAsString, Matchers.notNullValue());
    assertThat(contentAsString, Matchers.containsString("en"));

    LOGGER.info(contentAsString);
  }

  @Test
  public void identifyPortugues() throws Exception {

    final String content = "Depois de anos sob olhares suspeitos, chegou a hora da DC dominar a discussão na Comic Con de San Diego."
        + " Com Liga da Justiça e Mulher-Maravilha, a marca pode fazer uma apresentação histórica! Confira o OmeleTV sobre o assunto"
        + " e comente conosco!";

    final RequestBuilder request = post("/identify")
        .contentType(MediaType.TEXT_PLAIN_VALUE)
        .content(content);

    final String contentAsString = mvc.perform(request)
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertThat(contentAsString, Matchers.notNullValue());
    assertThat(contentAsString, Matchers.containsString("pt"));

    LOGGER.info(contentAsString);
  }

  @Test
  public void identifyItalian() throws Exception {

    final String content = "Tutto in un giorno. Dopodomani, venerdì 30 giugno, Gerard Deulofeu si gioca la finale dell'Europeo Under"
        + " 21 e il prossimo futuro. Il capitano della \"Rojita\" cercherà di guidare i compagni al successo contro la Germania e"
        + " prima o dopo la partita conoscerà il suo destino. ";

    final RequestBuilder request = post("/identify")
        .contentType(MediaType.TEXT_PLAIN_VALUE)
        .content(content);

    final String contentAsString = mvc.perform(request)
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertThat(contentAsString, Matchers.notNullValue());
    assertThat(contentAsString, Matchers.containsString("it"));

    LOGGER.info(contentAsString);
  }
}