 /*************************************************************************
 * (C) 2019 Trackitecture LLC 
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Trackitecture LLC and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Trackitecture LLC
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Trackitecture LLC.
 */

package demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.hazelcast.config.Config;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * @author OliverGros
 *
 */
@TestInstance (Lifecycle.PER_CLASS)
public class ListWithGenericsTest {

	protected HazelcastInstance instance;
	
	@BeforeAll
	public void startup () {

		Config cfg = new Config();
		cfg.setInstanceName("Test");
		SerializationConfig serConf = new SerializationConfig();
		serConf.addPortableFactory(1, new PortFact()).setPortableVersion(0);
		cfg.setSerializationConfig(serConf);		
		instance = Hazelcast.getOrCreateHazelcastInstance(cfg);

	}
	
	@AfterAll
	public void shutdown () {
		if (instance != null) { 
			instance.shutdown();
		}
	}
	
	@Test
	public void allInOne () {

		IMap<String, MyCollection> map = instance.getMap("MyMap");
		
		MyCollection col1 = new MyCollection();
		
		col1.addMember(new MyObjectString() );
		col1.addMember(new MyObjectString() );
		
		assertDoesNotThrow(()->map.put("c1", col1));
		
		MyCollection c1a = map.get("c1");
		System.err.println (c1a);
		System.err.println ("========================================");
		
		MyCollection col2 = new MyCollection();
		
		//col2.addMember(new MyObjectString() );
		col2.addMember(new MyObjectString() );
		col2.addMember(new MyObjectInteger() );
		//col2.addMember(new MyObjectInteger() );
		
		assertDoesNotThrow(()->map.put("c2", col2));
		
		MyCollection c2a = map.get("c2");
	
		System.out.println (c2a);
	}
}
