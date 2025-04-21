import entities.Contato;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
                case 2:
                    System.out.println("Meus contatos: ");
                    if(!contatos.isEmpty()){
                        for(Contato c : contatos){
                            System.out.println(c);
                        }
                        option = menu();
                    }else{
                        System.out.println("Sem contatos na lista");
                        option = menu();
                    }
                break;
                case 3:
                    System.out.println("Qual o nome do contato deseja buscar :");
                    String nomeBusca = sc.next();
                    for(Contato c : contatos){
                        if(c.getNome().equalsIgnoreCase(nomeBusca)){
                            System.out.println(c);
                        }
                    }
                    option = menu();
                    break;
                case 5:
                    System.out.println("Qual o nome do contato deseja deletar :");
                    String nomeBuscaDelete = sc.next();
                    for(Contato c : contatos){
                        if(c.getNome().equalsIgnoreCase(nomeBuscaDelete)){
                            System.out.println(c);
                        }
                    }
                    System.out.println("Digite o email do contato que deseja deletar :");
                    String DeleteEmail = sc.next();

                    ArrayList<Contato> contatosParaRemover = new ArrayList<>();
                    for (Contato cdeletar : contatos){
                        if(cdeletar.getEmail().equalsIgnoreCase(DeleteEmail)){
                            contatosParaRemover.add(cdeletar);
                        }
                    }
                    contatos.removeAll(contatosParaRemover);
                    System.out.println("Contato deletado");
                    option = menu();
                    break;
                case 6:
                    String path = "C:\\Users\\mathe\\OneDrive\\Documentos\\Programacao\\estudos\\ProjetosJava\\Pro_contatos\\contatos.txt";
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                        for(Contato cExportar : contatos){
                            String linha = cExportar.getNome() + "-" + cExportar.getTelefone() + "-" + cExportar.getEmail();
                            bw.write(linha);
                            bw.newLine();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


                    option = menu();
                    break;
            }
        }while (option != 0);
    }

    public static int menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------");
        System.out.println("Qual operação você deseja fazer?");
        System.out.println("0 - sair");
        System.out.println("1 - adicionar novo contato");
        System.out.println("2 - buscar todos meus contatos");
        System.out.println("3 - buscar contato");
        System.out.println("4 - editar contato");
        System.out.println("5 - excluir contato");
        System.out.println("6 - exportar contatos");
        System.out.println("-----------------------");

        return sc.nextInt();
    }
}