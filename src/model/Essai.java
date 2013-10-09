package model;

import java.io.File;
import java.util.ArrayList;
 
public class Essai
{
	public static void main(String args[])
	{
		al = new ArrayList();
 
		essai(new File("C:\\"),"ihm.java");
 
		int n = al.size();
		for(int i=0;i<n;i++)
		{
			System.out.println(al.get(i));
		}
	}
 
	private static void essai(File f,String s)
	{
		if(f.getName().equals(s)) al.add(f.getPath());
 
		File[] liste_fils = f.listFiles();
 
		if(liste_fils!=null)
		{
			for(int i=0;i<liste_fils.length;i++)
			{
				essai(liste_fils[i],s);
			}
		}
	}
 
	private static ArrayList al;
}