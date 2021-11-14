package org.serratec.backend.trabalhofinalapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String para, String assunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("roni.info.net@gamil.com");
		message.setTo(para);
		message.setSubject(assunto);
		message.setText("Dados da inscrição:\n" + texto + "\n\n\n Parabéns por efetuar o seu cadastro na nossa API! \n\n Boas compras \n Atenciosamente: Rodrigo, Rafael, Raquel, Arthur.");
		javaMailSender.send(message);
	}

}
