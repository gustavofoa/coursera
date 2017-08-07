import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pessoa {

	private Date dataDeNascimento;

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getIdade() {
		long time = Relogio.agora() - dataDeNascimento.getTime();
		return (int) (time / (1000 * 60 * 60 * 24 * 365.4));
	}

	public String getSigno() {
		
		Calendar nasc = GregorianCalendar.getInstance();
		nasc.setTime(dataDeNascimento);
		
		switch (nasc.get(Calendar.MONTH)) {
		case 1:
			if(nasc.get(Calendar.DATE) < 21)
				return "Capricórnio";
			else
				return "Aquário";
		case 2:
			if(nasc.get(Calendar.DATE) < 19)
				return "Aquário";
			else
				return "Peixes";
		case 3:
			if(nasc.get(Calendar.DATE) < 21)
				return "Peixes";
			else
				return "Áries";
		case 4:
			if(nasc.get(Calendar.DATE) < 21)
				return "Áries";
			else
				return "Touro";
		case 5:
			if(nasc.get(Calendar.DATE) < 21)
				return "Touro";
			else
				return "Gêmeos";
		case 6:
			if(nasc.get(Calendar.DATE) < 22)
				return "Gêmeos";
			else
				return "Câncer";
		case 7:
			if(nasc.get(Calendar.DATE) < 21)
				return "Câncer";
			else
				return "Leão";
		case 8:
			if(nasc.get(Calendar.DATE) < 23)
				return "Leão";
			else
				return "Virgem";
		case 9:
			if(nasc.get(Calendar.DATE) < 23)
				return "Virgem";
			else
				return "Libra";
		case 10:
			if(nasc.get(Calendar.DATE) < 23)
				return "Libra";
			else
				return "Escorpião";
		case 11:
			if(nasc.get(Calendar.DATE) < 22)
				return "Escorpião";
			else
				return "Sagitário";
		case 12:
			if(nasc.get(Calendar.DATE) < 21)
				return "Sagitário";
			else
				return "Capricórnio";
		}
		
		return "";
	}
}
