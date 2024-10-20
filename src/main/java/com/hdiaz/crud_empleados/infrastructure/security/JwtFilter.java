package com.hdiaz.crud_empleados.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;


@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if (Objects.isNull(authHeader)|| !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        jwt = authHeader.substring(7);
        userEmail = jwtService.getUserName(jwt);
        /*TODO: se válida que el userEmail sea diferente de nulo, y que el usuario no esté previamente autenticado.*/
        if (Objects.nonNull(userEmail) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())){

            /*TODO: verifica que el usuario exista en la BD, y lo retorna.*/
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            /*TODO: método que validará si el token es valido*/
            if (jwtService.validateToken(jwt,userDetails)){

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());

                /*TODO: agregamos los detalles de la petición, dichos detalles vienen dentro del request*/
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                /*TODO: actualizamos el securityContextHolder.
                 *  -> podemos ver el securityContextHolder el el diagrama.*/
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

            filterChain.doFilter(request,response);
        }
    }


}
