import java.util.Date;


public class Relogio {
	
	public static long tempoFixo=0;
	
	public static long agora(){
		if(tempoFixo==0)
			return new Date().getTime();
		else
			return tempoFixo;
	}

}
