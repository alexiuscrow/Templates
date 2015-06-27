package pkg.impl.stringtemplate.letters;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

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

    private final STGroup group = new STGroupFile("stringtemplate/letter.stg", '$', '$');
    private final ST st = group.getInstanceOf("NewsLetter");

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
        st.add("title", title);
        st.add("mainContent", mainContent);
        st.add("btnText", btnText);
        st.add("btnLink", btnLink);
        st.add("headImageURL", headImageURL);

        return st.render();
    }
}
