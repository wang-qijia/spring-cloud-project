package com.sunhome.cloud.alarm.service.notify;

import com.alibaba.fastjson.JSON;
import com.sunhome.cloud.alarm.config.AlarmProperties;
import com.sunhome.cloud.alarm.entiy.AlarmMessage;
import com.sunhome.cloud.alarm.entiy.AlarmMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangqijia
 * @date 2019/11/28 15:36
 */
@Service
public class MailAlarmService implements AlarmService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailContentBuilder mailContentBuilder;

    @Autowired
    private AlarmProperties alarmProperties;

    @Override
    public void notify(List<AlarmMessage> alarmMessages) {
        System.out.println("mail send:" + JSON.toJSONString(alarmMessages));

        StringBuilder sb = new StringBuilder();
        List<AlarmMessageDTO> alarmMessageList = new ArrayList<>();

        for (AlarmMessage alarmMessage : alarmMessages) {
//            toMessageStr(sb, alarmMessage);
            toMessageDTO(alarmMessageList, alarmMessage);
        }

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(alarmProperties.getFrom());
            helper.setTo(alarmProperties.getTo());
            helper.setSubject(alarmProperties.getTo());
//            helper.setText(sb.toString());
            helper.setText(mailContentBuilder.build(alarmMessageList), true);
            mailContentBuilder.build(alarmMessageList);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

    private void toMessageDTO(List<AlarmMessageDTO> alarmMessageList, AlarmMessage alarmMessage) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        AlarmMessageDTO alarmMessageDTO = new AlarmMessageDTO();
        alarmMessageDTO.setAlarmMessage(Rule.get(alarmMessage.getRuleName(), alarmMessage.getAlarmMessage()));
        alarmMessageDTO.setName(alarmMessage.getName());
        alarmMessageDTO.setRuleName(alarmMessage.getRuleName());
        alarmMessageDTO.setScope(alarmMessage.getScope());
        alarmMessageDTO.setStartTime(sdf.format(new Date(alarmMessage.getStartTime())));
        alarmMessageList.add(alarmMessageDTO);
    }

    private void toMessageStr(StringBuilder sb, AlarmMessage alarmMessage) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sb.append("告警时间:")
                .append(sdf.format(new Date(alarmMessage.getStartTime())))
                .append("|")
                .append("服务范围:")
                .append(alarmMessage.getScope())
                .append("|")
                .append("目标服务名称:")
                .append(alarmMessage.getName())
                .append("|")
                .append("告警规则:")
                .append(alarmMessage.getRuleName())
                .append("|")
                .append("告警消息:")
                .append(alarmMessage.getAlarmMessage())
                .append("\n\n");
    }


}
