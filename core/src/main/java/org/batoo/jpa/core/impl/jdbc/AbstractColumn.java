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
package org.batoo.jpa.core.impl.jdbc;

import org.batoo.jpa.core.impl.manager.SessionImpl;
import org.batoo.jpa.core.impl.model.attribute.AttributeImpl;
import org.batoo.jpa.parser.impl.AbstractLocator;

/**
 * Abstract base implementation for columns
 * 
 * @author hceylan
 * @since $version
 */
public abstract class AbstractColumn {

	/**
	 * Returns the attribute of the column.
	 * 
	 * @return the attribute of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract AttributeImpl<?, ?> getAttribute();

	/**
	 * Returns the static definition of the column.
	 * 
	 * @return the static definition of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract String getColumnDefinition();

	/**
	 * Returns the length of the column.
	 * 
	 * @return the length of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract int getLength();

	/**
	 * Returns the locator of the column.
	 * 
	 * @return the locator of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract AbstractLocator getLocator();

	/**
	 * Returns the mapping name of the column.
	 * 
	 * @return the mapping name of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract String getMappingName();

	/**
	 * Returns the name of the column.
	 * 
	 * @return the name of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract String getName();

	/**
	 * Returns the precision of the column.
	 * 
	 * @return the precision of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract int getPrecision();

	/**
	 * Returns the scale of the column.
	 * 
	 * @return the scale of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract int getScale();

	/**
	 * Returns the SQL Type of the column.
	 * 
	 * @return the SQL Type of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract int getSqlType();

	/**
	 * Returns the table of the column
	 * 
	 * @return the table
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract AbstractTable getTable();

	/**
	 * Returns the table name of the column.
	 * 
	 * @return the table name of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract String getTableName();

	/**
	 * Returns the value for the column
	 * 
	 * @param sesssion
	 *            the session
	 * @param instance
	 *            the instance
	 * @return the value
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract Object getValue(SessionImpl sesssion, Object instance);

	/**
	 * Returns the insertable of the column.
	 * 
	 * @return the insertable of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract boolean isInsertable();

	/**
	 * Returns the nullable of the column.
	 * 
	 * @return the nullable of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract boolean isNullable();

	/**
	 * Returns the unique of the column.
	 * 
	 * @return the unique of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract boolean isUnique();

	/**
	 * Returns the updatable of the column.
	 * 
	 * @return the updatable of the column
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract boolean isUpdatable();

	/**
	 * Sets the table of the column.
	 * 
	 * @param table
	 *            the owning table
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract void setTable(AbstractTable table);

	/**
	 * Sets the value for the instance
	 * 
	 * @param instance
	 *            the instance of which to set value
	 * @param value
	 *            the value to set
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public abstract void setValue(Object instance, Object value);
}