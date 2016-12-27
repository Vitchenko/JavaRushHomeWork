package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.IPQuery;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**Класс, который будет отвечать за парсинг логов называется LogParser.
 1.1.	Добавь в класс LogParser конструктор с парметром Path logDir, где logDir -
 директория с логами (логов может быть несколько, все они должны иметь расширение log).
 1.2.	Реализуй интерфейс IPQuery у класса LogParser:
 1.2.1.+ Метод getNumberOfUniqueIPs(Date after, Date before) должен возвращать
 количество уникальных IP адресов за выбранный период. Здесь и далее,
 если в методе есть параметры Date after и Date before, то нужно возвратить
 данные касающиеся только данного периода (включая даты after и before).
 Если параметр after равен null, то нужно обработать все записи, у которых
 дата меньше или равна before.
 Если параметр before равен null, то нужно обработать все записи, у которых
 дата больше или равна after.
 Если и after, и before равны null, то нужно обработать абсолютно все записи
 (без фильтрации по дате).
 1.2.2.+	Метод getUniqueIPs() должен возвращать множество, содержащее все
 неповторяющиеся IP. Тип в котором будем хранить IP будет String.
 1.2.3.+	Метод getIPsForUser() должен возвращать IP, с которых работал
 переданный пользователь.
 1.2.4.	Метод getIPsForEvent() должен возвращать IP, с которых было произведено
 переданное событие.
 1.2.5.	Метод getIPsForStatus() должен возвращать IP, события с которых
 закончилось переданным статусом.
 */
public class LogParser implements IPQuery{

    private Path logDir;
    private List<String> linesList;

    public LogParser(Path logDir)
    {
        this.logDir = logDir;
        linesList = getLinesList();
    }

    private List<String> getLinesList()
    {
        String[] files = logDir.toFile().list(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".log");
            }
        });

        List<String> lines = new ArrayList<>();
        for (String file : files)
        {
            try
            {
                lines.addAll(Files.readAllLines(Paths.get(logDir + File.separator + file), Charset.defaultCharset()));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return lines;
    }

    private void addStringEntity(Date after, Date before, Set<String> enteties, String[] parts, int part)
    {
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(parts[part]);
        }
    }

    private void addDateEntity(Date after, Date before, Set<Date> enteties, String[] parts)
    {
        Date lineDate = getDate(parts[2]);
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(lineDate);
        }
    }

    private void addEventEntity(Date after, Date before, Set<Event> enteties, String[] parts)
    {
        Event lineEvent = Event.valueOf(parts[3].split(" ")[0]);
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(lineEvent);
        }
    }

    private boolean isCompatibleDate(long lineDateTime, Date after, Date before)
    {
        if (after == null && before == null)
        {
            return true;
        } else if (after == null)
        {
            if (lineDateTime <= before.getTime())
            {
                return true;
            }
        } else if (before == null)
        {
            if (lineDateTime >= after.getTime())
            {
                return true;
            }
        } else
        {
            if (lineDateTime >= after.getTime() && lineDateTime <= before.getTime())
            {
                return true;
            }
        }
        return false;
    }

    private Date getDate(String part)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try
        {
            date = dateFormat.parse(part);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before)
    {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before)
    {
        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            addStringEntity(after, before, uniqueIPs, parts, 0);
        }
        return uniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before)
    {
        Set<String> IPsForUser = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (user.equals(parts[1]))
            {
                addStringEntity(after, before, IPsForUser, parts, 0);
            }
        }
        return IPsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before)
    {
        Set<String> IPsForEvent = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (event.toString().equals(parts[3].split(" ")[0]))
            {
                addStringEntity(after, before, IPsForEvent, parts, 0);
            }
        }
        return IPsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before)
    {
        Set<String> IPsForEvent = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (status.toString().equals(parts[4]))
            {
                addStringEntity(after, before, IPsForEvent, parts, 0);
            }
        }
        return IPsForEvent;
    }
}