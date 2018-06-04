package by.grsu.liudkevich.dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import by.grsu.liudkevich.dataaccess.AbstractDao;
import by.grsu.liudkevich.datamodel.Patient;
import by.grsu.liudkevich.table.PatientTable;

public class PatientDao extends AbstractDao<PatientTable, Patient> implements Serializable{

	public PatientDao(final String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(Patient newPatient) {
		// set ID
		newPatient.setId(getNextId());
		// get existing data
		final PatientTable PatientTable = deserializeFromXml();
		// add new row
		PatientTable.getRows().add(newPatient);
		// save data
		serializeToXml(PatientTable);
		//
	}

	@Override
	public void update(Patient entity) {
		// get existing data
		final PatientTable PatientTable = deserializeFromXml();
		// find by ID
		for (final Patient row : PatientTable.getRows()) {
			if (row.getId().equals(entity.getId())) {
				// found!!!
				// copy data
				row.setName(entity.getName());
				row.setDiagnosis(entity.getDiagnosis());
				row.setDischarged(entity.isDischarged());
				row.setAppoinments(entity.getAppoinments());
				break;
			}
		}
		// save updated table
		serializeToXml(PatientTable);
	}

	@Override
	public Patient get(Long id) {
		// get existing data
		final PatientTable PatientTable = deserializeFromXml();
		// find by ID
		for (final Patient row : PatientTable.getRows()) {
			if (row.getId().equals(id)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public List<Patient> getAll() {
		// get existing data
		final PatientTable PatientTable = deserializeFromXml();
		return PatientTable.getRows();
	}

	@Override
	public void delete(Long id) {
		// get existing data
		final PatientTable PatientTable = deserializeFromXml();
		// find by ID
		Patient toBeDeleted = null;
		for (final Patient row : PatientTable.getRows()) {
			if (row.getId().equals(id)) {
				// found!!!
				toBeDeleted = row;
				break;
			}
		}
		// remove from list
		PatientTable.getRows().remove(toBeDeleted);
		// save updated table
		serializeToXml(PatientTable);
	}

	@Override
	protected Class<PatientTable> getTableClass() {
		return PatientTable.class;
	}

}
