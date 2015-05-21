
package uk.co.codeecho.tvjackal.task;

import biz.devspot.entity.framework.core.EntityManagerFactory;
import biz.devspot.entity.framework.core.EntityManagerImpl;
import biz.devspot.entity.framework.core.dao.mongo.MongoDao;
import biz.devspot.entity.framework.core.mapping.json.DataBackedObjectMapper;
import com.github.fakemongo.Fongo;
import com.mongodb.FongoDB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RetrieveRecommendationsTaskTest {

    public RetrieveRecommendationsTaskTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class RetrieveRecommendationsTask.
     */
    @Test
    public void testRun() {
//        EntityManagerFactory.setManager(new EntityManagerImpl(new MongoDao(new Fongo("Test Server").getDB("test"), new DataBackedObjectMapper())));
//        EntityManagerFactory.getManager().openTransaction();
//        RetrieveRecommendationsTask instance = new RetrieveRecommendationsTask();
//        instance.run();
//        //EntityManagerFactory.getManager().commitTransaction();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}