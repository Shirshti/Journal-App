package com.shrii.journalApp.Filter;

import com.shrii.journalApp.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter; //run before controller

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter { //already exists in spring
    @Autowired
    JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         System.out.println("Filter running");

         String authHeader = request.getHeader("Authorization");
         if(authHeader!= null && authHeader.startsWith("Bearer ")){
             String token = authHeader.substring(7);
             String username = jwtService.extractUsername(token);

             UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, null);

             SecurityContextHolder.getContext().setAuthentication(auth);
         }
        filterChain.doFilter(request,response); //continue the request after filter
    }
}
