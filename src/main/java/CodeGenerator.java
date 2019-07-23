
public class CodeGenerator {

	private String number="111222333444555666777";
	
	private String Code="";

	CodeGenerator(String number){
		this.number = number;
		generate();
	}

	
	CodeGenerator() {
		generate();
	}

	private void generate(){

		int side = 1;
		int distance = 0;

		for(int i=0; i<number.length();i++) {

			distance = (int) number.charAt(i)-48;

			for(int j=0; j<distance; j++) {

				if(side == 1) Code += "1";
				else Code += "0";
			}

			side *= -1;

		}
	}
	
	String getCode() {
		System.out.println(Code);
		return Code;
	}
	
}
