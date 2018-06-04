package by.grsu.liudkevich.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import by.grsu.liudkevich.dataaccess.impl.PatientDao;
import by.grsu.liudkevich.datamodel.Appoinment;
import by.grsu.liudkevich.datamodel.Patient;
import junit.framework.Assert;

public class PatientDaoTest {

	private static final String TEST_XML_FOLDER = "testXmlFolder";
	private static PatientDao patientDao;

	@BeforeClass
	public static void createDao() {
		patientDao = new PatientDao(TEST_XML_FOLDER);
	}

		
	@AfterClass
	public static void deleteTestXmlData() {
	//	 write code to clean up test results from FS
		
	}

	@Test
	public void testAdd() {
		System.out.println("Start 'save' test for Patient");
		final Patient newPatient = saveNewPatient();
		Assert.assertNotNull(patientDao.get(newPatient.getId()));
	}

	 @Test
	 public void testDelete() {
	 System.out.println("Start 'delete' test for Patient");
	 final Patient newPatient = saveNewPatient();
	 patientDao.delete(newPatient.getId());
	 Assert.assertNull(patientDao.get(newPatient.getId()));
	 }
	
	 @Test
	 public void testGetAll() {
	 System.out.println("Start 'getAll' test for Patient");
	 final int initialRowsCount = patientDao.getAll().size();
	 saveNewPatient();
	 Assert.assertEquals(patientDao.getAll().size(), initialRowsCount + 1);
	 }

	private Patient saveNewPatient() {
		List<Appoinment> appoinments = new ArrayList<Appoinment>();
		final Patient newPatient = new Patient();
		newPatient.setName("Michael Johns");
		newPatient.setDiagnosis("Cancer");
		newPatient.setDischarged(false);
		newPatient.setAppoinments(appoinments);
		patientDao.saveNew(newPatient);
		return newPatient;
	}
}