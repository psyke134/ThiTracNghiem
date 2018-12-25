package DAO;

import java.sql.Date;
import java.sql.Time;

public class FormatDAO {
	public static Time minutesToTime(int minutes)
	{
		Time result = new Time(0, 0, 0);
		while(minutes >= 60)
		{
			result.setHours(result.getHours()+1);
			minutes -= 60;
		}
		result.setMinutes(minutes);
		return result;
	}
	public static Time timeCombination(int hours, int minutes)
	{
		Time result = new Time(0, 0, 0);
		result.setHours(hours);
		result.setMinutes(minutes);
		return result;
	}
	public static Date dateCombination(int day, int month, int year)
	{
		Date result = new Date(0, 0, 0);
		result.setDate(day);
		result.setMonth(month);
		result.setYear(year);
		return result;
	}
}
