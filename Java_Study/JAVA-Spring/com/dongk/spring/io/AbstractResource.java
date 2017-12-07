package com.dongk.spring.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.dongk.spring.util.ResourceUtils;

public abstract class AbstractResource implements Resource{

	@Override
	public InputStream getInputStream() throws IOException {
		
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists() {
		try{
		  return getFile().exists();	
		}catch(IOException ex){
			try{
				InputStream is = getInputStream();
				is.close();
				return true;
			}catch(Throwable isEx){
				return false;
			}
		}
	}

	public boolean isReadable() {
		return true;
	}

	public boolean isOpen() {
		return false;
	}

	public URL getURL() throws IOException {
		throw new FileNotFoundException(getDescription() + " cannot be resolved to URL");
	}

	public URI getURI() throws IOException {
		URL url = getURL();
		try{
			return ResourceUtils.toURI(url);
		}catch(URISyntaxException ex){
			throw new IllegalArgumentException("Invalid URI [ " + url + " ] ");
		}
	}

	public File getFile() throws IOException {
		throw new FileNotFoundException(getDescription() + " cannot be resolved to absolute file path");
	}
	
	public long contentLength() throws IOException {
		return getFile().length();
	}

	public long lastModified() throws IOException {
		long lastModified = getFileForLastModifiedCheck().lastModified();
		if(lastModified == 0L){
			throw new FileNotFoundException(getDescription() +
					" cannot be resolved in the file system for resolving its last-modified timestamp");
		}
		return lastModified;
	}
    
	/**
	 * ȷ��ʹ��ʱ��������ļ� 
	 * <p>Ĭ�ϵ�ʵ���ǵ���getFile()����</p>
	 * @return ��������ʱ��������ļ�
	 */
	protected File getFileForLastModifiedCheck() throws IOException{
		return getFile();
	}
	
	public Resource createRelative(String relativePath) throws IOException {
		throw new FileNotFoundException("Cannot create a relative resource for " + getDescription());
	}

	public String getFilename() {
		throw new IllegalStateException(getDescription() + " does not have a filename");
	}

	@Override
	public String toString(){
		return getDescription();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj == this ||
		    (obj instanceof Resource && ((Resource) obj).getDescription().equals(getDescription())));
	}
	
	@Override
	public int hashCode() {
		return getDescription().hashCode();
	}


}
