package by.grsu.liudkevich.dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import by.grsu.liudkevich.dataaccess.AbstractDao;
import by.grsu.liudkevich.datamodel.Nurse;
import by.grsu.liudkevich.table.NurseTable;

public class NurseDao extends AbstractDao<NurseTable, Nurse> implements Serializable{

	public NurseDao(final String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(Nurse newNurse) {
		// set ID
		newNurse.setId(getNextId());
		// get existing data
		final NurseTable NurseTable = deserializeFromXml();
		// add new row
		NurseTable.getRows().add(newNurse);
		// save data
		serializeToXml(NurseTable);
		//
	}

	@Override
	public void update(Nurse entity) {
		// get existing data
		final NurseTable NurseTable = deserializeFromXml();
		// find by ID
		for (final Nurse row : NurseTable.getRows()) {
			if (row.getId().equals(entity.getId())) {
				// found!!!
				// copy data
				row.setName(entity.getName());
				break;
			}
		}
		// save updated table
		serializeToXml(NurseTable);
	}

	@Override
	public Nurse get(Long id) {
		// get existing data
		final NurseTable NurseTable = deserializeFromXml();
		// find by ID
		for (final Nurse row : NurseTable.getRows()) {
			if (row.getId().equals(id)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public List<Nurse> getAll() {
		// get existing data
		final NurseTable NurseTable = deserializeFromXml();
		return NurseTable.getRows();
	}

	@Override
	public void delete(Long id) {
		// get existing data
		final NurseTable NurseTable = deserializeFromXml();
		// find by ID
		Nurse toBeDeleted = null;
		for (final Nurse row : NurseTable.getRows()) {
			if (row.getId().equals(id)) {
				// found!!!
				toBeDeleted = row;
				break;
			}
		}
		// remove from list
		NurseTable.getRows().remove(toBeDeleted);
		// save updated table
		serializeToXml(NurseTable);
	}

	@Override
	protected Class<NurseTable> getTableClass() {
		return NurseTable.class;
	}

}
