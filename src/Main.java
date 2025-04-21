import entities.Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contato> contatos = new ArrayList<>();

        int option = menu();
        do {
            switch (option){
                case 1:
                    System.out.println("Digite os dados do contato: ");
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    System.out.print("Telefone: ");
                    String telefone = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();

                    Contato contato = new Contato(nome, telefone, email);
                    contatos.add(contato);

                    option = menu();
                    break;
            }
        }while (option != 0);



    for(Contato c : contatos){
        System.out.println(c);
    }



    }
    public static int menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual operação você deseja fazer?");
        System.out.println("0 - sair");
        System.out.println("1 - adicionar novo contato");
        System.out.println("2 - buscar todos meus contatos");
        System.out.println("3 - buscar contato");
        System.out.println("4 - editar contato");
        System.out.println("5 - excluir contato");
        System.out.println("6 - exportar contatos");

        return sc.nextInt();
    }
}