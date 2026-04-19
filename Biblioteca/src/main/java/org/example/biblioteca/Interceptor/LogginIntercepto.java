package org.example.biblioteca.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalTime;

public class LogginIntercepto implements HandlerInterceptor {
    //vamos a trabajar con interceptores de fechas y horas


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalTime actual = LocalTime.now();
        LocalTime apertura = LocalTime.of(8,0);
        LocalTime cierre = LocalTime.of(17, 0);

        if(actual.isBefore(apertura) || actual.isAfter(cierre)){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); //403
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\"error\": \"Servicio disponible solo de 8:00 AM a 17:00 PM\"}"
            );
            return false; // bloquea el request
        }

        return true; //deja pasar

    }
}
