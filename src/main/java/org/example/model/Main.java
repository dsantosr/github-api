package org.example.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaGitHub consultaGitHub = new ConsultaGitHub();
        String userName;

        while (true) {
            System.out.println("\nInforme o nome do usuário que desejas pesquisar (Ou \"sair\" se desejas sair): ");
            userName = scanner.nextLine();

            if (userName.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                String userJson = consultaGitHub.buscaUsuario(userName);
                System.out.println(userJson);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                User usuario = gson.fromJson(userJson, User.class);
                System.out.println(usuario);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando a aplicação");
            }
        }
    }
}