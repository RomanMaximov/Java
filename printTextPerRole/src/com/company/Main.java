package com.company;

public class Main {

    public static void main(String[] args) {
        String [] roles = {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(printTextPerRole(roles, textLines));
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        //String text = "";
        StringBuilder text = new StringBuilder("");
        String search = "";

        for(int i = 0; i < roles.length; ++i) {
            //text = text + roles[i] + ":\n";
            text = text.append(roles[i]);
            text = text.append(":\n");
            search = search + roles[i] + ":";
            for(int j = 0; j < textLines.length; ++j) {
                if(textLines[j].startsWith(search)) {
                    text = text.append(j+1);
                    text = text.append(") ");
                    text = text.append(textLines[j].substring(search.length() + 1));
                    text = text.append("\n");
                }
                    //text = text + (j+1) + ") " + textLines[j].substring(search.length() + 1) + "\n";

            }
            //text += "\n";
            text = text.append("\n");
            search = "";
        }
        return text.toString();
    }
}
