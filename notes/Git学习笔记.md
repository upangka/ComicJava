# Git 学习笔记

> 学习自 CodeBuddy + 用户实践

## 一、基础操作

### 查看状态
```bash
git status
git status --short    # 简洁模式
```

### 添加文件
```bash
git add <file>        # 添加单个文件
git add -A            # 添加所有文件
```

### 提交
```bash
git commit -m "提交信息"
```

### 推送
```bash
git push
```

---

## 二、远程仓库操作

### 查看远程仓库地址
```bash
git remote -v
```

### 切换远程仓库协议（HTTPS ↔ SSH）
```bash
# 查看当前远程地址
git remote -v
# 输出：
# origin  https://github.com/user/repo.git (fetch)
# origin  https://github.com/user/repo.git (push)

# 切换为 SSH
git remote set-url origin git@github.com:user/repo.git

# 切换为 HTTPS
git remote set-url origin https://github.com/user/repo.git
```

---

## 三、SSH Key 配置

### 生成 SSH Key
```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```
- `-t ed25519`：指定密钥类型（推荐）
- `-C`：添加注释（通常用邮箱）

### 生成的密钥位置
- Windows: `C:\Users\<用户名>\.ssh\`
- Linux/Mac: `~/.ssh/`

### 生成的的文件
- `id_ed25519` - 私钥（保密）
- `id_ed25519.pub` - 公钥（可分享）

### 查看公钥
```bash
cat ~/.ssh/id_ed25519.pub
```

---

## 四、GitHub 添加 SSH Key

1. 打开 https://github.com/settings/keys
2. 点击 **New SSH key**
3. 填写：
   - Title：标识（如 `My PC`、`Work Laptop`）
   - Key：粘贴公钥内容
4. 点击 **Add SSH key**

---

## 五、known_hosts 文件

### 作用
存储已验证的服务器 host key，防止中间人攻击。

### 什么是 host key？
- 每个服务器（如 github.com）都有自己的**公钥**，称为 host key
- 用于验证你连接的是真正的服务器，而不是伪造的
- host key 是**公开的**，GitHub 官方公开在 https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/githubs-ssh-key-fingerprints

### 手动添加 GitHub 的 host key
如果 `ssh-keyscan` 命令失败（版本不兼容），可以手动添加：
```bash
# GitHub 官方公开的 host key（可从官网验证）
echo "github.com ssh-ed25519 SHA256:+DiY3wvvV6TuJJkpbpWodz88QbVJQ7T6ywB65YmCqW8I" >> ~/.ssh/known_hosts
```

### 查看 known_hosts 内容
```bash
cat ~/.ssh/known_hosts
```

---

## 六、.gitignore 配置

### 作用
告诉 Git 忽略某些文件/目录，不提交。

### 示例
```gitignore
# 注释
bin/              # 忽略目录
*.class           # 忽略所有 .class 文件
```

### 常用忽略项
```gitignore
# 编译输出
bin/
out/
build/

# IDE 配置
.idea/
*.iml

# 日志
*.log

# Maven/Gradle
target/
```

---

## 七、HTTPS vs SSH 对比

| 特性 | HTTPS | SSH |
|------|-------|-----|
| 每次操作 | 可能需要输入用户名密码 | 不需要 |
| 配置难度 | 简单 | 需要生成 SSH Key |
| 防火墙 | 可能被拦截 | 通常畅通 |
| 适用场景 | 临时克隆 | 日常开发 |

---

## 八、常见问题

### Q: Host key verification failed
**原因**: known_hosts 中没有 GitHub 的 host key  
**解决**: 添加 GitHub 的 host key 到 known_hosts

### Q: Permission denied (publickey)
**原因**: 没有配置 SSH Key 或 Key 没有添加到 GitHub  
**解决**: 
1. 检查 Key 是否存在: `ls ~/.ssh/`
2. 确认公钥已添加到 GitHub

### Q: Could not read from remote repository
**原因**: 网络问题或仓库地址错误  
**解决**: 检查 `git remote -v` 确认地址正确

---

## 九、本次实践记录

### 用户环境
- OS: Windows (PowerShell)
- GitHub 用户名: upangka
- 邮箱: q10viking@outlook.com

### 执行的命令
```bash
# 1. 查看远程仓库
git remote -v

# 2. 切换到 SSH
git remote set-url origin git@github.com:upangka/ComicJava.git

# 3. 生成 SSH Key
ssh-keygen -t ed25519 -C "q10viking@outlook.com"

# 4. 添加 GitHub host key
echo "github.com ssh-ed25519 ..." >> ~/.ssh/known_hosts

# 5. 推送
git push
```

---

## 十、推荐学习资源

- [Git 官方文档](https://git-scm.com/doc)
- [GitHub SSH 配置指南](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)
