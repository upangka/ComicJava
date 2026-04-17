package cn.comicjava.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WoWTextadventure {

    public static void main(String[] args) throws IOException {
        System.out.println("""
                你好 %s 欢迎来到魔兽世界。你现在在布克瑟尔纳克瑟尔村。
                """.formatted(args.length > 0 ? args[0] : "Pkmer"));

        System.out.println("使用按键 A、W、S、D 来移动，按 I 查看你的背包。");
        System.out.println("按 Q 退出游戏。");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while ((command = reader.readLine()) != null) {
            switch (command.toLowerCase()) {
                case "w" -> System.out.println("你向上走去。");
                case "s" -> System.out.println("你向下走去。");
                case "a" -> System.out.println("你向左走去。");
                case "d" -> System.out.println("你向右走去。");
                case "" -> System.out.println("你什么都不想做？我不信。");
                case "i" -> System.out.println("由于你尚未领悟数组贤者的智慧，你的背包里只有一个物品：一把木剑。");
                case "q" -> {
                    System.out.println("你真的要现在就放弃吗？Y/N");
                    String confirmation = reader.readLine();
                    if ("y".equalsIgnoreCase(confirmation)) {
                        System.out.println("ByeBye");
                        System.exit(0);
                    }
                }
                default -> System.err.println("📍未知操作");
            }
        }
    }
}
