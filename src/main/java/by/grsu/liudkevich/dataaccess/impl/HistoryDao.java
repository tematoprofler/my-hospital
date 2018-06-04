package by.grsu.liudkevich.dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import by.grsu.liudkevich.dataaccess.AbstractDao;
import by.grsu.liudkevich.datamodel.History;
import by.grsu.liudkevich.table.HistoryTable;

public class HistoryDao extends AbstractDao<HistoryTable, History> implements Serializable{

	public HistoryDao(final String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(History newHistory) {
		// set ID
		newHistory.setId(getNextId());
		// get existing data
		final HistoryTable HistoryTable = deserializeFromXml();
		// add new row
		HistoryTable.getRows().add(newHistory);
		// save data
		serializeToXml(HistoryTable);
		//
	}

	@Override
	public void update(History entity) {
		// get existing data
		final HistoryTable HistoryTable = deserializeFromXml();
		// find by ID
		for (final History row : HistoryTable.getRows()) {
			if (row.getId().equals(entity.getId())) {
				// found!!!
				// copy data
				row.setPatient(entity.getPatient());
				row.setActions(entity.getActions());
				break;
			}
		}
		// save updated table
		serializeToXml(HistoryTable);
	}

	@Override
	public History get(Long id) {
		// get existing data
		final HistoryTable HistoryTable = deserializeFromXml();
		// find by ID
		for (final History row : HistoryTable.getRows()) {
			if (row.getId().equals(id)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public List<History> getAll() {
		// get existing data
		final HistoryTable HistoryTable = deserializeFromXml();
		return HistoryTable.getRows();
	}

	@Override
	public void delete(Long id) {
		// get existing data
		final HistoryTable HistoryTable = deserializeFromXml();
		// find by ID
		History toBeDeleted = null;
		for (final History row : HistoryTable.getRows()) {
			if (row.getId().equals(id)) {
				// found!!!
				toBeDeleted = row;
				break;
			}
		}
		// remove from list
		HistoryTable.getRows().remove(toBeDeleted);
		// save updated table
		serializeToXml(HistoryTable);
	}

	@Override
	protected Class<HistoryTable> getTableClass() {
		return HistoryTable.class;
	}

}
