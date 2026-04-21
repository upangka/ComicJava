# Comic Guide to Java - 学习仓库

德国作者：**Philipp Ackermann**  
书籍：《Comic Guide to Java》三本系列

## 📚 学习进度

### 第一本：Easy Beginner
- [x] 第一章：Java基础
- [ ] 第二章：变量与数据类型
- [ ] 第三章：控制流程
- [ ] 第四章：面向对象编程
- [ ] ...

### 第二本：Intermediate
- 进度待定

### 第三本：Advanced
- 进度待定

## 📁 项目结构

```
ComicJava/
├── src/                      # Java 源代码
│   └── cn/
│       └── comicjava/
│           ├── ch01/          # 第一章代码
│           └── ch02/          # 第二章代码
├── notes/                    # 学习笔记
├── images/                   # 图片资源
├── .codebuddy/               # CodeBuddy 规则
├── bin/                      # 编译输出 (不提交)
└── README.md
```

## 🛠️ 编译运行

```bash
# 编译 (在项目根目录)
javac -d bin src/cn/comicjava/Main.java

# 运行
java -cp bin cn.comicjava.Main
```

## 📖 学习笔记

- [ch01-编写第一个程序](./notes/ch01-编写第一个程序.md)
- [ch02-线程基础](./notes/ch02-线程基础.md) - 渐进更新中...
- [ch03-生产者与消费者模型](./notes/ch03-生产者与消费者模型.md) - 渐进更新中...
- [ch05-装饰器模式](./notes/ch05-装饰器模式.md)
- [Git学习笔记](./notes/Git学习笔记.md) - Git 操作与 SSH 配置
