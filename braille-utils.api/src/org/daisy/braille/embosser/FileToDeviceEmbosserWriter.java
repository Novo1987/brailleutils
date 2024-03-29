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
package org.daisy.braille.embosser;

import java.io.File;
import java.io.IOException;

import javax.print.PrintException;

import org.daisy.printing.Device;

/**
 * Provides a bridge between a Device and file based EmbosserWriter
 * @author Joel Håkansson
 */
public class FileToDeviceEmbosserWriter implements EmbosserWriter {
	private final EmbosserWriter w;
	private final File f;
	private final Device bd;
	
	/**
	 * Creates a new file-to-device embosser writer.
	 * @param w the underlying EmbosserWriter
	 * @param f the file used by the supplied EmbosserWriter
	 * @param bd the device to send the file to
	 */
	public FileToDeviceEmbosserWriter(EmbosserWriter w, File f, Device bd) {
		this.w = w;
		this.bd = bd;
		this.f = f;
	}

	//jvm1.6@Override
	public int getRowGap() {
		return w.getRowGap();
	}

	//jvm1.6@Override
	public boolean isClosed() {
		return w.isClosed();
	}

	//jvm1.6@Override
	public boolean isOpen() {
		return w.isOpen();
	}

	//jvm1.6@Override
	public void newLine() throws IOException {
		w.newLine();
	}

	//jvm1.6@Override
	public void newPage() throws IOException {
		w.newPage();
	}

	//jvm1.6@Override
	public void newSectionAndPage(boolean duplex) throws IOException {
		w.newSectionAndPage(duplex);
	}

	//jvm1.6@Override
	public void newVolumeSectionAndPage(boolean duplex) throws IOException {
		w.newVolumeSectionAndPage(duplex);
	}

	//jvm1.6@Override
	public void open(boolean duplex) throws IOException {
		w.open(duplex);
	}

	//jvm1.6@Override
	public void setRowGap(int value) {
		w.setRowGap(value);
	}

	//jvm1.6@Override
	public void write(String braille) throws IOException {
		w.write(braille);
	}

	//jvm1.6@Override
	public int getMaxHeight() {
		return w.getMaxHeight();
	}

	//jvm1.6@Override
	public int getMaxWidth() {
		return w.getMaxWidth();
	}

	//jvm1.6@Override
	public boolean supports8dot() {
		return w.supports8dot();
	}

	//jvm1.6@Override
	public boolean supportsAligning() {
		return w.supportsAligning();
	}

	//jvm1.6@Override
	public boolean supportsDuplex() {
		return w.supportsDuplex();
	}

	//jvm1.6@Override
	public boolean supportsVolumes() {
		return w.supportsVolumes();
	}
	
	public boolean supportsZFolding() {
		return w.supportsZFolding();
	}

	public boolean supportsPrintMode(PrintMode mode) {
		return w.supportsPrintMode(mode);
	}

	//jvm1.6@Override
	public void close() throws IOException {
		w.close();
		try {
			bd.transmit(f);
		} catch (PrintException e) {
			IOException e2 = new IOException();
			e2.initCause(e);
			throw e2;
		}
	}

	//jvm1.6@Override
	public void open(boolean duplex, Contract contract) throws IOException, ContractNotSupportedException {
		w.open(duplex, contract);
	}

}
