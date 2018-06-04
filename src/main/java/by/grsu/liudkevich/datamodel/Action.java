package by.grsu.liudkevich.datamodel;

import java.sql.Date;

public class Action extends AbstractModel{
	private Appoinment type;
	private Date date;
	private String performerName;
	private Doctor doctor;
	private Nurse nurse;
}
