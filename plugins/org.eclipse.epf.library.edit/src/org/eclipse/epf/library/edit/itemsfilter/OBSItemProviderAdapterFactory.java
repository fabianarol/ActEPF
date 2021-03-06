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
package org.eclipse.epf.library.edit.itemsfilter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * The item provider adapter for break down elements in the Team Allocation page
 * of a Process editor.
 * 
 * @author Shashidhar Kannoori
 * @since 1.0
 */
public class OBSItemProviderAdapterFactory extends
		org.eclipse.epf.library.edit.process.OBSItemProviderAdapterFactory {

	public Adapter createActivityAdapter() {
		return new OBSActivityItemProvider(this);
	}

	public Adapter createCapabilityPatternAdapter() {
		return new OBSProcessItemProvider(this, (ItemProviderAdapter) super
				.createCapabilityPatternAdapter());
	}

	public Adapter createDeliveryProcessAdapter() {
		return new OBSProcessItemProvider(this, (ItemProviderAdapter) super
				.createDeliveryProcessAdapter());
	}

}
