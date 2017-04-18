package SupportingClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.net.URI;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandle extends File
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1683706571612330157L;

	public FileHandle(File parent, String child) 
	{
		super(parent, child);
		
	}
	public FileHandle(String pathname) 
	{
		super(pathname);
		
		
	}
	public FileHandle(String parent, String child) 
	{
		super(parent, child);
		
	}
	public FileHandle(URI uri) 
	{
		super(uri);
		
	}
    
	public void AppendFileHandle(String Outputname,String Value) throws IOException
	{
		FileWriter fw = new FileWriter(this.getAbsolutePath(),true);
		BufferedWriter br = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(br);
		pw.println(Outputname + "=" + Value);
		pw.flush();
		pw.close();
		br.close();
		fw.close();
	}
	
  
}
