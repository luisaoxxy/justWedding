package es.justWeddings.beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.themeswitcher.ThemeSwitcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import es.justWeddings.domain.Theme;
import es.justWeddings.services.ThemeService;

@Component
@SessionScope
public class ThemeSwitcherBean {

  private List<Theme> themes;
  private String theme;
  private static final Logger logger = Logger.getLogger(ThemeSwitcherBean.class.getSimpleName());

  @Autowired
  private ThemeService service;

  @PostConstruct
  public void init() {
    themes = service.getThemes();
    if (theme == null) {
      // Humanity por defecto
      theme = themes.get(20).getName();
    }
  }

  public void saveTheme(AjaxBehaviorEvent ajax) {
    String aux = (String) ((ThemeSwitcher) ajax.getSource()).getValue();
    logger.log(Level.FINE, "El usuario " + " ha modificado su tema a" + aux);
    theme = aux;
  }

  /* GETTER Y SETTERS */
  public List<Theme> getThemes() {
    return themes;
  }

  public void setService(ThemeService service) {
    this.service = service;
  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public void setThemes(List<Theme> themes) {
    this.themes = themes;
  }
}
