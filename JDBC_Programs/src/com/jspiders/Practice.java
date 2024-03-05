package com.jspiders;




public class Practice {
		public static void main(String[] args) {
			String s= "kakashi";
			String temp="";
			boolean flag=true;
			for(int i=0;i<s.length();i++) {
				char ch=s.charAt(i);
				
				for(int j=i+1;j<s.length();j++) {
					char ch1=s.charAt(j);
					if(ch==ch1 && i!=j)
						
						flag=false;
					break;
					
				}
				
				if(flag)
					System.out.print(s.charAt(i));
				
			}
			
			
			
		}
}
