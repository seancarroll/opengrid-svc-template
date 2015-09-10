package com.opengrid.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.opengrid.data.meta.OpenGridDataset;
import org.opengrid.data.meta.OpenGridMeta;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//TODO: mock 'online' Mongo calls
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MetaTest {
	
	@BeforeClass  
	public static void initTest() throws Exception {
	}
	
	
	@AfterClass  
	public static void cleanupTest() {
	}
	
	@Test
	public void t1_ReadMeta() throws JsonParseException, JsonMappingException, IOException  {
		OpenGridMeta meta;
		ObjectMapper mapper = new ObjectMapper();
		
		//TODO: use relative path or use resource streams to make use of class path
		meta = mapper.readValue(new File("C:/Projects/Java/CoC/Workspaces/WG2/opengridservice/src/test/resources/opengrid_meta_generic.json"), OpenGridMeta.class);
		assertTrue("Dataset count must equal 2", meta.getDatasets().size() == 2);
	}
}

