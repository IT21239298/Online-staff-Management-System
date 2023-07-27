package com.airline.entities;

public class Sallary {
		private int sal_id;
		private String month;
		private String year;
		private String  hours;
		private String hour_pay;
		private String full_pay;
		private int empl_id;
		public Sallary(int sal_id, String month, String year, String hours, String hour_pay, String full_pay,int empl_id) {
			super();
			this.sal_id = sal_id;
			this.month = month;
			this.year = year;
			this.hours = hours;
			this.hour_pay = hour_pay;
			this.full_pay = full_pay;
			this.empl_id = empl_id;
		}
		public int getSal_id() {
			return sal_id;
		}
		public String getMonth() {
			return month;
		}
		public String getYear() {
			return year;
		}
		public String getHours() {
			return hours;
		}
		public String getHour_pay() {
			return hour_pay;
		}
		public String getFull_pay() {
			return full_pay;
		}
		public int getEmpl_id() {
			return empl_id;
		}
		
		
		
}
