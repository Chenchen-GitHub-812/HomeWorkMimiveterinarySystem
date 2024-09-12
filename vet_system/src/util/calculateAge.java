package util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class calculateAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	public void calculateforAge(JTextField birthday , JTextPane age) {
		String BirthDateString = birthday.getText();  // 取得輸入的生日
        DateTimeFormatter formatterBirthday = DateTimeFormatter.ofPattern("yyyy/MM/dd");  // 指定日期格式
        
        try {
            LocalDate birthDate = LocalDate.parse(BirthDateString, formatterBirthday);  // 將生日字串轉換為 LocalDate
            LocalDate today = LocalDate.now();  // 獲取當前日期
            int yearsold = Period.between(birthDate, today).getYears();  // 計算年齡
            age.setText(String.valueOf(yearsold));  // 顯示年齡
        } catch (DateTimeParseException ex) {
            // 若日期格式不正確，顯示錯誤訊息
            age.setText("");
	}
}

}