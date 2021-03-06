//------------------------------------------------------------------------------
// Copyright (c) 2005, 2007 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.epf.common.service.utils;

/**
 * Interface for excuting a command line
 * 
 * @author Weiping Lu
 * @since 1.2
 */
public interface ICommandLineRunner {
	boolean execute(String[] args);
}
