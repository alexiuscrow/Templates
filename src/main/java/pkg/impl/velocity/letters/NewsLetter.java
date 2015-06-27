package pkg.impl.velocity.letters;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

/**
 * Created by void on 26.06.2015.
 */
public class NewsLetter {
    private String title;
    private String mainContent;
    private String btnText;
    private String btnLink;
    private URL headImageURL;

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
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        Template template = ve.getTemplate("src/main/resources/velocity/letter.vm");
        VelocityContext context = new VelocityContext();
        context.put("title", title);
        context.put("mainContent", mainContent);
        context.put("btnText", btnText);
        context.put("btnLink", btnLink);
        context.put("headImageURL", headImageURL);

        Writer writer = new StringWriter();

        template.merge(context, writer);

        return writer.toString();
    }
}
