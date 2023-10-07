package ru.skillbench.tasks.text.regex;

import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae {
    private String text = null;
    private HashMap<String, String> hide = new HashMap<>();

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        if(this.text == null) {
            throw new IllegalStateException("ERROR in method getText: text is null");
        }
        return this.text;
    }

    @Override
    public List<Phone> getPhones() {
        if(text == null) {
            throw new IllegalStateException("ERROR in method getPhones: text is null");
        }
        List<Phone> list = new ArrayList<>();

        Pattern pat = Pattern.compile(PHONE_PATTERN);
        Matcher mat = pat.matcher(text);

        while (mat.find()) {
            String phonetext = mat.group();

            int areaCode = Integer.parseInt(mat.group(2) == null ? "-1" : mat.group(2));
            int extension = Integer.parseInt(mat.group(7) == null ? "-1" : mat.group(7));

            Phone phone = new Phone(phonetext, areaCode, extension);
            list.add(phone);
        }

        return list;
    }

    @Override
    public String getFullName() {
        if(text == null) {
            throw new IllegalStateException("ERROR in method getFullName: text is null");
        }

        String patternSource = "(([A-Z]([a-z]*[.]?)?\\s)([A-Z]([a-z]*[.]?)?\\R|([A-Z]([a-z]*[.]?)?)(\\s[A-Z]([a-z]*[.]?)?)\\R))";

        Pattern pat = Pattern.compile(patternSource);
        Matcher mat = pat.matcher(text);

        if(mat.find()) {
            return mat.group().trim();
        }else {
            throw new NoSuchElementException("Name is not correct");
        }
    }

    @Override
    public String getFirstName() {
        String name = getFullName();
        return name.split(" ")[0];
    }

    @Override
    public String getMiddleName() {
        String name = getFullName();
        return name.split(" ").length == 3 ? name.split(" ")[1] : null;
    }

    @Override
    public String getLastName() {
        String name = getFullName();
        return name.split(" ")[name.split(" ").length - 1];
    }

    @Override
    public void updateLastName(String newLastName) {
        String lastName = getLastName();
        text = text.replaceFirst(lastName, newLastName);
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        List<Phone> phones = getPhones();
        if(phones.stream().filter(phone -> phone.getNumber().equals(oldPhone.getNumber())).findAny().orElse(null) == null) {
            throw new IllegalArgumentException("Hasn't phone: " + oldPhone);
        } else {
            text = text.replaceAll(oldPhone.getNumber(), newPhone.getNumber());
        }
    }

    @Override
    public void hide(String piece) {
        if(text == null) {
            throw new IllegalStateException("ERROR in method hide: text is null");
        }
        if(!text.contains(piece)) {
            throw new IllegalArgumentException();
        }

        String xxStr = piece.replaceAll("[^. @]", "X");
        this.hide.put(xxStr, piece);
        text = text.replace(piece, xxStr);
    }

    @Override
    public void hidePhone(String phone) {
        if(text == null) {
            throw new IllegalStateException("ERROR in method hidePhone: text is null");
        }
        if(!text.contains(phone)) {
            throw new IllegalArgumentException();
        }

        String xStrPhone = phone.replaceAll("[\\d]", "X");
        this.hide.put(xStrPhone, phone);
        text = text.replace(phone, xStrPhone);
    }

    @Override
    public int unhideAll() {
        if(text == null) {
            throw new IllegalStateException("ERROR in method unhiddeAll: text is null");
        }
        int counter = 0;

        for(Map.Entry<String, String> entry : hide.entrySet()) {
            text = text.replaceAll(entry.getKey().replaceAll("\\(", "\\\\\\(").replaceAll("\\)", "\\\\\\)"), entry.getValue());
            counter++;
        }
        return counter;
    }
}
