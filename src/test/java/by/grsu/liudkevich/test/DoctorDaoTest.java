package by.grsu.liudkevich.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import by.grsu.liudkevich.dataaccess.impl.DoctorDao;
import by.grsu.liudkevich.datamodel.Doctor;
import junit.framework.Assert;

public class DoctorDaoTest {

	private static final String TEST_XML_FOLDER = "testXmlFolder";
	private static DoctorDao doctorDao;

	@BeforeClass
	public static void createDao() {
		doctorDao = new DoctorDao(TEST_XML_FOLDER);
	}

		
	@AfterClass
	public static void deleteTestXmlData() {
	//	 write code to clean up test results from FS
		
	}

	@Test
	public void testAdd() {
		System.out.println("Start 'save' test for Doctor");
		final Doctor newDoctor = saveNewDoctor();
		Assert.assertNotNull(doctorDao.get(newDoctor.getId()));
	}

	 @Test
	 public void testDelete() {
	 System.out.println("Start 'delete' test for Doctor");
	 final Doctor newDoctor = saveNewDoctor();
	 doctorDao.delete(newDoctor.getId());
	 Assert.assertNull(doctorDao.get(newDoctor.getId()));
	 }
	
	 @Test
	 public void testGetAll() {
	 System.out.println("Start 'getAll' test for Doctor");
	 final int initialRowsCount = doctorDao.getAll().size();
	 saveNewDoctor();
	 Assert.assertEquals(doctorDao.getAll().size(), initialRowsCount + 1);
	 }

	private Doctor saveNewDoctor() {
		final Doctor newDoctor = new Doctor();
		newDoctor.setName("Michael Johns");
		doctorDao.saveNew(newDoctor);
		return newDoctor;
	}
}