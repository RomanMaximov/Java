package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("SSD");
        logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                new Object[]{"A", "B", "C"});

    }
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static class UntrustworthyMailWorker implements MailService {
        private static MailService[] ms;
        private static RealMailService realMan = new RealMailService();

        public UntrustworthyMailWorker (MailService[] ms){
            this.ms = ms;
        }

        public MailService getRealMailService() {
            return realMan;
        }
        @Override
        public Sendable processMail(Sendable mail) {
            Sendable temp = mail;
            for (int i = 0; i < this.ms.length; ++i) {
                temp = this.ms[i].processMail(temp);
            }
            return getRealMailService().processMail(temp);
        }
    }

    public static class Thief implements MailService {
        public int totalPrice = 0;
        public int minPrice = 0;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }
        public int getStolenValue() {
            return totalPrice;
        }
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getPrice() > minPrice) {
                    totalPrice += ((MailPackage) mail).getContent().getPrice();
                    return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of "
                            + ((MailPackage) mail).getContent().getContent(), 0));
                }
            }
            return mail;
        }
    }

    public static class Spy implements MailService {
        public final Logger logger;
        public Spy (Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().equals(AUSTIN_POWERS) | mail.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if ( ((MailPackage) mail).getContent().getContent().contains("weapons")
                        || ((MailPackage) mail).getContent().getContent().contains("banned substance")) {
                    throw new IllegalPackageException();
                }
                if ( ((MailPackage) mail).getContent().getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {}
        public IllegalPackageException(String message)
        {
            super(message);
        }
    }
    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {}
        public StolenPackageException(String message)
        {
            super(message);
        }
    }
}
