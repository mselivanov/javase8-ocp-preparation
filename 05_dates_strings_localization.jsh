// Date and datetime
// New classes for working with dates and time are in java.time package
import java.time.*;
import java.time.temporal.*;
import static java.lang.System.*;
import static java.lang.String.*;
import java.text.*;

LocalDate dateNow = LocalDate.now();
LocalTime timeNow = LocalTime.now();
LocalDateTime dtNow = LocalDateTime.now();
out.println(format("LocalDate.now(): %s", dateNow));
out.println(format("LocalTime.now(): %s", timeNow));
out.println(format("LocalDateTime.now(): %s", dtNow));

// Create LocalDate, LocalTime, LocalDateTime using factory methods
LocalDate d1 = LocalDate.of(2018, Month.JANUARY, 30)
out.println(format("LocalDate.of(2018, Month.JANUARY, 30): %s", d1));

// Use factory method supplying hour, minute, second and nanosecond
LocalTime t1 = LocalTime.of(22, 13, 32, 12345)
out.println(format("LocalTime.of(22, 13, 32): %s", t1));

// Use 2 factory methods for creating LocalDateTime
LocalDateTime dt1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
out.println(format("LocalDateTime.of(LocalDate.now(), LocalTime.now()): %s", dt1));
LocalDateTime dt2 = LocalDateTime.of(2018, Month.APRIL, 1, 13, 14, 15);
out.println(format("LocalDateTime.of(2018, Month.APRIL, 1, 13, 14, 15): %s", dt2));



// For date/time with time zone we use ZonedDateTime
ZoneId zone = ZoneId.of("Asia/Kolkata");
out.println(format("ZoneId.of(\"Asia/Kolkata\") = %s", zone));

ZonedDateTime zdt1 = ZonedDateTime.of(2018, 4, 1, 20, 0, 0, 0, zone); 
out.println(format("ZonedDateTime.of(2018, 4, 1, 20, 0, 0, 0, zone) = %s", zdt1));
out.println("All available time zones:");
// Uncomment next line to output all time zones
// ZoneId.getAvailableZoneIds().stream().sorted((s1, s2)->s1.length() - s2.length()).forEach(out::println);

// Manipulating dates
LocalDate d2 = LocalDate.now().plusDays(10).plusWeeks(2).plusMonths(1).plusYears(1);
out.println(format("LocalDate.now().plusDays(10).plusWeeks(2).plusMonths(1).plusYears(1) = %s", d2));
LocalDate d3 = d2.minusYears(1).minusMonths(1).minusWeeks(2).minusDays(10);
out.println(format("d2.minusYears(1).minusMonths(1).minusWeeks(2).minusDays(10) = %s", d3));

// Converting LocalDate and LocalDateTime to long (to epoch)
out.println(format("LocalDate.now().toEpochDate() = %s", LocalDate.now().toEpochDay()));
out.println(format("LocalDateTime.now().toEpochSecond() = %s", LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)));

// Working with time periods
Period periodMonth = Period.ofMonths(1);
out.println(format("Period.ofMonths(1) = %s", periodMonth));
Period periodYear = Period.ofYears(1);
out.println(format("Period.ofYears(1) = %s", periodYear));
Period periodDay = Period.ofDays(1);
out.println(format("Period.ofDays(1) = %s", periodDay));
Period periodWeek = Period.ofWeeks(1);
out.println(format("Period.ofWeeks(1) = %s", periodWeek));
Period periodCustom = Period.of(1, 2, 3);
out.println(format("Period.of(1, 2, 3) = %s", periodCustom));
out.println(format("LocalDate.now().plus(periodMonth) = %s", LocalDate.now().plus(periodMonth)));
Duration daily = Duration.ofDays(1);
out.println(format("Duration.ofDays(1) = %s", daily));
Duration hourly = Duration.ofHours(1);
out.println(format("Duration.ofHours(1) = %s", hourly));
Duration minute = Duration.ofMinutes(1);
out.println(format("Duration.ofMinutes(1) = %s", minute));

