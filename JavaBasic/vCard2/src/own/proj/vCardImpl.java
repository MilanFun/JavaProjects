package own.proj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class vCardImpl implements vCard {
    private String fullName;
    private String organization;
    private String gender;
    private Calendar birthday;
    private String email;
    private Map<String, String> phone;

    @Override
    public vCard getInstance(Scanner scanner) {
        vCard res = new vCardImpl();
        ((vCardImpl) res).phone = new HashMap();
        scanner.useDelimiter("\r\n");

        boolean beginFlag = false;
        boolean endFlag = false;
        boolean nameFlag = false;
        boolean genderFlag = false;
        boolean orgFlag = false;
        boolean birthFlag = false;
        boolean emFlag = false;
        boolean phFlag = false;

        while(scanner.hasNext()) {
            String str = scanner.next();

            if(str.equals("BEGIN:VCARD")) {
                beginFlag = true;
            }
            if(str.equals("END:VCARD")) {
                endFlag = true;
            }
            if(!str.contains(":")) {
                throw new InputMismatchException("Does not contains ':' ");
            }

            Scanner sc = new Scanner(str);
            sc.useDelimiter(":");
            String nameOfStatement = sc.next();
            if(nameOfStatement.equals("FN")) {
                nameFlag = true;
                ((vCardImpl) res).fullName = sc.next();
                sc.close();
            }
            if(nameOfStatement.equals("ORG")) {
                orgFlag = true;
                ((vCardImpl) res).organization = sc.next();
                sc.close();
            }
            if(nameOfStatement.equals("GENDER")) {
                String gen = sc.next();
                if(!gen.equals("F") && !gen.equals("M")) {
                    throw new InputMismatchException("Wrong format gender");
                } else {
                    genderFlag = true;
                    ((vCardImpl) res).gender = gen;
                    sc.close();
                }
            }
            if(nameOfStatement.equals("EMAIL")) {
                String mail = sc.next();
                if(!mail.contains("@") && !mail.contains(".ru")) {
                    throw new InputMismatchException("Wrong format email");
                } else {
                    ((vCardImpl) res).email = mail;
                    emFlag = true;
                    sc.close();
                }
            }
            if(nameOfStatement.equals("BDAY")) {
                String date = sc.next();
                if(date.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
                    int year = Integer.parseInt(date.split("-")[2]);
                    int day = Integer.parseInt(date.split("-")[0]);
                    int month = Integer.parseInt(date.split("-")[1]);
                    ((vCardImpl) res).birthday = new GregorianCalendar(year, month - 1, day);
                    birthFlag = true;
                    sc.close();
                } else {
                    throw new InputMismatchException("Wrong format BDAY");
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
                    throw new InputMismatchException("Wrong format of phone number");
                }
                ((vCardImpl) res).phone.put(phoneType, phoneNumber);
                    phFlag = true;

            }
            pScanner.close();
            sc.close();
        }

        if((!beginFlag) || (!endFlag) || (!nameFlag) || (!genderFlag) ||
                (!orgFlag) || (!birthFlag) || (!emFlag) || (!phFlag)) {
            throw new InputMismatchException("Wrong format of vCard fiel");
        }

        scanner.close();
        return res;
    }

    @Override
    public vCard getInstance(String data) {
        Scanner dat = new Scanner(data);
        return getInstance(dat);
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public String getOrganization() {
        return this.organization;
    }

    @Override
    public boolean isWoman() {
        if(this.gender.equals("F")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Calendar getBirthday() {
        return this.birthday;
    }

    @Override
    public Period getAge() {
        Calendar now = Calendar.getInstance();

        LocalDate birth = LocalDateTime.ofInstant(birthday.toInstant(), birthday.getTimeZone().toZoneId()).toLocalDate();
        LocalDate current = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();

        Period period = Period.between(birth, current);

        return period;
    }

    @Override
    public int getAgeYears() {
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
    }

    @Override
    public String getPhone(String type) {
        if(this.phone.containsKey(type)) {
            String s = this.phone.get(type);
            return "(" + s.substring(0,3) + ")" + " " + s.substring(3,6) + "-" + s.substring(6,8) + "-" + s.substring(8,10);
        } else {
            throw new NoSuchElementException("ERROR with get phone number");
        }
    }

    public static void main(String[] args) {
        String GOOD[] = {
                "BEGIN:VCARD\r\nFN:Forrest Gump\r\nORG:Bubba Gump Shrimp Co.\r\nEMAIL:ptukha.aiu@phystech.ru\r\nBDAY:24-11-1991\r\nGENDER:M\r\nTEL;TYPE=HOME:4951234567\r\nEND:VCARD",
                "BEGIN:VCARD\r\nFN:Chuck Norris\r\nORG:Hollywood\r\nEMAIL:aaaal2@mai.ru\r\nGENDER:M\r\nBDAY:10-04-1940\r\nTEL;TYPE=WORK:1234567890\r\nEND:VCARD",
        };
        String BAD[] = {
                "BEGIN:VCARD\r\nFN:Forrest Gump\r\nORG:Bubba Gump Shrimp Co.\r\nGENDER:M\r\nBDAY:06-06-1944\r\nTEL;TYPE=HOME:+1 234-567\r\nEND:VCARD", //wrong phone format
                "BEGIN:VCARD\r\nFN:Chuck Norris\r\nORG:Hollywood\r\nBDAY:10-04-1940\r\nTEL;TYPE=WORK:12345678901\r\nEND:VCARD", //digits > 10
        };
        vCard check = new vCardImpl();
        vCard cc = check.getInstance(GOOD[0]);
        System.out.println(cc.getFullName());
        System.out.println(cc.getOrganization());
        System.out.println(cc.isWoman());
        System.out.println(cc.getGender());
        System.out.println(cc.getAgeYears());
        System.out.println(cc.getAge());
        System.out.println(cc.getPhone("HOME"));
        System.out.println(cc.getEmail());
    }
}
