import java.util.*;
import java.util.regex.*;
public class Main
{
	public static void main(String[] args) {
	   String word=".bear and tot ,brush ,banana by to going am I";
        
       StringTokenizer st=new StringTokenizer(word," ");
       Stack stringstack=new Stack();
       while(st.hasMoreTokens())
       {
           String tempstring=new String(st.nextToken());
           StringBuilder tempsb=new StringBuilder(tempstring);
           
           String regpattern="^[^A-Za-z][A-Za-z]";
           Pattern pt=Pattern.compile(regpattern);
           Matcher mt=pt.matcher(tempstring);
           
           if(mt.find())
           {
               char[] chararray=tempstring.toCharArray();
              
               char nonchar=chararray[0];
               for(int i=1;i<chararray.length;i++)
               {
                   chararray[i-1]=chararray[i];
               }
               chararray[chararray.length-1]=nonchar;
               String st1=new String(chararray);
              
               tempstring=st1;
               stringstack.push(tempstring);
           }
           else{
               stringstack.push(tempstring);
           }
           
       }
       int stsize=stringstack.size();
       StringBuilder sb=new StringBuilder();
       
       for(int i=0;i<stsize;i++)
       {
           sb.append(stringstack.pop()+" ");
       }
       
       String streversed=new String(sb.toString());
       System.out.print(streversed);
       
       
	}
}
