package com.Employee.EmployeeDetails.Exception;

import java.util.Date;

public class ExceptionResponse 
{
		private Date time;
		private String msg;
		private String Details;
		
		
		public ExceptionResponse(Date time, String msg, String details) {
			super();
			this.time = time;
			this.msg = msg;
			Details = details;
		}
		public Date getTime() {
			return time;
		}
		public String getMsg() {
			return msg;
		}
		public String getDetails() {
			return Details;
		}
	
	
}
