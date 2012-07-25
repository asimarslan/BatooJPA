/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.batoo.jpa.core.impl.model.mapping;

import java.util.Iterator;

import org.batoo.jpa.core.impl.jdbc.AbstractTable;
import org.batoo.jpa.core.impl.model.attribute.AttributeImpl;
import org.batoo.jpa.core.impl.model.type.EmbeddableTypeImpl;

import com.google.common.base.Splitter;

/**
 * Root mapping for Embeddable element mappings.
 * 
 * @param <X>
 *            the embeddable type
 * 
 * @author hceylan
 * @since $version
 */
public class ElementMapping<X> extends ParentMapping<X, X> implements RootMapping<X> {

	private final EmbeddableTypeImpl<X> embeddable;
	private final ElementCollectionMapping<?, ?, X> mapping;

	/**
	 * @param mapping
	 *            the element collection mapping
	 * @param embeddable
	 *            the embeddable
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public ElementMapping(ElementCollectionMapping<?, ?, X> mapping, EmbeddableTypeImpl<X> embeddable) {
		super(null, null, embeddable.getJavaType(), null);

		this.mapping = mapping;
		this.embeddable = embeddable;

		this.createMappings();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public AttributeImpl<? super X, X> getAttribute() {
		return null;
	}

	/**
	 * Returns the collection table.
	 * 
	 * @return the collection table
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public AbstractTable getCollectionTable() {
		return this.mapping.getCollectionTable();
	}

	/**
	 * Returns the mapping corresponding to the path.
	 * 
	 * @param path
	 *            the path of the mapping
	 * @return the mapping
	 * 
	 * @since $version
	 * @author hceylan
	 */
	@Override
	public Mapping<?, ?, ?> getMapping(String path) {
		final Iterator<String> segments = Splitter.on('.').split(path).iterator();

		Mapping<?, ?, ?> mapping = this;

		while (segments.hasNext()) {
			if (mapping instanceof ParentMapping) {
				mapping = ((ParentMapping<?, ?>) mapping).getChild(segments.next());

				if (mapping == null) {
					return null;
				}
			}
			else {
				return null;
			}
		}

		return mapping;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public RootMapping<?> getRoot() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public EmbeddableTypeImpl<X> getType() {
		return this.embeddable;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public boolean isEntity() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public boolean isId() {
		return false;
	}
}