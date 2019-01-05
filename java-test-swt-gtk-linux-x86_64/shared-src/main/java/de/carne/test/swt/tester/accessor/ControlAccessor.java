/*
 * Copyright (c) 2017-2019 Holger de Carne and contributors, All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.carne.test.swt.tester.accessor;

import java.util.function.Function;
import java.util.function.Predicate;

import org.eclipse.swt.widgets.Control;

/**
 * Accessor class for {@linkplain Control} objects.
 *
 * @param <O> the actual object type to access.
 */
public class ControlAccessor<O extends Control> extends Accessor<O> {

	/**
	 * Constructs a new {@linkplain ControlAccessor} instance.
	 *
	 * @param control the {@linkplain Control} instance to access.
	 */
	protected ControlAccessor(O control) {
		super(control);
	}

	/**
	 * Creates a {@linkplain Predicate} for control type matching.
	 *
	 * @param type the control type to match.
	 * @return the created {@linkplain Predicate}.
	 */
	public static Predicate<Control> matchClass(Class<? extends Control> type) {
		return control -> type.isAssignableFrom(control.getClass());
	}

	/**
	 * Creates a {@linkplain Function} for control type mapping.
	 *
	 * @param type the control type to map to.
	 * @return the created {@linkplain Function}.
	 * @param <S> the control type to map to.
	 */
	public static <S extends Control> Function<Control, S> mapClass(Class<S> type) {
		return type::cast;
	}

}
