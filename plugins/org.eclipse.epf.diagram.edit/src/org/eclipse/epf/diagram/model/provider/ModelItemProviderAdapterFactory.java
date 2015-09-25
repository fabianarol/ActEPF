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
/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelItemProviderAdapterFactory.java,v 1.1 2008/01/15 08:53:03 jtham Exp $
 */
package org.eclipse.epf.diagram.model.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.epf.diagram.model.util.ModelAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelItemProviderAdapterFactory extends ModelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.Diagram} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramItemProvider diagramItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.Diagram}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramAdapter() {
		if (diagramItemProvider == null) {
			diagramItemProvider = new DiagramItemProvider(this);
		}

		return diagramItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.Link} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkItemProvider linkItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.Link}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLinkAdapter() {
		if (linkItemProvider == null) {
			linkItemProvider = new LinkItemProvider(this);
		}

		return linkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.NamedNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedNodeItemProvider namedNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.NamedNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNamedNodeAdapter() {
		if (namedNodeItemProvider == null) {
			namedNodeItemProvider = new NamedNodeItemProvider(this);
		}

		return namedNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.ActivityDiagram} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityDiagramItemProvider activityDiagramItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.ActivityDiagram}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActivityDiagramAdapter() {
		if (activityDiagramItemProvider == null) {
			activityDiagramItemProvider = new ActivityDiagramItemProvider(this);
		}

		return activityDiagramItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.TypedNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedNodeItemProvider typedNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.TypedNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTypedNodeAdapter() {
		if (typedNodeItemProvider == null) {
			typedNodeItemProvider = new TypedNodeItemProvider(this);
		}

		return typedNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.WorkProductDependencyDiagram} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkProductDependencyDiagramItemProvider workProductDependencyDiagramItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.WorkProductDependencyDiagram}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWorkProductDependencyDiagramAdapter() {
		if (workProductDependencyDiagramItemProvider == null) {
			workProductDependencyDiagramItemProvider = new WorkProductDependencyDiagramItemProvider(this);
		}

		return workProductDependencyDiagramItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.WorkProductNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkProductNodeItemProvider workProductNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.WorkProductNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWorkProductNodeAdapter() {
		if (workProductNodeItemProvider == null) {
			workProductNodeItemProvider = new WorkProductNodeItemProvider(this);
		}

		return workProductNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.ActivityDetailDiagram} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityDetailDiagramItemProvider activityDetailDiagramItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.ActivityDetailDiagram}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActivityDetailDiagramAdapter() {
		if (activityDetailDiagramItemProvider == null) {
			activityDetailDiagramItemProvider = new ActivityDetailDiagramItemProvider(this);
		}

		return activityDetailDiagramItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.RoleNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleNodeItemProvider roleNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.RoleNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRoleNodeAdapter() {
		if (roleNodeItemProvider == null) {
			roleNodeItemProvider = new RoleNodeItemProvider(this);
		}

		return roleNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.RoleTaskComposite} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleTaskCompositeItemProvider roleTaskCompositeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.RoleTaskComposite}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRoleTaskCompositeAdapter() {
		if (roleTaskCompositeItemProvider == null) {
			roleTaskCompositeItemProvider = new RoleTaskCompositeItemProvider(this);
		}

		return roleTaskCompositeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.TaskNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskNodeItemProvider taskNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.TaskNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTaskNodeAdapter() {
		if (taskNodeItemProvider == null) {
			taskNodeItemProvider = new TaskNodeItemProvider(this);
		}

		return taskNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.WorkProductDescriptorNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkProductDescriptorNodeItemProvider workProductDescriptorNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.WorkProductDescriptorNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWorkProductDescriptorNodeAdapter() {
		if (workProductDescriptorNodeItemProvider == null) {
			workProductDescriptorNodeItemProvider = new WorkProductDescriptorNodeItemProvider(this);
		}

		return workProductDescriptorNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.WorkBreakdownElementNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkBreakdownElementNodeItemProvider workBreakdownElementNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.WorkBreakdownElementNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWorkBreakdownElementNodeAdapter() {
		if (workBreakdownElementNodeItemProvider == null) {
			workBreakdownElementNodeItemProvider = new WorkBreakdownElementNodeItemProvider(this);
		}

		return workBreakdownElementNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.epf.diagram.model.WorkProductComposite} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkProductCompositeItemProvider workProductCompositeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.epf.diagram.model.WorkProductComposite}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWorkProductCompositeAdapter() {
		if (workProductCompositeItemProvider == null) {
			workProductCompositeItemProvider = new WorkProductCompositeItemProvider(this);
		}

		return workProductCompositeItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (diagramItemProvider != null) diagramItemProvider.dispose();
		if (linkItemProvider != null) linkItemProvider.dispose();
		if (namedNodeItemProvider != null) namedNodeItemProvider.dispose();
		if (activityDiagramItemProvider != null) activityDiagramItemProvider.dispose();
		if (typedNodeItemProvider != null) typedNodeItemProvider.dispose();
		if (workProductDependencyDiagramItemProvider != null) workProductDependencyDiagramItemProvider.dispose();
		if (workProductNodeItemProvider != null) workProductNodeItemProvider.dispose();
		if (activityDetailDiagramItemProvider != null) activityDetailDiagramItemProvider.dispose();
		if (roleNodeItemProvider != null) roleNodeItemProvider.dispose();
		if (roleTaskCompositeItemProvider != null) roleTaskCompositeItemProvider.dispose();
		if (taskNodeItemProvider != null) taskNodeItemProvider.dispose();
		if (workProductDescriptorNodeItemProvider != null) workProductDescriptorNodeItemProvider.dispose();
		if (workBreakdownElementNodeItemProvider != null) workBreakdownElementNodeItemProvider.dispose();
		if (workProductCompositeItemProvider != null) workProductCompositeItemProvider.dispose();
	}

}
