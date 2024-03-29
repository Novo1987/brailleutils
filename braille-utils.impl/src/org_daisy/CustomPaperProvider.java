/*
 * Braille Utils (C) 2010-2011 Daisy Consortium 
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org_daisy;

import java.util.Collection;
import java.util.Collections;

import org.daisy.paper.CustomPaperCollection;
import org.daisy.paper.Paper;
import org.daisy.paper.PaperProvider;

import aQute.bnd.annotation.component.Component;

@Component
public class CustomPaperProvider implements PaperProvider {

	public CustomPaperProvider() {
	}

	public Collection<Paper> list() {
		return Collections.unmodifiableCollection(CustomPaperCollection.getInstance().list());
	}

}
