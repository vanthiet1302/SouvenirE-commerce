package nlu.fit.web.souvenirecommerce.service;

import jakarta.mail.MessagingException;
import nlu.fit.web.souvenirecommerce.util.EmailUtils;

public class EmailService {
    private EmailUtils emailUtils = new EmailUtils();

    public void sendActivationEmail(String userEmail, String token, String otp) {
        String activationLink = "https://yourshop.com/verify?token=" + token;

        String htmlBody = "<h1>Kích hoạt tài khoản của bạn</h1>" +
                "<p>Vui lòng chọn 1 trong 2 cách sau để kích hoạt:</p>" +
                "<ul>" +
                "<li><b>Cách 1:</b> Click vào link: <a href='" + activationLink + "'>Kích hoạt ngay</a></li>" +
                "<li><b>Cách 2:</b> Nhập mã OTP: <b>" + otp + "</b></li>" +
                "</ul>" +
                "<p>Lưu ý: Mã và Link có hiệu lực trong 15 phút. Kiểm tra thư rác nếu không thấy!</p>";

        try {
            new Thread(() -> {
                try {
                    emailUtils.sendHtmlEmail(userEmail, "Xác thực tài khoản Lưu Niệm", htmlBody);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}