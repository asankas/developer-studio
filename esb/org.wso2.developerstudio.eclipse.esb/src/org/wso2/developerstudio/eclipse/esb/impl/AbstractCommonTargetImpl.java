/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.AbstractCommonTarget;
import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.MediatorSequence;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.esb.TargetSequenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Common Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractCommonTargetImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractCommonTargetImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractCommonTargetImpl#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractCommonTargetImpl#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractCommonTargetImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractCommonTargetImpl#getEndpointKey <em>Endpoint Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractCommonTargetImpl extends ModelObjectImpl implements AbstractCommonTarget {
	/**
	 * The default value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final TargetSequenceType SEQUENCE_TYPE_EDEFAULT = TargetSequenceType.NONE;

	/**
	 * The cached value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected TargetSequenceType sequenceType = SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSequence() <em>Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected MediatorSequence sequence;

	/**
	 * The cached value of the '{@link #getSequenceKey() <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty sequenceKey;

	/**
	 * The default value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected static final TargetEndpointType ENDPOINT_TYPE_EDEFAULT = TargetEndpointType.NONE;

	/**
	 * The cached value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected TargetEndpointType endpointType = ENDPOINT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndpoint() <em>Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpoint()
	 * @generated
	 * @ordered
	 */
	protected EndPoint endpoint;

	/**
	 * The cached value of the '{@link #getEndpointKey() <em>Endpoint Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty endpointKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractCommonTargetImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Sequence.
		setSequenceType(TargetSequenceType.NONE);
		if (self.hasAttribute("sequence")) {
			setSequenceType(TargetSequenceType.REGISTRY_REFERENCE);
			getSequenceKey().load(self);
		} else {			
			loadObject(self, "sequence", MediatorSequence.class, false, new ObjectHandler<MediatorSequence>() {
				public void handle(MediatorSequence object) {
					object.setAnonymous(true);
					setSequence(object);
					setSequenceType(TargetSequenceType.ANONYMOUS);
				}
			});		
		}
		
		// Endpoint.
		setEndpointType(TargetEndpointType.NONE);
		if (self.hasAttribute("endpoint")) {
			setEndpointType(TargetEndpointType.REGISTRY_REFERENCE);
			getEndpointKey().load(self);
		} else {			
			loadObject(self, "endpoint", EndPoint.class, false, new ObjectHandler<EndPoint>() {
				public void handle(EndPoint object) {
					object.setAnonymous(true);
					setEndpoint(object);
					setEndpointType(TargetEndpointType.ANONYMOUS);
				}				
			});			
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "target");
		
		// Sequence.
		switch (getSequenceType()) {
			case REGISTRY_REFERENCE: {
				getSequenceKey().save(self);
				break;
			}
			
			case ANONYMOUS: {
				if (null != getSequence()) {
					// Force the sequence to be anonymous.
					getSequence().setAnonymous(true);
			
					getSequence().save(self);
				}
				break;
			}
		}		
		
		// Endpoint.
		switch (getEndpointType()) {
			case REGISTRY_REFERENCE: {
				getEndpointKey().save(self);
				break;
			}
			
			case ANONYMOUS: {
				if (null != getEndpoint()) {
					// Force the endpoint to be anonymous.
					getEndpoint().setAnonymous(true);
					
					getEndpoint().save(self);
				}
				break;
			}
		}		
		
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ABSTRACT_COMMON_TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSequenceType getSequenceType() {
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceType(TargetSequenceType newSequenceType) {
		TargetSequenceType oldSequenceType = sequenceType;
		sequenceType = newSequenceType == null ? SEQUENCE_TYPE_EDEFAULT : newSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE, oldSequenceType, sequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorSequence getSequence() {
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequence(MediatorSequence newSequence, NotificationChain msgs) {
		MediatorSequence oldSequence = sequence;
		sequence = newSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE, oldSequence, newSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequence(MediatorSequence newSequence) {
		if (newSequence != sequence) {
			NotificationChain msgs = null;
			if (sequence != null)
				msgs = ((InternalEObject)sequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE, null, msgs);
			if (newSequence != null)
				msgs = ((InternalEObject)newSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE, null, msgs);
			msgs = basicSetSequence(newSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE, newSequence, newSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSequenceKey() {
		return sequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceKey(RegistryKeyProperty newSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldSequenceKey = sequenceKey;
		sequenceKey = newSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, oldSequenceKey, newSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceKey(RegistryKeyProperty newSequenceKey) {
		if (newSequenceKey != sequenceKey) {
			NotificationChain msgs = null;
			if (sequenceKey != null)
				msgs = ((InternalEObject)sequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, null, msgs);
			if (newSequenceKey != null)
				msgs = ((InternalEObject)newSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, null, msgs);
			msgs = basicSetSequenceKey(newSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, newSequenceKey, newSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetEndpointType getEndpointType() {
		return endpointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointType(TargetEndpointType newEndpointType) {
		TargetEndpointType oldEndpointType = endpointType;
		endpointType = newEndpointType == null ? ENDPOINT_TYPE_EDEFAULT : newEndpointType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE, oldEndpointType, endpointType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint getEndpoint() {
		return endpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpoint(EndPoint newEndpoint, NotificationChain msgs) {
		EndPoint oldEndpoint = endpoint;
		endpoint = newEndpoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT, oldEndpoint, newEndpoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpoint(EndPoint newEndpoint) {
		if (newEndpoint != endpoint) {
			NotificationChain msgs = null;
			if (endpoint != null)
				msgs = ((InternalEObject)endpoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT, null, msgs);
			if (newEndpoint != null)
				msgs = ((InternalEObject)newEndpoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT, null, msgs);
			msgs = basicSetEndpoint(newEndpoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT, newEndpoint, newEndpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getEndpointKey() {
		return endpointKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointKey(RegistryKeyProperty newEndpointKey, NotificationChain msgs) {
		RegistryKeyProperty oldEndpointKey = endpointKey;
		endpointKey = newEndpointKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY, oldEndpointKey, newEndpointKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointKey(RegistryKeyProperty newEndpointKey) {
		if (newEndpointKey != endpointKey) {
			NotificationChain msgs = null;
			if (endpointKey != null)
				msgs = ((InternalEObject)endpointKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY, null, msgs);
			if (newEndpointKey != null)
				msgs = ((InternalEObject)newEndpointKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY, null, msgs);
			msgs = basicSetEndpointKey(newEndpointKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY, newEndpointKey, newEndpointKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE:
				return basicSetSequence(null, msgs);
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY:
				return basicSetSequenceKey(null, msgs);
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT:
				return basicSetEndpoint(null, msgs);
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY:
				return basicSetEndpointKey(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE:
				return getSequenceType();
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE:
				return getSequence();
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY:
				return getSequenceKey();
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE:
				return getEndpointType();
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT:
				return getEndpoint();
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY:
				return getEndpointKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE:
				setSequenceType((TargetSequenceType)newValue);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE:
				setSequence((MediatorSequence)newValue);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE:
				setEndpointType((TargetEndpointType)newValue);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT:
				setEndpoint((EndPoint)newValue);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE:
				setSequence((MediatorSequence)null);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE:
				setEndpointType(ENDPOINT_TYPE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT:
				setEndpoint((EndPoint)null);
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE:
				return sequence != null;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY:
				return sequenceKey != null;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE:
				return endpointType != ENDPOINT_TYPE_EDEFAULT;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT:
				return endpoint != null;
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY:
				return endpointKey != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sequenceType: ");
		result.append(sequenceType);
		result.append(", endpointType: ");
		result.append(endpointType);
		result.append(')');
		return result.toString();
	}

} //AbstractCommonTargetImpl
