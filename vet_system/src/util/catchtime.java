package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class catchtime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JLabel time = new JLabel("");
		catchtime ct = new catchtime();
		ct.catchtimenow(time);
		System.out.println(time.getText());
		
	}
	
	public void catchtimenow(JLabel datetime)
	{
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
		String formatterDateTime = now.format(formatter);
		datetime.setText(formatterDateTime);
		
	}
	
	public void catchdate(JLabel Date)
	{
		LocalDate today= LocalDate.now();
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattertoday = today.format(dateformatter);
		Date.setText(formattertoday);
	}
	
	public void catchtime(JLabel time)
	{
		LocalTime timenow = LocalTime.now();
		DateTimeFormatter timenowformatter= DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattertime=timenow.format(timenowformatter);
		time.setText(formattertime);
	}
}
