package com.javanetworking.basics;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Classe Singleton que implementa um roteador de funções com base em rotas.
 * As respostas das rotas são enviadas para um OutputStream.
 * 
 * @author Erick
 */
public class Router {
    private Map<String, Supplier<String>> roteador;
    
    private static Router route = null;

    private Router() {
        roteador = new HashMap<>();
    }

    public static synchronized Router getInstance() {
        if (route == null) {
            route = new Router();
        }
        return route;
    }

    public void addRoute(String rota, Supplier<String> funcao) {
        roteador.put(rota, funcao);
    }

    public void executeRoute(String rota, OutputStream outputStream) throws IOException {
        Supplier<String> funcao = roteador.get(rota);

        try (Writer writer = new OutputStreamWriter(outputStream, Charset.defaultCharset())) {
            if (funcao != null) {
                writer.write(funcao.get());
            } else {
                writer.write("Rota não encontrada");
            }
            writer.flush();
        }
    }
}
