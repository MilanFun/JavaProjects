package ru.skillbench.tasks.text;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContactCardImpl implements ContactCard {
    private String fullName;
    private String org;
    private String gender;
    private Calendar birthday;
    private Map<String, String> phoneNumber;

    public static void main(String[] args) {
        String GOOD[] = {
                "BEGIN:VCARD\r\nFN:Forrest Gump\r\nORG:Bubba Gump Shrimp Co.\r\nBDAY:24-11-1991\r\nGENDER:M\r\nTEL;TYPE=HOME:4951234567\r\nEND:VCARD",
                "BEGIN:VCARD\r\nFN:Chuck Norris\r\nORG:Hollywood\r\nBDAY:10-04-1940\r\nTEL;TYPE=WORK:1234567890\r\nEND:VCARD",
        };
        String BAD[] = {
                "BEGIN:VCARD\r\nFN:Forrest Gump\r\nORG:Bubba Gump Shrimp Co.\r\nGENDER:M\r\nBDAY:06-06-1944\r\nTEL;TYPE=HOME:+1 234-567\r\nEND:VCARD", //wrong phone format
                "BEGIN:VCARD\r\nFN:Chuck Norris\r\nORG:Hollywood\r\nBDAY:10-04-1940\r\nTEL;TYPE=WORK:12345678901\r\nEND:VCARD", //digits > 10
        };
        ContactCard check = new ContactCardImpl();
        ContactCard cc = check.getInstance(GOOD[0]);
        System.out.println(cc.getFullName());
        System.out.println(cc.getOrganization());
        System.out.println(cc.isWoman());
        System.out.println(cc.getAgeYears());
        System.out.println(cc.getAge());
        System.out.println(cc.getAge().getYears());
        System.out.println(cc.getPhone("HOME"));
    }

    @Override
    public ContactCard getInstance(Scanner scanner) {
        ContactCard contCrd = new ContactCardImpl();
        ((ContactCardImpl) contCrd).phoneNumber = new HashMap();
        scanner.useDelimiter("\r\n");

        @SuppressWarnings("unused")
        boolean beginFlag = false, endFlag = false, fnFlag = false, orgFlag = false;

        while(scanner.hasNext()) {
            String str = scanner.next();

            if (str.equals("BEGIN:VCARD")) {
                beginFlag = true;
            }
            if (str.equals("END:VCARD")) {
                endFlag = true;
            }
            if (!str.contains(":")) {
                throw new InputMismatchException("Wrong format");
            }

            Scanner sc = new Scanner(str);
            sc.useDelimiter(":");
            String fName = sc.next();
            if (fName.equals("FN")) {
                fnFlag = true;
                ((ContactCardImpl) contCrd).fullName = sc.next();
                sc.close();
            }
            if (fName.equals("ORG")) {
                orgFlag = true;
                ((ContactCardImpl) contCrd).org = sc.next();
                sc.close();
            }
            if (fName.equals("GENDER")) {
                String gen = sc.next();
                sc.close();
                if (!gen.equals("F") && !gen.equals("M")) {
                    throw new InputMismatchException("Wrong format2");
                } else {
                    ((ContactCardImpl) contCrd).gender = gen;
                }
            }
            if (fName.equals("BDAY")) {
                String date = sc.next();
                if (date.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
                    int day = Integer.parseInt(date.split("-")[0]);
                    int month = Integer.parseInt(date.split("-")[1]);
                    int year = Integer.parseInt(date.split("-")[2]);
                    ((ContactCardImpl) contCrd).birthday = new GregorianCalendar(year, month - 1, day);
                    sc.close();
                } else {
                    throw new InputMismatchException("Wrong format3");
                }
            }

            Scanner pScanner = new Scanner(str);
            pScanner.useDelimiter(";");
            if (pScanner.hasNext("TEL")) {
                pScanner.next();
                Scanner anotherPhoneScanner = new Scanner(pScanner.next());
                anotherPhoneScanner.useDelimiter("=");
                anotherPhoneScanner.next();
                String[] phoneInfo = anotherPhoneScanner.next().split(":");
                anotherPhoneScanner.close();

                String phoneType = phoneInfo[0];
                String phoneNumber = phoneInfo[1];
                if (!phoneNumber.matches("[0-9]{10}")) {
                    throw new InputMismatchException("Wrong format4");
                }

                ((ContactCardImpl) contCrd).phoneNumber.put(phoneType, phoneNumber);
            }
            pScanner.close();
            sc.close();

        }

        if ((!fnFlag) || (!orgFlag) || (!beginFlag) || (!endFlag)) {
            throw new NoSuchElementException("Field not found");
        }

        scanner.close();
        return contCrd;

    }

    @Override
    public ContactCard getInstance(String data) {
        Scanner scan = new Scanner(data);
        return this.getInstance(scan);
    }

    @Override
    public String getFullName() {
            return this.fullName;
    }

    @Override
    public String getOrganization() {
        return this.org;
    }

    @Override
    public boolean isWoman() {
        boolean flag = false;

        if (this.gender == null || this.gender.equals("M")) {
            flag = false;
        } else if (this.gender.equals("F")) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Calendar getBirthday() {
        if(this.birthday != null) {
            return this.birthday;
        } else {
            throw new NoSuchElementException("No birthday");
        }
    }

    @Override
    public Period getAge() {
        if (birthday == null)
            throw new NoSuchElementException();

        Calendar now = Calendar.getInstance();

        LocalDate birth = LocalDateTime.ofInstant(birthday.toInstant(), birthday.getTimeZone().toZoneId()).toLocalDate();
        LocalDate current = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();

        Period period = Period.between(birth, current);

        return period;
    }

    @Override
    public int getAgeYears() {
        if(this.birthday != null) {
            Calendar today = GregorianCalendar.getInstance();
            Calendar birth = GregorianCalendar.getInstance();

            birth.set(this.birthday.get(Calendar.YEAR), this.birthday.get(Calendar.MONTH), this.birthday.get(Calendar.DAY_OF_MONTH));

            int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

            if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH) ||
                    today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) &&
                            today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
                age--;
            }
            return age;
        } else {
            throw new NoSuchElementException("Birthday not found");
        }
    }

    @Override
    public String getPhone(String type) {
        if (this.phoneNumber.containsKey(type)) {
            return this.phoneNumber.get(type);
        } else {
            throw new NoSuchElementException();
        }
    }
}