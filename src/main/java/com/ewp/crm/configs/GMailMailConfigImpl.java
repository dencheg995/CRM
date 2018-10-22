package com.ewp.crm.configs;

import com.ewp.crm.configs.inteface.MailConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:./gmail.properties")
public class GMailMailConfigImpl implements MailConfig {

    private String login;
    private String password;
    private String mailFrom;
    private String socketFactoryClass;
    private String socketFactoryFallback;
    private String protocol;
    private String port;
    private String useTls;
    private String debug;
    private String imapServer;

    private static Logger logger = LoggerFactory.getLogger(GMailMailConfigImpl.class);

    @Autowired
    public GMailMailConfigImpl(Environment env) {
        try {
            login = env.getRequiredProperty("google.mail.login");//.replaceAll("@", "%40");
            password = env.getRequiredProperty("google.mail.password");
            mailFrom = env.getRequiredProperty("mail.from");
            socketFactoryClass = env.getRequiredProperty("mail.imap.socketFactory.class");
            socketFactoryFallback = env.getRequiredProperty("mail.imap.socketFactory.fallback");
            protocol = env.getRequiredProperty("mail.store.protocol");
//            port = env.getRequiredProperty("mail.tls.port");
//            useTls = env.getRequiredProperty("mail.smtp.starttls.enable");
            debug = env.getRequiredProperty("mail.debug");
            imapServer = env.getRequiredProperty("mail.imap.server");
            logger.warn("login: {}, pass: {}, mailFrom: {}, socFacCl: {}, socFacCb: {}, protocol: {}, " +
                    "debug: {}, imapSer: {}", login, password, mailFrom, socketFactoryClass, socketFactoryFallback,
                    protocol, debug, imapServer);
            if (login.isEmpty() || password.isEmpty() || mailFrom.isEmpty() || socketFactoryClass.isEmpty() ||
                    socketFactoryFallback.isEmpty() || protocol.isEmpty() || debug.isEmpty() || imapServer.isEmpty()) {
                throw new NullPointerException();
            }
        } catch (IllegalStateException | NullPointerException e) {
            logger.error("GMail configs have not initialized. Check gmail.properties file");
            System.exit(-1);
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public String getSocketFactoryClass() {
        return socketFactoryClass;
    }

    public String getSocketFactoryFallback() {
        return socketFactoryFallback;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDebug() {
        return debug;
    }

    public String getImapServer() {
        return imapServer;
    }
}
