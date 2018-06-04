package by.grsu.liudkevich.table;

import java.util.ArrayList;
import java.util.List;

import by.grsu.liudkevich.datamodel.History;

public class HistoryTable extends AbstractTable<History>{
	private List<History> rows;

	@Override
	public List<History> getRows() {
		if (rows == null) {
			rows = new ArrayList<History>();
		}
		return rows;
	}

	@Override
	public void setRows(List<History> rows) {
		this.rows = rows;
	}
}
