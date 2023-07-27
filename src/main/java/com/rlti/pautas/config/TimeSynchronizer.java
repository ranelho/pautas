package com.rlti.pautas.config;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class TimeSynchronizer {

    private static final String NTP_SERVER = "pool.ntp.org";

    public LocalDateTime getCurrentTime() {
        try {
            NTPUDPClient ntpClient = new NTPUDPClient();
            InetAddress inetAddress = InetAddress.getByName(NTP_SERVER);
            TimeInfo timeInfo = ntpClient.getTime(inetAddress);
            long returnTime = timeInfo.getReturnTime();
            Instant instant = Instant.ofEpochMilli(returnTime);
            return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        } catch (Exception e) {
            e.printStackTrace();
            return LocalDateTime.now(); // Retorna a data e hora atual local em caso de falha na sincronização
        }
    }
}
