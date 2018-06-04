package by.grsu.liudkevich.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import by.grsu.liudkevich.dataaccess.impl.NurseDao;
import by.grsu.liudkevich.datamodel.Nurse;
import junit.framework.Assert;

public class NurseDaoTest {

	private static final String TEST_XML_FOLDER = "testXmlFolder";
	private static NurseDao nurseDao;

	@BeforeClass
	public static void createDao() {
		nurseDao = new NurseDao(TEST_XML_FOLDER);
	}

		
	@AfterClass
	public static void deleteTestXmlData() {
	//	 write code to clean up test results from FS
		
	}

	@Test
	public void testAdd() {
		System.out.println("Start 'save' test for Nurse");
		final Nurse newNurse = saveNewNurse();
		Assert.assertNotNull(nurseDao.get(newNurse.getId()));
	}

	 @Test
	 public void testDelete() {
	 System.out.println("Start 'delete' test for Nurse");
	 final Nurse newNurse = saveNewNurse();
	 nurseDao.delete(newNurse.getId());
	 Assert.assertNull(nurseDao.get(newNurse.getId()));
	 }
	
	 @Test
	 public void testGetAll() {
	 System.out.println("Start 'getAll' test for Nurse");
	 final int initialRowsCount = nurseDao.getAll().size();
	 saveNewNurse();
	 Assert.assertEquals(nurseDao.getAll().size(), initialRowsCount + 1);
	 }

	private Nurse saveNewNurse() {
		final Nurse newNurse = new Nurse();
		newNurse.setName("Aghata Kristie");
		nurseDao.saveNew(newNurse);
		return newNurse;
	}
}