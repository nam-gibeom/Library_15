package la.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import la.Dao.DAOException;

public class BookServiceTest {

	public static void main(String[] args) throws DAOException {
		
		String publish_date = "2026-03-20";
		String current_date = "2026-06-19";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate Publish = LocalDate.parse(publish_date, format);
		LocalDate Current = LocalDate.parse(current_date, format);
		Period.between(Publish, Current);
		
		if ((Period.between(Publish, Current).getYears() >= 1) || (Period.between(Publish, Current).getYears() == 0) && Period.between(Publish, Current).getMonths() >= 3) {
			System.out.println("三ヶ月以上！");
		} else {
			System.out.println("失敗");
		}
		
	}
	
	
}