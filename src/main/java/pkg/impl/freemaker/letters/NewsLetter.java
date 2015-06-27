package pkg.impl.freemaker.letters;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by void on 26.06.2015.
 */
public class NewsLetter {
    private String title;
    private String mainContent;
    private String btnText;
    private String btnLink;
    private URL headImageURL;

    private Configuration cfg = new Configuration(new Version("2.3.0"));

    public NewsLetter(){}

    public NewsLetter(String title, String mainContent, String btnText, String btnLink, URL headImageURL) {
        this.title = title;
        this.mainContent = mainContent;
        this.btnText = btnText;
        this.btnLink = btnLink;
        this.headImageURL = headImageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public String getBtnLink() {
        return btnLink;
    }

    public void setBtnLink(String btnLink) {
        this.btnLink = btnLink;
    }

    public URL getHeadImageURL() {
        return headImageURL;
    }

    public void setHeadImageURL(URL headImageURL) {
        this.headImageURL = headImageURL;
    }

    @Override
    public String toString() {
        try {
            Template template = cfg.getTemplate("src/main/resources/freemaker/letter.ftl");

            Map<String, Object> data = new HashMap<String, Object>();
            data.put("title", title);
            data.put("mainContent", mainContent);
            data.put("btnText", btnText);
            data.put("btnLink", btnLink);
            data.put("headImageURL", headImageURL);

            Writer writer = new StringWriter();
            template.process(data, writer);

            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
