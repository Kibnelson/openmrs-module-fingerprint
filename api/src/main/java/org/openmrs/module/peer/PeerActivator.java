/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.peer;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.ModuleActivator;

/**
 * This class contains the logic that is run every time this module is either started or stopped.
 */
public class PeerActivator implements ModuleActivator {

	protected Log log = LogFactory.getLog(getClass());

	/**
	 * @see org.openmrs.module.ModuleActivator#willRefreshContext()
	 */
	public void willRefreshContext() {
		log.info("Refreshing peer Module");
	}

	/**
	 * @see org.openmrs.module.ModuleActivator#contextRefreshed()
	 */
	public void contextRefreshed() {
		log.info("peer Module refreshed");
	}

	/**
	 * @see org.openmrs.module.ModuleActivator#willStart()
	 */
	public void willStart() {
		log.info("Starting peer Module");
	}

	/**
	 * @see org.openmrs.module.ModuleActivator#started()
	 */
	public void started() {
		log.info("peer Module started");
	}

	/**
	 * @see org.openmrs.module.ModuleActivator#willStop()
	 */
	public void willStop() {
		log.info("Stopping peer Module");
	}

	/**
	 * @see org.openmrs.module.ModuleActivator#stopped()
	 */
	public void stopped() {
		log.info("peer Module stopped");
	}

}
