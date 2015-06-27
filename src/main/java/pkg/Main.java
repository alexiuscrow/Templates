package pkg;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;
import pkg.impl.stringtemplate.letters.NewsLetter;

import javax.mail.Message;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by void on 25.06.2015.
 */
public class Main {

    public Main(){}

    public static void main(String[] arg) throws IOException {

        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("emailconfig.properties"));

        Email email = new Email();
        email.setFromAddress("Test SimpleMail", properties.getProperty("email"));
        email.setSubject("Newsletter");
        email.addRecipient("Bob", properties.getProperty("email"), Message.RecipientType.TO);
        email.setText("Some text");

        //What you want?
        email.setTextHTML(stringTemplateImpl());
//        email.setTextHTML(freeMakerImpl());
//        email.setTextHTML(velocityImpl());


        new Mailer(properties.getProperty("smtpHost"), Integer.parseInt(properties.getProperty("smtpPort")),
                properties.getProperty("email"), properties.getProperty("pass"),
                Enum.valueOf(TransportStrategy.class, properties.getProperty("smtpTransportStrategy"))).sendMail(email);
    }

    private static String stringTemplateImpl() throws MalformedURLException {
        NewsLetter newsLetter = new NewsLetter();
        newsLetter.setTitle("Lorem ipsum dolor sit amet consectetur");
        newsLetter.setMainContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        newsLetter.setBtnText("Read more");
        newsLetter.setBtnLink("http://lipsum.com/");
        newsLetter.setHeadImageURL(new URL("http://i.imgur.com/W5NGyai.jpg"));

        return newsLetter.toString();
    }

    private static String freeMakerImpl() throws IOException {
        pkg.impl.freemaker.letters.NewsLetter newsLetter = new pkg.impl.freemaker.letters.NewsLetter();
        newsLetter.setTitle("Lorem ipsum dolor sit amet consectetur");
        newsLetter.setMainContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        newsLetter.setBtnText("Read more");
        newsLetter.setBtnLink("http://lipsum.com/");
        newsLetter.setHeadImageURL(new URL("http://i.imgur.com/W5NGyai.jpg"));

        return newsLetter.toString();
    }

    private static String velocityImpl() throws IOException {
        pkg.impl.velocity.letters.NewsLetter newsLetter = new pkg.impl.velocity.letters.NewsLetter();
        newsLetter.setTitle("Lorem ipsum dolor sit amet consectetur");
        newsLetter.setMainContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        newsLetter.setBtnText("Read more");
        newsLetter.setBtnLink("http://lipsum.com/");
        newsLetter.setHeadImageURL(new URL("http://i.imgur.com/W5NGyai.jpg"));

        return newsLetter.toString();
    }

}
