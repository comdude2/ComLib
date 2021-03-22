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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.LinkedList;

/**
 * Downloads a web page and stores it in a LinkedList <String> format via <Page>.
 * @author comdude2
 */
public class PageDownloader {
	
	/**
	 * Returns a web page in LinkedList <String> format.
	 * Currently does not accept cookies in order to trick some web sites into giving data.
	 * @param address
	 * @return Page
	 * TODO Add cookie support
	 */
	public static Page downloadPage(String address) {
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    if (address == null) {return null;}
	    if (address.length() == 0) {return null;}
	    try {
	    	URLConnection connection = new URL(address).openConnection();
	    	connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
	    	connection.connect();
	    	
	    	br  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
	        LinkedList <String> lines = new LinkedList <String> ();
	        while ((line = br.readLine()) != null) {
	        	lines.add(line);
	        }
	        if (lines.size() == 0) {return null;}
	        Page page = new Page(address, lines);
	        return page;
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	            // nothing to see here
	        }
	    }
	    return null;
	}
}