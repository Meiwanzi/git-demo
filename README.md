# Demo Skeleton

这是一个用于 IntelliJ IDEA 和 Git 手动操作练习的最小 Java 项目。项目只包含
基础工程配置、配置读取、启动入口和分层包骨架，不包含业务功能。

## 环境要求

- JDK 17 或更高版本
- Maven 3.6 或更高版本
- IntelliJ IDEA

## 在 IDEA 中打开

1. 启动 IntelliJ IDEA。
2. 选择 `File → Open`。
3. 打开 `E:\demo-skeleton`，不要只打开 `src` 目录。
4. 等待 Maven 自动导入完成。
5. 在 `File → Project Structure → Project SDK` 中选择 JDK 17 或更高版本。

如果 Maven 没有自动导入，打开右侧 Maven 工具窗口并点击刷新按钮。

## 运行与测试

在 IDEA 中打开：

```text
src/main/java/cn/edu/hbnu/studyseat/DemoApplication.java
```

点击 `main` 方法左侧的绿色运行按钮。控制台应输出：

```text
Demo application started: demo-skeleton
```

也可以打开 IDEA 底部终端执行：

```cmd
mvn test
```

## 项目结构

```text
src/main/java/cn/edu/hbnu/studyseat
  domain/       领域对象、状态和业务规则
  service/      应用服务接口
  repository/   数据访问接口
  exception/    业务异常
  config/       配置读取
db/schema.sql   数据库结构占位脚本
docs/           设计、开发、验收和团队任务材料
```

配置项位于 `src/main/resources/application.properties`：

```properties
app.name=demo-skeleton
```

## 手动提交到 Git

项目创建时没有初始化 Git，以下命令需要在 IDEA 的 Terminal 中手动执行。

### 第一次提交

```cmd
git init -b main
git status
git add .
git status
git commit -m "初始化 demo 项目骨架"
```

确认 `git status` 中没有密码、IDEA 工作区文件或构建产物。

### 添加 GitHub 远端并推送

先在 GitHub 创建一个空仓库，然后执行：

```cmd
git remote add origin git@github.com:<用户名>/<仓库名>.git
git push -u origin main
```

### 后续提交

```cmd
git status
git add .
git commit -m "本次修改说明"
git push
```

在 IDEA 中也可以按 `Ctrl+K` 打开提交窗口，选择文件、填写提交说明，然后点击
`Commit and Push...`。
