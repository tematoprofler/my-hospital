package by.grsu.liudkevich.datamodel;

import java.util.List;

public class Patient extends AbstractModel {
	private String name;
	private String diagnosis;
	private List<Appoinment> appoinments;

	private boolean discharged;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public List<Appoinment> getAppoinments() {
		return appoinments;
	}

	public void setAppoinments(List<Appoinment> appoinments) {
		this.appoinments = appoinments;
	}

	public boolean isDischarged() {
		return discharged;
	}


	public void setDischarged(boolean discharged) {
		this.discharged = discharged;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((appoinments == null) ? 0 : appoinments.hashCode());
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + (discharged ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (appoinments == null) {
			if (other.appoinments != null)
				return false;
		} else if (!appoinments.equals(other.appoinments))
			return false;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (discharged != other.discharged)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	
}