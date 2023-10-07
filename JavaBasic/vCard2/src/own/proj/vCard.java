package own.proj;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public interface vCard {
    public vCard getInstance(Scanner scanner);

    public vCard getInstance(String data);

    public String getFullName();

    public String getEmail();

    public String getGender();

    public String getOrganization();

    public boolean isWoman();

    public Calendar getBirthday();

    public Period getAge();

    public int getAgeYears();

    public String getPhone(String type);
}
