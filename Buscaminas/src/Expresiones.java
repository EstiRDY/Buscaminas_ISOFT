import java.util.regex.*;

public class Expresiones 
{

public void main(){
	String cadena = "1";
	Pattern pat = Pattern.compile("[123]");
	Matcher mat = pat.matcher(cadena); {
		if (mat.matches()) {
			System.out.println("SI");
	} else { System.out.println("No");}
		
	
	}
}
}



