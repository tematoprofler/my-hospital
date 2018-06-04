package by.grsu.liudkevich.dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import by.grsu.liudkevich.dataaccess.AbstractDao;
import by.grsu.liudkevich.datamodel.Doctor;
import by.grsu.liudkevich.table.DoctorTable;

public class DoctorDao extends AbstractDao<DoctorTable, Doctor> implements Serializable{

	public DoctorDao(final String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(Doctor newDoctor) {
		// set ID
		newDoctor.setId(getNextId());
		// get existing data
		final DoctorTable DoctorTable = deserializeFromXml();
		// add new row
		DoctorTable.getRows().add(newDoctor);
		// save data
		serializeToXml(DoctorTable);
		//
	}

	@Override
	public void update(Doctor entity) {
		// get existing data
		final DoctorTable DoctorTable = deserializeFromXml();
		// find by ID
		for (final Doctor row : DoctorTable.getRows()) {
			if (row.getId().equals(entity.getId())) {
				// found!!!
				// copy data
				row.setName(entity.getName());
				break;
			}
		}
		// save updated table
		serializeToXml(DoctorTable);
	}

	@Override
	public Doctor get(Long id) {
		// get existing data
		final DoctorTable DoctorTable = deserializeFromXml();
		// find by ID
		for (final Doctor row : DoctorTable.getRows()) {
			if (row.getId().equals(id)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public List<Doctor> getAll() {
		// get existing data
		final DoctorTable DoctorTable = deserializeFromXml();
		return DoctorTable.getRows();
	}

	@Override
	public void delete(Long id) {
		// get existing data
		final DoctorTable DoctorTable = deserializeFromXml();
		// find by ID
		Doctor toBeDeleted = null;
		for (final Doctor row : DoctorTable.getRows()) {
			if (row.getId().equals(id)) {
				// found!!!
				toBeDeleted = row;
				break;
			}
		}
		// remove from list
		DoctorTable.getRows().remove(toBeDeleted);
		// save updated table
		serializeToXml(DoctorTable);
	}

	@Override
	protected Class<DoctorTable> getTableClass() {
		return DoctorTable.class;
	}

}
