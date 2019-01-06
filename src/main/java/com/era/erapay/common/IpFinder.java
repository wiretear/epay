package com.era.erapay.common;

import org.apache.http.*;
import org.apache.http.params.HttpParams;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class IpFinder {
    public   String getIp(HttpServletRequest request )

    {

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;

    }

}
