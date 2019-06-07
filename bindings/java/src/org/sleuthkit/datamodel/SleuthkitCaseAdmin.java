/*
 * Sleuth Kit Data Model
 *
 * Copyright 2019 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	 http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sleuthkit.datamodel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class SleuthkitCaseAdmin {
	
		private static final Logger logger = Logger.getLogger(SleuthkitCase.class.getName());

	
	private SleuthkitCaseAdmin() {
	
	}
	
	public static void deleteDataSource(SleuthkitCase theCase, Long dataSourceObjId) throws TskCoreException {
	
		try {
            Method m=theCase.getClass().getDeclaredMethod("deleteDataSource", long.class);	
		    m.setAccessible(true);
		    m.invoke(theCase, dataSourceObjId);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
			throw new TskCoreException("Error deleting data source.", ex);	
		}
	}
}
