/*
 * Braille Utils (C) 2010 Daisy Consortium 
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
package org.daisy.braille.embosser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.spi.ServiceRegistry;

import org.daisy.factory.FactoryFilter;

class DefaultEmbosserCatalog extends EmbosserCatalog {
	private final HashMap<String, Embosser> map;
	
	protected DefaultEmbosserCatalog() {
		map = new HashMap<String, Embosser>();
		Iterator<EmbosserProvider> i = ServiceRegistry.lookupProviders(EmbosserProvider.class);
		while (i.hasNext()) {
			EmbosserProvider provider = i.next();
			for (Embosser embosser : provider.list()) {
				map.put(embosser.getIdentifier(), embosser);
			}
		}
	}
	
	public Object getFeature(String key) {
		throw new IllegalArgumentException("Unsupported feature: " + key);	}
	
	public void setFeature(String key, Object value) {
		throw new IllegalArgumentException("Unsupported feature: " + key);	}
	
	public Embosser get(String identifier) {
		return map.get(identifier);
	}
	
	public Collection<Embosser> list() {
		return map.values();
	}
	
	public Collection<Embosser> list(FactoryFilter<Embosser> filter) {
		Collection<Embosser> ret = new ArrayList<Embosser>();
		for (Embosser embosser : map.values()) {
			if (filter.accept(embosser)) {
				ret.add(embosser);
			}
		}
		return ret;
	}
}