Duration customDuration = Duration.of(230, ChronoUnit.HOURS);
out.println(format("Duration.of(230, ChronoUnit.HOURS) = %s", customDuration));
Duration nanoDuration = Duration.ofNanos(230);
out.println(format("Duration.ofNanos(230) = %s", nanoDuration));

// Using ChronoUnit to calculate amount of time between two temporal objects
long numOfDays = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.of(1981, 11, 15));
out.println(format("ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.of(1981, 11, 15)) = %d", numOfDays));

// Working with Instants.
Instant now = Instant.now();
Thread.sleep(1000);
Instant later = Instant.now();
out.println(format("Instant.now() - Instant.now() after 1 second = %s", Duration.between(later, now)));

// Converting ZonedDateTime to Instant
ZoneId zone = ZoneId.of("Europe/Athens");
LocalDate ld1 = LocalDate.of(2018, 2, 21);
LocalTime lt1 = LocalTime.of(20, 2, 12);
ZonedDateTime zdt1 = ZonedDateTime.of(ld1, lt1, zone);
out.println(format("ZonedDateTime zdt1 = %s", zdt1));
out.println(format("zdt1.toInstant() = %s", zdt1.toInstant()));

long nowInSeconds = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
Instant instant = Instant.ofEpochSecond(nowInSeconds);
out.println(format("Instant.ofEpochSecond() = %s", instant));
out.println(format("instant.plus(1, ChronoUnits.DAYS) = %s", instant.plus(1, ChronoUnit.DAYS)));
out.println(format("instant.plus(1, ChronoUnits.HOURS) = %s", instant.plus(1, ChronoUnit.HOURS)));

// Daylight savings example
LocalDate springChangeDate = LocalDate.of(2016, Month.MARCH, 13);
LocalTime timeBeforeChange = LocalTime.of(1, 30, 0);
ZoneId usZone = ZoneId.of("US/Eastern");
ZonedDateTime zonedDateTimeOfChange = ZonedDateTime.of(springChangeDate, timeBeforeChange, usZone);
ZonedDateTime anHourLater = zonedDateTimeOfChange.plusHours(1);
out.println(format("US/Eastern 1:30 Am = %s", zonedDateTimeOfChange));
out.println(format("US/Easter 1:30 AM + 1 hour at date of change = %s", anHourLater));

// Common String methods
String s = " abcde ";
out.println(format("String s = %s", s));
out.println(format("s.trim() = %s", s.trim()));
out.println(format("s.length() = %d", s.length()));
out.println(format("s.substring(1, 4) = %s", s.substring(1, 4)));
out.println(format("s.indexOf('b') = %d", s.indexOf('b')));
out.println(format("s.indexOf(\"de\") = %d", s.indexOf("de")));
out.println(format("s.charAt(2) = %s", s.charAt(2)));
out.println(format("s.contains(\"cd\") = %s", s.contains("cd")));
out.println(format("s.replace(\"ab\", \"!\") = %s", s.replace("ab", "!")));
out.println(format("s.toUpperCase() = %s", s.toUpperCase()));
out.println(format("s.startsWith(\" ab\") = %s", s.startsWith(" ab")));

// Localization and Internationalization
Locale defaultLocale = Locale.getDefault();
out.println(format("Default locale: %s", defaultLocale));
out.println(format("Locale.GERMANY = %s", Locale.GERMANY));
out.println(format("new Locale(\"fr\", \"CA\") = %s", new Locale("fr", "CA")));
out.println(format("new Locale.Builder().setLanguage(\"en\").setRegion(\"UK\").build() = %s", new Locale.Builder().setLanguage("en").setRegion("UK").build()));

// Number formatting
Locale.setDefault(new Locale("ru", "RU"));
NumberFormat number = NumberFormat.getInstance(new Locale("ru", "RU"));
NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
out.println(format("124145.12 in ru_RU locale = %s", number.format(124145.12)));
out.println(format("123.12 rubles in ru_RU locale = %s", currency.format(123.12)));

