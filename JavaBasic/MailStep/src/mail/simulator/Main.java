package mail.simulator;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

/*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
abstract class AbstractSendable implements Sendable {

    protected final String from;
    protected final String to;

    public AbstractSendable(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractSendable that = (AbstractSendable) o;

        if (!from.equals(that.from)) {
            return false;
        }
        if (!to.equals(that.to)) {
            return false;
        }

        return true;
    }

}

/*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
class MailMessage extends AbstractSendable {
    private final String message;

    public MailMessage(String from, String to, String message) {
        super(from, to);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }


        MailMessage that = (MailMessage) o;

        if (message != null ? !message.equals(that.message) : that.message != null) {
            return false;
        }

        return true;
    }

}

/*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
class MailPackage extends AbstractSendable {
    private final Package content;

    public MailPackage(String from, String to, Package content) {
        super(from, to);
        this.content = content;
    }

    public Package getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        MailPackage that = (MailPackage) o;

        if (!content.equals(that.content)) {
            return false;
        }

        return true;
    }

}

/*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
class Package {
    private final String content;
    private final int price;

    public Package(String content, int price) {
        this.content = content;
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Package aPackage = (Package) o;

        if (price != aPackage.price) {
            return false;
        }
        if (!content.equals(aPackage.content)) {
            return false;
        }

        return true;
    }
}

/*
Класс, в котором скрыта логика настоящей почты
*/
class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}

class UntrustworthyMailWorker implements MailService {
    private RealMailService rms;
    private MailService[] mailserv; //набор третьих лиц

    public UntrustworthyMailWorker(MailService[] serv) {
        this.mailserv = serv;
        this.rms = new RealMailService();
    }

    public RealMailService getRealMailService() {
        return this.rms;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for(int i = 0; i < this.mailserv.length; i++) {
            mail = this.mailserv[i].processMail(mail);
        }

        return this.rms.processMail(mail);
    }
}

class Spy implements MailService {
    private final Logger logger;
    public static final String AUSTIN_POWERS = "Austin Powers";

    public Spy(final Logger logger) {
        this.logger = logger;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailMessage) {
            MailMessage mail2 = (MailMessage) mail;
            if(mail2.getFrom().equals(AUSTIN_POWERS) || mail2.getTo().equals(AUSTIN_POWERS)) {
                this.logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{mail2.getFrom(), mail2.getTo(), mail2.getMessage()});
            } else {
                this.logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object[]{mail2.getFrom(), mail2.getTo()});
            }
        }
        return mail;
    }
}

class Thief implements MailService {
    private int minValue;
    private int StolenValue;

    public int getStolenValue() {
        return this.StolenValue;
    }

    public Thief(int min) {
        this.minValue = min;
        this.StolenValue = 0;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailPackage) {
            MailPackage mail2 = (MailPackage) mail;
            if(mail2.getContent().getPrice() >= this.minValue) {
                this.StolenValue += mail2.getContent().getPrice();
                return new MailPackage(mail2.getFrom(), mail2.getTo(),
                        new Package("stones instead of " + mail2.getContent().getContent(), 0));
            }
        }
        return mail;
    }
}

class Inspector implements MailService {
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailPackage) {
            MailPackage mail2 = (MailPackage) mail;
            if(mail2.getContent().getContent().equals(WEAPONS) ||
                    mail2.getContent().getContent().equals(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            if(mail2.getContent().getContent().contains("stones")) {
                throw new StolenPackageExceptions();
            }
            return mail2;
        }
        return mail;
    }
}

class StolenPackageExceptions extends RuntimeException {
    public StolenPackageExceptions() {
        super("Discovered the theft from the parcel!");
    }
}

class IllegalPackageException extends RuntimeException {
    public IllegalPackageException() {
        super("IllegalPackageException!");
    }
}