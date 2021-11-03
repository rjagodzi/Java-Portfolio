package Cwiczenie1;

import java.util.*;
import java.text.*;

public class DzienTygodnia {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj datę (format: dd-MM-yyyy): ");
        String data = sc.nextLine();

        Locale locale = new Locale("pl", "PL");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", locale);

        try {
            Date date = sdf.parse(data);
            GregorianCalendar kalendarz = (GregorianCalendar) GregorianCalendar.getInstance(locale);
            kalendarz.setTime(date);

            System.out.println("Dzień tygodnia: " + kalendarz.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale));
            kalendarz.add(Calendar.YEAR, 1);
            System.out.println("Dzień tygodnia za rok: ");
        } catch (ParseException e) {
            System.out.println("Nieprawidłowy format (dzień-miesiąc-rok)!");
            System.out.println("Spróbuj ponownie.");
        }
    }
}
