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
package org.eclipse.epf.uma.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.epf.uma.ProcAspect;
import org.eclipse.epf.uma.UmaFactory;
import org.eclipse.epf.uma.UmaPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.epf.uma.ProcAspect} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcAspectItemProvider extends VarElementItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcAspectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTipoVariacionPropertyDescriptor(object);
			addActivePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Tipo Variacion feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTipoVariacionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Variation_tipoVariacion_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_Variation_tipoVariacion_feature", "_UI_Variation_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						UmaPackage.Literals.VARIATION__TIPO_VARIACION, true,
						false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Active feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActivePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ProcAspect_active_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_ProcAspect_active_feature", "_UI_ProcAspect_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						UmaPackage.Literals.PROC_ASPECT__ACTIVE, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
						null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(UmaPackage.Literals.PROC_ASPECT__ADVICE);
			childrenFeatures.add(UmaPackage.Literals.PROC_ASPECT__POINTCUT);
			childrenFeatures.add(UmaPackage.Literals.PROC_ASPECT__CONTAIN);
			childrenFeatures.add(UmaPackage.Literals.PROC_ASPECT__UTILIZA);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ProcAspect.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/ProcAspect")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((ProcAspect) object).getVpName();
		return label == null || label.length() == 0 ? getString("_UI_ProcAspect_type") : //$NON-NLS-1$
				getString("_UI_ProcAspect_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ProcAspect.class)) {
		case UmaPackage.PROC_ASPECT__ACTIVE:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case UmaPackage.PROC_ASPECT__ADVICE:
		case UmaPackage.PROC_ASPECT__POINTCUT:
		case UmaPackage.PROC_ASPECT__CONTAIN:
		case UmaPackage.PROC_ASPECT__UTILIZA:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors,
			Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__ADVICE, UmaFactory.eINSTANCE
						.createProcAdvice()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__POINTCUT, UmaFactory.eINSTANCE
						.createProcPointcut()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVariant()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVarActivity()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVarPhase()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVarIteration()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVarRoleDescriptor()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVarTaskDescriptor()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVarMilestone()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVarTeamProfile()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__CONTAIN, UmaFactory.eINSTANCE
						.createVarWorkProductDescriptor()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createVarPoint()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createvpActivity()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createvpPhase()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createvpIteration()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createvpRoleDescriptor()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createvpTaskDescriptor()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createvpMilestone()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createvpTeamProfile()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.PROC_ASPECT__UTILIZA, UmaFactory.eINSTANCE
						.createvpWorkProductDescriptor()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == UmaPackage.Literals.VAR_ELEMENT__CLIENT
				|| childFeature == UmaPackage.Literals.VAR_ELEMENT__SUPPLIER;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
					new Object[] { getTypeText(childObject),
							getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return UmaEditPlugin.INSTANCE;
	}

}