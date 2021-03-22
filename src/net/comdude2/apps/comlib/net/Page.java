/*
ComLib - A library for my projects
Copyright (C) 2021  comdude2 (Matt Armer)
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
Contact: comdude2@msn.com
*/

package net.comdude2.apps.comlib.net;

import java.util.LinkedList;

/**
 * Holds the contents of a page
 * @author comdude2
 */
public class Page {
	
	private String pageName = null;
	private LinkedList <String> pageContent = null;
	
	public Page(String name, LinkedList <String> content) {
		this.pageName = name;
		this.pageContent = content;
	}
	
	public String getPageName() {
		return this.pageName;
	}
	
	public LinkedList <String> getPageContent(){
		return this.pageContent;
	}
	
	public void print() {
		System.out.println("Address: " + this.pageName);
		System.out.println("");
		System.out.println("Content:");
		for (String l : this.pageContent) {
			System.out.println(l);
		}
		System.out.println("");
		System.out.println("Page line length: " + this.pageContent.size());
	}
}