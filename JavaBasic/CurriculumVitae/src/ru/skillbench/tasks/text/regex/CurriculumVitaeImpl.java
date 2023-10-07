package ru.skillbench.tasks.text.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae {
    private String text;
    private String FullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<Phone> phoneNum;
    private Map<String, String> hidden = new HashMap<String, String>();

    private final String NAME_PATTERN1 = "(\\b[A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+\\b)";
    private final String NAME_PATTERN2 = "(\\b[A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+\\b)";


    public static void main(String[] args) {
    }

    public void parseName() {
        String fname = getText().split("\n")[0];
        Pattern pat = Pattern.compile(NAME_PATTERN1);
        Matcher mat = pat.matcher(fname);

        if(mat.matches()) {
            this.firstName = mat.group(1);
            this.middleName = mat.group(3);
            this.lastName = mat.group(5);
            this.FullName = this.firstName + " " + this.middleName + " " + this.lastName;
        }

        Pattern pat1 = Pattern.compile(NAME_PATTERN2);
        Matcher mat1 = pat1.matcher(fname);
        if(mat1.matches()) {
            this.firstName = mat1.group(1);
            this.middleName = null;
            this.lastName = mat1.group(3);
            this.FullName = firstName + " " + lastName;
        }

        if(!mat.matches() && !mat1.matches()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        if(this.text == null) {
            throw new IllegalStateException();
        }
        return this.text;
    }

    @Override
    public List<Phone> getPhones() {
        if(this.text == null) {
            throw new IllegalStateException();
        }

        this.phoneNum = new ArrayList<Phone>();
        Pattern pat = Pattern.compile(PHONE_PATTERN);
        Matcher mat = pat.matcher(getText());
        Phone phone;
        while(mat.find()) {
            int areaCode = -1;
            int extension = -1;
            if(mat.group(2) != null) {
                areaCode = Integer.parseInt(mat.group(2));
            }
            if(mat.group(7) != null) {
                extension = Integer.parseInt(mat.group(7));
            }
            phone = new Phone(mat.group(), areaCode, extension);
            this.phoneNum.add(phone);
        }
        return this.phoneNum;
    }

    @Override
    public String getFullName() throws NoSuchElementException, IllegalStateException {
        if(this.text == null) {
            throw new NoSuchElementException();
        }

        parseName();
        if(this.FullName == null) {
            throw new NoSuchElementException();
        }

        return this.FullName;
    }

    @Override
    public String getFirstName() {
        parseName();
        if(this.FullName == null){
            throw new NoSuchElementException();
        }

        return this.firstName;
    }

    @Override
    public String getMiddleName() {
        parseName();
        if(this.FullName == null){
            throw new NoSuchElementException();
        }

        return this.middleName;
    }

    @Override
    public String getLastName() {
        parseName();
        if(this.FullName == null){
            throw new NoSuchElementException();
        }

        return this.lastName;
    }

    @Override
    public void updateLastName(String newLastName) {
        if(this.FullName == null) {
            throw new NoSuchElementException();
        }

        if(this.text == null) {
            throw new IllegalStateException();
        }

        this.lastName = newLastName;
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        if(oldPhone.getNumber() == null || newPhone.getNumber() == null) {
            throw new IllegalArgumentException();
        }

        if(this.text == null) {
            throw new IllegalStateException();
        }

        this.phoneNum.remove(oldPhone);
        this.phoneNum.add(newPhone);
    }

    @Override
    public void hide(String piece) {
        String newText = getText();
        if(newText == null) {
            throw new IllegalStateException();
        } else if(!newText.contains(piece)){
            throw new IllegalArgumentException();
        }

        String xStr = newText.replaceAll("[^\\. @]", "X");
        this.hidden.put(xStr, piece);
        this.text = xStr.replace(piece, xStr);
    }

    @Override
    public void hidePhone(String phone) {
        if((phone == null)){
            throw new IllegalArgumentException();
        }



    }

    @Override
    public int unhideAll() {
        if (this.text == null) {
            throw new IllegalStateException();
        }
        return 0;
    }
}
