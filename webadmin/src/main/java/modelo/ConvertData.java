package modelo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConvertData {

	private Date data;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date textForDate(String data) throws Exception {

		Date dataAbertura = null;

		if(data == null) {
			return dataAbertura = null;
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			dataAbertura = sdf.parse(data);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dataAbertura;

	}

	public String dataForText(Date data) {

		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dataText = simpleDateFormat.format(data);

		return dataText;

	}

	public String getDataHora() {

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return formato.format(now);

	}


}
