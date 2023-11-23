package com.inq.learnease.service;

import com.inq.learnease.dto.MailResponseDto;
import com.inq.learnease.entity.Certification;
import com.inq.learnease.repository.CertificationRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender emailSender;
    private final CertificationRepository certificationRepository;
    private String ePw;


    public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = emailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, to);
        message.setSubject("Learn_Ease 회원가입 이메일 인증");

        String msgg = "";
        msgg += "<div style='margin:100px;'>";
        msgg += "<h1> 안녕하세요</h1>";
        msgg += "<h1> Learn_Ease 입니다</h1>";
        msgg += "<br>";
        msgg += "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요<p>";
        msgg += "<br>";
        msgg += "<p>항상 당신의 미래를 응원합니다. 감사합니다!<p>";
        msgg += "<br>";
        msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgg += "<div style='font-size:130%'>";
        msgg += "CODE : <strong>";
        msgg += ePw + "</strong><div><br/> ";
        msgg += "</div>";
        message.setText(msgg, "utf-8", "html");
        message.setFrom(new InternetAddress("hsb422917@naver.com", "Learn_Ease"));

        return message;
    }

    public String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            int index = rnd.nextInt(3);

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    break;
            }
        }

        return key.toString();
    }

    public MailResponseDto sendSimpleMessage(String to) throws Exception {

        ePw = createKey();
        // 삭제
        System.out.println("인증코드 : " + ePw);
        MailResponseDto mailResponseDto = save(ePw);
        MimeMessage message = createMessage(to);

        try {
            emailSender.send(message);
        } catch (MailException es) {
            es.printStackTrace();
            throw new IllegalArgumentException();
        }

        return mailResponseDto;
    }

    public MailResponseDto save(final String number) {
        Certification certification = new Certification(number);
        Certification saveCertification = certificationRepository.save(certification);
        return MailResponseDto.from(saveCertification);
    }

    public void validateNumber(final String id, final String number) {
        Certification certification = certificationRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException());


        if (!certification.getNumber().equals(number)) {
            throw new IllegalArgumentException("인증 번호가 다릅니다.");
        }
    }
}
