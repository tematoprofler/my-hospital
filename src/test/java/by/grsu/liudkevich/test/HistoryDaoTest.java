package by.grsu.liudkevich.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import by.grsu.liudkevich.dataaccess.impl.HistoryDao;
import by.grsu.liudkevich.datamodel.Action;
import by.grsu.liudkevich.datamodel.History;
import by.grsu.liudkevich.datamodel.Patient;
import junit.framework.Assert;

public class HistoryDaoTest {

	private static final String TEST_XML_FOLDER = "testXmlFolder";
	private static HistoryDao historyDao;

	@BeforeClass
	public static void createDao() {
		historyDao = new HistoryDao(TEST_XML_FOLDER);
	}

		
	@AfterClass
	public static void deleteTestXmlData() {
	//	 write code to clean up test results from FS
		
	}

	@Test
	public void testAdd() {
		System.out.println("Start 'save' test for History");
		final History newHistory = saveNewHistory();
		Assert.assertNotNull(historyDao.get(newHistory.getId()));
	}

	 @Test
	 public void testDelete() {
	 System.out.println("Start 'delete' test for History");
	 final History newHistory = saveNewHistory();
	 historyDao.delete(newHistory.getId());
	 Assert.assertNull(historyDao.get(newHistory.getId()));
	 }
	
	 @Test
	 public void testGetAll() {
	 System.out.println("Start 'getAll' test for History");
	 final int initialRowsCount = historyDao.getAll().size();
	 saveNewHistory();
	 Assert.assertEquals(historyDao.getAll().size(), initialRowsCount + 1);
	 }

	private History saveNewHistory() {
		final Patient newPatient = new Patient();
		List<Action> actions = new ArrayList<Action>();
		final History newHistory = new History();
		newHistory.setPatient(newPatient);
		newHistory.setActions(actions);
		historyDao.saveNew(newHistory);
		return newHistory;
	}
}