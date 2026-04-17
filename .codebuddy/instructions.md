# ComicJava 项目规则

## 项目背景
- 这是一个学习仓库，用于存储《Comic Guide to Java》书籍的学习代码
- 作者：Philipp Ackermann（德国）
- 共三本：Easy Beginner、Intermediate、Advanced

## 技术规范
- 不使用 Maven、Gradle 等构建工具
- 纯 Java 代码，手动编译运行
- 包名：`com.comicjava`

## 代码组织
- 源代码：`src/`
- 编译输出：`bin/`（不提交）
- 按章节分包：`ch01`, `ch02`, ...

## 编译运行命令
```bash
javac -d bin src/com/comicjava/Main.java
java -cp bin com.comicjava.Main
```
