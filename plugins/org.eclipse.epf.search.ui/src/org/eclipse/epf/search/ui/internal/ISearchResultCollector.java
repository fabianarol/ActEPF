//------------------------------------------------------------------------------
// Copyright (c) 2005, 2006 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.epf.search.ui.internal;

/**
 * The interface for a method search result collector.
 * 
 * @author Kelvin Low
 * @since 1.0
 */
public interface ISearchResultCollector {

	/**
	 * Evaluates the given object to see if there is a match in the search
	 * criteria.
	 * 
	 * @param match
	 *            an object containing the method element to match
	 */
	void accept(Object match);

}
